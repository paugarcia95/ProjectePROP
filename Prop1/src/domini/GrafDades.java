package domini;

import java.util.ArrayList;
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
	
	/**
	 * Crea un GrafDades buit.
	 */
	public GrafDades() {
		categories = new TreeMap<String, Categoria>();
		pagines = new TreeMap<String, Pagina>();
	}
	
	/**
	 * 
	 * @param nom el nom de la categoria que retorna
	 * @return la categoria amb nom especificat. <code>null</code> si la categoria no pertany al graf
	 */
	public Categoria getCategoria(String nom) {
		return categories.get(nom);
	}
	
	/**
	 * 
	 * @param nom el nom de la pàgina que retorna
	 * @return la pàgina amb nom especificat. <code>null</code> si la pàgina no pertany al graf
	 */
	public Pagina getPagina(String nom) {
		return pagines.get(nom);
	}
	
	/**
	 * @return el nombre de categories que hi ha al graf
	 */	
	public Integer getNombreCategories() {
		return categories.size();
	}
	
	/**
	 * @return el nombre de pàgines que hi ha al graf
	 */	
	public Integer getNombrePagines() {
		return pagines.size();
	}
	
	/**
	 * Afegeix una nova categoria al graf.
	 * 
	 * @param cat la categoria que serà afegida al graf
	 * @return <code>true</code> si s'ha afegit la categoria. <code>false</code> si la categoria ja existia al graf
	 */
	public Boolean addCategoria(Categoria cat) {
		if (categories.containsKey(cat.getNom())) return false;
		categories.put(cat.getNom(), cat);
		return true;
	}
	
	/**
	 * Afegeix una nova pàgina al graf.
	 * 
	 * @param pag la pàgina que serà afegida al graf
	 * @return <code>true</code> si s'ha afegit la pàgina. <code>false</code> si la pàgina ja existia al graf
	 */
	public Boolean addPagina(Pagina pag) {
		if (pagines.containsKey(pag.getNom())) return false;
		pagines.put(pag.getNom(), pag);
		return true;
	}	
	
	/**
	 * Crea la relació "és subcategoria" a la categoria amb nom <code>cat1</code> i l'inversa a la categoria amb nom <code>cat2</code>.
	 * 
	 * @param categoria1 nom de la categoria a la que es crea la relació "és subcategoria"
	 * @param categoria2 nom de la categoria a la que es crea la relació "és supercategoria"
	 * @return <code>true</code> si s'ha creat la relació. <code>false</code> si ja existia
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
			//els casos (0,0) i (1,2) es tracten al final del metode
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
	 * Crea la relació "és apuntada per la pàgina" a la categoria amb nom especificat i l'inversa a la pàgina amb nom especificat.
	 * 
	 * @param pagina nom de la pàgina a la que es crea la relació "apunta a"
	 * @param categoria nom de la categoria a la que es crea la relació "és apuntada per"
	 * @return <code>true</code> si s'ha creat la relació. <code>false</code> si ja existia
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
			//els casos (0,0) i (2,2) es tracten al final del metode
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
	 * Crea la relació "apunta a la pàgina" a la categoria amb nom especificat i l'inversa a la pàgina amb nom especificat.
	 * 
	 * @param categoria nom de la categoria a la que es crea la relació "apunta a"
	 * @param pagina nom de la pàgina a la que es crea la relació "és apuntada per"
	 * @return <code>true</code> si s'ha creat la relació. <code>false</code> si ja existia
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
			//els casos (0,0) i (1,1) es tracten al final del metode
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
	 * Elimina la relació "és subcategoria" de la categoria <code>cat1</code> i l'inversa de la categoria <code>cat2</code>.
	 * 
	 * @param cat1 categoria de la qual s'elimina la relació "és subcategoria"
	 * @param cat2 categoria de la qual s'elimina la relació "és supercategoria"
	 * @return <code>true</code> si s'ha eliminat la relació. <code>false</code> si no existeix al graf alguna categoria o si no estan relacionades
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
	 * Elimina la relació "és apuntada per la pàgina" a la categoria <code>cat</code> i l'inversa a la pàgina <code>pag</code>.
	 * 
	 * @param pag pàgina a la qual s'elimina la relació "apunta a"
	 * @param cat categoria a la qual s'elimina la relació "és apuntada per"
	 * @return <code>true</code> si s'ha eliminat la relació. <code>false</code> si no existeix al graf la categoria o la pàgina; o si no estan relacionades
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
	 * Elimina la relació "apunta a la pàgina" a la categoria <code>cat</code> i l'inversa a la pàgina <code>pag</code>.
	 * 
	 * @param cat categoria a la qual s'elimina la relació "apunta a"
	 * @param pag pàgina a la qual s'elimina la relació "és apuntada per"
	 * @return <code>true</code> si s'ha eliminat la relació. <code>false</code> si no existeix al graf la categoria o la pàgina; o si no estan relacionades
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
	 * Elimina una categoria del graf i totes les seves relacions.
	 * 
	 * @param nom la categoria que serà eliminada del graf
	 * @return <code>true</code> si s'ha eliminat la categoria. <code>false</code> si la categoria no pertanyia al graf
	 */
	public Boolean removeCategoria(String nom) {
		if (categories.containsKey(nom)) {
			Categoria c = categories.remove(nom);
			Map<String, Pagina> CpPc = c.getMapCP();
			for (Pagina pag : CpPc.values()) pag.removeCP(nom);
			CpPc = c.getMapPC();
			for (Pagina pag : CpPc.values()) pag.removePC(nom);
			Map<String, Categoria> CSubcCsupc = c.getMapCSubC();
			for (Categoria cat : CSubcCsupc.values()) cat.removeCsupC(nom);
			CSubcCsupc = c.getMapCSupC();
			for (Categoria cat : CSubcCsupc.values()) cat.removeCsubC(nom);
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina una pàgina del graf i totes les seves relacions.
	 * 
	 * @param nom la pàgina que serà eliminada del graf
	 * @return <code>true</code> si s'ha eliminat la pàgina. <code>false</code> si la pàgina no pertanyia al graf
	 */
	public Boolean removePagina(String nom) {
		if (pagines.containsKey(nom)) {
			Pagina p = pagines.remove(nom);			
			Map<String, Categoria> PcCp = p.getPC();
			for (Categoria cat : PcCp.values()) cat.removePC(nom);
			PcCp = p.getCP();
			for (Categoria cat : PcCp.values()) cat.removeCP(nom);
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna si la categoria amb nom especificat existeix al graf. 
	 * 
	 * @param nom nom de la categoria buscada
	 * @return <code>true</code> si la categoria amb nom especificat pertany a <code>categories</code>
	 */
	public Boolean existsCategoria(String nom) {
		return categories.containsKey(nom);
	}

	/**
	 * Retorna si la pàgina amb nom especificat existeix al graf. 
	 * 
	 * @param nom nom de la pàgina buscada
	 * @return <code>true</code> si la pàgina amb nom especificat pertany a <code>pagines</code>
	 */
	public Boolean existsPagina(String nom) {
		return pagines.containsKey(nom);
	}

	/**
	 * Canvia el nom de la categoria especificada pel nou nom especificat.
	 * 
	 * @param nomAntic nom de la categoria a la que se li modificarà el <code>nom</code>
	 * @param nomNou el nou <code>nom</code> de la categoria especificada
	 * @return <code>true</code> si s'ha canviat el <code>nom</code>. <code>false</code> si la categoria no pertanyia al graf o si existeix una categoria amb nom = nomNou
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
	 * Canvia el nom de la pàgina especificada pel nou nom especificat.
	 * 
	 * @param nomAntic nom de la pàgina a la que se li modificarà el <code>nom</code>
	 * @param nomNou el nou <code>nom</code> de la pàgina especificada
	 * @return <code>true</code> si s'ha canviat el <code>nom</code>. <code>false</code> si la pàgina no pertanyia al graf o si existeix una pàgina amb nom = nomNou
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
	 * Obté les categories que pertanyen al graf.
	 * @return les categories del graf
	 */
	public Collection<Categoria> getCategories() {
		return categories.values();
	}
	
	/**
	 * Obté les pàgines que pertanyen al graf.
	 * @return les pàgines del graf
	 */
	public Collection<Pagina> getPagines() {
		return pagines.values();
	}
	
	/**
	 * Obté el nom de les categories que pertanyen al graf.
	 * @return el nom de les categories del graf
	 */
	public ArrayList<String> getNomCategories() {
		ArrayList<String> result = new ArrayList<String>();
		for (Categoria cat : categories.values()) {
			result.add(cat.getNom());
	    }
		return result;		
	}
	
	/**
	 * Obté el nom de les pàgines que pertanyen al graf.
	 * @return el nom de les pàgines del graf
	 */
	public ArrayList<String> getNomPagines() {
		ArrayList<String> result = new ArrayList<String>();
		for (Pagina pag : pagines.values()) {
			result.add(pag.getNom());
	    }
		return result;	
	}
	
}
