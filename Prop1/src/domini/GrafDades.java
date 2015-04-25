package domini;

import java.util.Map;
import java.util.TreeMap;

public class GrafDades {
	
	private Map<String, Categoria> Categories;
	private Map<String, Pagina> Pagines;
	
	
	public GrafDades() {
		Categories = new TreeMap<String, Categoria>();
		Pagines = new TreeMap<String, Pagina>();
	}
	
	//Pre: nom �s una key de Categories amb una assignaci�
	//Post: retorna la assignaci� de nom a Categories
	public Categoria getCategoria(String nom) {
		return Categories.get(nom);
	}
	
	//Pre: nom �s una key de Pagines amb una assignaci�
	//Post: retorna la assignaci� de nom a Pagines
	public Pagina getPagina(String nom) {
		return Pagines.get(nom);
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de Categories que hi ha al graf
	public Integer getNombreCategories() {
		return Integer.valueOf(Categories.size());
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de P�gines que hi ha al graf
	public Integer getNombrePagines() {
		return Integer.valueOf(Pagines.size());
	}
	
	//Pre: cat no �s l'assignaci� de cap key a Categories
	//Post: cat �s l'assignaci� de la key cat.Nom
	public Boolean addCategoria(Categoria cat) {
		if (Categories.containsKey(cat.getNom())) return Boolean.FALSE;
		Categories.put(cat.getNom(), cat);
		return Boolean.TRUE;
	}
	
	//Pre: pag no �s l'assignaci� de cap key a Pagines
	//Post: pag �s l'assignaci� de la key pag.Nom
	public Boolean addPagina(Pagina pag) {
		Pagines.put(pag.getNom(), pag);
		return Boolean.TRUE;
	}
	
	
	public Boolean addCC(Categoria cat1, Categoria cat2) {
		if (Categories.containsKey(cat1.getNom()) && Categories.containsKey(cat2.getNom())) {
			if (cat1.existsCC(cat2.getNom()) == 2 && cat2.existsCC(cat1.getNom()) == 1) { //ja existeix
				return Boolean.FALSE;
			}
			if (cat1.existsCC(cat2.getNom()) == 1 && cat2.existsCC(cat1.getNom()) == 2) { //existeix la contraria
				return Boolean.FALSE;
			}
			//com que el graf es consistent no existeixen els casos  {(0,1),(0,2),(1,0),(1,1),(2,0),(2,2)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!Categories.containsKey(cat1.getNom()) && Categories.containsKey(cat2.getNom())) {
			Categories.put(cat1.getNom(), cat1);
		}
		else if (Categories.containsKey(cat1.getNom()) && !Categories.containsKey(cat2.getNom())) {
			Categories.put(cat2.getNom(), cat2);
		}
		else {
			Categories.put(cat1.getNom(), cat1);
			Categories.put(cat2.getNom(), cat2);
		}
		cat1.addCsubC(cat2);
		cat2.addCsupC(cat1);
		return Boolean.TRUE;
	}
	
	
	public Boolean addPC(Pagina pag, Categoria cat) {
		if (Pagines.containsKey(pag.getNom()) && Categories.containsKey(cat.getNom())) {
			if (pag.existsPC(cat.getNom()) == 1 && cat.existsCP(pag.getNom()) == 1) { //ja existeix
				return Boolean.FALSE;
			}
			if (pag.existsPC(cat.getNom()) == 2 && cat.existsCP(pag.getNom()) == 2) { //existeix la contraria
				return Boolean.FALSE;
			}
			//com que el graf es consistent no existeixen els casos {(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!Pagines.containsKey(pag.getNom()) && Categories.containsKey(cat.getNom())) {
			Pagines.put(pag.getNom(), pag);
		}
		else if (Pagines.containsKey(pag.getNom()) && !Categories.containsKey(cat.getNom())) {
			Categories.put(cat.getNom(), cat);
		}
		else {
			Pagines.put(pag.getNom(), pag);
			Categories.put(cat.getNom(), cat);
		}
		pag.addPC(cat);
		cat.addPC(pag);
		return Boolean.TRUE;
	}
	
	
	public Boolean addCP(Categoria cat, Pagina pag) {
		if (Categories.containsKey(cat.getNom()) && Pagines.containsKey(pag.getNom())) {
			if (cat.existsCP(pag.getNom()) == 2 && pag.existsPC(cat.getNom()) == 2) { //ja existeix
				return Boolean.FALSE;
			}
			if (cat.existsCP(pag.getNom()) == 1 && pag.existsPC(cat.getNom()) == 1) { //existeix la contraria
				return Boolean.FALSE;
			}
			//com que el graf es consistent no existeixen els casos {(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!Categories.containsKey(cat.getNom()) && Pagines.containsKey(pag.getNom())) {
			Categories.put(cat.getNom(), cat);
		}
		else if (Categories.containsKey(cat.getNom()) && !Pagines.containsKey(pag.getNom())) {
			Pagines.put(pag.getNom(), pag);
		}
		else {
			Categories.put(cat.getNom(), cat);
			Pagines.put(pag.getNom(), pag);
		}
		cat.addCP(pag);
		pag.addCP(cat);
		return Boolean.TRUE;
	}
	
	//Pre: Cert
	//Post: retorna true si cat1 era super de cat2 i ja no, false altrament
	public Boolean removeCC(Categoria cat1, Categoria cat2) {
		if (Categories.containsKey(cat1.getNom()) && Categories.containsKey(cat2.getNom())) {
			if (cat1.existsCC(cat2.getNom()) == 2 && cat2.existsCC(cat1.getNom()) == 1) {
				cat1.removeCsubC(cat2.getNom());
				cat2.removeCsupC(cat1.getNom());
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	//Pre: Cert
	//Post: retorna true si pag apuntava a cat i ja no, false altrament
	public boolean removePC(Pagina pag, Categoria cat) {
		if (Pagines.containsKey(pag.getNom()) && Categories.containsKey(cat.getNom())) {
			if (pag.existsPC(cat.getNom()) == 1 && cat.existsCP(pag.getNom()) == 1) {
				pag.removePC(cat.getNom());
				cat.removePC(pag.getNom());
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	//Pre: Cert
	//Post: retorna true si cat apuntava a pag i ja no, false altrament
	public Boolean removeCP(Categoria cat, Pagina pag) {
		if (Categories.containsKey(cat.getNom()) && Pagines.containsKey(pag.getNom())) {
			if (pag.existsPC(cat.getNom()) == 2 && cat.existsCP(pag.getNom()) == 2) {
				cat.removeCP(pag.getNom());
				pag.removeCP(cat.getNom());
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	
	//Pre: Cert
	//Post: si nom era una key de Categories amb una assignaci� nom ja no �s key de Categories, altrament retorna false
	public Boolean removeCategoria(String nom) {
		if (Categories.containsKey(nom)) {
			Categories.remove(nom);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	//Pre: Cert
	//Post: si nom era una key de Pagines amb una assignaci� ja no �s key de Pagines, altrament retorna false
	public Boolean removePagina(String nom) {
		if (Pagines.containsKey(nom)) {
			Pagines.remove(nom);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	//Pre: Cert
	//Post: retorna si existeix una Categoria assignada a nom
	public Boolean existsCategoria(String nom) {
		return Boolean.valueOf(Categories.containsKey(nom));
	}

	//Pre: Cert
	//Post: retorna si existeix una Pagina assignada a nom
	public Boolean existsPagina(String nom) {
		return Boolean.valueOf(Pagines.containsKey(nom));
	}
		

}
