package domini;

import java.util.ArrayList;

/**
 * @author Dani
 *
 */

public class Comunitat {
	
	private Integer id;
	private ArrayList<String> categoriesComunitat;
	
	/**
	 * Crea una Comunitat amb l'id especificat.
	 * 
	 * @param id l'identificador de la comunitat
	 */
	public Comunitat(Integer id) {
		this.id = id;
		categoriesComunitat = new ArrayList<String>();
	}
	
	/**
	 * Crea una Comunitat amb id -1.
	 */	
	public Comunitat() {
		id = -1;
		categoriesComunitat = new ArrayList<String>();
	}
	
	/**
	 * @return l'<code>id</code> de la comunitat
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id l'id de la comunitat
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return el nombre de categories que té la comunitat
	 */	
	public Integer getNumeroDeCategories() {
		return categoriesComunitat.size();	
	}
	
	/**
	 * Afegeix una nova categoria a la comunitat.
	 * 
	 * @param categoria la categoria que serà afegida a la comunitat
	 * @return <code>true</code> si s'ha afegit la categoria. <code>false</code> si la categoria ja pertanyia a la comunitat
	 */
	public Boolean addCat(String categoria) {
		for (String nom: categoriesComunitat) if(nom.equals(categoria)) return false;
		categoriesComunitat.add(categoria);
		return true;
	}
	
	/**
	 * Elimina una categoria de la comunitat.
	 * 
	 * @param categoria la categoria que serà eliminada de la comunitat
	 * @return <code>true</code> si s'ha eliminat la categoria. <code>false</code> si la categoria no pertanyia a la comunitat
	 */
	public Boolean removeCat(String categoria) {
		return categoriesComunitat.remove(categoria);
	}
	
	/**
	 * Obté el nom de les categories que pertanyen a la comunitat.
	 * @return el nom de les categories
	 */
	public ArrayList<String> getCategories() {
		return categoriesComunitat;
	}
	
}
