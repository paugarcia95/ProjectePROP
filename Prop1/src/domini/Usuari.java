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
	//Post: Crea un Usuari amb this.username=username, this.password=password i this.admin=admin
	public Usuari (String username, String password, Boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        cerquesFetes = new ArrayList<CercaComunitats>();
        nCerques = 0;
        eliminats = new LinkedList<Integer>();
	}
	
	//Pre: Cert
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
	//Post: this.password = password
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Pre: Cert
	//Post: Retorna l'username
	public String getUsername() {
		return username;
	}
	
	//Pre: Cert
	//Post: Retorna el password
	public String getPassword() {
		return password;
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de cerques que t� l'usuari
	public Integer getNumCerques() {
		return nCerques;
	}
	
	//Pre: i < cerquesFetes.size() && �s l'�ndex d'una CercaComunitats a cerquesFetes
	//Post: Retorna la CercaComunitats amb �ndex i
	public CercaComunitats getCerca(Integer i) {
		return cerquesFetes.get(i);
	}
	
	//Pre: Cert
	//Post: Si s �s el nom d'una cerca de l'usuari retorna aquesta cerca, altrament retorna null
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
	//Post: Si s �s el nom d'una cerca de l'usuari retorna la posici�o d'aquesta cerca, altrament retorna -1
	public Integer getPosCerca(String s) {
		for (int i = 0; i < cerquesFetes.size(); i++) {
	        CercaComunitats cerca = cerquesFetes.get(i);
	        if (cerca != null && s.equals(cerca.getNom())) {
	        	return i;
	        }
	    }
		return -1;
	}
	
	//Pre: Cert
	//Post: Retorna si existeix una cerca amb nom s
	public Boolean existsCerca(String s) {
		if (this.getPosCerca(s) != -1) return true;
		return false;
	}
	
	//Pre: c.nom �s �nic a cerquesFetes
	//Post: Si c no pertanyia a cerquesFetes ++nCerques i c pertany a cerquesFetes
	public Integer addCerca(CercaComunitats c) {
		int i;
		if(eliminats.isEmpty()) {
			i = nCerques;
			if (i == cerquesFetes.size()) { //sempre que eliminats.isEmpty s'ha de complir aix�
				cerquesFetes.add(i, c);
				++nCerques;
				return i;
			}
		}
		else {
			i = eliminats.poll(); //primer �ndex buit
		}
		cerquesFetes.set(i, c);
		++nCerques;
		return i;		
	}
	
	//Pre: c �s a cerquesFetes
	//Post: c no �s a cerquesFetes i --nCerques
	public Boolean removeCerca(CercaComunitats c) {
		int i = cerquesFetes.indexOf(c);
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: Cert
	//Post: Si s era el nom d'una cerca a cerquesFetes, aquesta cerca no �s a cerquesFetes, --nCerques i retorna cert, altrament retorna false
	public Boolean removeCerca(String s) {
		int i = this.getPosCerca(s);
		if (i == -1) return false;
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: i < cerquesFetes.size() && �s l'�ndex d'una CercaComunitats a cerquesFetes
	//Post: cerquesFetes ja no cont� la CercaComunitats amb �ndex i
	public Boolean removeCerca(Integer i) {
		cerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: Cert
	//Post: Retorna cert si l'usuari es admin
	public Boolean esAdmin() {
		return admin;
	}

}
