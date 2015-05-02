/**
 * 
 */
package domini;

/**
 * @author Cristina
 *
 */
public class MacroControlador {
	static ControladorUsers cu;
	private ConjuntUsuaris conj;
	static String useractual;
	static ControladorAdminUsers cau;
	private GrafDades gd;

// CREADORA///////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	public MacroControlador() {
		conj = new ConjuntUsuaris();
		cu = new ControladorUsers(conj);
		gd = new GrafDades();
		cau = new ControladorAdminUsers(gd);
	}
	
// MODIFICADORES///////////////////////////////////////////////////////////////////////////////
	
	public void setUserActual(String user) {
		useractual = user;
	}
	public boolean carregaDades() {
		return cau.iniciCarregarDades();
		
	}
	
	public boolean carregaUsers() {
		return cu.iniciCarregarUsers();
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

}
