package domini;

import static domini.MacroControlador.gd;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Dani
 *
 */
public class ControladorDadesGraf {

        public Boolean existsCategoria(String nom) {
            return gd.existsCategoria(nom);
        }

	/**
	 * Crea un ControladorDadesGraf.
	 */
	public ControladorDadesGraf() {} 
	
	/**
	 * Obt� el nom de les categories que pertanyen al graf.
	 * @return el nom de les categories
	 */
	public ArrayList<String> getCategories() {
		return gd.getNomCategories();
	}
	
	/**
	 * @return el nombre de categories que hi ha al graf
	 */	
	public Integer getNumCats() {
		return gd.getNombreCategories();
	}
	
	/**
	 * Retorna les p�gines a les que apunta la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 * 
	 * @param nom el nom de la categoria
	 * @return el conjunt de p�gines a les que apunta la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 */	
	public ArrayList<String> getCatCP(String nom) {
		if (gd.existsCategoria(nom)) {
			Collection<Pagina> CP = gd.getCategoria(nom).getMapCP().values();
			ArrayList<String> result = new ArrayList<String>();
			for(Pagina pag : CP) {
				result.add(pag.getNom());
			}
			return result;
		}
		return null;
	} 
	
	/**
	 * Retorna les p�gines que apunten a la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 * 
	 * @param nom el nom de la categoria
	 * @return el conjunt de p�gines que apunten a la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 */
	public ArrayList<String> getCatPC(String nom) {
		if (gd.existsCategoria(nom)) {
			Collection<Pagina> PC = gd.getCategoria(nom).getMapPC().values();
			ArrayList<String> result = new ArrayList<String>();
			for(Pagina pag : PC) {
				result.add(pag.getNom());
			}
			return result;
		}
		return null;
	}
	
	/**
	 * Retorna les supercategories de la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 * 
	 * @param nom el nom de la categoria
	 * @return el conjunt de supercategories de la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 */
	public ArrayList<String> getCsupC(String nom) {
		if (gd.existsCategoria(nom)) {
			Collection<Categoria> CsupC = gd.getCategoria(nom).getMapCSupC().values();
			ArrayList<String> result = new ArrayList<String>();
			for(Categoria cat : CsupC) {
				result.add(cat.getNom());
			}
			return result;
		}
		return null;
	}
	
	/**
	 * Retorna les subcategories de la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 * 
	 * @param nom el nom de la categoria
	 * @return el conjunt de subcategories de la categoria amb nom especificat si existeix, o <code>null</code> si no existeix.
	 */
	public ArrayList<String> getCsubC(String nom) {
		if (gd.existsCategoria(nom)) {
			Collection<Categoria> CsupbC = gd.getCategoria(nom).getMapCSubC().values();
			ArrayList<String> result = new ArrayList<String>();
			for(Categoria cat : CsupbC) {
				result.add(cat.getNom());
			}
			return result;
		}
		return null;
	}
	
	/**
	 * Obt� el nom de les p�gines que pertanyen al graf.
	 * @return el nom de les p�gines
	 */
	public ArrayList<String> getPagines() {
		return gd.getNomPagines();
	}

	/**
	 * @return el nombre de p�gines que hi ha al graf
	 */	
	public Integer getNumPags() {
		return gd.getNombrePagines();
	}
	
	/**
	 * Retorna les categories que apunten a la p�gina amb nom especificat si existeix, o <code>null</code> si no existeix.
	 * 
	 * @param nom el nom de la p�gina
	 * @return el conjunt de categories que apunten a la p�gina amb nom especificat si existeix, o <code>null</code> si no existeix.
	 */
	public ArrayList<String> getPagCP(String nom) {
		if (gd.existsPagina(nom)) {
			Collection<Categoria> CP = gd.getPagina(nom).getCP().values();
			ArrayList<String> result = new ArrayList<String>();
			for(Categoria cat : CP) {
				result.add(cat.getNom());
			}
			return result;
		}
		return null;
	}
	
	/**
	 * Retorna les categories a les que apunta la p�gina amb nom especificat si existeix, o <code>null</code> si no existeix.
	 * 
	 * @param nom el nom de la p�gina
	 * @return el conjunt de categories a les que apunta la p�gina amb nom especificat si existeix, o <code>null</code> si no existeix.
	 */	
	public ArrayList<String> getPagPC(String nom) {
		if (gd.existsPagina(nom)) {
			Collection<Categoria> PC = gd.getPagina(nom).getPC().values();
			ArrayList<String> result = new ArrayList<String>();
			for(Categoria cat : PC) {
				result.add(cat.getNom());
			}
			return result;
		}
		return null;
	}	
	
	/**
	 * Esborra totes les dades del graf
	 */
	public void eliminarDades(){
		gd = new GrafDades();
	}

	/**
	 * Afegeix una nova categoria al graf.
	 * 
	 * @param nom la categoria que ser� afegida al graf
	 * @return <code>true</code> si s'ha afegit la categoria. <code>false</code> si la categoria ja pertanyia al graf
	 */
	public Boolean addCateg(String nom) {
		Categoria cat = new Categoria(nom);
		return gd.addCategoria(cat);
	}
	
	/**
	 * Crea la relaci� "apunta a la p�gina" a la categoria especificada i l'inversa a les p�gines especificades.
	 * 
	 * @param nomCat categoria a la que es crea la relaci� "apunta a la p�gina"
	 * @param cPs les p�gines que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si alguna ja existia
	 */
	public Boolean addCatCP(String nomCat, ArrayList<String> cPs) {
		boolean retorn = true;
		for (String nomPag: cPs) if (!gd.addCP(nomCat, nomPag)) retorn = false;
		return retorn;
	}
	
	/**
	 * Crea la relaci� "�s apuntada per la p�gina" a la categoria especificada i l'inversa a les p�gines especificades.
	 * 
	 * @param nomCat categoria a la que es crea la relaci� "�s apuntada per la p�gina"
	 * @param pCs les p�gines que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si alguna ja existia
	 */
	public Boolean addCatPC(String nomCat, ArrayList<String> pCs) {
		boolean retorn = true;
		for (String nomPag: pCs) if (!gd.addPC(nomPag, nomCat)) retorn = false;
		return retorn;
	}

	/**
	 * Crea la relaci� "�s supercategoria" a la categoria especificada i l'inversa a les categories de <code>sup</code> especificades.
	 * 
	 * @param nomCat categoria a la que es crea la relaci� "�s supercategoria"
	 * @param sup les categories que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si alguna ja existia
	 */
	public Boolean addCsupC(String nomCat, ArrayList<String> sup) {
		boolean retorn = true;
		for (String aux: sup) if (!gd.addCC(aux, nomCat)) retorn = false;
		return retorn;
	}
	
	/**
	 * Crea la relaci� "�s subcategoria" a la categoria especificada i l'inversa a les categories de <code>sub</code> especificades.
	 * 
	 * @param nomCat categoria a la que es crea la relaci� "�s subcategoria"
	 * @param sub les categories que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si alguna ja existia
	 */
	public Boolean addCsubC(String nomCat, ArrayList<String> sub) {
		boolean retorn = true;
		for (String aux: sub) if (!gd.addCC(nomCat, aux)) retorn = false;
		return retorn;
	}

	/**
	 * Canvia el nom de la categoria especificada pel nou nom especificat.
	 * 
	 * @param nomAntic nom de la categoria a la que se li modificar� el <code>nom</code>
	 * @param nomNou el nou <code>nom</code> de la categoria especificada
	 * @return <code>true</code> si s'ha canviat el <code>nom</code>. <code>false</code> si la categoria no pertanyia al graf o si existeix una categoria amb nom = nomNou
	 */
	public Boolean setNomCateg(String nomAntic, String nomNou) {
		return gd.setNomCategoria(nomAntic, nomNou);
	}
	
	
	/**
	 * Assigna la relaci� "apunta a la p�gina" a la categoria especificada i l'inversa a les p�gines especificades. Totes les que havian abans son esborrades.
	 * 
	 * @param nomCat categoria a la que s'assigna la relaci� "apunta a la p�gina"
	 * @param cPs les p�gines que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si hi ha alguna repetida
	 */
	public Boolean setCatCP(String nomCat, ArrayList<String> cPs) {
		Categoria cat = gd.getCategoria(nomCat);
		for (String relacio: gd.getCategoria(nomCat).getMapCP().keySet()) {
			if(!cPs.remove(relacio)) gd.removeCP(cat, gd.getPagina(relacio));
		}
		
		boolean retorn = true;
		for (String s: cPs) if (!gd.addCP(nomCat, s)) retorn = false;		
		
		return retorn;
	}
	
	/**
	 * Assigna la relaci� "�s apuntada per la p�gina" a la categoria especificada i l'inversa a les p�gines especificades. Totes les que havian abans son esborrades.
	 * 
	 * @param nomCat categoria a la que s'assigna la relaci� "�s apuntada per la p�gina"
	 * @param pCs les p�gines que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si hi ha alguna repetida
	 */
	public Boolean setCatPC(String nomCat, ArrayList<String> pCs) {
		Categoria cat = gd.getCategoria(nomCat);
		for (String relacio: gd.getCategoria(nomCat).getMapPC().keySet()) {
			if(!pCs.remove(relacio)) gd.removePC(gd.getPagina(relacio), cat);
		}
		
		boolean retorn = true;
		for (String s: pCs) if (!gd.addPC(s, nomCat)) retorn = false;		
		
		return retorn;
	}
	
	/**
	 * Assigna la relaci� "�s supercategoria" a la categoria especificada i l'inversa a les categories de <code>sup</code> especificades. Totes les que havian abans son esborrades.
	 * 
	 * @param nomCat categoria a la s'assigna la relaci� "�s supercategoria"
	 * @param sup les categories que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si hi ha alguna repetida
	 */
	public Boolean setCsupC(String nomCat, ArrayList<String> sup) {
		Categoria cat = gd.getCategoria(nomCat);
		for (String relacio: gd.getCategoria(nomCat).getMapCSupC().keySet()) {
			if(!sup.remove(relacio)) gd.removeCC(gd.getCategoria(relacio), cat);		
		}
		
		boolean retorn = true;
		for (String s: sup) if (!gd.addCC(s, nomCat)) retorn = false;
		
		return retorn;
	}
	
	/**
	 * Assigna la relaci� "�s subcategoria" a la categoria especificada i l'inversa a les categories de <code>sub</code> especificades. Totes les que havian abans son esborrades.
	 * 
	 * @param nomCat categoria a la s'assigna la relaci� "�s subcategoria"
	 * @param sub les categories que ser�n relacionades amb la categoria
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si hi ha alguna repetida
	 */
	public Boolean setCsubC(String nomCat, ArrayList<String> sub) {
		Categoria cat = gd.getCategoria(nomCat);
		for (String relacio: gd.getCategoria(nomCat).getMapCSubC().keySet()) {
			if(!sub.remove(relacio)) gd.removeCC(cat, gd.getCategoria(relacio));
		}
		
		boolean retorn = true;		 
		for (String s: sub) if (!gd.addCC(nomCat, s)) retorn = false;
		
		return retorn;
	}
	
	/**
	 * Afegeix una nova p�gina al graf.
	 * 
	 * @param nom la p�gina que ser� afegida al graf
	 * @return <code>true</code> si s'ha afegit la p�gina. <code>false</code> si la p�gina ja pertanyia al graf
	 */
	public Boolean addPagina(String nom) {
		Pagina pag = new Pagina(nom);
		return gd.addPagina(pag);
	}
	
	/**
	 * Crea la relaci� "�s apuntada per la categoria" a la p�gina especificada i l'inversa a les categories especificades.
	 * 
	 * @param nomPag p�gina a la que es crea la relaci� "�s apuntada per la categoria"
	 * @param cPs les categories que ser�n relacionades amb la p�gina
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si alguna ja existia
	 */
	public Boolean addPagCP(String nomPag, ArrayList<String> cPs) {
		boolean retorn = true;
		for (String nomCat: cPs) if (!gd.addCP(nomCat, nomPag)) retorn = false;
		return retorn;
	}
	
	/**
	 * Crea la relaci� "apunta a la categoria" a la p�gina especificada i l'inversa a les categories especificades.
	 * 
	 * @param nomPag p�gina a la que es crea la relaci� "apunta a la categoria"
	 * @param pCs les categories que ser�n relacionades amb la p�gina
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si alguna ja existia
	 */
	public Boolean addPagPC(String nomPag, ArrayList<String> pCs) {
		boolean retorn = true;
		for (String nomCat: pCs) if (!gd.addPC(nomPag, nomCat)) retorn = false;
		return retorn;
	}
	
	/**
	 * Canvia el nom de la p�gina especificada pel nou nom especificat.
	 * 
	 * @param nomAntic nom de la p�gina a la que se li modificar� el <code>nom</code>
	 * @param nomNou el nou <code>nom</code> de la p�gina especificada
	 * @return <code>true</code> si s'ha canviat el <code>nom</code>. <code>false</code> si la p�gina no pertanyia al graf o si existeix una p�gina amb nom = nomNou
	 */
	public Boolean setNomPagina(String nomAntic, String nomNou) {
		return gd.setNomPagina(nomAntic, nomNou);
	}	
	
	/**
	 * Assigna la relaci� "�s apuntada per la categoria" a la p�gina especificada i l'inversa a les categories especificades. Totes les que havian abans son esborrades.
	 * 
	 * @param nomPag p�gina a la que s'assigna la relaci� "�s apuntada per la categoria"
	 * @param cPs les categories que ser�n relacionades amb la p�gina
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si hi ha alguna repetida
	 */
	public Boolean setPagCP(String nomPag, ArrayList<String> cPs) {
		Pagina pag = gd.getPagina(nomPag);
		for (String relacio: gd.getPagina(nomPag).getCP().keySet()){
			if(!cPs.remove(relacio)) gd.removeCP(gd.getCategoria(relacio), pag);
		}
		
		boolean retorn = true;
		for (String s: cPs) if (!gd.addCP(s, nomPag)) retorn = false;		
		
		return retorn;
	}
	
	/**
	 * Assigna la relaci� "apunta a la categoria" a la p�gina especificada i l'inversa a les categories especificades. Totes les que havian abans son esborrades.
	 * 
	 * @param nomPag p�gina a la que s'assigna la relaci� "apunta a la categoria"
	 * @param pCs les categories que ser�n relacionades amb la p�gina
	 * @return <code>true</code> si s'han creat totes les relacions. <code>false</code> si hi ha alguna repetida
	 */
	public Boolean setPagPC(String nomPag, ArrayList<String> pCs) {
		Pagina pag = gd.getPagina(nomPag);
		for (String relacio: gd.getPagina(nomPag).getPC().keySet()) {
			if(!pCs.remove(relacio)) gd.removePC(pag, gd.getCategoria(relacio));
		}
		
		boolean retorn = true;
		for (String s: pCs) if (!gd.addPC(nomPag, s)) retorn = false;		
		
		return retorn;
	}
		
	/**
	 * Elimina una p�gina del graf i totes les seves relacions.
	 * 
	 * @param nom la p�gina que ser� eliminada del graf
	 * @return <code>true</code> si s'ha eliminat la p�gina. <code>false</code> si la p�gina no pertanyia al graf
	 */
	public Boolean removePag(String nom) {
		return gd.removePagina(nom);
	}
	
	/**
	 * Elimina una categoria del graf i totes les seves relacions.
	 * 
	 * @param nom la categoria que ser� eliminada del graf
	 * @return <code>true</code> si s'ha eliminat la categoria. <code>false</code> si la categoria no pertanyia al graf
	 */
	public Boolean removeCateg(String nom) {
		return gd.removeCategoria(nom);
	}
}
