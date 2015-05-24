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
	
	public Boolean addCat(String categoria) {
		for (String nom: categoriesComunitat) if(nom.equals(categoria)) return false;
		categoriesComunitat.add(categoria);
		return true;
	}
	
	public Boolean removeCat(String categoria) {
		return categoriesComunitat.remove(categoria);
	}
	
	public ArrayList<String> getCategories() {
		return categoriesComunitat;
	}
	
}
