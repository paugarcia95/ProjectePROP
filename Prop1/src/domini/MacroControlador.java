/**
 * 
 */
package domini;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;

/**
 * @author Cristina
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

// CREADORA///////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	public MacroControlador() {
		conj = new ConjuntUsuaris();
		gd = new GrafDades();
		cu = new ControladorUsers(conj, gd);
		cau = new ControladorDadesGraf();
		ta = new TraduccioiAlgorisme();
		aux = new EntradaSortidaDades();
	}
	
// MODIFICADORES///////////////////////////////////////////////////////////////////////////////
	
	public void setUserActual(String user) {
		useractual = user;
	}
	public Boolean carregaDades() {
            if(aux.carregarGrafDades(gd))return false;
            if(aux.carregarUsuaris(conj.getMap()))return false;
            return true;
	}
        
	public void carregaDadesFitxer(File fitxer) {
            aux.llegirGrafDades(gd,fitxer);
            //aux.carregarGrafDades(gd);
	}
	public Boolean carregaUsers() {
		return cu.iniciCarregarUsers();
	}
        
        
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
