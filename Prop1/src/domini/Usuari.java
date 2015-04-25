package domini;

import java.util.ArrayList;
import java.util.Queue;

public class Usuari {
	
	private String Username, Password;
	private Boolean Admin;
	private ArrayList<CercaComunitats> Cerques_fetes;
	private Integer nCerques;
	private Queue<Integer> eliminats;
	
	
	//Pre: No hi existeix cap usuari amb el mateix Username
	//Post: Crea un Usuari amb Username=Username, Password=Password i Admin=Admin
	public Usuari (String Username, String Password, Boolean Admin) {
        this.Username = Username;
        this.Password = Password;
        this.Admin = Admin;
        Cerques_fetes = new ArrayList<CercaComunitats>();
        nCerques = Integer.valueOf(0);
	}
	
	//Pre: cert
	//Post: Admin = true
	public void ferAdmin() {
		Admin = Boolean.TRUE;				
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
		return Cerques_fetes.get(i.intValue());
	}
	
	//Pre: Cert
	//Post: ++nCerques i c pertany a Cerques_fetes
	public Integer addCerca(CercaComunitats c) {
		Integer i;
		if(eliminats.isEmpty()) {
			if (nCerques == Cerques_fetes.size()) {
				Cerques_fetes.ensureCapacity(nCerques+5);
			}
			i = nCerques;
		}
		else {
			i = eliminats.poll(); //primer index buit
		}
		Cerques_fetes.set(i.intValue(), c);
		nCerques = Integer.valueOf(nCerques.intValue()+1);
		return i;		
	}
	
	//Pre: c es a Cerques_fetes
	//Post: c no es a Cerques_fetes i --Cerques_fetes.size() (o --nCerques)
	public Boolean removeCerca(CercaComunitats c) {
		Integer i = Integer.valueOf(Cerques_fetes.indexOf(c));
		Cerques_fetes.set(i.intValue(), null);
		nCerques = Integer.valueOf(nCerques.intValue()-1);
		eliminats.add(Integer.valueOf(i));
		return Boolean.TRUE;
	}
	
	//Pre: i < Cerques_fetes.size() && es l'index d'una CercaComunitats a Cerques_fetes
	//Post: Cerques_fetes ja no conté la CercaComunitats amb index i
	public Boolean removeCerca(Integer i) {
		Cerques_fetes.set(i.intValue(), null);
		nCerques = Integer.valueOf(nCerques.intValue()-1);
		eliminats.add(Integer.valueOf(i));
		return Boolean.TRUE;
	}
	
	//Pre: Cert
	//Post: retorna cert si l'usuari es Admin
	public Boolean esAdmin() {
		return Admin;
	}

}
