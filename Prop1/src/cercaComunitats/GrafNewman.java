/**
 * 
 */
package cercaComunitats;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

/**
 * @author Cristina & Pau
 *
 */
public class GrafNewman extends Graf {

	private Vector<Vector<Integer>> NCM;
	@SuppressWarnings("unused")
	private Integer maxi;
	@SuppressWarnings("unused")
	private Integer maxj;
	private Integer maxNumCM;
	private HashSet<HashSet<Integer>> comunitats;

	public class Aresta { // Ha de ser privada!!! pero pel driver la deixo aixi
							// de moment
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
		 *            �s el node d'un dels extrems de l'aresta (A la funci� on
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
		 * Compara l'aresta les arestes mitjan�ant el seu pes. (Pau)
		 * 
		 * @param o1
		 *            Una Aresta.
		 * @param o2
		 *            L'altra Aresta.
		 * @return Un enter positiu si o1 t� un pes m�s gran que o2, 0 si tenen
		 *         el mateix pes i un enter negatiu si o2 t� un pes major a o1.
		 */
		@Override
		public int compare(ArestaPes o1, ArestaPes o2) {
			// Es multiplica el valor per 100 per no perdre precisi� a la
			// comparaci� de doubles (ja que despres es fa un cast a integer i
			// es perden els decimals)
			return (int) (o1.pes * 100 - o2.pes * 100);
		}
	}

	private static final class QueueVector {
		private static Vector<Queue<Aresta>> Q;

		/**
		 * Constructora per defecte. (Pau)
		 * 
		 * @param size
		 *            Representa el tamany del vector
		 * @return Un vector que cont� tantes Queue (buides) com size indica
		 */
		public QueueVector(int size) {
			Q = new Vector<Queue<Aresta>>();
			Q.setSize(size);

			for (int i = 0; i < size; ++i) {
				Q.set(i, new LinkedList<Aresta>());
			}
		}

		/**
		 * Insereix l'element "a" a la cua de la posici� i (Pau)
		 * 
		 * @param i
		 *            Posici� on es vol inserir
		 * @param a
		 *            Aresta que es vol inserir
		 */
		public void push(int i, Aresta a) {
			// El que fa aquest push �s posar les arestes necessaries per
			// arribar al primer node de l'aresta m�s la nova aresta per arribar
			// al seg�ent node

			Queue<Aresta> aux = new LinkedList<Aresta>();
			aux = new LinkedList<Aresta>(Q.get(a.node1));

			while (!aux.isEmpty()) {
				Q.get(i).add(aux.poll());
			}

			Q.get(i).add(a);
		}

		/**
		 * Retorna la cua de la posici� i. (Pau)
		 * 
		 * @param i
		 *            Posici� on es troba la cua desitjada
		 * @return La cua de la posici� i
		 */
		public Queue<Aresta> getQueue(int i) {
			return Q.get(i);
		}
	}

	private HashSet<Integer> getAdjacents(Integer posicio) {
		HashSet<Integer> Cjt = new HashSet<Integer>();
		Integer N = Matriu.size();
		if (posicio >= N)
			return Cjt;
		for (Integer j = 0; j < N; ++j) {
			if (Matriu.get(posicio).get(j) > 0.0)
				Cjt.add(j);
		}
		return Cjt;
	}

	private void connectedComponents() {
		/*
		 * ArrayList<Set<Integer> > connectedComponents = new
		 * ArrayList<Set<Integer>>(); HashSet<Integer> visitedNodes= new
		 * HashSet<Integer>(); int nodes = Matriu.size(); for(int i = 0; i <
		 * nodes; ++i) { if(visitedNodes.contains(i)) continue;
		 * 
		 * LinkedList<Integer> nextNodes = new LinkedList<Integer>(); int
		 * currentNode = i; nextNodes.push(i);
		 * 
		 * HashSet<Integer> cc = new HashSet<Integer>();
		 * connectedComponents.add(cc); cc.add(i); while(nextNodes.size()>0) {
		 * currentNode = nextNodes.get(0); nextNodes.remove(0); Set<Integer>
		 * adjNodes = (Set<Integer>) } }
		 */

		comunitats = new HashSet<HashSet<Integer>>();
		int mida = Matriu.size();
		for (int i = 0; i < mida; ++i) {

		}
		// Iterator<HashSet<Integer>> com = comunitats.iterator();

	}

	/**
	 * Calcula el cam� minim des del nodeA al nodeB. (Pau)
	 * 
	 * @param nodeA
	 *            El node d'un dels extrems del cam�.
	 * @param nodeB
	 *            El node de l'altre extrem.
	 * @return Una cua de les arestes per on passa.
	 */
	public Queue<Aresta> camiMin(int nodeA, int nodeB) {
		// Implementat amb Dijkstra

		QueueVector camiMinim = new QueueVector(this.size());

		// Vector que marca la dist�ncia del nodeA a la resta de nodes
		Vector<Double> distancia = new Vector<Double>();
		distancia.setSize(this.size());
		/** TENIR EN COMPTE QUE POTSER QE ELS NODES NO SIGUIN CONSECUTIUS!!! */

		// Es com una cua de prioritat que ordena els nodes en una posicio mes
		// curta al principi
		PriorityQueue<ArestaPes> cola = new PriorityQueue<ArestaPes>(new ComparaValors());

		// En un principi no se sap, i es marquen les dist�ncies com a infinites
		for (int i = 0; i < distancia.size(); ++i) {
			distancia.set(i, Double.POSITIVE_INFINITY);
		}

		// La dist�ncia del nodeA a ell mateix �s 0
		distancia.set(nodeA, 0.0);

		cola.add(new ArestaPes(nodeA, distancia.get(nodeA)));

		while (!cola.isEmpty()) {
			ArestaPes a = cola.poll();
			Integer u = a.aresta;

			// Cont� els nodes adjacents a "u"
			HashSet<Integer> adjacents = this.getAdjacents(u);
			Iterator<Integer> it2 = adjacents.iterator();

			while (it2.hasNext()) {
				Integer v = it2.next();
				Double pesUV = this.getPes(DiccionariInvers.get(u), DiccionariInvers.get(v));

				if (distancia.get(v) > distancia.get(u) + pesUV) {
					distancia.set(v, distancia.get(u) + pesUV);
					cola.add(new ArestaPes(v, distancia.get(v)));

					camiMinim.push(v, new Aresta(u, v));
				}
			}
		}
		return camiMinim.getQueue(nodeB);
	}
	/**
	 * Creadora per defecte.
	 */
	public GrafNewman() { // Cris
		super();
		// crea NCM de la mateixa mida que Matriu
		NCM = new Vector<Vector<Integer>>(super.Matriu.size());
		maxNumCM = maxi = maxj = 0;
		comunitats = new HashSet<HashSet<Integer>>();

	}

	/**
	 * Calcula el nombre de camins minims que passen per cada vertex.
	 * 
	 * @return true si s'ha pogut calcular tot correctament, false si hi ha
	 *         hagut algun error.
	 */
	public Integer getMaxBet() {
		return maxNumCM;
	}
	/**
	 * Calcula el nombre de camins minims que passen per cada vertex.
	 * 
	 * @return true si s'ha pogut calcular tot correctament, false si hi ha
	 *         hagut algun error.
	 */
	public Boolean Calculate_edge_between() { // CRIS
		if (NCM.size() < 2)
			return false;
		// Posem a 0 tots els camins minims per "comen�ar" la nova ronda
		for (int i = 0; i < NCM.size(); ++i) {
			for (int j = 0; i < NCM.size(); ++j)
				NCM.get(i).set(j, 0);
		}
		// Calcula el cami minim de cada node cap a tots els nodes
		for (int i = 0; i < NCM.size(); ++i) {
			for (int j = 0; i < NCM.size(); ++j) {
				if (i != j) {
					Queue<Aresta> cami = camiMin(i, j);
					// un cop trobat cada cami minim, sumar 1 a la pos de NCM
					if (cami.size() > 0) {
						Iterator<Aresta> itc = cami.iterator();
						while (itc.hasNext()) {
							Aresta aux = itc.next();
							Integer act = NCM.get(aux.node1).get(aux.node2);
							NCM.get(aux.node1).set(aux.node2, act + 1);
							// mantenir el vertex per on passen mes camins
							// minims (variables maxi, maxj i maxNumCM)
							if (maxNumCM <= act) {
								maxi = aux.node1;
								maxj = aux.node2;
							}
						}
					}
				}
			}
		}
		return null;
	}

	// Fa la inversa dels pesos de les arestes del graf, retorna false si hi ha
	// hagut algun error.
	public Boolean Invertir_pesos() { // Cris
		int mida = Matriu.size();
		if (mida < 2)
			return false;
		else {
			for (int i = 0; i < mida; ++i) {
				for (int j = 0; j < mida; ++j) {
					double act = Matriu.get(i).get(j);
					if (act != 0.0)
						Matriu.get(i).set(j, 1 / act);
				}
			}
			return true;
		}
	}

	// Esborra l�aresta per la que passen m�s camins m�nims de tot el graf,
	// retorna false si hi ha hagut algun error.
	public Boolean esborrar_maxim() { // Cris
		// del Graf "original", eliminem (posar a null, infinit o lu q sigui)
		// del graf de pesos la posicio que indiqui la variable maxNumCM i la
		// posem a 0

		return null;
	}

	/**
	 * Recorre una comunitat i va marcant com a true al vector visitats pels
	 * nodes que passa (Pau)
	 * 
	 * @param nodeOrigen
	 *            Node del qual se'n vol saber la comunitat
	 * @param visitats
	 *            Vector que cont� tots els nodes del graf i t� com a true els
	 *            nodes que ja ha visitat i amb false els que no
	 */
	private void recorrerComunitat(Integer nodeOrigen, Vector<Boolean> visitats) {
		HashSet<Integer> adjacents = getAdjacents(nodeOrigen);
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
	 * Retorna el nombre de comunitats en les que est� dividit el graf o -1 en
	 * cas d'error (Pau)
	 * 
	 * @return Nombre de comunitats del graf
	 */
	public Integer numComunitats() { // He canviat el nom!!!
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
		return numComunitats;
	}

	/**
	 * Recorre una comunitat i va marcant com a true al vector visitats pels
	 * nodes que passa. Retorna les comunitats que pertanyen al nodeOrigen (Pau)
	 * 
	 * @param nodeOrigen
	 *            Node del qual se'n vol saber la comunitat
	 * @param visitats
	 *            Vector que cont� tots els nodes del graf i t� com a true els
	 *            nodes que ja ha visitat i amb false els que no
	 * @return El conjunt de comunitats a la que pertany el nodeOrigen
	 */
	private HashSet<String> nodesDeLaComunitat(Integer nodeOrigen, Vector<Boolean> visitats) {
		HashSet<Integer> adjacents = getAdjacents(nodeOrigen);
		Iterator<Integer> it = adjacents.iterator();

		HashSet<String> comunitat = new HashSet<String>();
		comunitat.add(DiccionariInvers.get(nodeOrigen));

		while (it.hasNext()) {
			Integer n = it.next();
			if (!visitats.get(n)) {
				visitats.set(n, true);

				comunitat.add(DiccionariInvers.get(n));
				comunitat.addAll(nodesDeLaComunitat(n, visitats));
			}
		}
		return comunitat;
	}

	/**
	 * Retorna un conjunt que cont� les comunitats que cont� el graf (Pau)
	 * 
	 * @return Un conjunt que cont� tants subconjunts com comunitats t� el graf
	 *         i cada subconjunt cont� els nodes de la comunitat
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
			// Per cada node miro si ja l'he visitat, si no �s aix� invoco la
			// funci� nodesDeLaComunitat que em retorna els nodes de la
			// comunitat a la qual pertany n
			Integer n = Diccionari.get(it.next());
			if (!visitats.get(n)) {
				visitats.set(n, true);
				// Afegeixo aquesta comunitat al HashSet
				comunitats.add(nodesDeLaComunitat(n, visitats));
			}
		}
		return comunitats;
	}
}
