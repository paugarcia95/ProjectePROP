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
	static ControladorUsers cu;
	static ControladorAdminUsers cau;
	static TraduccioiAlgorisme ta;
	static GrafDades gd;
	static ConjuntUsuaris conj;
	static String useractual;
	EntradaSortidaDadesGraf aux;

// CREADORA///////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	public MacroControlador() {
		conj = new ConjuntUsuaris();
		gd = new GrafDades();
		cu = new ControladorUsers(conj, gd);
		cau = new ControladorAdminUsers(gd, conj);
		ta = new TraduccioiAlgorisme();
	}
	
// MODIFICADORES///////////////////////////////////////////////////////////////////////////////
	
	public void setUserActual(String user) {
		useractual = user;
	}
	public Boolean carregaDades() {
		return cau.iniciCarregarDades();
		
	}
	public void carregaDadesFitxer(File fitxer) throws FileNotFoundException {
		aux = new EntradaSortidaDadesGraf();
		try {
			aux.carregarGrafDades(gd,fitxer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Boolean carregaUsers() {
		return cu.iniciCarregarUsers();
	}
	
	public void eliminarDadesGraf(){
		gd = new GrafDades();
		cau.actualitzaRefs(conj, gd);
		cu.actualitzaRefs(conj, gd);
	}
	
	

// CONSULTORES///////////////////////////////////////////////////////////////////////////////

	public ControladorUsers getContUser(){
		return cu;
	}
	
	public ControladorAdminUsers getContAdUs() {
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

        
        
        public static void main(String[] args) {
         MacroControlador macro = new MacroControlador();
         Interficie.InterficiaProva aux = new Interficie.InterficiaProva();
         aux.passaMacro(macro);
         aux.setVisible(true);
         //while(true);
         
        }
}


