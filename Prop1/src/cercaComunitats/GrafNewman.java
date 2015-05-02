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

	public class Aresta {
		public Integer posi;
		public Integer posj;

		public Aresta(int posi, int posj) {
			this.posi = posi;
			this.posj = posj;
		}
	};

	private static final class ArestaPes {
		public Integer aresta;
		public Double pes;

		public ArestaPes(int aresta, double pes) {
			this.aresta = aresta;
			this.pes = pes;
		}
	}

	private static final class ComparaValors implements Comparator<ArestaPes> {
		@Override
		public int compare(ArestaPes o1, ArestaPes o2) {
			// Es multiplica el valor per 100 per no perdre precisió a la
			// comparació de doubles (ja que despres es fa un cast a integer i
			// es perden els decimals)
			return (int) (o1.pes * 100 - o2.pes * 100);
		}
	}

	private static final class QueueVector {
		private static Vector<Queue<Aresta>> Q;

		public QueueVector(int size) {
			Q = new Vector<Queue<Aresta>>();
			Q.setSize(size);

			for (int i = 0; i < size; ++i) {
				Q.set(i, new LinkedList<Aresta>());
			}
		}

		public void push(int i, Aresta a) {
			// El que fa aquest push és posar les arestes necessaries per
			// arribar al primer node de l'aresta més la nova aresta per arribar
			// al següent node

			Queue<Aresta> aux = new LinkedList<Aresta>();
			aux = new LinkedList<Aresta>(Q.get(a.posi));

			while (!aux.isEmpty()) {
				Q.get(i).add(aux.poll());
			}

			Q.get(i).add(a);
		}

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
	 * Calcula el camí minim des del nodeA al nodeB. (Pau)
	 * 
	 * @param nodeA
	 *            El node d'un dels extrems del camí.
	 * @param nodeB
	 *            El node de l'altre extrem.
	 * @return Una cua de les arestes per on passa.
	 */
	public Queue<Aresta> camiMin(int nodeA, int nodeB) {
		// Implementat amb Dijkstra

		QueueVector camiMinim = new QueueVector(this.size());

		// Vector que marca la distància del nodeA a la resta de nodes
		Vector<Double> distancia = new Vector<Double>();
		distancia.setSize(this.size());
		/** TENIR EN COMPTE QUE POTSER QE ELS NODES NO SIGUIN CONSECUTIUS!!! */

		// Es com una cua de prioritat que ordena els nodes en una posicio mes
		// curta al principi
		PriorityQueue<ArestaPes> cola = new PriorityQueue<ArestaPes>(new ComparaValors());

		// En un principi no se sap, i es marquen les distàncies com a infinites
		for (int i = 0; i < distancia.size(); ++i) {
			distancia.set(i, Double.POSITIVE_INFINITY);
		}

		// La distància del nodeA a ell mateix és 0
		distancia.set(nodeA, 0.0);

		cola.add(new ArestaPes(nodeA, distancia.get(nodeA)));

		while (!cola.isEmpty()) {
			ArestaPes a = cola.poll();
			Integer u = a.aresta;

			// Conté els nodes adjacents a "u"
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
		// Posem a 0 tots els camins minims per "començar" la nova ronda
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
							Integer act = NCM.get(aux.posi).get(aux.posj);
							NCM.get(aux.posi).set(aux.posj, act + 1);
							// mantenir el vertex per on passen mes camins
							// minims (variables maxi, maxj i maxNumCM)
							if (maxNumCM <= act) {
								maxi = aux.posi;
								maxj = aux.posj;
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

	// Esborra l’aresta per la que passen més camins mínims de tot el graf,
	// retorna false si hi ha hagut algun error.
	public Boolean esborrar_maxim() { // Cris
		// del Graf "original", eliminem (posar a null, infinit o lu q sigui)
		// del graf de pesos la posicio que indiqui la variable maxNumCM i la
		// posem a 0

		return null;
	}

	// Retorna el nombre de comunitats en les quals està dividit el graf o 1 en
	// cas d’error.
	public Integer Num_comunitats() { // Pau
		return null;
	}

	// Retorna el conjunt de comunitats existents.
	public HashSet<HashSet<String>> comunitats() { // Pau
		return null;
	}

}
