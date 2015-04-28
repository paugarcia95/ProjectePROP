package domini;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConjuntUsuaris {
	
	private Map<String, Usuari> Users;
	
	public ConjuntUsuaris() {
		Users = new TreeMap<String, Usuari>();
	}
	
	//Pre: u no existeix a Users
	//Post: u pertany a Users
	public Boolean addUser(Usuari u) {
		Users.put(u.getUsername(), u);
		return true;
	}
	
	//Pre: Cert
	//Post: Retorna si existeix l'Usuari u a Users
	public Boolean exists(Usuari u) {
		return Users.containsKey(u.getUsername()); 	// log(n)
		//return Users.containsValue(u); 			// (n)
	}
	
	//Pre: Cert
	//Post: Retorna si existeix l'Usuari amb Username=Username a Users
	public Boolean exists(String Username) {
		return Users.containsKey(Username);
	}
	
	//Pre: Username pertany a un Usuari de Users
	//Post: Retorna l'Usuari amb Username = Username
	public Usuari getUser(String Username) {
		return Users.get(Username);
	}
	
	//Pre: username es la key d'un usuari existent a Users
	//Post: l'usuari amb key username ja no existeix a Users
	public Boolean removeUser(String username) {
		Users.remove(username);
		return true;
	}
	
	public Integer getNombreUsers() {
		return Users.size();
	}
	
	public Set<String> getUsers() {
		return Users.keySet();
	}
	
	//Pre: Cert
	//Post: si existeix Usuari amb Username = antic, ara Username = nou
	public Boolean setUsername(String antic, String nou) {
		if (Users.containsKey(antic) && !Users.containsKey(nou)) {
			Usuari u = Users.remove(antic);
			u.setUsername(nou);
			Users.put(nou, u);
			return true;
		}
		return false;
	}

}

