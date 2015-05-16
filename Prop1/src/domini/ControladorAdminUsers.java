/**
 * 
 */
package domini;

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
	private GrafDades gd;
	@SuppressWarnings("unused")
	private ConjuntUsuaris conj;
	EntradaSortidaDadesGraf aux;
	String rutaXDefecte = "C:/Users/Cristina/Google Drive/UNI/PROP/Projecte/cats.txt";
	//PUBLIC
//CONSTRUCTORA
	/**
	 * @param noug
         * @param nouu
	 */
	public ControladorAdminUsers(GrafDades noug, ConjuntUsuaris nouu) {
		gd= noug;
		conj = nouu;
	}
	
	public void actualitzaRefs(ConjuntUsuaris nouu, GrafDades noug) {
		conj = nouu;
		gd = noug;
	}

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
	 * @return
	 */
	public Boolean carregarFitxerEnllacosInserir(String ruta) {return true;}
	
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean eliminarDades(){return true;}
	
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
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addCateg(String nom) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addCP(String nom_cat, ArrayList<String> CPs ) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addPC(String nom_cat, ArrayList<String> PCs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addCsupC(String nom_cat, ArrayList<String> Sup) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addCsubC(String nom_cat, ArrayList<String> Sub) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	//els set abans eren Modifica_
	public Boolean setNomCateg(String nom_antic, String nom) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean setCP(String nom_cat, ArrayList<String> CPs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean setPC(String nom_cat, ArrayList<String> PCs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean setCsupC(String nom_cat, ArrayList<String> Sup) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean setCsubC(String nom_cat, ArrayList<String> Sub) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addPagina(String nom) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addPCP(String nom_pag, ArrayList<String> CPs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean addPPC(String nom_pag, ArrayList<String> PCs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean setNomPagina(String nom_antic, String nom_nou) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean setPCP(String nom_pag, ArrayList<String> CPs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean setPPC(String nom_pag, ArrayList<String> PCs) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean removePag(String nom) {return true;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public Boolean removeCateg(String nom) {return true;}
}
