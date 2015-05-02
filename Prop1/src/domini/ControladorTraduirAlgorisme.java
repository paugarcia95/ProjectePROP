/**
 * 
 */
package domini;

/**
 * @author Rafa
 *
 */
public class ControladorTraduirAlgorisme {

		private Integer maxvalor = new Integer(80);
	/**
	 * Explicacio
	 * @param 
	 * @param 
	 * @return 
	 */
	private Integer CalcularPesEntreCategories(Categoria c1, Categoria c2, Criteris cri){
		Integer solucio = new Integer(0);
		if(cri.getEvitaCat().contains(c1) || cri.getEvitaCat().contains(c2)) return solucio; // Criteri d'ignorar
		else if(cri.getSubconjCat().contains(c1) && cri.getSubconjCat().contains(c2)) return solucio = maxvalor; //Criteri de només aquell subconjunt de cats
		else {
			
			////////////**************Criteri de cat-cat i cat-pg********/////////////
			Integer temp = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg
			if(temp == 5) solucio += 5;
			else if(temp > 5) solucio += (5+(temp-5));
			else solucio += 5-(5-temp);
			/////////////*********************************************///////////
			
			//////////*************Criteri de coincidencia *********//////////
			String paraulacercada = new String(cri.getParaulaClau().getParaula()); // Criteri nom cat coincident
			String ncat = new String(c1.getNom());
			String ncat2 = new String(c2.getNom());
			Integer criteri = new Integer(cri.getParaulaClau().getNum());
			
			if(criteri == 10) { // Cas de que han de contenir EXACTAMENT la paraula
				if(ncat.indexOf(paraulacercada) != -1 && ncat2.indexOf(paraulacercada) != -1) {
					return solucio = maxvalor;
				}
				else return solucio = 0;
			}
			else if (criteri > 5) { // Cas en q és >5, premiem les coincidencies i penalitzem els errors
				if(ncat.indexOf(paraulacercada) != -1 && ncat2.indexOf(paraulacercada) != -1) {
					solucio += paraulacercada.length()*criteri; // premio la coincidencia
					solucio += solucio/2; // Y favorezco que esté en los 2
					solucio -= ((ncat.length() - paraulacercada.length())*criteri)+((ncat2.length() - paraulacercada.length())*criteri); // Li resto una mica per la diferència
				}
				else { // Si no conté a la paraula clau
					solucio -= paraulacercada.length()*criteri; // Li resto una mica de valor
				}
			}
			else if ( criteri > 0) {
				if(ncat.indexOf(paraulacercada) != -1) solucio += paraulacercada.length()*criteri; // premio la coincidencia
			}
			/////////////////////***********************************//////////////////
		}
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
	private Boolean GrafDadestoGraf (GrafDades graf, Criteris cri) {
		
		return null;
	}
	/**
	 * Explicacio
	 * @param 
	 * @param 
	 * @return 
	 */
	public CercaComunitats Traduir_i_buscar (GrafDades graf, Criteris cri) {
		
		return null;
		
	}
}
