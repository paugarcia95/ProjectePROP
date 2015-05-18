package domini;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dani
 *
 */

public class Usuari {
	
	private String username, password;
	private Boolean admin;
	private ArrayList<CercaComunitats> cerquesFetes;
	private Integer nCerques;
	private Queue<Integer> eliminats;
	
	
	/**
	 * Pre: No hi existeix cap Usuari amb el mateix username
	 * Post: Crea un Usuari amb this.username=username, this.password=password i this.admin=admin
	 */
	public Usuari (String username, String password, Boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        cerquesFetes = new ArrayList<CercaComunitats>();
        nCerques = 0;
        eliminats = new LinkedList<Integer>();
	}
	
	public Usuari() {
		username = "NoIndicat";
		admin = false;
		cerquesFetes = new ArrayList<CercaComunitats>();
		nCerques = 0;
		eliminats = new LinkedList<Integer>();
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
		return nCerques;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna la CercaComunitats amb índex i
	 */
	public CercaComunitats getCerca(Integer i) {
		if (i >= 0 && i < cerquesFetes.size()) return cerquesFetes.get(i); //pot retornar null si i és l'índex d'una cerca eliminada
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
	        if (cerca != null && s.equals(cerca.getNom())) {
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
	 * Pre: c.nom és únic a cerquesFetes
	 * Post: S'incrementa nCerques i c pertany a cerquesFetes
	 */
	public Integer addCerca(CercaComunitats c) {
		int i;
		if(eliminats.isEmpty()) {
			i = nCerques;
			if (i == cerquesFetes.size()) { //sempre que eliminats.isEmpty s'ha de complir això
				cerquesFetes.add(i, c);
				++nCerques;
				return i;
			}
		}
		else {
			i = eliminats.poll(); //primer índex buit
		}
		cerquesFetes.set(i, c);
		++nCerques;
		return i;		
	}
	
	/**
	 * Pre: Cert
	 * Post: Si c pertanyia a cerquesFetes ja no és a cerquesFetes, es decrementa nCerques i retorna true, altrament retorna false
	 */
	public Boolean removeCerca(CercaComunitats c) {
		int i = cerquesFetes.indexOf(c);
		if (i == -1) return false;
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si s era el nom d'una cerca a cerquesFetes, aquesta cerca no és a cerquesFetes, es decrementa nCerques i retorna cert, altrament retorna false
	 */
	public Boolean removeCerca(String s) {
		int i = this.getPosCerca(s);
		if (i == -1) return false;
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Si i era l'índex d'una cercaFeta cerquesFetes ja no conté la CercaComunitats i retorna true, retorna false altrament
	 */
	public Boolean removeCerca(Integer i) {
		if (i >= 0 && i < cerquesFetes.size() && cerquesFetes.get(i) != null) {
			cerquesFetes.set(i, null);
			--nCerques;
			eliminats.add(i);
			return true;
		}
		return false;
	}

}
