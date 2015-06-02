package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Categoria {
	
	private String nom;
	private Map<String, Pagina> cP, pC; //cP cont� les p�gines a les que apunta i pC les p�gines que li apunten
	private Map<String, Categoria> cSubC, cSupC; //cSubC cont� les seves subcategories, cSupC cont� les seves supercategories
	
	
	/**
	 * Crea una Categoria amb el nom especificat sense cap relaci�.
	 * 
	 * @param nom nom de la categoria
	 */
	public Categoria(String nom) {
		this.nom = nom;
		cP = new TreeMap<String, Pagina>();
		pC = new TreeMap<String, Pagina>();
		cSubC = new TreeMap<String, Categoria>();
		cSupC = new TreeMap<String, Categoria>();
	}
	
	/**
	 * Crea una Categoria amb nom "NoIndicat" sense cap relaci�.
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
	 * @param nom el nom de la categoria
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Retorna 1 si la p�gina l'apunta, 2 si apunta a la p�gina, 0 si no t� relaci�.
	 * 
	 * @param nomPagina nom de la p�gina amb la qual busca la relaci�
	 * @return 0 si no existeix ni <code>cP</code> ni <code>pC</code>, 1 si �s <code>pC</code> i 2 si es <code>cP</code>
	 */
	public Integer existsCP(String nomPagina) {
		if(pC.containsKey(nomPagina)) return 1;
		if(cP.containsKey(nomPagina)) return 2;
		return 0;
	}
	
	/**
	 * Retorna 1 si la categoria �s supercategoria, 2 si �s subcategoria, 0 si no t� relaci�.
	 * 
	 * @param nomCategoria nom de la categoria amb la qual busca la relaci�
	 * @return 0 si no hi ha ni <code>cSupC</code> ni <code>cSubC</code>, 1 si �s <code>cSupC</code> i 2 si �s <code>cSubC</code>
	 */
	public Integer existsCC(String nomCategoria) {
		if(cSupC.containsKey(nomCategoria)) return 1;
		if(cSubC.containsKey(nomCategoria)) return 2;
		return 0;
	}
	
	/**
	 * Crea la relaci� "apunta a la p�gina".
	 * 
	 * @param pagina la p�gina que no pertany a <code>cP</code> i ser� inserida
	 */
	public void addCP(Pagina pagina) {
		cP.put(pagina.getNom(), pagina);
	}
	
	/**
	 * Crea la relaci� "�s apuntada per la p�gina".
	 * 
	 * @param pagina la p�gina que no pertany a <code>pC</code> i ser� inserida
	 */
	public void addPC(Pagina pagina) {
		pC.put(pagina.getNom(), pagina);
	}
	
	/**
	 * Crea la relaci� "<code>categoria</code> �s supercategoria".
	 * 
	 * @param categoria la categoria que no pertany a <code>cSupC</code> i ser� inserida
	 */
	public void addCsupC(Categoria categoria) {
		cSupC.put(categoria.nom, categoria);
	}
	
	/**
	 * Crea la relaci� "<code>categoria</code> �s subcategoria".
	 * 
	 * @param categoria la categoria que no pertany a <code>cSubC</code> i ser� inserida
	 */
	public void addCsubC(Categoria categoria) {
		cSubC.put(categoria.nom, categoria);
	}
	
	/** 
	 * Elimina la relaci� "apunta a la p�gina".
	 * 
	 * @param nomPagina <code>key</code> que ser� eliminada de <code>cP</code>
	 */
	public void removeCP(String nomPagina) {
		cP.remove(nomPagina);
	}
	
	/**
	 * Elimina la relaci� "�s apuntada per la p�gina".
	 * 
	 * @param nomPagina <code>key</code> que ser� eliminada de <code>pC</code>
	 */
	public void removePC(String nomPagina) {
		pC.remove(nomPagina);
	}
	
	/**
	 * Elimina la relaci� "�s subcategoria".
	 * 
	 * @param nomCategoria <code>key</code> que ser� eliminada de <code>cSubC</code>
	 */
	public void removeCsubC(String nomCategoria) {
		cSubC.remove(nomCategoria);
	}
	
	/**
	 * Elimina la relaci� "�s supercategoria".
	 * 
	 * @param nomCategoria <code>key</code> que ser� eliminada de <code>cSupC</code>
	 */
	public void removeCsupC(String nomCategoria) {
		cSupC.remove(nomCategoria);
	}
	
	/**
	 * @return el mapa de relacions "apunta a la p�gina"
	 */
	public Map<String, Pagina> getMapCP() {
		return cP;
	}

	/**
	 * @return el mapa de relacions "�s apuntada per la p�gina"
	 */
	public Map<String, Pagina> getMapPC() {
		return pC;
	}
	
	/**
	 * @return el mapa de relacions "�s subcategoria"
	 */
	public Map<String, Categoria> getMapCSubC() {
		return cSubC;
	}
	
	/**
	 * @return el mapa de relacions "�s supercategoria"
	 */
	public Map<String, Categoria> getMapCSupC() {
		return cSupC;
	}

	/**
	 * 
	 * @param mapa mapa que cont� totes les relacions "apunta a la p�gina"
	 */
	public void setMapCP(Map<String, Pagina> mapa) {
		cP = mapa;
	}
	
	/**
	 * 
	 * @param mapa mapa que cont� totes les relacions "�s apuntada per la p�gina"
	 */
	public void setMapPC(Map<String, Pagina> mapa) {
		pC = mapa;
	}

	/**
	 * 
	 * @param mapa mapa que cont� totes les relacions "�s subcategoria"
	 */
	public void setMapCSubC(Map<String, Categoria> mapa) {
		cSubC = mapa;
	}

	/**
	 * 
	 * @param mapa mapa que cont� totes les relacions "�s supercategoria"
	 */
	public void setMapCSupC(Map<String, Categoria> mapa) {
		cSupC = mapa;
	}	

}