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
public class AlgorismeNewmanGirvan {

	/**
	 * 
	 * Creadora per defecte
	 */
	public AlgorismeNewmanGirvan() {
		// TODO Auto-generated constructor stub
	}
	
	public AlgorismeNewmanGirvan(Graf G) {
		
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
		Integer solu = new Integer(((iterador) * percentatge) / 100);
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
		GrafNewman util = new GrafNewman(G);
                int arestes = util.getNumArestes();
                util.invertirPesos();
		util.calcularEdgeBetween();
		int quitoca = calculadora(arestes, percentatge);
                int iterador = 0;
		while ( iterador< quitoca) {
			util.esborrarMaxim();
			util.calcularEdgeBetween();
			++iterador;
		}
		return util.comunitats();
            
            /*ArrayList<HashSet<HashSet<String>>> storage = new ArrayList<HashSet<HashSet<String>>>();
		int iterador = 0;
		GrafNewman util = new GrafNewman(G);
                util.invertirPesos();
		util.calcularEdgeBetween();
                Integer numero =util.numComunitats(); 
		while ( numero< G.size()) {
			storage.add(iterador, util.comunitats());
			util.esborrarMaxim();
			util.calcularEdgeBetween();
			++iterador;
                        numero = util.numComunitats();
		}
		storage.add(iterador, util.comunitats());
		Integer quitoca = new Integer(calculadora(iterador, percentatge));
		return storage.get(quitoca); */

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
	public static HashSet<HashSet<String>> executaNum(Graf G, Integer numComunidades) {
            
		GrafNewman util = new GrafNewman(G);
                util.invertirPesos();
		util.calcularEdgeBetween();
		Integer tamany = new Integer(G.getNodes().size());
		if(numComunidades > tamany) numComunidades = tamany; // En cas de q se'ns demani mes comunitats q nodes, canviem el valor
		while (util.numComunitats() < numComunidades) {
			if (!util.esborrarMaxim()) return null; //control d'errors
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
	public static HashSet<HashSet<String>> executabet(Graf G, Integer maxbetweness) {
		GrafNewman util = new GrafNewman(G);
                util.invertirPesos();
		util.calcularEdgeBetween();
		int maxactual = util.getMaxBetween(); // Variable amb el valor de maxbtw
		while (maxactual > maxbetweness) {
			if (!util.esborrarMaxim()) return null;// control d'errors
			util.calcularEdgeBetween();
			maxactual = util.getMaxBetween();
		}
		return util.comunitats();
	}
}
