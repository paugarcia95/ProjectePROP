/**
 * 
 */
package cercaComunitats;

import java.util.HashSet;

/**
 * @author Rafa
 *
 */
public class Algorisme_NewmanGirvan {
	
	public Algorisme_NewmanGirvan() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Retorna el conjunt de comunitats corresponent a l’execució de l’algorisme NewmannGirvan a partir del percentatge de dispersió desitjat.
	public HashSet<HashSet<String>> executa(Graf G, Integer percentatge) {
		GrafNewman util = new GrafNewman();
		util = (GrafNewman) G; // Transformem de Graf a GrafNewman
		util.Calculate_edge_between();
		return null;
		
	}
	
	//Retorna el conjunt de comunitats corresponent a l’execució de l’algorisme NewmannGirvan a partir del nombre de Comunitats desitjat.
	public HashSet<HashSet<String>> executa_num(Graf G, Integer numComunidades) {
		GrafNewman util = new GrafNewman();
		util = (GrafNewman) G; // Transformem de Graf a GrafNewman
		util.Calculate_edge_between();
		while(util.Num_comunitats() < numComunidades) {
			if(!util.esborrar_maxim()) return null; // Futur control d'errors
			util.Calculate_edge_between();
		}
		return util.comunitats();
		
	}
	
	//Retorna el conjunt de comunitats corresponent a l’execució de l’algorisme NewmannGirvan a partir del màxim de camins mínims que passen per a qualsevol aresta.
	public HashSet<HashSet<String>> executa_bet(Graf G, Integer maxbetweness) {
		GrafNewman util = new GrafNewman();
		util = (GrafNewman) G; // Transformem de Graf a GrafNewman
		util.Calculate_edge_between();
		int maxactual = util.getMaxBet(); //Variable amb el valor de maxbtw
		while(maxactual > maxbetweness) {
			if(!util.esborrar_maxim()) return null; // Futur control d'errors
			util.Calculate_edge_between();
			maxactual = util.getMaxBet();
		}
		return util.comunitats();
	}
}
