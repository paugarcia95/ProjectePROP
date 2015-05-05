/**
 * 
 */
package domini;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
	 * Pre:
	 * Post:
	 * @return
	 */
	public ArrayList<String>  getCategories() {return null;} 
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public String getCategoria(Integer i) {return null;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	//nse si aquestes d'aqui abaix (idem x pag) es poden posar totes dins d'una funci�, per� el fet de donar-li a la vista tots els atributs a partir d'strings es la unica manera q se m'ha acudit
	public ArrayList<String> getCatCP(String Categoria) {return null;} 
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public ArrayList<String> getCatPC(String Categoria) {return null;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public ArrayList<String> getCsupC(String Categoria) {return null;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public ArrayList<String> getCsubC(String Categoria) {return null;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public ArrayList<String> getPagines() {return null;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public String getPagina(Integer i) {return null;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public ArrayList<String> getPagCP(String Pagina) {return null;}
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public ArrayList<String> getPagPC(String Pagina) {return null;}

//MODIFICADORES///////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Pre:
	 * Post: Carrega en el graf les dades del fitxer per defecte
	 * @return true si s'ha carregat tot correctament, false si hi ha hagut algun error.
	 */
	public Boolean iniciCarregarDades() {
		aux = new EntradaSortidaDadesGraf();
		try {
			aux.carregarGrafDades(gd,rutaXDefecte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	//el Boolean indica quin dels dos tipus de format d'entrada �s, el Boolean retorna 0 si no hi ha errors, 1 si no es reconeix l'URL o 2 si �s algun altre tipus d'error
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
