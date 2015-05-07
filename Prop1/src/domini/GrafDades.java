package domini;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class GrafDades {
	
	private Map<String, Categoria> categories;
	private Map<String, Pagina> pagines;
	
	
	public GrafDades() {
		categories = new TreeMap<String, Categoria>();
		pagines = new TreeMap<String, Pagina>();
	}
	
	/**
	 * Pre: nom és una key de categories amb una assignació
	 * Post: Retorna la assignació de nom a categories
	 */
	public Categoria getCategoria(String nom) {
		return categories.get(nom);
	}
	
	/**
	 * Pre: nom és una key de pagines amb una assignació
	 * Post: Retorna la assignació de nom a pagines
	 */
	public Pagina getPagina(String nom) {
		return pagines.get(nom);
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de categories que hi ha al graf
	 */
	public Integer getNombreCategories() {
		return categories.size();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de pàgines que hi ha al graf
	 */
	public Integer getNombrePagines() {
		return pagines.size();
	}
	
	/**
	 * Pre: Cert
	 * Post: Si cat no existia a categories ara és l'assignació de la key cat.Nom i retorna true, altrament retorna false
	 */
	public Boolean addCategoria(Categoria cat) {
		if (categories.containsKey(cat.getNom())) return false;
		categories.put(cat.getNom(), cat);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si pag no existia a pagines ara és l'assignació de la key pag.Nom i retorna true, altrament retorna false
	 */
	public Boolean addPagina(Pagina pag) {
		if (pagines.containsKey(pag.getNom())) return false;
		pagines.put(pag.getNom(), pag);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia ja la relació entre cat1 i cat2 ara cat1 es super de cat2 i retorna true, altrament retorna false
	 */	
	public Boolean addCC(Categoria cat1, Categoria cat2) {
		if (cat1 == cat2 || cat1.getNom() == cat2.getNom()) return false;
		boolean conte1, conte2;
		conte1 = categories.containsKey(cat1.getNom());
		conte2 = categories.containsKey(cat2.getNom());
		if (conte1 && conte2) {
			if (cat1.existsCC(cat2.getNom()) == 2 /*&& cat2.existsCC(cat1.getNom()) == 1*/) { //ja existeix
				return false;
			}
			//com que el graf es consistent no existeixen els casos  {(0,1),(0,2),(1,0),(1,1),(2,0),(2,2)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!conte1 && conte2) {
			categories.put(cat1.getNom(), cat1);
		}
		else if (conte1 && !conte2) {
			categories.put(cat2.getNom(), cat2);
		}
		else {
			categories.put(cat1.getNom(), cat1);
			categories.put(cat2.getNom(), cat2);
		}
		cat1.addCsubC(cat2);
		cat2.addCsupC(cat1);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia ja la relació entre cat1 i cat2 ara cat1 es super de cat2 i retorna true, altrament retorna false
	 */	
	public Boolean addCC(String categoria1, String categoria2) {
		if (categoria1.equals(categoria2)) return false;
		boolean conte1, conte2;
		Categoria cat1, cat2;
		conte1 = categories.containsKey(categoria1);
		conte2 = categories.containsKey(categoria2);
		if (conte1 && conte2) {
			cat1 = categories.get(categoria1);
			cat2 = categories.get(categoria2);
			if (cat1.existsCC(categoria2) == 2 /*&& cat2.existsCC(categoria1) == 1*/) { //ja existeix
				return false;
			}
			//com que el graf es consistent no existeixen els casos  {(0,1),(0,2),(1,0),(1,1),(2,0),(2,2)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!conte1 && conte2) {
			cat1 = new Categoria(categoria1);
			categories.put(categoria1, cat1);
			cat2 = categories.get(categoria2);
		}
		else if (conte1 && !conte2) {
			cat1 = categories.get(categoria1);
			cat2 = new Categoria(categoria2);
			categories.put(categoria2, cat2);
		}
		else {
			cat1 = new Categoria(categoria1);
			cat2 = new Categoria(categoria2);
			categories.put(categoria1, cat1);
			categories.put(categoria2, cat2);
		}
		cat1.addCsubC(cat2);
		cat2.addCsupC(cat1);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia ja la relació entre pag i cat ara pag apunta a cat i retorna true, altrament retorna false
	 */
	public Boolean addPC(Pagina pag, Categoria cat) {
		boolean conte1, conte2;
		conte1 = pagines.containsKey(pag.getNom());
		conte2 = categories.containsKey(cat.getNom());
		if (conte1 && conte2) {
			if (pag.existsPC(cat.getNom()) == 1 /*&& cat.existsCP(pag.getNom()) == 1*/) { //ja existeix
				return false;
			}
			//com que el graf es consistent no existeixen els casos {(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!conte1 && conte2) {
			pagines.put(pag.getNom(), pag);
		}
		else if (conte1 && !conte2) {
			categories.put(cat.getNom(), cat);
		}
		else {
			pagines.put(pag.getNom(), pag);
			categories.put(cat.getNom(), cat);
		}
		pag.addPC(cat);
		cat.addPC(pag);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia ja la relació entre pag i cat ara pag apunta a cat i retorna true, altrament retorna false
	 */
	public Boolean addPC(String pagina, String categoria) {
		Categoria cat;
		Pagina pag;
		boolean conte1, conte2;
		conte1 = pagines.containsKey(pagina);
		conte2 = categories.containsKey(categoria);
		if (conte1 && conte2) {
			pag = pagines.get(pagina);
			cat = categories.get(categoria);
			if (pag.existsPC(categoria) == 1 /*&& cat.existsCP(pagina) == 1*/) { //ja existeix
				return false;
			}
			//com que el graf es consistent no existeixen els casos {(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!conte1 && conte2) {
			pag = new Pagina(pagina);
			pagines.put(pagina, pag);
			cat = categories.get(categoria);
		}
		else if (conte1 && !conte2) {
			pag = pagines.get(pagina);
			cat = new Categoria(categoria);
			categories.put(categoria, cat);
		}
		else {
			pag = new Pagina (pagina);
			cat = new Categoria (categoria);
			pagines.put(pagina, pag);
			categories.put(categoria, cat);
		}
		pag.addPC(cat);
		cat.addPC(pag);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia ja la relació entre cat i pag ara cat apunta a pag i retorna true, altrament retorna false
	 */
	public Boolean addCP(Categoria cat, Pagina pag) {
		boolean conte1, conte2;
		conte1 = categories.containsKey(cat.getNom());
		conte2 = pagines.containsKey(pag.getNom());
		if (conte1 && conte2) {
			if (cat.existsCP(pag.getNom()) == 2 /*&& pag.existsPC(cat.getNom()) == 2*/) { //ja existeix
				return false;
			}
			//com que el graf es consistent no existeixen els casos {(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!conte1 && conte2) {
			categories.put(cat.getNom(), cat);
		}
		else if (conte1 && !conte2) {
			pagines.put(pag.getNom(), pag);
		}
		else {
			categories.put(cat.getNom(), cat);
			pagines.put(pag.getNom(), pag);
		}
		cat.addCP(pag);
		pag.addCP(cat);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia ja la relació entre cat i pag ara cat apunta a pag i retorna true, altrament retorna false
	 */
	public Boolean addCP(String categoria, String pagina) {
		Pagina pag;
		Categoria cat;
		boolean conte1, conte2;
		conte1 = categories.containsKey(categoria);
		conte2 = pagines.containsKey(pagina);
		if (conte1 && conte2) {
			cat = categories.get(categoria);
			pag = pagines.get(pagina);
			if (cat.existsCP(pagina) == 2 /*&& pag.existsPC(categoria) == 2*/) { //ja existeix
				return false;
			}
			//com que el graf es consistent no existeixen els casos {(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)}
			//el cas (0,0) es tracta al final del metode
		}
		else if (!conte1 && conte2) {
			cat = new Categoria(categoria);
			categories.put(categoria, cat);
			pag = pagines.get(pagina);
		}
		else if (conte1 && !conte2) {
			cat = categories.get(categoria);
			pag = new Pagina(pagina);
			pagines.put(pagina, pag);
		}
		else {
			cat = new Categoria (categoria);
			pag = new Pagina (pagina);
			categories.put(categoria, cat);
			pagines.put(pagina, pag);
		}
		cat.addCP(pag);
		pag.addCP(cat);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna true si cat1 era super de cat2 i ja no, false altrament
	 */
	public Boolean removeCC(Categoria cat1, Categoria cat2) {
		if (categories.containsKey(cat1.getNom()) && categories.containsKey(cat2.getNom())) {
			if (cat1.existsCC(cat2.getNom()) == 2 && cat2.existsCC(cat1.getNom()) == 1) {
				cat1.removeCsubC(cat2.getNom());
				cat2.removeCsupC(cat1.getNom());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna true si pag apuntava a cat i ja no, false altrament
	 */
	public Boolean removePC(Pagina pag, Categoria cat) {
		if (pagines.containsKey(pag.getNom()) && categories.containsKey(cat.getNom())) {
			if (pag.existsPC(cat.getNom()) == 1 && cat.existsCP(pag.getNom()) == 1) {
				pag.removePC(cat.getNom());
				cat.removePC(pag.getNom());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna true si cat apuntava a pag i ja no, false altrament
	 */
	public Boolean removeCP(Categoria cat, Pagina pag) {
		if (categories.containsKey(cat.getNom()) && pagines.containsKey(pag.getNom())) {
			if (pag.existsPC(cat.getNom()) == 2 && cat.existsCP(pag.getNom()) == 2) {
				cat.removeCP(pag.getNom());
				pag.removeCP(cat.getNom());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si nom era una key de categories amb una assignació nom ja no és key de categories i retorna true, altrament retorna false
	 */
	public Boolean removeCategoria(String nom) {
		if (categories.containsKey(nom)) {
			categories.remove(nom);
			return true;
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si nom era una key de pagines amb una assignació ja no és key de pagines i retorna true, altrament retorna false
	 */
	public Boolean removePagina(String nom) {
		if (pagines.containsKey(nom)) {
			pagines.remove(nom);
			return true;
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna si existeix una Categoria assignada a nom
	 */
	public Boolean existsCategoria(String nom) {
		return categories.containsKey(nom);
	}

	/**
	 * Pre: Cert
	 * Post: Retorna si existeix una Pagina assignada a nom
	 */
	public Boolean existsPagina(String nom) {
		return pagines.containsKey(nom);
	}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Categoria amb nom == nomAntic ara nom = nomNou i retorna true, altrament retorna false
	 */
	public Boolean setNomCategoria(String nomAntic, String nomNou) {
		if (nomAntic.equals(nomNou)) return false;
		if (categories.containsKey(nomAntic) && !categories.containsKey(nomNou)) {
			Categoria c = categories.remove(nomAntic);
			c.setNom(nomNou);
			categories.put(nomNou, c);
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
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Pagina amb nom == nomAntic ara nom = nomNou i retorna true, altrament retorna false
	 */
	public Boolean setNomPagina(String nomAntic, String nomNou) {
		if (pagines.containsKey(nomAntic) && !pagines.containsKey(nomNou)) {
			Pagina p = pagines.remove(nomAntic);
			p.setNom(nomNou);
			pagines.put(nomNou, p);
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
	
	/**
	 * Pre: Cert
	 * Post: Retorna el conjunt de categories
	 */
	public Collection<Categoria> getCategories() {
		return categories.values();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el conjunt de pàgines
	 */
	public Collection<Pagina> getPagines() {
		return pagines.values();
	}
	
}
