package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Categoria {
	
	private String nom;
	private Map<String, Pagina> cP, pC; //cP conté les pàgines a les que apunta i pC les pàgines que li apunten
	private Map<String, Categoria> cSubC, cSupC; //cSubC conté les seves subcategories, cSupC conté les seves supercategories
	
	
	/**
	 * Crea una Categoria amb el nom especificat sense cap relació.
	 * 
	 * @param nom nom que posar a la categoria
	 */
	public Categoria(String nom) {
		this.nom = nom;
		cP = new TreeMap<String, Pagina>();
		pC = new TreeMap<String, Pagina>();
		cSubC = new TreeMap<String, Categoria>();
		cSupC = new TreeMap<String, Categoria>();
	}
	
	/**
	 * Crea una Categoria amb nom "NoIndicat" sense cap relació.
	 */
	public Categoria() {
		nom = "NoIndicat";
		cP = new TreeMap<String, Pagina>();
		pC = new TreeMap<String, Pagina>();
		cSubC = new TreeMap<String, Categoria>();
		cSupC = new TreeMap<String, Categoria>();
	}
	
	/**
	 * @return el <code>nom</code> de la categoria
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param nom nom que posar a la categoria
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Retorna 1 si la pàgina l'apunta, 2 si apunta a la pàgina, 0 si no té relació.
	 * 
	 * @param nomPagina nom de la pàgina amb la qual busca la relació
	 * @return 0 si no existeix ni <code>cP</code> ni <code>pC</code>, 1 si és <code>pC</code> i 2 si es <code>cP</code>
	 */
	public Integer existsCP(String nomPagina) {
		if(pC.containsKey(nomPagina)) return 1;
		if(cP.containsKey(nomPagina)) return 2;
		return 0;
	}
	
	/**
	 * Retorna 1 si la categoria és supercategoria, 2 si és subcategoria, 0 si no té relació.
	 * 
	 * @param nomCategoria nom de la categoria amb la qual busca la relació
	 * @return 0 si no hi ha ni <code>cSupC</code> ni <code>cSubC</code>, 1 si és <code>cSupC</code> i 2 si és <code>cSubC</code>
	 */
	public Integer existsCC(String nomCategoria) {
		if(cSupC.containsKey(nomCategoria)) return 1;
		if(cSubC.containsKey(nomCategoria)) return 2;
		return 0;
	}
	
	/**
	 * 
	 * @param pagina la pàgina que no pertany a <code>cP</code> i serà inserida
	 */
	public void addCP(Pagina pagina) {
		cP.put(pagina.getNom(), pagina);
	}
	
	/**
	 * 
	 * @param pagina la pàgina que no pertany a <code>pC</code> i serà inserida
	 */
	public void addPC(Pagina pagina) {
		pC.put(pagina.getNom(), pagina);
	}
	
	/**
	 * 
	 * @param categoria la categoria que no pertany a <code>cSupC</code> i serà inserida
	 */
	public void addCsupC(Categoria categoria) {
		cSupC.put(categoria.nom, categoria);
	}
	
	/**
	 * 
	 * @param categoria la categoria que no pertany a <code>cSubC</code> i serà inserida
	 */
	public void addCsubC(Categoria categoria) {
		cSubC.put(categoria.nom, categoria);
	}
	
	/** 
	 * Pre: nomPagina es una key de cP amb un valor assignat
	 * Post: nomPagina ja no es key de cP
	 */
	public void removeCP(String nomPagina) {
		cP.remove(nomPagina);
	}
	
	/**
	 * Pre: nomPagina es una key de pC amb un valor assignat
	 * Post: nomPagina ja no es key de pC
	 */
	public void removePC(String nomPagina) {
		pC.remove(nomPagina);
	}
	
	/**
	 * Pre: nomCategoria es una key de cSubC amb un valor assignat
	 * Post: nomCategoria ja no es key de cSubC
	 */
	public void removeCsubC(String nomCategoria) {
		cSubC.remove(nomCategoria);
	}
	
	/**
	 * Pre: nomCategoria es una key de cSupC amb un valor assignat
	 * Post: nomCategoria ja no es key de cSupC
	 */
	public void removeCsupC(String nomCategoria) {
		cSupC.remove(nomCategoria);
	}
	
	public Map<String, Pagina> getMapCP() {
		return cP;
	}

	public Map<String, Pagina> getMapPC() {
		return pC;
	}
	
	public Map<String, Categoria> getMapCSubC() {
		return cSubC;
	}
	
	public Map<String, Categoria> getMapCSupC() {
		return cSupC;
	}

	public void setMapCP(Map<String, Pagina> mapa) {
		cP = mapa;
	}
	
	public void setMapPC(Map<String, Pagina> mapa) {
		pC = mapa;
	}

	public void setMapCSubC(Map<String, Categoria> mapa) {
		cSubC = mapa;
	}

	public void setMapCSupC(Map<String, Categoria> mapa) {
		cSupC = mapa;
	}	

}