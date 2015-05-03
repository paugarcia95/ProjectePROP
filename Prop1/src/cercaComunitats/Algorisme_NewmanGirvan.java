/**
 * 
 */
package cercaComunitats;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Rafa
 *
 */
public class Algorisme_NewmanGirvan {

	/**
	 * 
	 * Creadora per defecte
	 */
	public Algorisme_NewmanGirvan() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param iterador
	 *            Integer que indica les iteracions que s'han fet
	 * @param percentatge
	 *            Integer de dispersi� requerida
	 * @return Retorna la iteraci� en la qual hi havia el param de dispersi�
	 *         requerit
	 */
	private static Integer calculadora(Integer iterador, Integer percentatge) {
		Integer solu = new Integer(((iterador - 1) * percentatge) / 100);
		return solu;
	}

	/**
	 * Retorna el conjunt de comunitats corresponent a l�execuci� de l�algorisme
	 * NewmanGirvan a partir del percentatge de dispersi� desitjat.
	 * 
	 * @param G
	 *            Graf que es tractar�
	 * @param percentatge
	 *            Integer que indica el percentatge de dispersi� desitjat
	 * @return Comunitats creades a partir de l'execuci� amb el parametre de
	 *         dispersi� requerit
	 */
	public static HashSet<HashSet<String>> executa(Graf G, Integer percentatge) {
		ArrayList<HashSet<HashSet<String>>> storage = new ArrayList<HashSet<HashSet<String>>>();
		Integer iterador = new Integer(1);
		GrafNewman util = new GrafNewman();
		util = (GrafNewman) G; // Transformem de Graf a GrafNewman
		util.calcularEdgeBetween();
		while (util.numComunitats() != G.size()) {
			storage.add(iterador, util.comunitats());
			util.esborrarMaxim();
			util.calcularEdgeBetween();
			++iterador;
		}

		Integer quitoca = new Integer(calculadora(iterador, percentatge));
		return storage.get(quitoca);

	}

	/**
	 * Retorna el conjunt de comunitats corresponent a l�execuci� de l�algorisme
	 * NewmanGirvan a partir del nombre de Comunitats desitjat.
	 * 
	 * @param G
	 *            Graf que es tractar�
	 * @param numComunidades
	 *            Integer que indica el max n� de comunitats que es poden crear
	 * @return Comunitats creades a partir de l'execuci� ( com a max =
	 *         numcomunidades comunitats)
	 */
	public static HashSet<HashSet<String>> executa_num(Graf G, Integer numComunidades) {
		GrafNewman util = new GrafNewman();
		util = (GrafNewman) G; // Transformem de Graf a GrafNewman
		util.calcularEdgeBetween();
		while (util.numComunitats() < numComunidades) {
			if (!util.esborrarMaxim())
				return null; // Futur control d'errors
			util.calcularEdgeBetween();
		}
		return util.comunitats();

	}

	/**
	 * Retorna el conjunt de comunitats corresponent a l�execuci� de l�algorisme
	 * NewmanGirvan a partir del m�xim de camins m�nims que passen per a
	 * qualsevol aresta.
	 * 
	 * @param G
	 *            Graf que es tractar�
	 * @param maxbetweness
	 *            Integer que indica la max btw que hi pot haver al graf
	 * @return Comunitats en les qual cap node tindr� btw > maxbetweness.
	 */
	public static HashSet<HashSet<String>> executa_bet(Graf G, Integer maxbetweness) {
		GrafNewman util = new GrafNewman();
		util = (GrafNewman) G; // Transformem de Graf a GrafNewman
		util.calcularEdgeBetween();
		int maxactual = util.getMaxBetween(); // Variable amb el valor de maxbtw
		while (maxactual > maxbetweness) {
			if (!util.esborrarMaxim())
				return null; // Futur control d'errors
			util.calcularEdgeBetween();
			maxactual = util.getMaxBetween();
		}
		return util.comunitats();
	}
}
