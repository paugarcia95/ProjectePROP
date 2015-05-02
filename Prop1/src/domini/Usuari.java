package domini;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dani
 *
 */

public class Usuari {
	
	private String Username, Password;
	private Boolean Admin;
	private ArrayList<CercaComunitats> CerquesFetes;
	private Integer nCerques;
	private Queue<Integer> eliminats;
	
	
	//Pre: No hi existeix cap usuari amb el mateix Username
	//Post: Crea un Usuari amb Username=Username, Password=Password i Admin=Admin
	public Usuari (String Username, String Password, Boolean Admin) {
        this.Username = Username;
        this.Password = Password;
        this.Admin = Admin;
        CerquesFetes = new ArrayList<CercaComunitats>();
        nCerques = 0;
        eliminats = new LinkedList<Integer>();
	}
	
	//Pre: cert
	//Post: Admin = true
	public void ferAdmin() {
		Admin = true;				
	}

	//Pre: Cert
	//Post: Username = nom
	public void setUsername(String nom) {
		Username = nom;
	}

	//Pre: Cert
	//Post: Password = Password
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	//Pre: Cert
	//Post: retorna l'Username
	public String getUsername() {
		return Username;
	}
	
	//Pre: Cert
	//Post: retorna el Password
	public String getPassword() {
		return Password;
	}
	
	//Pre: Cert
	//Post: Retorna el numero de cerques fetes
	public Integer getNumCerques() {
		return nCerques;
	}
	
	//Pre: i < Cerques_fetes.size() && es l'index d'una CercaComunitats a Cerques_fetes
	//Post: Retorna el CercaComunitats amb índex i
	public CercaComunitats getCerca(Integer i) {
		return CerquesFetes.get(i);
	}
	
	//Pre: Cert
	//Post: si s es el nom d'una cerca de l'usuari retorna aquesta cerca, altrament retorna null
	public CercaComunitats getCerca(String s) {
		for (int i = 0; i < CerquesFetes.size(); i++) {
	        CercaComunitats cerca = CerquesFetes.get(i);
	        if (cerca != null && s.equals(cerca.getNom())) {
	        	return cerca;
	        }
	    }
		return null;
	}
	
	//Pre: Cert
	//Post: si s es el nom d'una cerca de l'usuari retorna la posiciço d'aquesta cerca, altrament retorna -1
	public Integer getPosCerca(String s) {
		for (int i = 0; i < CerquesFetes.size(); i++) {
	        CercaComunitats cerca = CerquesFetes.get(i);
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
	
	//Pre: Cert
	//Post: Si c no pertanyia a CerquesFetes ++nCerques i c pertany a Cerques_fetes, 
	public Integer addCerca(CercaComunitats c) {
		int i;
		if(eliminats.isEmpty()) {
			i = nCerques;
			if (i == CerquesFetes.size()) { //sempre que eliminats.isEmpty s'ha de complir això
				CerquesFetes.add(i, c);
				++nCerques;
				return i;
			}
		}
		else {
			i = eliminats.poll(); //primer index buit
		}
		CerquesFetes.set(i, c);
		++nCerques;
		return i;		
	}
	
	//Pre: c és a Cerques_fetes
	//Post: c no és a Cerques_fetes i --Cerques_fetes.size() (o --nCerques)
	public Boolean removeCerca(CercaComunitats c) {
		int i = CerquesFetes.indexOf(c);
		CerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: cert
	//Post: c no és a Cerques_fetes i --Cerques_fetes.size() (o --nCerques)
	public Boolean removeCerca(String s) {
		int i;
		for (i = 0; i < CerquesFetes.size(); i++) {
	        CercaComunitats cerca = CerquesFetes.get(i);
	        if (cerca != null && s.equals(cerca.getNom())) {
	        	break;
	        }
	    }
		if (i == CerquesFetes.size()) return false;
		CerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: i < Cerques_fetes.size() && es l'index d'una CercaComunitats a Cerques_fetes
	//Post: Cerques_fetes ja no conté la CercaComunitats amb index i
	public Boolean removeCerca(Integer i) {
		CerquesFetes.set(i, null);
		--nCerques;
		eliminats.add(i);
		return true;
	}
	
	//Pre: Cert
	//Post: retorna cert si l'usuari es Admin
	public Boolean esAdmin() {
		return Admin;
	}

}
