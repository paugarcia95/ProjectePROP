package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Comunitat {
	
	private Map<String, Categoria> categoriesComunitat;
		
	public Comunitat() {
		categoriesComunitat = new TreeMap<String, Categoria>();
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
