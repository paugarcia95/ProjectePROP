/**
 * 
 */
package cercaComunitats;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

/**
 * @author cristina.fontanet & Pau
 *
 */
public class GrafNewman extends Graf {

        private ArrayList<HashMap<Integer,Integer> > NCM;   //Llista d'adjacencies que conte el nombre de camins minims que passen per a cada aresta
        private Integer maxi;           //Node i del maxNumCM
	private Integer maxj;           //Node j del maxNUMCM
	private Integer maxNumCM;       //Maxim nombre de camins minims que passen per qualsevol aresta
	private Integer numCom;     //Numero de comunitats actuals
       
        private class ArcP{
            public Double pes;
            public Integer node2;
		/**
		 * Constructora per defecte. (Cris)
		 * 
		 * @param node1
		 *            El node d'un dels extrems de l'aresta.
		 * @param nodeB
		 *            El node de l'altre extrem.
		 * @return Una Aresta formada per node1 i node2
		 **/
		public ArcP(Double pes, int node2) {
			this.pes = pes;
			this.node2 = node2;
		}
        };
        public class arcPCCompara implements Comparator<ArcP> {
            @Override
            public int compare(ArcP x, ArcP y) {
                return (int)(x.pes*100-y.pes*100);
            }
        }
        private ArrayList<Queue<Aresta> > getCamiMinimv2(Integer nodeA){
            ArrayList<Queue<Aresta> > result = new ArrayList<Queue<Aresta> >();
            int num = llista.size();
            ArrayList<Double> dist = new ArrayList<Double>();
            ArrayList<Boolean> visit = new ArrayList<Boolean> ();
            for(int i = 0; i < num; ++i){
                dist.add(Double.POSITIVE_INFINITY);
                visit.add(false);
                result.add(new LinkedList<Aresta>() );
            }
            dist.set(nodeA, 0.0);
            Comparator<ArcP> compara = new arcPCCompara();
            PriorityQueue<ArcP> q = new PriorityQueue<ArcP>(10,compara);  //definir comparador!
            q.add(new ArcP(0.0,nodeA));
            while(!q.isEmpty()){
                Integer u = q.peek().node2;
                q.poll();
                if(! visit.get(u)) {
                    visit.set(u, true);
                    //int ta = this.getAdjacents(u).size();
                    for(Integer comp: this.getAdjacents(u)){
                        if(dist.get(comp)> dist.get(u)+llista.get(u, comp)) {
                            dist.set(comp, dist.get(u)+llista.get(u, comp));
                            Queue<Aresta> aux = result.get(comp);
                            aux.add(new Aresta(comp,u));
                            result.set(comp, aux);
                            q.add(new ArcP(dist.get(comp),comp));
                        }
                    }
                }
            }
            return result;
        }
        
        
        
        public Boolean calcularEdgeBetweenv2() {
		// Posem a 0 tots els camins minims per "comencar" la nova ronda
            for(HashMap<Integer,Integer> i: NCM)
                for(Integer j: i.keySet()){
                    i.put(j, 0);
                }
   
            for(int i = 0; i < NCM.size();++i) {
                ArrayList<Queue<Aresta> > camins = getCamiMinimv2(i);
                for(int j=0; j < NCM.size();++j) {
                    while(!camins.get(j).isEmpty()) {
                        Aresta aux = camins.get(j).poll();
                        Integer act = NCM.get(aux.node1).get(aux.node2);
                        ++act;
                        NCM.get(aux.node1).put(aux.node2,act);
                        NCM.get(aux.node2).put(aux.node1,act);
			// mantenir el vertex per on passen mes camins minims (variables maxi, maxj i maxNumCM)
                        if (maxNumCM <= act) {
                            maxi = aux.node1;
                            maxj = aux.node2;
                            maxNumCM = act;
                        }
                    }
                }
            }
		return true;
	}
        

        public Integer getNumArestes(){
            Integer num = 0;
            int aux = 0;
            for(HashMap<Integer,Integer> aresta: NCM) {
               // System.out.println("El node "+DiccionariInvers.get(aux)+" te "+aresta.size()+" arestes");
                num+=aresta.size();
                ++aux;
                //System.out.println("En portem acumulades: "+num);
            }
            return num/2;
        }
	private class Aresta { 
		public Integer node1;
		public Integer node2;
		/**
		 * Constructora per defecte. (Cris)
		 * 
		 * @param node1
		 *            El node d'un dels extrems de l'aresta.
		 * @param nodeB
		 *            El node de l'altre extrem.
		 * @return Una Aresta formada per node1 i node2
		 */
		public Aresta(int node1, int node2) {
			this.node1 = node1;
			this.node2 = node2;
		}
	};

	private static final class ArestaPes {
		public Integer aresta;
		public Double pes;

		/**
		 * Constructora per defecte. (Pau)
		 * 
		 * @param aresta
		 *            Es el node d'un dels extrems de l'aresta (A la funcio on
		 *            s'utilitza representa el node a on es vol anar).
		 * @param pes
		 *            Representa el pes de l'aresta formada per el node d'origen
		 *            i "aresta".
		 * @return Una ArestaPes amb aresta i pes.
		 */
		public ArestaPes(int aresta, double pes) {
			this.aresta = aresta;
			this.pes = pes;
		}
	}

	private static final class ComparaValors implements Comparator<ArestaPes> {
		/**
		 * Compara l'aresta les arestes mitjancant el seu pes. (Pau)
		 * 
		 * @param o1
		 *            Una Aresta.
		 * @param o2
		 *            L'altra Aresta.
		 * @return Un enter positiu si o1 te un pes mes gran que o2, 0 si tenen
		 *         el mateix pes i un enter negatiu si o2 te un pes major a o1.
		 */
		@Override
		public int compare(ArestaPes o1, ArestaPes o2) {
			// Es multiplica el valor per 100 per no perdre precisio a la
			// comparacio de doubles (ja que despres es fa un cast a integer i
			// es perden els decimals)
			return (int) (o1.pes * 100 - o2.pes * 100);
		}
	}

	private static final class QueueVector {
		private static ArrayList<Queue<Aresta>> Q;

		/**
		 * Constructora per defecte. (Pau)
		 * 
		 * @param size
		 *            Representa el tamany del vector
		 * @return Un vector que conte tantes Queue (buides) com size indica
		 */
		public QueueVector(int size) {
			Q = new ArrayList<Queue<Aresta>>(size);
                        for (int i = 0; i < size; i++) {
                            Q.add(new LinkedList<Aresta>());
                        }
		}

		/**
		 * Insereix l'element "a" a la cua de la posicio "i" (Pau)
		 * 
		 * @param i
		 *            Posicio on es vol inserir
		 * @param a
		 *            Aresta que es vol inserir
		 */
		public void push(int i, Aresta a) {
			// El que fa aquest push es posar les arestes necessaries per
			// arribar al primer node de l'aresta mes la nova aresta per
			// arribar al seguent node
                        Q.get(i).clear();
                        
			Queue<Aresta> aux = new LinkedList<>(Q.get(a.node1));
			while (!aux.isEmpty()) {
				Q.get(i).add(aux.poll());
			}

			Q.get(i).add(a);
		}

		/**
		 * Retorna i elimina el primer element de la cua de la posició i. (Pau)
		 * 
		 * @param i
		 *            Posicio on es troba la cua desitjada
		 * @return El primer element de la cua de la posició i
		 */
		public Aresta pop(int i) {
			return Q.get(i).poll();
		}

		/**
		 * Retorna, pero NO elimina, el primer element de la cua de la posició
		 * i. (Pau)
		 * 
		 * @param i
		 *            Posicio on es troba la cua desitjada
		 * @return El primer element de la cua de la posició i
		 */
		public Aresta top(int i) {
			return Q.get(i).peek();
		}

		/**
		 * Retorna la cua de la posicio i. (Pau)
		 * 
		 * @param i
		 *            Posicio on es troba la cua desitjada
		 * @return La cua de la posicio i
		 */
		public Queue<Aresta> getQueue(int i) {
			return Q.get(i);
		}
	}

	/**
	 * Creadora per defecte. (Cristina)
	 */
	public GrafNewman() {
		super();
                //MatriuNova
		maxNumCM = maxi = maxj = numCom = 0;
                NCM = new ArrayList<HashMap<Integer,Integer> >();
	}	
	public GrafNewman(Graf G) {
		Diccionari = new TreeMap<String,Integer>(G.Diccionari);
		DiccionariInvers = new TreeMap<Integer,String>(G.DiccionariInvers);
		llista = new LlistaAdjacencia(G.llista);
		maxNumCM = maxi = maxj = numCom = 0;
                NCM = new ArrayList<HashMap<Integer,Integer> >();
                for(int i = 0; i < llista.size();++i) {
                    HashMap<Integer,Integer> aux = new HashMap<Integer,Integer>();
                    for(Integer node: llista.adjacents(i).keySet()) {
                        aux.put(node, 0);
                    }
                    NCM.add(aux);
                }
	}
	/**
	 * Agrupa els nodes adjacents al donat. (Cristina)
	 * 
	 * @param posicio
	 *            Node del qual es vol saber els adjacents
	 * 
	 * @return El conjunt de nodes adjacents a posicio
	 */
	private Set<Integer> getAdjacents(Integer posicio) {
                 return llista.adjacents(posicio).keySet();
	}      
	/**
	 * Recorre una comunitat i va marcant com a true al vector visitats pels
	 * nodes que passa. Retorna les comunitats que pertanyen al nodeOrigen (Pau)
	 * 
	 * @param nodeOrigen
	 *            Node del qual se'n vol saber la comunitat
	 * @param visitats
	 *            Vector que conte tots els nodes del graf i te com a true els
	 *            nodes que ja ha visitat i amb false els que no
	 * @return El conjunt de comunitats a la que pertany el nodeOrigen
	 */
	private HashSet<String> getNodesDeLaComunitat(Integer nodeOrigen, Vector<Boolean> visitats) {
		Set<Integer> adjacents = getAdjacents(nodeOrigen);
		Iterator<Integer> it = adjacents.iterator();

		HashSet<String> comunitat = new HashSet<String>();
		comunitat.add(DiccionariInvers.get(nodeOrigen));

		while (it.hasNext()) {
			Integer n = it.next();
			if (!visitats.get(n)) {
				visitats.set(n, true);

				comunitat.add(DiccionariInvers.get(n));
				comunitat.addAll(getNodesDeLaComunitat(n, visitats));
			}
		}
		return comunitat;
	}
	/**
	 * Indica si el nodeA i el nodeB pertanyen a la mateixa comunitat (Pau)
	 * 
	 * @param nodeA
	 *            L'identificador d'un dels nodes
	 * @param nodeB
	 *            L'identificador de l'altre node
	 * @return true si pertanyen a la mateixa comunitat i false en cas contrari
	 */
	private Boolean pertanyenMateixaComunitat(int nodeA, int nodeB) {
		Vector<Boolean> visitats = new Vector<Boolean>();
		visitats.setSize(this.size());
		for (int i = 0; i < visitats.size(); ++i)
			visitats.set(i, false);

		recorrerComunitat(nodeA, visitats);

		return visitats.get(nodeB);
	}
	/**
	 * Recorre una comunitat i va marcant com a true al vector visitats pels
	 * nodes que passa (Pau)
	 * 
	 * @param nodeOrigen
	 *            Node del qual se'n vol saber la comunitat
	 * @param visitats
	 *            Vector que conte tots els nodes del graf i te com a true els
	 *            nodes que ja ha visitat i amb false els que no
	 */
	private void recorrerComunitat(Integer nodeOrigen, Vector<Boolean> visitats) {
		Set<Integer> adjacents = getAdjacents(nodeOrigen);
		Iterator<Integer> it = adjacents.iterator();
		while (it.hasNext()) {
			Integer n = it.next();
			if (!visitats.get(n)) {
				visitats.set(n, true);
				recorrerComunitat(n, visitats);
			}
		}
	}
	/**
	 * Calcula el cami minim des del nodeA a la resta de nodes. (Pau)
	 * 
	 * @param nodeA
	 *            El node d'un dels extrems del cami.
	 * @return Un vector de cues de les arestes per on passen els camins minims.
	 */
	private QueueVector getCamiMinim(int nodeA) {
		// Implementat amb Dijkstra
		QueueVector camiMinim = new QueueVector(this.size());
		// Vector que marca la distancia del nodeA a la resta de nodes
		ArrayList<Double> distancia = new ArrayList<Double>(this.size());
        
		// Es com una cua de prioritat que ordena els nodes en una posicio mes
		// curta al principi
		PriorityQueue<ArestaPes> cola = new PriorityQueue<ArestaPes>(100, new ComparaValors());

		// En un principi no se sap, i es marquen les distancies com a
		// infinites
		for (int i = 0; i < this.size(); ++i) {
			distancia.add(Double.POSITIVE_INFINITY);
		}

		// La distancia del nodeA a ell mateix es 0
		distancia.set(nodeA, 0.0);
		cola.add(new ArestaPes(nodeA, 0.0));

		while (!cola.isEmpty()) {
			ArestaPes a = cola.poll();
			Integer u = a.aresta;

			// Conte un iterador dels nodes adjacents a "u"
			Iterator<Integer> it2 = this.getAdjacents(u).iterator();

			while (it2.hasNext()) {
				Integer v = it2.next();
				Double pesUV = llista.get(u, v);

				if (distancia.get(v) > distancia.get(u) + pesUV) {
					distancia.set(v, distancia.get(u) + pesUV);
					cola.add(new ArestaPes(v, distancia.get(v)));
                                        //Aquest push que es fa aqu� �s especial: insereix el cam� per arribar fins
                                        //a "u" i despres l'aresta de u a v.
					camiMinim.push(v, new Aresta(u, v));
				}
			}
		}
		return camiMinim;
	}
	/**
	 * Indica el maxim nombre de camins minims que passen entre dos nodes del
	 * graf.
	 * 
	 * @return el maxim nombre de camins minims que pasen entre dos nodes del
	 *         graf.
	 */
	public Integer getMaxBetween() {
		return maxNumCM;
	}
	/**
	 * Calcula el nombre de camins minims que passen per cada vertex. (Cristina)
	 * 
	 * @return true si s'ha pogut calcular tot correctament, false si hi ha
	 *         hagut algun error.
	 */
	public Boolean calcularEdgeBetween() {
		// Posem a 0 tots els camins minims per "comencar" la nova ronda
            for(HashMap<Integer,Integer> i: NCM)
                for(Integer j: i.keySet()){
                    i.put(j, 0);
                }
   
            for(int i = 0; i < NCM.size();++i) {
                QueueVector camins = getCamiMinim(i);
                for(int j=0; j < NCM.size();++j) {
                    System.out.println("Cami de "+DiccionariInvers.get(i)+" a "+DiccionariInvers.get(j)+": ");
                    while(!camins.getQueue(j).isEmpty()) {
                        Aresta aux = camins.pop(j);
                        System.out.println(aux);
                        //System.out.println(", de "+DiccionariInvers.get(aux.node1)+ " a "+DiccionariInvers.get(aux.node2));
                        Integer act = NCM.get(aux.node1).get(aux.node2);
                        ++act;
                        NCM.get(aux.node1).put(aux.node2,act);
                        NCM.get(aux.node2).put(aux.node1,act);
			// mantenir el vertex per on passen mes camins minims (variables maxi, maxj i maxNumCM)
                        if (maxNumCM <= act) {
                            maxi = aux.node1;
                            maxj = aux.node2;
                            maxNumCM = act;
                        }
                    }
                }
            }
		return true;
	}

	/**
	 * Fa la inversa dels pesos de les arestes del graf, de manera que un numero
	 * mes gran indica menys relacio (Cristina)
	 * 
	 * @return false si hi ha hagut algun problema, true en cas contrari
	 */
	public Boolean invertirPesos() {
            for(Integer nodes: DiccionariInvers.keySet()){
                for(Integer j: llista.adjacents(nodes).keySet()) {
                    double act = llista.get(nodes, j);
                    if(act != 0.0 ) llista.setDirected(nodes,j,(1/act));
                    //else System.out.println("EEEEPS, hi ha una aresta amb pes 0.0 entre els nodes "+nodes+" i "+j);
                }
             }
           return true;
	}

	/**
	 * Esborra l'aresta per la que passen mes camins minims de tot el graf
	 * (Cristina)
	 * 
	 * @return false si hi ha hagut algun problema i no s'ha pogut eliminar,
	 *         true en cas contrari
	 */
	public Boolean esborrarMaxim() {
		if (maxNumCM != 0) {
                        llista.remove(maxi, maxj);
                        NCM.get(maxi).remove(maxj);
                        NCM.get(maxj).remove(maxi);
			if (!pertanyenMateixaComunitat(maxi, maxj)) {
				numCom = 0;
				numComunitats();
			}
			maxNumCM=0;
			maxi=0;maxj=0;
			return true;
		} 
		else if(maxi==0 &&maxj==0) {
			numComunitats();
			return true;
		}else return false;
	}

	/**
	 * Retorna el nombre de comunitats en les que esta� dividit el graf o -1 en
	 * cas d'error (Pau)
	 * 
	 * @return Nombre de comunitats del graf
	 */
	public Integer numComunitats() {
		HashSet<String> nodes = this.getNodes();
		Iterator<String> it = nodes.iterator();
		Integer numComunitats = 0;

		Vector<Boolean> visitats = new Vector<Boolean>();
		visitats.setSize(this.size());
		for (int i = 0; i < visitats.size(); ++i)
                    visitats.set(i, false);
			
		while (it.hasNext()) {
                    Integer n = Diccionari.get(it.next());
			if (!visitats.get(n)) {
                            visitats.set(n, true);
                            recorrerComunitat(n, visitats);
                            ++numComunitats;
			}
		}
		numCom = numComunitats;
		return numCom;
	}

	/**
	 * Retorna un conjunt que conte les comunitats que conte el graf (Pau)
	 * 
	 * @return Un conjunt que conte tants subconjunts com comunitats te el graf
	 *         i cada subconjunt conte els nodes de la comunitat
	 */
	public HashSet<HashSet<String>> comunitats() {
		HashSet<String> nodes = this.getNodes();
		Iterator<String> it = nodes.iterator();
		HashSet<HashSet<String>> comunitats = new HashSet<HashSet<String>>();

		// Inicialitzo vector visitats a false
		Vector<Boolean> visitats = new Vector<Boolean>();
		visitats.setSize(this.size());

		for (int i = 0; i < visitats.size(); ++i)
			visitats.set(i, false);

		while (it.hasNext()) {
			// Per cada node miro si ja l'he visitat, si no es aixo invoco la
			// funcio getNodesDeLaComunitat que em retorna els nodes de la
			// comunitat a la qual pertany n
			Integer n = Diccionari.get(it.next());
			if (!visitats.get(n)) {
				visitats.set(n, true);
				// Afegeixo aquesta comunitat al HashSet
				comunitats.add(getNodesDeLaComunitat(n, visitats));
			}
		}
		numCom = comunitats.size();
		return comunitats;
	}
}