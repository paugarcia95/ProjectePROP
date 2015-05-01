package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Comunitat {
	
	private Integer Identificador;
	private Map<String, Categoria> CategoriesComunitat;
	
	public Comunitat(Integer id) {
		Identificador = id;
		CategoriesComunitat = new TreeMap<String, Categoria>();
	}
	
	public Comunitat() {
		Identificador = -1; 	//Pau: mmm.. aixo podria donar problemes, podrien haver-hi dues comunitats amb el mateix 
												//     id, ho hauriem de parlar a classe. he vist que has posat que podria ser un string,
												//	   a mi tambe em sembla bé
		CategoriesComunitat = new TreeMap<String, Categoria>();
	}
	
	public Integer getId() {
		return Identificador;
	}
	
	public Integer getNumeroDeCategories() {
		return CategoriesComunitat.size();	
	}
	
	public Categoria getCat(String nom) {
		return CategoriesComunitat.get(nom);
	}
	
	public void addCat(Categoria c) {
		CategoriesComunitat.put(c.getNom(), c);
	}
	
	public void removeCat(String categoria) {
		CategoriesComunitat.remove(categoria);
	}
	
	public Map<String, Categoria> getMapCat() {
		return CategoriesComunitat;
	}
	
	public void setMapCat(Map<String, Categoria> mapa) {
		CategoriesComunitat = mapa;
	}
	
}
