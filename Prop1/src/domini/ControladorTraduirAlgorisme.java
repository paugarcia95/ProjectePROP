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
			
			Integer temp = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg
			if(temp == 5) solucio += 5;
			else if(temp > 5) solucio += (5+(temp-5));
			else solucio += 5-(5-temp);
			
			
		}
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
