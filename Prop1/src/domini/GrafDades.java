package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class GrafDades {
	
	private Map<String, Categoria> Categories;
	private Map<String, Pagina> Pagines;
	
	
	public GrafDades() {
		Categories = new TreeMap<String, Categoria>();
		Pagines = new TreeMap<String, Pagina>();
	}
	
	//Pre: nom és una key de Categories amb una assignació
	//Post: retorna la assignació de nom a Categories
	public Categoria getCategoria(String nom) {
		return Categories.get(nom);
	}
	
	//Pre: nom és una key de Pagines amb una assignació
	//Post: retorna la assignació de nom a Pagines
	public Pagina getPagina(String nom) {
		return Pagines.get(nom);
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de Categories que hi ha al graf
	public Integer getNombreCategories() {
		return Categories.size();
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de Pàgines que hi ha al graf
	public Integer getNombrePagines() {
		return Pagines.size();
	}
	
	//Pre: Cert
	//Post: cat és l'assignació de la key cat.Nom
	public Boolean addCategoria(Categoria cat) {
		if (Categories.containsKey(cat.getNom())) return false;
		Categories.put(cat.getNom(), cat);
		return true;
	}
	
	//Pre: Cert
	//Post: pag és l'assignació de la key pag.Nom
	public Boolean addPagina(Pagina pag) {
		if (Pagines.containsKey(pag.getNom())) return false;
		Pagines.put(pag.getNom(), pag);
		return true;
	}
	
	
	public Boolean addCC(Categoria cat1, Categoria cat2) {
		if (Categories.containsKey(cat1.getNom()) && Categories.containsKey(cat2.getNom())) {
			if (cat1.existsCC(cat2.getNom()) == 2 && cat2.existsCC(cat1.getNom()) == 1) { //ja existeix
				return false;
			}
			if (cat1.existsCC(cat2.getNom()) == 1 && cat2.existsCC(cat1.getNom()) == 2) { //existeix la contraria
				return false;
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
		return true;
	}
	
	
	public Boolean addPC(Pagina pag, Categoria cat) {
		if (Pagines.containsKey(pag.getNom()) && Categories.containsKey(cat.getNom())) {
			if (pag.existsPC(cat.getNom()) == 1 && cat.existsCP(pag.getNom()) == 1) { //ja existeix
				return false;
			}
			if (pag.existsPC(cat.getNom()) == 2 && cat.existsCP(pag.getNom()) == 2) { //existeix la contraria
				return false;
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
		return true;
	}
	
	
	public Boolean addCP(Categoria cat, Pagina pag) {
		if (Categories.containsKey(cat.getNom()) && Pagines.containsKey(pag.getNom())) {
			if (cat.existsCP(pag.getNom()) == 2 && pag.existsPC(cat.getNom()) == 2) { //ja existeix
				return false;
			}
			if (cat.existsCP(pag.getNom()) == 1 && pag.existsPC(cat.getNom()) == 1) { //existeix la contraria
				return false;
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
		return true;
	}
	
	//Pre: Cert
	//Post: retorna true si cat1 era super de cat2 i ja no, false altrament
	public Boolean removeCC(Categoria cat1, Categoria cat2) {
		if (Categories.containsKey(cat1.getNom()) && Categories.containsKey(cat2.getNom())) {
			if (cat1.existsCC(cat2.getNom()) == 2 && cat2.existsCC(cat1.getNom()) == 1) {
				cat1.removeCsubC(cat2.getNom());
				cat2.removeCsupC(cat1.getNom());
				return true;
			}
		}
		return false;
	}
	
	//Pre: Cert
	//Post: retorna true si pag apuntava a cat i ja no, false altrament
	public Boolean removePC(Pagina pag, Categoria cat) {
		if (Pagines.containsKey(pag.getNom()) && Categories.containsKey(cat.getNom())) {
			if (pag.existsPC(cat.getNom()) == 1 && cat.existsCP(pag.getNom()) == 1) {
				pag.removePC(cat.getNom());
				cat.removePC(pag.getNom());
				return true;
			}
		}
		return false;
	}
	
	//Pre: Cert
	//Post: retorna true si cat apuntava a pag i ja no, false altrament
	public Boolean removeCP(Categoria cat, Pagina pag) {
		if (Categories.containsKey(cat.getNom()) && Pagines.containsKey(pag.getNom())) {
			if (pag.existsPC(cat.getNom()) == 2 && cat.existsCP(pag.getNom()) == 2) {
				cat.removeCP(pag.getNom());
				pag.removeCP(cat.getNom());
				return true;
			}
		}
		return false;
	}
	
	
	//Pre: Cert
	//Post: Si nom era una key de Categories amb una assignació nom ja no és key de Categories, altrament retorna false
	public Boolean removeCategoria(String nom) {
		if (Categories.containsKey(nom)) {
			Categories.remove(nom);
			return true;
		}
		return false;
	}
	
	//Pre: Cert
	//Post: Si nom era una key de Pagines amb una assignació ja no és key de Pagines, altrament retorna false
	public Boolean removePagina(String nom) {
		if (Pagines.containsKey(nom)) {
			Pagines.remove(nom);
			return true;
		}
		return false;
	}
	
	//Pre: Cert
	//Post: Retorna si existeix una Categoria assignada a nom
	public Boolean existsCategoria(String nom) {
		return Categories.containsKey(nom);
	}

	//Pre: Cert
	//Post: Retorna si existeix una Pagina assignada a nom
	public Boolean existsPagina(String nom) {
		return Pagines.containsKey(nom);
	}
	
	//Pre: Cert
	//Post: Si existia una Categoria amb nom == nomAntic ara nom = nomNou i retorna true, altrament retorna false
	public Boolean setNomCategoria(String nomAntic, String nomNou) {
		if (Categories.containsKey(nomAntic) && !Categories.containsKey(nomNou)) {
			Categoria c = Categories.remove(nomAntic);
			c.setNom(nomNou);
			Categories.put(nomNou, c);
			Map<String, Pagina> CpPc = c.getMapCP();
			for (Pagina pag : CpPc.values())
			{
				pag.removeCP(nomAntic);
				pag.addCP(c);
			}
			CpPc = c.getMapPC();
			for (Pagina pag : CpPc.values())
			{
				pag.removePC(nomAntic);
				pag.addPC(c);
			}
			Map<String, Categoria> CSubcCsupc = c.getMapCSubC();
			for (Categoria cat : CSubcCsupc.values())
			{
				cat.removeCsupC(nomAntic);
				cat.addCsupC(c);
			}
			CSubcCsupc = c.getMapCSupC();
			for (Categoria cat : CSubcCsupc.values())
			{
				cat.removeCsubC(nomAntic);
				cat.addCsubC(c);
			}
			return true;
		}
		return false;
	}
	
	//Pre: Cert
	//Post: Si existia una Pagina amb nom == nomAntic ara nom = nomNou i retorna true, altrament retorna false
	public Boolean setNomPagina(String nomAntic, String nomNou) {
		if (Pagines.containsKey(nomAntic) && !Pagines.containsKey(nomNou)) {
			Pagina p = Pagines.remove(nomAntic);
			p.setNom(nomNou);
			Pagines.put(nomNou, p);
			Map<String, Categoria> PcCp = p.getPC();
			for (Categoria cat : PcCp.values())
			{
				cat.removePC(nomAntic);
				cat.addPC(p);
			}
			PcCp = p.getCP();
			for (Categoria cat : PcCp.values())
			{
				cat.removeCP(nomAntic);
				cat.addCP(p);
			}
			return true;
		}
		return false;
	}
		

}
