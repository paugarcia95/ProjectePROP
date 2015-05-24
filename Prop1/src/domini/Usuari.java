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
	 * Pre: No hi existeix cap Usuari amb el mateix username
	 * Post: Crea un Usuari amb this.username=username, this.password=password i this.admin=admin
	 */
	public Usuari (String username, String password, Boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        cerquesFetes = new ArrayList<CercaComunitats>();
	}
	
	public Usuari() {
		username = "NoIndicat";
		password = "PerDefecte";
		admin = false;
		cerquesFetes = new ArrayList<CercaComunitats>();
	}
	
	/**
	 * Pre: Cert
	 * Post: admin = true
	 */
	public void ferAdmin() {
		admin = true;				
	}

	/**
	 * Pre: Cert
	 * Post: username = nom
	 */
	public void setUsername(String nom) {
		username = nom;
	}

	/**
	 * Pre: Cert
	 * Post: this.password = password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna l'username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna cert si l'usuari es admin
	 */
	public Boolean esAdmin() {
		return admin;
	}

	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de cerques que té l'usuari
	 */
	public Integer getNumCerques() {
		return cerquesFetes.size();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna la CercaComunitats amb índex i
	 */
	public CercaComunitats getCerca(Integer i) {
		if (i >= 0 && i < cerquesFetes.size()) return cerquesFetes.get(i);
		else return null;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si s és el nom d'una cerca de l'usuari retorna aquesta cerca, altrament retorna null
	 */
	public CercaComunitats getCerca(String s) {
		for (int i = 0; i < cerquesFetes.size(); i++) {
	        CercaComunitats cerca = cerquesFetes.get(i);
	        if (cerca != null && s.equals(cerca.getNom())) {
	        	return cerca;
	        }
	    }
		return null;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si s és el nom d'una cerca de l'usuari retorna la posiciço d'aquesta cerca, altrament retorna -1
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
	 * Pre: Cert
	 * Post: Retorna si existeix una cerca amb nom s
	 */
	public Boolean existsCerca(String s) {
		if (this.getPosCerca(s) != -1) return true;
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: S'incrementa nCerques i c pertany a cerquesFetes
	 */
	public Integer addCerca(CercaComunitats c) {
		if (c != null) {
			cerquesFetes.add(c);
			return cerquesFetes.size() - 1;
		}
		return null;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si c pertanyia a cerquesFetes ja no és a cerquesFetes, es decrementa nCerques i retorna true, altrament retorna false
	 */
	public Boolean removeCerca(CercaComunitats c) {
		if (c != null) {
			return cerquesFetes.remove(c);
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si s era el nom d'una cerca a cerquesFetes, aquesta cerca no és a cerquesFetes, es decrementa nCerques i retorna cert, altrament retorna false
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
	 * Pre: Cert
	 * Post: Si i era l'índex d'una cercaFeta cerquesFetes ja no conté la CercaComunitats i retorna true, retorna false altrament
	 */
	public Boolean removeCerca(Integer i) {
		if (i >= 0 && i < cerquesFetes.size()) {
			cerquesFetes.remove(i);
			return true;
		}
		return false;
	}

}
