/**
 * 
 */
package domini;

import java.util.ArrayList;
import java.util.Collection;

import cercaComunitats.Graf;


/**
 * @author Rafa
 *
 */
public class ControladorTraduirAlgorisme {

	private Integer maxvalor = new Integer(80);
	
	private static int similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) { // longer should always have greater length
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) { return 10; /* both strings are zero length */ }

        return (longerLength - editDistance(longer, shorter)); // Retorna la distancia

    }


    private static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }
	
	
	/**
	 * Explicacio
	 * @param 
	 * @param 
	 * @return 
	 */
	private Integer CalcularPesEntreCategories(Categoria c1, Categoria c2, Criteris cri){
		Integer solucio = new Integer(0);	
		
		////////////**************Criteri de cat-cat i cat-pg********/////////////
		Integer temp = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg
		if(temp == 5) solucio += 5;
		else if(temp > 5) solucio += (5+(temp-5));
		else solucio += 5-(5-temp);
		/////////////*********************************************///////////
		
		
		/////////// Criteri Semblan�a //////////////////
		solucio += cri.getSemblNom()*(similarity(c1.getNom(),c2.getNom()));
		/////////////////////////////////////////////////
		
		
		if(solucio < 0) solucio = 0; // Evitem que suigi negatiu
		return solucio;
	}
	
	
	/**
	 * Explicacio
	 * @param 
	 * @param 
	 * @return 
	 */
	private Integer CalcularPesEntreCatPag(Categoria c, Pagina p, Criteris cri) {
		Integer solucio = new Integer(0);
		if(cri.getEvitaCat().contains(c) || cri.getEvitaCat().contains(p)) return solucio; // Criteri d'ignorar aquestes cat o pg !!! ESta mal lo de p!!!!
		else {
			
			Integer temp = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg
			if(temp == 5) solucio += 5;
			else if(temp < 5) solucio += (5+(5-temp));
			else solucio += 5-(temp-5);
			
			
		}
		
		return solucio;
		
	}
	
	
	
	/**
	 * Explicacio
	 * @param 
	 * @param 
	 * @return 
	 */
	private Graf GrafDadestoGraf (GrafDades graf, Criteris cri) {
		Graf solucio;
		Collection<Categoria> llistat = graf.getCategories();
		
		/////////////////ANEM A AFEGIR ELS NODES AL GRAF //////////////////
		
		if(cri.getSubconjCat().size() != 0) {// Si aquest criteri est� actiu...(subconjunt)
			for(Categoria cataux : llistat) {
				if(cri.getSubconjCat().contains(cataux)) {// I est� a la llista d'acceptats
					solucio.addNode(cataux.getNom()); // L'afegim
				}
			}
		}
		else {
			if(cri.getParaulaClau().getNum() != 0) { // Si est� activat el criteri de paraula clau
				if(cri.getParaulaClau().getNum() == 5) {
					String ayuda = cri.getParaulaClau().getParaula().substring(0, (cri.getParaulaClau().getParaula().length())/2); // Partim la paraula /2
					for(Categoria cataux : llistat) { // Recorrem els nodes
						if(cataux.getNom().indexOf(ayuda) != -1) { // Si la paraula/2 est� inclosa al nom de la categoria
							solucio.addNode(cataux.getNom()); //L'afegim al graf
						}
					}
				}
				else { // Si el criteri val 10 �s molt estricte
					String ayuda = cri.getParaulaClau().getParaula();
					for(Categoria cataux : llistat) {
						if(cataux.getNom().indexOf(ayuda) != -1) { // mirem q continguin exactament aquella paraula
							solucio.addNode(cataux.getNom());
						}
						
					}
					
				}
			}
		}
		return solucio;
	}
	
	/**
	 * Explicacio
	 * @param 
	 * @param 
	 * @return 
	 */
	public ArrayList<Comunitat> Traduir_i_buscar (GrafDades graf, Criteris cri) {
		
		return null;
		
	}
}
