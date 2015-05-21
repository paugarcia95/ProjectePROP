package domini;

import java.util.ArrayList;

/**
 * @author Dani
 *
 */

public class Comunitat {
	
	private Integer id;
	private ArrayList<String> categoriesComunitat;
		
	public Comunitat(Integer id) {
		this.id = id;
		categoriesComunitat = new ArrayList<String>();
	}
	
	public Comunitat() {
		id = -1;
		categoriesComunitat = new ArrayList<String>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroDeCategories() {
		return categoriesComunitat.size();	
	}
	
	/*public Categoria getCat(String nom) { AIXÒ JA NO FUNCIONA JA QUE ARA GUARDA STRINGS
		return categoriesComunitat.get(nom);
	}*/
	
	public void addCat(String categoria) {
		categoriesComunitat.add(categoria);
	}
	
	public void removeCat(String categoria) {
		categoriesComunitat.remove(categoria);
	}
	
	public ArrayList<String> getCategories() {
		return categoriesComunitat;
	}
	
}
