/**
 * 
 */
package domini;

import java.util.ArrayList;

/**
 * @author Cristina
 *
 */
public class ControladorAdminUsers {
	//PRIVAT
	//	Atribut: una constant amb inici
	
	//PUBLIC
//CONSTRUCTORA
	/**
	 * 
	 */
	public ControladorAdminUsers() {
		// TODO Auto-generated constructor stub
	}

//CONSULTORES
	public ArrayList<String>  getCategories() {return null;} 
	public String getCategoria(Integer i) {return null;}
	//nse si aquestes d'aqui abaix (idem x pag) es poden posar totes dins d'una funció, però el fet de donar-li a la vista tots els atributs a partir d'strings es la unica manera q se m'ha acudit
	public ArrayList<String> getCatCP(String Categoria) {return null;} 
	public ArrayList<String> getCatPC(String Categoria) {return null;}
	public ArrayList<String> getCsupC(String Categoria) {return null;}
	public ArrayList<String> getCsubC(String Categoria) {return null;}
	public ArrayList<String> getPagines() {return null;}
	public String getPagina(Integer i) {return null;}
	public ArrayList<String> getPagCP(String Pagina) {return null;}
	public ArrayList<String> getPagPC(String Pagina) {return null;}

//MODIFICADORES
	
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean inici_carregarDades() {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean carregar_fitxer_enllacos_inserir(String ruta) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public void fer_cerca() {}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean Eliminar_dades(){return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	//el boolean indica quin dels dos tipus de format d'entrada és, el boolean retorna 0 si no hi ha errors, 1 si no es reconeix l'URL o 2 si és algun altre tipus d'error
	public Integer Intro_fitx(String URL, boolean enllaços) {return 1;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addEnllac(String inici, String fin, Integer tipus) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addCateg(String nom) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addCP(String nom_cat, ArrayList<String> CPs ) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addPC(String nom_cat, ArrayList<String> PCs) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addCsupC(String nom_cat, ArrayList<String> Sup) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addCsubC(String nom_cat, ArrayList<String> Sub) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	//els set abans eren Modifica_
	public boolean setNomCateg(String nom_antic, String nom) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean setCP(String nom_cat, ArrayList<String> CPs) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean setPC(String nom_cat, ArrayList<String> PCs) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean setCsupC(String nom_cat, ArrayList<String> Sup) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean setCsubC(String nom_cat, ArrayList<String> Sub) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addPagina(String nom) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addPCP(String nom_pag, ArrayList<String> CPs) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean addPPC(String nom_pag, ArrayList<String> PCs) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean setNomPagina(String nom_antic, String nom_nou) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean setPCP(String nom_pag, ArrayList<String> CPs) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean setPPC(String nom_pag, ArrayList<String> PCs) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean removePag(String nom) {return true;}
	/**
	 * Pre:
	 * Post:
	 * @return
	 */
	public boolean removeCateg(String nom) {return true;}
}
