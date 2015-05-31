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
        
	public static final class Aresta {
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

	private static final class ArcP {
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

	private ArrayList<Queue<Aresta>> getCamiMinim(Integer nodeA) {
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
            PriorityQueue<ArcP> q = new PriorityQueue<ArcP>(1,compara);  //definir comparador!
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
        
	public static final class QueueMatrix {
		private static Queue<Aresta>[][] Q;

		/**
		 * Constructora per defecte. (Pau)
		 * 
		 * @param size
		 *            Representa el tamany de la matriu
		 */
		public QueueMatrix(int size) {
			Q = new LinkedList[size][size];
			for (int i = 0; i < size; ++i) {
				for (int j = 0; j < size; ++j) {
					Q[i][j] = new LinkedList<Aresta>();
				}
			}
		}

		/**
		 * Afegeix una aresta de i a j al cami de i a j. (Pau)
		 * 
		 * @param i
		 *            primer node
		 * @param j
		 *            segon node
		 */
		public void pushAresta(int i, int j) {
			Q[i][j].add(new Aresta(i, j));
		}

		/**
		 * Crea el cami minim d'inici a fi passant pel node meitat El que fa
		 * aquest push es posar les arestes necessaries per arribar al node fi
		 * fent que el cami sigui de inici a meitat i de meitat a fi. (Pau)
		 * 
		 * @param inici
		 *            node origen
		 * @param fi
		 *            node desti
		 * @param meitat
		 *            node pel qual es passa per arribar a fi
		 */
		public void pushCami(int inici, int meitat, int fi) {
			System.out.println("ENTRO");
			// El que fa aquest push es posar les arestes necessaries per
			// arribar al node fi fent que el cami sigui de inici a meitat i de
			// meitat a fi
			Q[inici][fi].clear();; // Netejo el cami minim de inici a fi
			Q[inici][fi].addAll(new LinkedList<Aresta>(Q[inici][meitat]));
			Q[inici][fi].addAll(new LinkedList<Aresta>(Q[meitat][fi]));
		}

		/**
		 * Retorna i elimina, el primer element del cami minim de i a j. (Pau)
		 * 
		 * @param i
		 *            primer node
		 * @param j
		 *            segon node
		 * @return El primer node pel que passa el cami minim de i a j (i
		 *         l'esborra)
		 */
		public Aresta popCami(int i, int j) {
			return Q[i][j].poll();
		}

		/**
		 * Retorna, pero NO elimina, el primer element del cami minim de i a j.
		 * (Pau)
		 * 
		 * @param i
		 *            primer node
		 * @param j
		 *            segon node
		 * @return El primer node pel que passa el cami minim de i a j
		 */
		public Aresta topCami(int i, int j) {
			return Q[i][j].peek();
		}

		/**
		 * Retorna el cami minim del node i al j. (Pau)
		 * 
		 * @param i
		 *            primer node
		 * @param j
		 *            segon node
		 * @return Una cua pels nodes que passa el cami minim de i a j
		 */
		public Queue<Aresta> getCamiMinim(int i, int j) {
			return Q[i][j];
		}

		/**
		 * Indica si hi ha mes nodes al cami minim de i a j (Pau)
		 * 
		 * @param i
		 *            primer node
		 * @param j
		 *            segon node
		 * @return un boolea que indica si no queden mes nodes
		 */
		public Boolean isEmpty(int i, int j) {
			return Q[i][j].isEmpty();
		}
	};

	public QueueMatrix getCaminsMinims() {
		QueueMatrix caminsMinims = new QueueMatrix(size());
		double[][] pes = new double[size()][size()];

		inicialitzaPesos(pes, caminsMinims);

		for (int k = 0; k < pes.length; k++) {
			for (int i = 0; i < pes.length; i++) {
				for (int j = 0; j < pes.length; j++) {
					if (pes[i][j] > pes[i][k] + pes[k][j]) {
						caminsMinims.pushCami(i, k, j);
					}
					pes[i][j] = Math.min(pes[i][j], pes[i][k] + pes[k][j]);
				}
			}
		}
		return caminsMinims;
	}

	public void inicialitzaPesos(double[][] pes, QueueMatrix caminsMinims) {
		for (int i = 0; i < pes.length; ++i) {
			for (int j = 0; j < pes[0].length; ++j) {
				if (i == j) {
					pes[i][j] = 0;
				} else if (llista.exists(i, j)) {
					pes[i][j] = llista.get(i, j);
					caminsMinims.pushAresta(i, j);;
				} else
					pes[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	private void printPesos(double[][] pes) {
		for (int i = 0; i < pes.length; ++i) {
			for (int j = 0; j < pes[0].length; ++j) {
				if (pes[i][j] == Integer.MAX_VALUE)
					System.out.print("inf ");
				else
					System.out.print(pes[i][j] + " ");
			}
			System.out.println();
		}
	}

	public Boolean calcularEdgeBetween() {
		// Posem a 0 tots els camins minims per "comencar" la nova ronda
            for(HashMap<Integer,Integer> i: NCM)
                for(Integer j: i.keySet()){
                    i.put(j, 0);
                }
   /*//////////////////// PART ANTIGA ///////////////////////////////////////////
    * 
		for (int i = 0; i < NCM.size(); ++i) {
                ArrayList<Queue<Aresta> > camins = getCamiMinim(i);
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
		} */
            
        // PART NOVA ///////////////////////////////////////////////////////////
		
		QueueMatrix caminsMin = getCaminsMinims();
		for (int i = 0; i < NCM.size(); ++i) {
			for (int j = 0; j < NCM.size(); ++j) {
				while (!caminsMin.isEmpty(i, j)) {
					Aresta a = caminsMin.popCami(i, j);
					int act = NCM.get(a.node1).get(a.node2);
					++act;
					NCM.get(a.node1).put(a.node2, act);
					NCM.get(a.node2).put(a.node1, act);
					if (maxNumCM <= act) {
						maxi = a.node1;
						maxj = a.node2;
						maxNumCM = act;
					}
				}
			} 
		}
		
		

		return true;
	}
        
	public Integer getNumArestes() {
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