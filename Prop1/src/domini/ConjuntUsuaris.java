package domini;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class ConjuntUsuaris {
	
	private Map<String, Usuari> users;
	
	public ConjuntUsuaris() {
		users = new TreeMap<String, Usuari>();
	}
        
	/**
	 * Pre: u no existeix a Users
	 * Post: u pertany a Users
	 */
	public Boolean addUser(Usuari u) {
		users.put(u.getUsername(), u);
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna si existeix l'Usuari u a users
	 */
	public Boolean exists(Usuari u) {
		return users.containsKey(u.getUsername());
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna si existeix l'Usuari amb username = username a users
	 */
	public Boolean exists(String username) {
		return users.containsKey(username);
	}
	
	/**
	 * Pre: username pertany a un Usuari d'users
	 * Post: Retorna l'Usuari amb username = username
	 */
	public Usuari getUser(String username) {
		return users.get(username);
	}
	
	/**
	 * Pre: Cert
	 * Post: Si hi havia un Usuari amb key username ja no existeix a users i retorna true, retorna flase altrament
	 */
	public Boolean removeUser(String username) {
		if (users.remove(username) != null) return true;
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre d'usuaris existents
	 */
	public Integer getNombreUsers() {
		return users.size();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nom de tots els usuaris a users
	 */	
	public Set<String> getUsers() {
		return users.keySet();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el mapa users
	 */	
	public Map<String,Usuari> getMap(){
        return users;
    }
	
	/**
	 * Pre: Cert
	 * Post: Si existeix Usuari amb Username == antic, ara Username = nou
	 */
	public Boolean setUsername(String antic, String nou) {
		if (users.containsKey(antic) && !users.containsKey(nou)) {
			Usuari u = users.remove(antic);
			u.setUsername(nou);
			users.put(nou, u);
			return true;
		}
		return false;
	}

}

