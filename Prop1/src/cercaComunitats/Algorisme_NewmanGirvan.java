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
		while(util.Num_comunitats() < numComunidades) {
			util.Calculate_edge_between();
			if(!util.esborrar_maxim()) return null; // Futur control d'errors;
		}
		return util.comunitats();
		
	}
	
	//Retorna el conjunt de comunitats corresponent a l’execució de l’algorisme NewmannGirvan a partir del màxim de camins mínims que passen per a qualsevol aresta.
	public HashSet<HashSet<String>> executa_bet(Graf G, Integer maxbetwennesses) {
		return null;
		
		
	}
}
