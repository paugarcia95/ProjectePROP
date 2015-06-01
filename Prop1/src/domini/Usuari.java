package domini;

import java.util.ArrayList;

/**
 * @author Dani
 *
 */

public class Usuari {
	
	private String username, password;
	private Boolean admin;
	private ArrayList<CercaComunitats> cerquesFetes;
	
	
	/**
	 * Crea un Usuari amb els paràmetres especificats.
	 * 
	 * @param username username de l'usuari
	 * @param password contrasenya de l'usuari
	 * @param admin és administrador
	 */
	public Usuari (String username, String password, Boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        cerquesFetes = new ArrayList<CercaComunitats>();
	}
	
	/**
	 * Crea un Usuari amb <code>username</code> "NoIndicat" i <code>password</code> "PerDefecte" de tipus client.
	 */	
	public Usuari() {
		username = "NoIndicat";
		password = "PerDefecte";
		admin = false;
		cerquesFetes = new ArrayList<CercaComunitats>();
	}
	
	/**
	 * Assigna a l'usuari privilegis d'administrador.
	 */
	public void ferAdmin() {
		admin = true;				
	}

	/**
	 * 
	 * @param nom l'username de l'usuari
	 */
	public void setUsername(String nom) {
		username = nom;
	}

	/**
	 * 
	 * @param password la contrasenya de l'usuari
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return l'<code>username</code> de l'usuari
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @return la <code>password</code> de l'usuari
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @return <code>true</code> si l'usuari es administrador
	 */
	public Boolean esAdmin() {
		return admin;
	}

	/**
	 * @return el nombre de cerques que té l'usuari
	 */	
	public Integer getNumCerques() {
		return cerquesFetes.size();
	}
	
	/**
	 * 
	 * @param i l'índex de la cerca que retorna
	 * @return la cerca amb índex especificat. <code>null</code> si l'índex no és positiu i inferior al nombre de cerques
	 */
	public CercaComunitats getCerca(Integer i) {
		if (i >= 0 && i < cerquesFetes.size()) return cerquesFetes.get(i);
		return null;
	}
	
	/**
	 * 
	 * @param s el nom de la cerca de la que es vol la posició
	 * @return l'índex de la cerca amb nom especificat. -1 si no hi ha cap cerca amb aquest nom
	 */
	public Integer getPosCerca(String s) {
		for (int i = 0; i < cerquesFetes.size(); i++) {
	        CercaComunitats cerca = cerquesFetes.get(i);
	        if (s.equals(cerca.getNom())) {
	        	return i;
	        }
	    }
		return -1;
	}
	
	/**
	 * Afegeix una nova cerca a l'usuari.
	 * 
	 * @param c la cerca que serà afegida a l'usuari
	 * @return l'índex de la nova cerca afegida. -1 si no s'introdueix una cerca vàlida
	 */
	public Integer addCerca(CercaComunitats c) {
		if (c != null) {
			cerquesFetes.add(c);
			return cerquesFetes.size() - 1;
		}
		return -1;
	}
	
	/**
	 * Elimina una cerca del conjunt de cerques fetes de l'usuari.
	 * 
	 * @param s nom de la cerca que elimina
	 * @return <code>true</code> si s'ha eliminat la cerca. <code>false</code> si no existeix una cerca amb aquest nom per l'usuari o si no es una cerca vàlida
	 */
	public Boolean removeCerca(String s) {
		if (s != null) {
			int i = this.getPosCerca(s);
			if (i != -1)  {
				cerquesFetes.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Elimina una cerca del conjunt de cerques fetes de l'usuari.
	 * 
	 * @param i l'índex de la cerca que elimina
	 * @return <code>true</code> si s'ha eliminat la cerca amb índex especificat. <code>false</code> si l'índex no és positiu i inferior al nombre de cerques fetes
	 */
	public Boolean removeCerca(Integer i) {
		if (i >= 0 && i < cerquesFetes.size()) {
			cerquesFetes.remove(i.intValue());
			return true;
		}
		return false;
	}

}
