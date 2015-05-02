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
	
	
	//Pre: No hi existeix cap usuari amb el mateix username
	//Post: Crea un Usuari amb username=username, password=password i admin=admin
	public Usuari (String username, String password, Boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        cerquesFetes = new ArrayList<CercaComunitats>();
        nCerques = 0;
        eliminats = new LinkedList<Integer>();
	}
	
	//Pre: cert
	//Post: admin = true
	public void ferAdmin() {
		admin = true;				
	}

	//Pre: Cert
	//Post: username = nom
	public void setUsername(String nom) {
		username = nom;
	}

	//Pre: Cert
	//Post: password = password
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Pre: Cert
	//Post: retorna l'username
	public String getUsername() {
		return username;
	}
	
	//Pre: Cert
	//Post: retorna el password
	public String getPassword() {
		return password;
	}
	
	//Pre: Cert
	//Post: Retorna el numero de cerques fetes
	public Integer getNumCerques() {
		return nCerques;
	}
	
	//Pre: i < cerquesFetes.size() && es l'index d'una CercaComunitats a cerquesFetes
	//Post: Retorna la CercaComunitats amb índex i
	public CercaComunitats getCerca(Integer i) {
		return cerquesFetes.get(i);
	}
	
	//Pre: Cert
	//Post: si s es el nom d'una cerca de l'usuari retorna aquesta cerca, altrament retorna null
	public CercaComunitats getCerca(String s) {
		for (int i = 0; i < cerquesFetes.size(); i++) {
	        CercaComunitats cerca = cerquesFetes.get(i);
	        if (cerca != null && s.equals(cerca.getNom())) {
	        	return cerca;
	        }
	    }
		return null;
	}
	
	//Pre: Cert
	//Post: si s es el nom d'una cerca de l'usuari retorna la posiciço d'aquesta cerca, altrament retorna -1
	public Integer getPosCerca(String s) {
		for (int i = 0; i < cerquesFetes.size(); i++) {
	        CercaComunitats cerca = cerquesFetes.get(i);
	        if (cerca != null && s.equals(cerca.getNom())) {
	        	return i;
	        }
	    }
		return -1;
	}
	
	//Pre: cert
	//Post: retorna si existeix una cerca amb nom s
	public Boolean existsCerca(String s) {
		if (this.getPosCerca(s) != -1) return true;
		return false;
	}
	
	//Pre: c.Nom és únic a cerquesFetes
	//Post: Si c no pertanyia a cerquesFetes ++nCerques i c pertany a cerquesFetes, 
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
			i = eliminats.poll(); //primer index buit
		}
		cerquesFetes.set(i, c);
		++nCerques;
		return i;		
	}
	
	//Pre: c és a cerquesFetes
	//Post: c no és a cerquesFetes i --nCerques
	public Boolean removeCerca(CercaComunitats c) {
		int i = cerquesFetes.indexOf(c);
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: cert
	//Post: c no és a cerquesFetes i --nCerques
	public Boolean removeCerca(String s) {
		int i;
		for (i = 0; i < cerquesFetes.size(); i++) {
	        CercaComunitats cerca = cerquesFetes.get(i);
	        if (cerca != null && s.equals(cerca.getNom())) {
	        	break;
	        }
	    }
		if (i == cerquesFetes.size()) return false;
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: i < cerquesFetes.size() && és l'index d'una CercaComunitats a cerquesFetes
	//Post: cerquesFetes ja no conté la CercaComunitats amb index i
	public Boolean removeCerca(Integer i) {
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: Cert
	//Post: retorna cert si l'usuari es Admin
	public Boolean esAdmin() {
		return admin;
	}

}
