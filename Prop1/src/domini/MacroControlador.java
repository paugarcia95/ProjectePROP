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
		cu = new ControladorUsers();
		cau = new ControladorDadesGraf();
		ta = new TraduccioiAlgorisme();
		aux = new EntradaSortidaDades();
	}
	
        /**
         *  Assigna l'usuari actual del programa
         * 
         * @param user usuari que fa el login
         */
	public void setUserActual(String user) {
		useractual = user;
	}
        
        /**
         * A traves de la persistencia, carrega les dades de la Wikipedia i dels seus usuaris de l'ultim estat del programa a memoria 
         * 
         * @return true si s'ha processat correctament el fitxer
         *         false si hi ha hagut algun error
         */
	public Boolean carregaDades() {
            if(aux.carregarGrafDades(gd))return false;
            if(aux.carregarUsuaris(conj.getMap()))return false;
            return true;
	}
        
        /**
         * Introdueix dades a la Wikipedia a partir d'un fitxer
         * 
         * @param fitxer de dades que l'usuari vol introduir al sistema
         * @return true si s'ha processat correctament el fitxer
         *         false si hi ha hagut algun error
         */
	public Boolean carregaDadesFitxer(File fitxer) {
            if(aux.llegirGrafDades(gd,fitxer))return false;
            else return true;
	}

        /**
         * A traves de la persistencia, guarda l'estat actual de les dades per a la proxima sessio
         * 
         * @return true si s'han pogut desar correctament les dades del sistema
         *         false si hi ha hagut algun error
         */
        public Boolean guardaDades() {
             if(aux.guardarGrafDades(gd)) return false;
             if(aux.guardarUsuaris(conj.getMap()))return false;
             return true;
        }
	
        /**
         * Elimina totes les dades de les pagines i categories de la Wikipedia
         */
	public void eliminarDadesGraf(){
		gd = new GrafDades();
	}
	
	/**
         * Consulta el missatge d'error de la capa de persistencia
         * 
         * @return missatge d'error de la capa de persistencia
         */
        public String getMissatgeError() {
            return aux.getError();
        }
        
        /**
         * Consulta el controlador d'usuaris del sistema
         * 
         * @return controlador d'usuaris del sistema
         */
	public ControladorUsers getContUser(){
		return cu;
	}
	
        /**
         * Consulta el controlador del dades de la wikipedia
         * 
         * @return controlador de dades de la wikipedia
         */
	public ControladorDadesGraf getContDades() {
		return cau;
	}
	
        /**
         *  Consulta l'usuari actual del sistema
         * 
         * @return usuari loguejat actualment
         */
	public String getUserActual() {
		return useractual;
	}
        
        //PROVISIONAL
	public GrafDades getGraf(){ 
		return gd;
	}
}
