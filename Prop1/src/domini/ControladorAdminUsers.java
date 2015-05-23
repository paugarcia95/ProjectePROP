/**
 * 
 */
package domini;

import static domini.MacroControlador.gd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author cristina.fontanet
 *
 */
public class ControladorAdminUsers {
	//PRIVAT
	//	Atribut: una constant amb inici
	EntradaSortidaDadesGraf aux;
	String rutaXDefecte = "C:/Users/Cristina/Google Drive/UNI/PROP/Projecte/cats.txt";
	//PUBLIC
//CONSTRUCTORA

	public ControladorAdminUsers() {/* inicialitzar aux? (EntradaSortidaDadesGraf) */}
	
//CONSULTORES///////////////////////////////////////////////////////////////////////////////
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
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les pàgines a les que apunta, altrament retorna null
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
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les pàgines que li apunten, altrament retorna null
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
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les seves super categories, altrament retorna null
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
	 * Post: Si nom és el nom d'una Categoria a GrafDades retorna les seves sub categories, altrament retorna null
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
	 * Post: Si nom és el nom d'una Pàgina a GrafDades retorna les categories que li apunten, altrament retorna null
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
	 * Post: Si nom és el nom d'una Pàgina a GrafDades retorna les categories a les que apunta, altrament retorna null
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

//MODIFICADORES///////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Pre:
	 * Post: Carrega en el graf les dades del fitxer per defecte
	 * @return true si s'ha carregat tot correctament, false si hi ha hagut algun error.
	 */
	public Boolean iniciCarregarDades() {
		aux = new EntradaSortidaDadesGraf();
	/*	try {
			aux.carregarGrafDades(gd,rutaXDefecte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return true;
		
	}
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean carregarFitxerEnllacosInserir(String ruta) {return true;}
	
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean eliminarDades(){
		gd = new GrafDades(); //TODO Pre Post
		return true;
	}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	//el Boolean indica quin dels dos tipus de format d'entrada ï¿½s, el Boolean retorna 0 si no hi ha errors, 1 si no es reconeix l'URL o 2 si ï¿½s algun altre tipus d'error
	public Integer introFitx(String URL, Boolean enllasos) {return 1;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addEnllac(String inici, String fin, Integer tipus) {return true;}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia cap Categoria amb nom == nom es crea i retorna true, altrament retorna false
	 */
	public Boolean addCateg(String nom) {
		Categoria cat = new Categoria(nom);
		return gd.addCategoria(cat);
	}
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean addCatCP(String nomCat, ArrayList<String> cPs ) {
		for (String nomPag: cPs) gd.addCP(nomCat, nomPag); //TODO Pre Post boolean i Lucid
		return true;
	}
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean addCatPC(String nomCat, ArrayList<String> pCs) {
		for (String nomPag: pCs) gd.addPC(nomPag, nomCat); //TODO Pre Post boolean i Lucid
		return true;
	}
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean addCsupC(String nomCat, ArrayList<String> sup) {
		for (String aux: sup) gd.addCC(aux, nomCat);  //TODO Pre Post boolean i Lucid
		return true;
	}
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean addCsubC(String nomCat, ArrayList<String> sub) {
		for (String aux: sub) gd.addCC(nomCat, aux); //TODO Pre Post boolean i Lucid
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Categoria amb nom == nomAntic i cap Categoria amb nom == nomNou ara nom = nomNou i retorna true, altrament retorna false
	 */
	public Boolean setNomCateg(String nomAntic, String nomNou) {
		return gd.setNomCategoria(nomAntic, nomNou);
	}
	
	/**TODO
	 * Pre:
	 * Post:
	 */
	public Boolean setCatCP(String nomCat, ArrayList<String> cPs) {
		ArrayList<String> memoria = new ArrayList<String>();
		for (String relacio: gd.getCategoria(nomCat).getMapCP().keySet()) memoria.add(relacio);
		
		ArrayList<String> eliminar = new ArrayList<String>();
		for (String s: memoria) if(!cPs.remove(s)) eliminar.add(s);
		
		boolean retorn = true;
		Categoria cat = gd.getCategoria(nomCat);
		for (String s: eliminar) gd.removeCP(cat, gd.getPagina(s));
		for (String s: cPs) if (!gd.addCP(nomCat, s)) retorn = false;		
		
		return retorn;
	}
	
	/**TODO
	 * Pre:
	 * Post:
	 */
	public Boolean setCatPC(String nomCat, ArrayList<String> pCs) {		
		ArrayList<String> memoria = new ArrayList<String>();
		for (String relacio: gd.getCategoria(nomCat).getMapPC().keySet()) memoria.add(relacio);
		
		ArrayList<String> eliminar = new ArrayList<String>();
		for (String s: memoria) if(!pCs.remove(s)) eliminar.add(s);
		
		boolean retorn = true;
		Categoria cat = gd.getCategoria(nomCat);
		for (String s: eliminar) gd.removePC(gd.getPagina(s), cat);
		for (String s: pCs) if (!gd.addPC(s, nomCat)) retorn = false;		
		
		return retorn;
	}
	
	/**TODO
	 * Pre:
	 * Post:
	 */
	public Boolean setCsupC(String nomCat, ArrayList<String> sup) {
		ArrayList<String> memoria = new ArrayList<String>();
		for (String relacio: gd.getCategoria(nomCat).getMapCSupC().keySet()) memoria.add(relacio);
		
		ArrayList<String> eliminar = new ArrayList<String>();
		for (String s: memoria) if(!sup.remove(s)) eliminar.add(s);
		
		boolean retorn = true;
		Categoria cat = gd.getCategoria(nomCat);
		for (String s: eliminar) gd.removeCC(gd.getCategoria(s), cat);
		for (String s: sup) if (!gd.addCC(s, nomCat)) retorn = false;
		
		return retorn;
	}
	
	/**TODO
	 * Pre:
	 * Post:
	 */
	public Boolean setCsubC(String nomCat, ArrayList<String> sub) {
		ArrayList<String> memoria = new ArrayList<String>();
		for (String relacio: gd.getCategoria(nomCat).getMapCSubC().keySet()) memoria.add(relacio);
		
		ArrayList<String> eliminar = new ArrayList<String>();
		for (String s: memoria) if(!sub.remove(s)) eliminar.add(s);
		
		boolean retorn = true;
		Categoria cat = gd.getCategoria(nomCat);
		for (String s: eliminar) gd.removeCC(cat, gd.getCategoria(s));
		for (String s: sub) if (!gd.addCC(nomCat, s)) retorn = false;
		
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si no existia cap Pàgina amb nom == nom es crea i retorna true, altrament retorna false
	 */
	public Boolean addPagina(String nom) {
		Pagina pag = new Pagina(nom);
		return gd.addPagina(pag);
	}
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean addPagCP(String nomPag, ArrayList<String> cPs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 */
	public Boolean addPagPC(String nomPag, ArrayList<String> pCs) {return true;}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Pàgina amb nom == nomAntic i cap Pàgina amb nom == nomNou ara nom = nomNou i retorna true, altrament retorna false
	 */
	public Boolean setNomPagina(String nomAntic, String nomNou) {
		return gd.setNomPagina(nomAntic, nomNou);
	}
	
	/**TODO
	 * Pre:
	 * Post:
	 */
	public Boolean setPagCP(String nomPag, ArrayList<String> cPs) {
		ArrayList<String> memoria = new ArrayList<String>();
		for (String relacio: gd.getPagina(nomPag).getCP().keySet()) memoria.add(relacio);
		
		ArrayList<String> eliminar = new ArrayList<String>();
		for (String s: memoria) if(!cPs.remove(s)) eliminar.add(s);
		
		boolean retorn = true;
		Pagina pag = gd.getPagina(nomPag);
		for (String s: eliminar) gd.removeCP(gd.getCategoria(s), pag);
		for (String s: cPs) if (!gd.addCP(s, nomPag)) retorn = false;		
		
		return retorn;
	}
	
	/**TODO
	 * Pre:
	 * Post:
	 */
	public Boolean setPagPC(String nomPag, ArrayList<String> pCs) {
		ArrayList<String> memoria = new ArrayList<String>();
		for (String relacio: gd.getPagina(nomPag).getPC().keySet()) memoria.add(relacio);
		
		ArrayList<String> eliminar = new ArrayList<String>();
		for (String s: memoria) if(!pCs.remove(s)) eliminar.add(s);
		
		boolean retorn = true;
		Pagina pag = gd.getPagina(nomPag);
		for (String s: eliminar) gd.removePC(pag, gd.getCategoria(s));
		for (String s: pCs) if (!gd.addPC(nomPag, s)) retorn = false;		
		
		return retorn;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Pàgina amb nom == nom ja no ni existeix cap relació amb aquesta Pàgina i retorna true, altrament retorna false
	 */
	public Boolean removePag(String nom) {
		return gd.removePagina(nom);
	}
	
	/**
	 * Pre: Cert
	 * Post: Si existia una Categoria amb nom == nom ja no ni existeix cap relació amb aquesta Categoria i retorna true, altrament retorna false
	 */
	public Boolean removeCateg(String nom) {
		return gd.removeCategoria(nom);
	}
}
