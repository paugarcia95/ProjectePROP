/**
 * 
 */
package domini;

import static domini.MacroControlador.gd;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Dani
 *
 */
public class ControladorDadesGraf {


	public ControladorDadesGraf() {} 
	

	/**
	 * Pre: Cert
	 * Post: Retorna el nom de totes les categories del graf
	 */
	public ArrayList<String>  getCategories() {
		return gd.getNomCategories();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de categories que hi ha al graf
	 */
	public Integer getNumCats() {
		return gd.getNombreCategories();
	}
	
	/**
	 * Pre: Cert
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les pàgines a les que apunta, altrament retorna <code>null</code>
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
	 * Pre: Cert
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les pàgines que li apunten, altrament retorna <code>null</code>
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
	 * Pre: Cert
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les seves super categories, altrament retorna <code>null</code>
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
	 * Pre: Cert
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les seves sub categories, altrament retorna <code>null</code>
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
	 * Pre: Cert
	 * Post: Retorna el nom de totes les pàgines del graf
	 */
	public ArrayList<String> getPagines() {
		return gd.getNomPagines();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de pàgines que hi ha al graf
	 */
	public Integer getNumPags() {
		return gd.getNombrePagines();
	}
	
	/**
	 * Pre: Cert
	 * Post: Si nom és el nom d'una Pàgina a GrafDades retorna les categories que li apunten, altrament retorna <code>null</code>
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
	 * Pre: Cert
	 * Post: Si nom és el nom d'una Pàgina a GrafDades retorna les categories a les que apunta, altrament retorna <code>null</code>
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
	
	/** TODO
	 * Pre:
	 * Post: Carrega en el graf les dades del fitxer per defecte
	 * @return <code>true</code> si s'ha carregat tot correctament, <code>false</code> si hi ha hagut algun error.
	 */
	/*public Boolean iniciCarregarDades() {
		aux.carregarGrafDades(gd);
		return true;		
	}*/
	
	/**
	 * Pre:
	 * Post:
	 */
	//public Boolean carregarFitxerEnllacosInserir(String ruta) {return true;}
	
	
	/**
	 * Pre: Cert
	 * Post: La Wikipedia és buida
	 */
	public void eliminarDades(){
		gd = new GrafDades();
	}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	//el Boolean indica quin dels dos tipus de format d'entrada ï¿½s, el Boolean retorna 0 si no hi ha errors, 1 si no es reconeix l'URL o 2 si ï¿½s algun altre tipus d'error
	//public Integer introFitx(String URL, Boolean enllasos) {return 1;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	//public Boolean addEnllac(String inici, String fin, Integer tipus) {return true;}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia cap Categoria amb nom == nom es crea i retorna <code>true</code>, altrament retorna <code>false</code>
	 */
	public Boolean addCateg(String nom) {
		Categoria cat = new Categoria(nom);
		return gd.addCategoria(cat);
	}
	
	/**
	 * Pre: Cert
	 * Post: La Categoria amb nom == nomCat apunta a les pàgines a cPs i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean addCatCP(String nomCat, ArrayList<String> cPs ) {
		boolean retorn = true;
		for (String nomPag: cPs) if (!gd.addCP(nomCat, nomPag)) retorn = false;
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: La Categoria amb nom == nomCat és apuntada per les pàgines a pCs i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean addCatPC(String nomCat, ArrayList<String> pCs) {
		boolean retorn = true;
		for (String nomPag: pCs) if (!gd.addPC(nomPag, nomCat)) retorn = false;
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: La Categoria amb nom == nomCat és subcategoria de les categories a sup i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean addCsupC(String nomCat, ArrayList<String> sup) {
		boolean retorn = true;
		for (String aux: sup) if (!gd.addCC(aux, nomCat)) retorn = false;
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: La Categoria amb nom == nomCat és supercategoria de les categories a sub i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean addCsubC(String nomCat, ArrayList<String> sub) {
		boolean retorn = true;
		for (String aux: sub) if (!gd.addCC(nomCat, aux)) retorn = false;
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Categoria amb nom == nomAntic i cap Categoria amb nom == nomNou ara nom = nomNou i retorna <code>true</code>, altrament retorna <code>false</code>
	 */
	public Boolean setNomCateg(String nomAntic, String nomNou) {
		return gd.setNomCategoria(nomAntic, nomNou);
	}
	
	/**
	 * Pre: Existeix una Categoria a GrafDades amb nom == nomCat
	 * Post: La Categoria amb nom == nomCat només apunta a les pàgines a cPs i retorna <code>true</code>, retorna <code>false</code> altrament
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
	 * Pre: Existeix una Categoria a GrafDades amb nom == nomCat
	 * Post: La Categoria amb nom == nomCat només és apuntada per les pàgines a pCs i retorna <code>true</code>, retorna <code>false</code> altrament
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
	 * Pre: Existeix una Categoria a GrafDades amb nom == nomCat
	 * Post: La Categoria amb nom == nomCat només és subcategoria de les categories a sup i retorna <code>true</code>, retorna <code>false</code> altrament
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
	 * Pre: Existeix una Categoria a GrafDades amb nom == nomCat
	 * Post: La Categoria amb nom == nomCat només és supercategoria de les categories a sub i retorna <code>true</code>, retorna <code>false</code> altrament
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
	 * Pre: Cert
	 * Post: Si no existia cap Pàgina amb nom == nom es crea i retorna <code>true</code>, altrament retorna <code>false</code>
	 */
	public Boolean addPagina(String nom) {
		Pagina pag = new Pagina(nom);
		return gd.addPagina(pag);
	}
	
	/**
	 * Pre: Cert
	 * Post: La Pàgina amb nom == nomPag és apuntada per les categories a cPs i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean addPagCP(String nomPag, ArrayList<String> cPs) {
		boolean retorn = true;
		for (String nomCat: cPs) if (!gd.addCP(nomCat, nomPag)) retorn = false;
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: La Pàgina amb nom == nomPag apunta a les categories a pCs i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean addPagPC(String nomPag, ArrayList<String> pCs) {
		boolean retorn = true;
		for (String nomCat: pCs) if (!gd.addPC(nomPag, nomCat)) retorn = false;
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Pàgina amb nom == nomAntic i cap Pàgina amb nom == nomNou ara nom = nomNou i retorna <code>true</code>, altrament retorna <code>false</code>
	 */
	public Boolean setNomPagina(String nomAntic, String nomNou) {
		return gd.setNomPagina(nomAntic, nomNou);
	}
	
	/**
	 * Pre: Existeix una Pàgina a GrafDades amb nom == nomPag
	 * Post: La Pàgina amb nom == nomPag només és apuntada per les categories a cPs i retorna <code>true</code>, retorna <code>false</code> altrament
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
	 * Pre: Existeix una Pàgina a GrafDades amb nom == nomPag
	 * Post: La Pàgina amb nom == nomPag només apunta a les categories a pCs i retorna <code>true</code>, retorna <code>false</code> altrament
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
	 * Pre: Cert
	 * Post: Si existia una Pàgina amb nom == nom ja no ni existeix cap relació amb aquesta Pàgina i retorna <code>true</code>, altrament retorna <code>false</code>
	 */
	public Boolean removePag(String nom) {
		return gd.removePagina(nom);
	}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Categoria amb nom == nom ja no ni existeix cap relació amb aquesta Categoria i retorna <code>true</code>, altrament retorna <code>false</code>
	 */
	public Boolean removeCateg(String nom) {
		return gd.removeCategoria(nom);
	}
}
