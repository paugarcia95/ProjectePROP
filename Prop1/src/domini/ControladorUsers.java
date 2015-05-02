/**
 * 
 */
package domini;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author cristina.fontanet
 *
 */
public class ControladorUsers {

	private ConjuntUsuaris conj;

// CREADORA///////////////////////////////////////////////////////////////////////////////

	/**
	 * Pre: no existeix cap conjunt d'usuaris en el sistema 
	 * Post: hi ha un
	 * conjunt d'usuaris que conté els usuaris existents en el registre
	 */
	public ControladorUsers() {
		// TODO Auto-generated constructor stub
		conj = new ConjuntUsuaris();
		/*
		 * DadesUser du = new DadesUser(); du.carregarUsers();
		 */
	}
// MODIFICADORES///////////////////////////////////////////////////////////////////////////////

	/**
	 * Pre: L'usuari username ja existeix 
	 * Post: l'usuari username es admin
	 * 
	 * @return
	 */
	public void addAdmin(String username) {
		conj.getUser(username).ferAdmin();
	}

	/**
	 * Pre: cert 
	 * Post: Es retorna cert si l'usuari s'ha pogut crear
	 * satisfactoriament i s'afegeix un usari amb les dades corresponents o es
	 * retorna fals si no s'ha pogut crear
	 * 
	 * @return
	 */
	public boolean addUser(String username, String pass) {
		if (!conj.exists(username)) {
			Usuari u = new Usuari(username, pass, false);
			return conj.addUser(u);
		}
		else return false;
	}

	/**
	 * Pre: l'usuari username existeix 
	 * Post: 
	 * @return identificador de la nova cerca creada
	 */
	public Integer addNovaCerca(String username) {
		Integer aux = conj.getUser(username).addCerca(new CercaComunitats());
		conj.getUser(username).getCerca(aux).setUsuari(username);
		Date act = new Date();		//Com s'obté la data actual?
		conj.getUser(username).getCerca(aux).setDataCreacio(act);
		return aux;
	}
	
	public boolean addCriterisCerca(Boolean modifica, String username, Integer i, String paraulast, Integer paraulain, Integer relacions, Integer sembla, Integer alg, Integer tipus, Integer dada, ArrayList<Categoria> subconj, ArrayList<Categoria> evita, String pare ) {
		ParaulaValor par = new ParaulaValor(paraulast, paraulain);
		Criteris aux = new Criteris(par, relacions, sembla, alg, tipus, dada, subconj, evita, pare);
		conj.getUser(username).getCerca(i).setCriteris_seleccio(aux);
		conj.getUser(username).getCerca(i).setAlgorisme(alg);
		if(modifica) conj.getUser(username).getCerca(i).setData_modificacio(new Date());
		return true;
	}
	
	public void addNomCerca(String username, Integer i, String nom) {
		conj.getUser(username).getCerca(i).setNom(nom);
	}
	
	public void addComentariCerca(String username, Integer i, String comentari) {
		conj.getUser(username).getCerca(i).setComentari(comentari);
	}
	
	/**
	 * Pre: username existeix
	 * Post:
	 * 
	 * @return
	 */
	public void setPassword(String username, String pass) {
		conj.getUser(username).setPassword(pass);
	}
	
	/**
	 * Pre:
	 * Post:
	 * 
	 * @return false si hi ha hagut algun problema, cert altrament
	 */
	public boolean setUsername(String antic, String nou) {
		return conj.setUsername(antic, nou);
	}

	/**
	 * Pre: cert 
	 * Post: si l'usuari existia, s'elimina
	 * 
	 * @return cert si s'ha pogut eliminar, fals en cas contrari
	 */
	public boolean removeUser(String username) {
		if (conj.exists(username)) return conj.removeUser(username);
		else return false;

	}
	
	public boolean removeCerca(String username, String nom) {
		return conj.getUser(username).removeCerca(nom);
	}
// CONSULTORES///////////////////////////////////////////////////////////////////////////////

	/**
	 * Pre: Cert 
	 * Post: no modifica les dades
	 * 
	 * @return Retorna cert si existeix l'usuari username al registre de dades
	 */
	public boolean existsUser(String username) {
		return conj.exists(username);
	}

	/**
	 * Pre: existeix un conjunt d'usuaris i username existeix
	 * Post: no modifica les dades
	 * @return cert si les dades son correctes i corresponen a un usuari
	 *         existent o fals en cas contrari
	 */
	public boolean login(String username, String pass) {
		Usuari u = conj.getUser(username);
		return u.getPassword().equals(pass);
	}
	
	/**
	 * Pre: l'usuari username existeix 
	 * Post: no modifica les dades
	 * @return cert si l'usuari és admin o fals en cas contrari
	 */
	public boolean isAdmin(String username) {
		return conj.getUser(username).esAdmin();
	}

	/**
	 * Pre:existeix un conjunt d'usuaris 
	 * Post: no modifica les dades
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
	 * Pre: l'usuari username existeix 
	 * Post: no modifica les dades
	 * @return noms de les cerques de comunitats fetes per l'usuari
	 */
	public ArrayList<String> getCerquesComunitats(String username) {
		Usuari aux = conj.getUser(username);
		int num = aux.getNumCerques();
		ArrayList<String> comunitats = new ArrayList<String>();
		for(int i = 0; i < num; ++i)comunitats.add(aux.getCerca(i).getNom());
		return comunitats;
	}
	
	
	public Integer getNumCerca(String quina) {			//////////////////////////////////////////////////
		return 1;
	}
	
	public String getNomCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getNom();
	}
	
	public String getComentariCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getComentari();
	}
	
	public Date getDataCreacioCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getDataCreacio();
	}

	public Date getDataModificacioCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getData_modificacio();
	}
	
	public Integer getAlgCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getAlgorisme();
	}
	
	public Integer getAlgDadaCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getDada();
	}
	
	public Integer getAlgTipuCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getTipuCerca();
	}
	
	public Integer getRelacioCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getRelacionsCat();
	}
	
	public Integer getSembCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getSemblNom();
	}
	
	public Integer getParaulaImpCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getParaulaClau().getNum();
	}
	
	public String getParaulaClauCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getParaulaClau().getParaula();
	}
	
	public String getPareCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriteris_seleccio().getPare();
	}
	
	public ArrayList<String> getSubCerca(String username, Integer quina) {
		ArrayList<String> aux = new ArrayList<String>();
		ArrayList<Categoria> aux2 = conj.getUser(username).getCerca(quina).getCriteris_seleccio().getSubconjCat();
		for(Categoria cat: aux2) aux.add(cat.getNom());
		return aux;
	}
	
	public ArrayList<String> getEvitaCerca(String username, Integer quina) {
		ArrayList<String> aux = new ArrayList<String>();
		ArrayList<Categoria> aux2 = conj.getUser(username).getCerca(quina).getCriteris_seleccio().getEvitaCat();
		for(Categoria cat: aux2) aux.add(cat.getNom());
		return aux;
	}
	public Integer getNumComunitatsCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getNumComunitats();
	}
	
	public Integer getNumCatCerca(String username, Integer quina, Integer num) {
		return conj.getUser(username).getCerca(quina).getComunitat(num).getNumeroDeCategories();
	}
	
	public Set<String> getCatCerca(String username, Integer quina, Integer com) {
		Map<String,Categoria> aux = conj.getUser(username).getCerca(quina).getComunitat(com).getMapCat();
		return aux.keySet();
	}
}
