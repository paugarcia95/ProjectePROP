/**
 * 
 */
package cercaComunitats;

import java.util.ArrayList;
import java.util.HashSet;

import domini.CercaComunitats;

/**
 * @author Rafa
 *
 */
public class Algorisme_NewmanGirvan {
	
	public Algorisme_NewmanGirvan() {
		// TODO Auto-generated constructor stub
	}
	
	private Integer calculadora (Integer iterador, Integer percentatge) {
		Integer solu = new Integer(((iterador-1)*percentatge)/100);
		return solu;
	}
	
	//Retorna el conjunt de comunitats corresponent a l’execució de l’algorisme NewmannGirvan a partir del percentatge de dispersió desitjat.
	public HashSet<HashSet<String>> executa(Graf G, Integer percentatge) {
		ArrayList<HashSet<HashSet<String>>> storage = new ArrayList<HashSet<HashSet<String>>>();
		Integer iterador = new Integer(1);
		GrafNewman util = new GrafNewman();
		util = (GrafNewman) G; // Transformem de Graf a GrafNewman
		util.Calculate_edge_between();
		while(util.Num_comunitats() != G.size()) {
			storage.add(iterador, util.comunitats());
			util.esborrar_maxim();
			util.Calculate_edge_between();
			++iterador;
		}
		
		Integer quitoca = new Integer(calculadora(iterador,percentatge));
		return storage.get(quitoca);
		
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
