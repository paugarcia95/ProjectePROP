/**
 * 
 */
package domini;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * @author cristina.fontanet
 *
 */
public class ControladorUsers {

	private ConjuntUsuaris conj;

	// CREADORA

	/**
	 * Pre: no existeix cap conjunt d'usuaris en el sistema Post: hi ha un
	 * conjunt d'usuaris que conté els usuaris existents en el registre
	 */
	public ControladorUsers() {
		// TODO Auto-generated constructor stub
		conj = new ConjuntUsuaris();
		/*
		 * DadesUser du = new DadesUser(); du.carregarUsers();
		 */
	}
	// MODIFICADORES

	/**
	 * Pre: L'usuari username ja existeix Post: l'usuari username es admin
	 * 
	 * @return
	 */
	public void addAdmin(String username) {
		conj.getUser(username).ferAdmin();
	}

	/**
	 * Pre: cert Post: Es retorna cert si l'usuari s'ha pogut crear
	 * satisfactoriament i s'afegeix un usari amb les dades corresponents o es
	 * retorna fals si no s'ha pogut crear
	 * 
	 * @return
	 */
	public boolean addUser(String username, String pass) {
		if (!conj.exists(username)) {
			Usuari u = new Usuari(username, pass, false);
			return conj.addUser(u);
		} else
			return false;
	}

	/**
	 * Pre: Post:
	 * 
	 * @return
	 */
	public boolean setPassword(String username, String pass) {
		return true; // /////////////////////////////////////
	}

	/**
	 * Pre: cert Post: si l'usuari existia, s'elimina
	 * 
	 * @return cert si s'ha pogut eliminar, fals en cas contrari
	 */
	public boolean removeUser(String username) {
		if (conj.exists(username))
			return conj.removeUser(username);
		else
			return false;

	}
	// CONSULTORES

	/**
	 * Pre: Cert Post: no modifica les dades
	 * 
	 * @return Retorna cert si existeix l'usuari username al registre de dades
	 */
	public boolean existsUser(String username) {
		return conj.exists(username);
	}

	/**
	 * Pre: existeix un conjunt d'usuaris Post: no modifica les dades
	 * 
	 * @return cert si les dades son correctes i corresponen a un usuari
	 *         existent o fals en cas contrari
	 */
	public boolean login(String username, String pass) {
		if (conj.exists(username)) {
			Usuari u = conj.getUser(username);
			return u.getPassword() == pass;
		} else
			return false;
	}

	/**
	 * Pre:existeix un conjunt d'usuaris Post: no modifica les dades
	 * 
	 * @return una llista amb els noms dels usuaris existents
	 */
	public ArrayList<String> getUsers() {
		Set<String> aux = conj.getUsers();
		ArrayList<String> llista = new ArrayList<String>();
		Iterator<String> itset = aux.iterator();
		while (itset.hasNext())
			llista.add(itset.next());
		return llista;
	}

	/**
	 * Pre: l'usuari username existeix Post: no modifica les dades
	 * 
	 * @return cert si l'usuari és admin o fals en cas contrari
	 */
	public boolean esAdmin(String username) {
		Usuari aux = conj.getUser(username);
		return aux.esAdmin();
	}

}
