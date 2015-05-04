/**
 * 
 */
package domini;

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
	private GrafDades gd;
	private ConjuntUsuaris conj;
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
	public Boolean carregaDadesFitxer(String ruta) {
		aux = new EntradaSortidaDadesGraf();
		try {
			aux.carregarGrafDades(gd,ruta);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
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
		return useractual;
	}
	public GrafDades getGraf(){ //PROVISIONAL
		return gd;
	}
	public ConjuntUsuaris getConjUsers() {	//PROVISIONAL
		return conj;
	}

}
