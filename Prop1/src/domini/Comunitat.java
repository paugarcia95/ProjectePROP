package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Comunitat {
	
	private Integer id;
	private Map<String, Categoria> categoriesComunitat;
		
	public Comunitat(Integer id) {
		this.id = id;
		categoriesComunitat = new TreeMap<String, Categoria>();
	}
	
	public Comunitat() {
		id = -1;
		categoriesComunitat = new TreeMap<String, Categoria>();
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
	
	public Categoria getCat(String nom) {
		return categoriesComunitat.get(nom);
	}
	
	public void addCat(Categoria c) {
		categoriesComunitat.put(c.getNom(), c);
	}
	
	public void removeCat(String categoria) {
		categoriesComunitat.remove(categoria);
	}
	
	public Map<String, Categoria> getMapCat() {
		return categoriesComunitat;
	}
	
	public void setMapCat(Map<String, Categoria> mapa) {
		categoriesComunitat = mapa;
	}
	
}
