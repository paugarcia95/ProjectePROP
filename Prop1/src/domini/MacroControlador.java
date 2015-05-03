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
	static ControladorAdminUsers cau;
	static TraduccioiAlgorisme ta;
	private GrafDades gd;
	private ConjuntUsuaris conj;
	static String useractual;

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
	public GrafDades getGraf(){
		return gd;
	}

}
