package domini;

import java.util.Map;
import java.util.TreeMap;

public class Comunitat {
	
	private int Identificador, Numero_categories; //crec que Numero_categories no fa falta
	private Map<String, Categoria> CategoriesComunitat;
	
	public Comunitat(int id) {
		Identificador = id;
		Numero_categories = 0;
		CategoriesComunitat = new TreeMap<String, Categoria>();
	}
	
	public Comunitat() {
		Identificador = -1; //Pau: mmm.. aixo podria donar problemes, podrien haver-hi dues comunitats amb el mateix 
							//     id, ho hauriem de parlar a classe. he vist que has posat que podria ser un string,
							//	   a mi tambe em sembla bé
		Numero_categories = 0;
		CategoriesComunitat = new TreeMap<String, Categoria>();
	}
	
	public int getId() {
		return Identificador;
	}
	
	public int getNumeroDeCategories() {
		return Numero_categories;
		//return CategoriesComunitat.size();	
	}
	
	public Categoria getCat(String key) {
		return CategoriesComunitat.get(key);
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
