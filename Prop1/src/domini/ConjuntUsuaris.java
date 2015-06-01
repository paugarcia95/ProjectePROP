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
	
	/**
	 * Crea un ConjuntUsuaris buit.
	 */
	public ConjuntUsuaris() {
		users = new TreeMap<String, Usuari>();
	}

	/**
	 * Afegeix un usuari al conjunt.
	 * 
	 * @param u l'usuari que serà afegit
	 * @return <code>true</code> si s'ha afegit l'usuari especificat. <code>false</code> si l'usuari ja pertanyia al conjunt
	 */
	public Boolean addUser(Usuari u) {
		if (users.containsKey(u.getUsername())) return false;
		users.put(u.getUsername(), u);
		return true;
	}
	
	/**
	 * Retorna si l'usuari amb <code>username</code> especificat pertany al conjunt. 
	 * 
	 * @param username nom de l'usuari buscat
	 * @return <code>true</code> si l'usuari amb username especificat és a <code>users</code>
	 */
	public Boolean exists(String username) {
		return users.containsKey(username);
	}
	
	/**
	 * Retorna l'usuari amb l'<code>username</code> especificat si existeix, o <code>null</code> si no existeix.
	 * 
	 * @param username l'username de l'usuari que es busca
	 * @return l'usuari amb l'<code>username</code> especificat si existeix, o <code>null</code> si no existeix.
	 */	
	public Usuari getUser(String username) {
		return users.get(username);
	}
	
	/**
	 * Pre: Cert
	 * Post: Si hi havia un Usuari amb key username ja no existeix a users i retorna <code>true</code>, retorna flase altrament
	 */
	/**
	 * Elimina un usuari del conjunt.
	 * 
	 * @param username l'username de l'usuari que serà eliminat del conjunt
	 * @return <code>true</code> si s'ha eliminat l'usuari. <code>false</code> si l'usuari no pertanyia al conjunt
	 */
	public Boolean removeUser(String username) {
		if (users.remove(username) != null) return true;
		return false;
	}
	
	/**
	 * @return el nombre de usuaris que hi ha al conjunt
	 */
	public Integer getNombreUsers() {
		return users.size();
	}
	
	/**
	 * Obté el nom dels usuaris que pertanyen al conjunt.
	 * @return el nom dels usuaris
	 */
	public Set<String> getUsers() {
		return users.keySet();
	}
	
	/**
	 * @return el mapa d'usuaris del conjunt
	 */
	public Map<String,Usuari> getMap(){
        return users;
    }
	
	/**
	 * Canvia l'username de l'usuari especificat pel nou username especificat.
	 * 
	 * @param antic username de l'usuari al que se li modificarà l'<code>username</code>
	 * @param nou el nou <code>username</code> de l'usuari especificat
	 * @return <code>true</code> si s'ha canviat l'<code>username</code>. <code>false</code> si l'usuari no pertanyia al conjunt o si existeix un usuari amb username = nou
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

