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
	private GrafDades gd;

// CREADORA///////////////////////////////////////////////////////////////////////////////

	/**
	 * Creadora del Controlador d'Usuaris.
	 * 
	 * @param nouu
	 * 			Conjunt d'usuaris existents en la memoria del programa.
	 * @param noug
	 * 			Graf de dades existent en la memoria del programa.
	 */
	public ControladorUsers(ConjuntUsuaris nouu, GrafDades noug) {
		conj = nouu;
		gd = noug;
	}
// MODIFICADORES///////////////////////////////////////////////////////////////////////////////

	/**
	 * Carrega els usuaris a la memoria del programa a partir del fitxer per defecte.
	 * 
	 * Esta per fer encara.
	 * 
	 * @return true si s'ha pogut carregar tot correctament, false si hi ha hagut algun error.
	 */
	public Boolean iniciCarregarUsers() { return true; }
	
	/**
	 * Fa Admin a un usuari username ja existent.
	 * 
	 * @param username
	 * 			Username de l'usuari que es vol fer administrador.
	 */
	public void addAdmin(String username) {
		conj.getUser(username).ferAdmin();
	}

	/**
	 * Afegeix un usuari nou al conjunt d'usuaris de la memoria del programa. 
	 * 
	 * @param username
	 * 				Username de l'usuari que volem afegir.
	 * @param pass
	 * 				Password de l'usuari que volem afegir.
	 *  
	 * @return true si s'ha afegit correctament, false si ja existia un usuari amb aquest username.
	 */
	public Boolean addUser(String username, String pass) {
		if (!conj.exists(username)) {
			Usuari u = new Usuari(username, pass, false);
			return conj.addUser(u);
		}
		else return false;
	}

	/**
	 * Afegeix una nova CercaComunitats a un usuari username existent.
	 *  
	 * @param username
	 * 			Username de l'usuari al qual volem afegir la CercaComunitats.
	 * 
	 * @return identificador dins de l'usuari username de la nova cerca creada.
	 */
	public Integer addNovaCerca(String username) {
		Integer aux = conj.getUser(username).addCerca(new CercaComunitats());
		conj.getUser(username).getCerca(aux).setUsuari(username);
		Date act = new Date();		//Com s'obté la data actual?
		conj.getUser(username).getCerca(aux).setDataCreacio(act);
		return aux;
	}
	
	/**
	 * Afegeix a una CercaComunitats d'un Usuari existent, els seus Criteris de cerca.
	 * 
	 * @param modifica
	 * 			Indica si es modifiquen els criteris o s'afegeixen de nou.
	 * @param username
	 * 			Username de l'usuari al qual li volem els criteris d'una de les seves CercaComunitats.
	 * @param i
	 * 			Identificador de la CercaComunitats dins de les Cerques de l'usuari.
	 * @param paraulast
	 * 			Paraula Clau a la qual se li vol donar una importancia determinada.
	 * @param paraulain
	 * 			Importancia que se li vol donar a la Paraula Clau.
	 * @param relacions
	 * 			Importancia que se li vol donar a les relacions entre Categories.
	 * @param sembla
	 * 			Importancia que se li vol donar a la semblança entre els noms de les Categories.
	 * @param alg 
	 * 			Indicador de quin algorisme es vol utilitzar.
	 * @param tipus
	 * 			Indica quina execucio es vol fer de l'algorisme seleccionat.
	 * @param dada
	 * 			Numero per realitzar la execucio d'una CercaComunitats, depen del tipus i de l'alg indicats.
	 * @param subconj
	 * 			Conjunt de Categories a partir de les quals es restringeix la Cerca.
	 * @param evitaCat
	 * 			Conjunt de Categories que no s'han de tenir en compte en la Cerca.
	 * @param evitaPag
	 * 			Conjunt de Pagines que no s'han de tenir en compte en la Cerca.
	 * @param String pare
	 * 			Nom de Categoria a partir de la qual es restringeix la Cerca.
	 * 
	 * @return false si hi ha hagut algun error, true altrament.
	 */
	public Boolean addCriterisCerca(Boolean modifica, String username, Integer i, String paraulast, Integer paraulain, Integer relacions, Integer sembla, Integer alg, Integer tipus, Integer dada, ArrayList<String> subconj, ArrayList<String> evitaCat, ArrayList<String> evitaPag, String pare ) {
		ParaulaValor par = new ParaulaValor(paraulast, paraulain);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		for(String catsub: subconj) {
			sub.add(gd.getCategoria(catsub));
		}
		ArrayList<Categoria> evitCat = new ArrayList<Categoria>();
		for(String evcat: evitaCat) {
			evitCat.add(gd.getCategoria(evcat));
		}
		ArrayList<Pagina> evitPag = new ArrayList<Pagina>();
		for(String evpag: evitaPag) {
			evitPag.add(gd.getPagina(evpag));
		}
		Criteris aux = new Criteris(par, relacions, sembla, alg, tipus, dada, sub, evitCat, evitPag, pare);
		conj.getUser(username).getCerca(i).setCriterisSeleccio(aux);
		conj.getUser(username).getCerca(i).setAlgorisme(alg);
		if(modifica) conj.getUser(username).getCerca(i).setDataModificacio(new Date());
		return true;
	}
	
	/**
	 * Afegeix el nom a una CercaComunitats d'un usuari existent.
	 *  
	 * @param username
	 * 			Username de l'usuari al qual volem afegir el nom de la CercaComunitats.
	 * @param i
	 * 			Identificador de la CercaComunitats dins de les Cerques de l'usuari.
	 * @param nom
	 * 			Nom que es vol posar a la CercaComunitats.
	 */
	public void addNomCerca(String username, Integer i, String nom) {
		conj.getUser(username).getCerca(i).setNom(nom);
	}
	/**
	 * Afegeix el comentari a una CercaComunitats d'un usuari existent.
	 *  
	 * @param username
	 * 			Username de l'usuari al qual volem afegir el comentari de la CercaComunitats.
	 * @param i
	 * 			Identificador de la CercaComunitats dins de les Cerques de l'usuari.
	 * @param comentari
	 * 			Comentari que es vol posar a la CercaComunitats.
	 */
	public void addComentariCerca(String username, Integer i, String comentari) {
		conj.getUser(username).getCerca(i).setComentari(comentari);
	}
	
	/**
	 * Assigna una password a un usuari existent.
	 *  
	 * @param username
	 * 			Username de l'usuari al qual es vol assignar la contrassenya.
	 * @param pass
	 * 			Nova password de l'usuari.
	 */
	public void setPassword(String username, String pass) {
		conj.getUser(username).setPassword(pass);
	}
	
	/**
	 * Canvia l'username d'un usuari existent.
	 *  
	 * @param antic
	 * 			Username antic de l'usuari al qual es vol canviar el nom.
	 * @param nou
	 * 			Nou username que es vol assignar a l'usuari.
	 * 
	 * @return false si no s'ha pogut canviar el nom, true en cas contrari.
	 */
	public Boolean setUsername(String antic, String nou) {
		return conj.setUsername(antic, nou);
	}

	/**
	 * Elimina un usuari del conjunt d'usuaris de la memoria del programa.
	 *  
	 * @param username
	 * 			Username de l'usuari que es vol eliminar.
	 * 
	 * @return false si no s'ha pogut eliminar, true altrament.
	 */
	public Boolean removeUser(String username) {
		if (conj.exists(username)) return conj.removeUser(username);
		else return false;

	}
	
	/**
	 * Elimina una CercaComunitats d'un usuari existent a partir del seu nom.
	 *  
	 * @param username
	 * 			Username de l'usuari del qual es vol eliminar la CercaComunitats.
	 * @param nom
	 * 			Nom de la CercaComunitats de l'usuari que es vol eliminar.
	 * 
	 * @return false si no s'ha pogut eliminar, true altrament.
	 */
	public Boolean removeCerca(String username, String nom) {
		return conj.getUser(username).removeCerca(nom);
	}
	
	/**
	 * Elimina una CercaComunitats d'un usuari existent a partir del seu identificador.
	 *  
	 * @param username
	 * 			Username de l'usuari del qual es vol eliminar la CercaComunitats.
	 * @param quina
	 * 			Identificador de la CercaComunitats de l'usuari que es vol eliminar.
	 * 
	 * @return false si no s'ha pogut eliminar, true altrament.
	 */
	public Boolean removeCerca(String username, Integer quina) {
		return conj.getUser(username).removeCerca(quina);
	}
	
	/**
	 * Executa el conjunt d'operacions necessàries per tal d'executar una Cerca de Comunitats.
	 *  
	 * @param username
	 * 			Username de l'usuari del es vol fer la CercaComunitats.
	 * @param quina
	 * 			Identificador de la CercaComunitats de l'usuari que es vol fer.
	 * 
	 * @return false si no s'ha pogut executar, true altrament.
	 */
	public Boolean ferCerca(String username, Integer quina){
		TraduccioiAlgorisme ta = new TraduccioiAlgorisme();
		ArrayList<Comunitat> list = ta.traduiricercar(gd, conj.getUser(username).getCerca(quina).getCriterisSeleccio());
		conj.getUser(username).getCerca(quina).setComunitats(list);
		return true;
	}
	
// CONSULTORES///////////////////////////////////////////////////////////////////////////////

	/**
	 * Consulta si existeix un usari al Conjunt d'usuaris.
	 * 
	 * @param username
	 * 			Nom de l'suari que es vol consultar.
	 * 
	 * @return true si existeix un usuari username.
	 */
	public Boolean existsUser(String username) {
		return conj.exists(username);
	}

	/**
	 * Consulta si la password concorda amb l'usuari .
	 * 
	 * @param username
	 * 			Nom de l'usuari que es vol consultar.
	 * @param pass
	 * 			Password que es vol consultar.
	 * 
	 * @return true si concorden, false en cas contrari.
	 */
	public Boolean login(String username, String pass) {
		Usuari u = conj.getUser(username);
		return u.getPassword().equals(pass);
	}
	
	/**
	 * Consulta si un cert usuari es administrador
	 * 
	 * @param username
	 * 			Nom de l'usuari que es vol consultar.
	 * 
	 * @return true si l'usuari es admin, false en cas contrari.
	 */
	public Boolean isAdmin(String username) {
		return conj.getUser(username).esAdmin();
	}

	/**
	 * Consulta el nom dels usuaris existents en la memoria principal del programa.
	 * 
	 * @return llista amb els noms dels usuaris existents.
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
	 * Consulta el nom de les Cerques de Comunitats realitzades per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es volen consultar les Cerques.
	 * 
	 * @return noms de les cerques de comunitats fetes per l'usuari.
	 */
	public ArrayList<String> getCerquesComunitats(String username) {
		Usuari aux = conj.getUser(username);
		int num = aux.getNumCerques();
		ArrayList<String> comunitats = new ArrayList<String>();
		for(int i = 0; i < num; ++i)comunitats.add(aux.getCerca(i).getNom());
		return comunitats;
	}
	
	/**
	 * Consulta la posicio d'una CercaComunitats dins de les fetes per un usuari a partir del seu nom.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la posicio de la Cerca.
	 * @param quina
	 * 			Nom de la Cerca de Comunitats de la qual es vol resoldre la posicio.
	 * 
	 * @return posicio de la Cerca dins de les Cerques de l'usuari.
	 */
	public Integer getNumCerca(String username, String quina) {	
		return conj.getUser(username).getPosCerca(quina);
	}
	
	/**
	 * Consulta el nom de la Cerca de Comunitats que esta a una certa posicio d'un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el nom de la Cerca.
	 * @param quina
	 * 			Posicio de la Cerca de la qual es vol resoldre el nom.
	 * 
	 * @return noms de la CercaComunitats a resoldre.
	 */
	public String getNomCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getNom();
	}
	
	/**
	 * Consulta el comentari d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el comentari de la Cerca.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el comentari.
	 * 
	 * @return comentari de la CercaComunitats a resoldre.
	 */
	public String getComentariCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getComentari();
	}
	
	/**
	 * Consulta la data de creacio d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la data de creacio.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber la data de creacio.
	 * 
	 * @return data de creacio de la CercaComunitats a resoldre.
	 */
	public Date getDataCreacioCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getDataCreacio();
	}

	/**
	 * Consulta la data de modificacio d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la data de modificacio.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber la data de modificacio.
	 * 
	 * @return data de modificacio de la CercaComunitats a resoldre.
	 */
	public Date getDataModificacioCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getDataModificacio();
	}
	
	/**
	 * Consulta l'algorisme seleccionat d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar l'algorisme.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber l'algorisme.
	 * 
	 * @return identificador de l'algorisme utilitzat en la CercaComunitats a resoldre.
	 */
	public Integer getAlgCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getAlgorisme();
	}
	
	/**
	 * Consulta el valor d'execucio d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la dada.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber la dada.
	 * 
	 * @return valor d'execucio de la CercaComunitats a resoldre.
	 */
	public Integer getAlgDadaCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getDada();
	}
	
	/**
	 * Consulta el tipus d'execucio d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el tipus d'execucio.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el tipus d'execucio.
	 * 
	 * @return identificador del tipus d'execucio seleccionat en la CercaComunitats a resoldre.
	 */
	public Integer getAlgTipuCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getTipuCerca();
	}
	
	/**
	 * Consulta la importancia entre les relacions entre categories d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la importancia entre les relacions entre categories.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber la importancia entre les relacions entre categories.
	 * 
	 * @return valor de la importancia entre les relacions entre categories de la CercaComunitats a resoldre.
	 */
	public Integer getRelacioCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getRelacionsCat();
	}
	
	/**
	 * Consulta la importancia entre la semblansa entre els noms de les categories d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la importancia entre la semblansa entre els noms de les categories.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber la importancia entre la semblansa entre els noms de les categories.
	 * 
	 * @return valor de la importancia entre la semblansa entre els noms de les categories de la CercaComunitats a resoldre.
	 */
	public Integer getSembCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getSemblaNom();
	}
	
	/**
	 * Consulta la importancia de la Paraula Clau d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la importancia de la Paraula Clau.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber la importancia de la Paraula Clau.
	 * 
	 * @return importancia de la Paraula Clau en la CercaComunitats a resoldre.
	 */
	public Integer getParaulaImpCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getParaulaClau().getNum();
	}
	
	/**
	 * Consulta Paraula Clau d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar la Paraula Clau.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber la Paraula Clau.
	 * 
	 * @return Paraula Clau en la CercaComunitats a resoldre.
	 */
	public String getParaulaClauCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getParaulaClau().getParaula();
	}
	
	/**
	 * Consulta Nom de Categoria a partir de la qual es restringeix una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el nom de la categoria Pare.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el nom de la categoria Pare.
	 * 
	 * @return Nom de la categoria Pare a partir de la qual es restringeix la CercaComunitats a resoldre.
	 */
	public String getPareCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getCriterisSeleccio().getPare();
	}
	
	/**
	 * Consulta el conjunt de categories a partir del qual es restringeix una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el conjunt de categories.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el conjunt de categories.
	 * 
	 * @return conjunt de categories a partir del qual es restringeix la CercaComunitats a resoldre.
	 */
	public ArrayList<String> getSubCerca(String username, Integer quina) {
		ArrayList<String> aux = new ArrayList<String>();
		ArrayList<Categoria> aux2 = conj.getUser(username).getCerca(quina).getCriterisSeleccio().getSubconjCat();
		for(Categoria cat: aux2) aux.add(cat.getNom());
		return aux;
	}
	
	/**
	 * Consulta el conjunt de categories evitades en una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el conjunt de categories evitades.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el conjunt de categories evitades.
	 * 
	 * @return conjunt de categories evitades en la CercaComunitats a resoldre.
	 */
	public ArrayList<String> getEvitaCatCerca(String username, Integer quina) {
		ArrayList<String> aux = new ArrayList<String>();
		ArrayList<Categoria> aux2 = conj.getUser(username).getCerca(quina).getCriterisSeleccio().getEvitaCat();
		for(Categoria cat: aux2) aux.add(cat.getNom());
		return aux;
	}
	
	/**
	 * Consulta el conjunt de pagines evitades en una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el conjunt de pagines evitades.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el conjunt de pagines evitades.
	 * 
	 * @return conjunt de pagines evitades en la CercaComunitats a resoldre.
	 */
	public ArrayList<String> getEvitaPagCerca(String username, Integer quina) {
		ArrayList<String> aux = new ArrayList<String>();
		ArrayList<Pagina> aux2 = conj.getUser(username).getCerca(quina).getCriterisSeleccio().getEvitaPag();
		for(Pagina cat: aux2) aux.add(cat.getNom());
		return aux;
	}
	
	/**
	 * Consulta el nombre de comunitats d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el nombre de comunitats.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el nombre de comunitats.
	 * 
	 * @return Nombre de comunitats de la CercaComunitats a resoldre.
	 */
	public Integer getNumComunitatsCerca(String username, Integer quina) {
		return conj.getUser(username).getCerca(quina).getNumComunitats();
	}
	
	/**
	 * Consulta el nombre de categories en una comunitat determinada d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar el nombre de categories de la comunitat.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber el nombre de categories de la comunitat.
	 * @param num
	 * 			Identificador de la comunitat de la qual es vol saber el nombre de categories.
	 * 
	 * @return Nombre de categories de la comunitat de la CercaComunitats a resoldre.
	 */
	public Integer getNumCatCerca(String username, Integer quina, Integer num) {
		return conj.getUser(username).getCerca(quina).getComunitat(num).getNumeroDeCategories();
	}
	
	/**
	 * Consulta els noms de les categories d'una comunitat determinada d'una certa Cerca de Comunitats realitzada per un usuari.
	 * 
	 * @param username
	 * 			Nom de l'usuari del qual es vol consultar els noms de les categories de la comunitat.
	 * @param quina
	 * 			Posicio de la cerca dins de les Cerques de l'usuari de la qual es vol saber els noms de les categories de la comunitat.
	 * @param num
	 * 			Identificador de la comunitat de la qual es vol saber els noms de categories.
	 * 
	 * @return Conjunt de noms de les categories de la comunitat de la CercaComunitats a resoldre.
	 */
	public Set<String> getCatCerca(String username, Integer quina, Integer com) {
		Map<String,Categoria> aux = conj.getUser(username).getCerca(quina).getComunitat(com).getMapCat();
		return aux.keySet();
	}
}
