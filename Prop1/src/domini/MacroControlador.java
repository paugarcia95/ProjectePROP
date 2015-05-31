/**
 * Controlador principal del programa de la Wikipedia (PROP 2015)
 */
package domini;

import java.io.File;

/**
 * @author cristina.fontanet
 *
 */
public class MacroControlador {
    
	static domini.ControladorUsers cu;
	static domini.ControladorDadesGraf cau;
	static TraduccioiAlgorisme ta;
	static domini.GrafDades gd;
	static domini.ConjuntUsuaris conj;
	static String useractual;
	static EntradaSortidaDades aux;

	/**
	 * Creadora per defecte del Macrocontrolador
	 */
	public MacroControlador() {
		conj = new ConjuntUsuaris();
		gd = new GrafDades();
		cu = new ControladorUsers(conj, gd);
		cau = new ControladorDadesGraf();
		ta = new TraduccioiAlgorisme();
		aux = new EntradaSortidaDades();
	}
	
        /*
        *   Assigna l'usuari actual del programa
        */
	public void setUserActual(String user) {
		useractual = user;
	}
        
        /*
        * A traves de la persistencia, carrega les dades de l'ultim estat del programa
        */
	public Boolean carregaDades() {
            if(aux.carregarGrafDades(gd))return false;
            if(aux.carregarUsuaris(conj.getMap()))return false;
            return true;
	}
        
        /*
        * Introdueix dades a la Wikipedia a partir d'un fitxer
        */
	public void carregaDadesFitxer(File fitxer) {
            aux.llegirGrafDades(gd,fitxer);
	}
        
        /*
        * A traves de la persistencia, guarda l'estat actual de les dades per a la proxima sessio
        */
        public Boolean guardaDades() {
             if(aux.guardarGrafDades(gd)) return false;
             if(aux.guardarUsuaris(conj.getMap()))return false;
             return true;
        }
	
	public void eliminarDadesGraf(){
		gd = new GrafDades();
	}
	
	

// CONSULTORES///////////////////////////////////////////////////////////////////////////////

        public String getMissatgeError() {
            return aux.getError();
        }
        
	public ControladorUsers getContUser(){
		return cu;
	}
	
	public ControladorDadesGraf getContAdUs() {
		return cau;
	}
	
	public String getUserActual() {
           // System.out.println(useractual);
		return useractual;
	}
	public GrafDades getGraf(){ //PROVISIONAL
		return gd;
	}
	//public ConjuntUsuaris getConjUsers() {	//PROVISIONAL
	//	return conj;
	//}

}
