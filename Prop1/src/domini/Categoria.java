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
	
	
	public Categoria(String nom) {
		this.nom = nom;
		cP = new TreeMap<String, Pagina>();
		pC = new TreeMap<String, Pagina>();
		cSubC = new TreeMap<String, Categoria>();
		cSupC = new TreeMap<String, Categoria>();
	}
	
	public Categoria() {
		nom = "NoIndicat";
		cP = new TreeMap<String, Pagina>();
		pC = new TreeMap<String, Pagina>();
		cSubC = new TreeMap<String, Categoria>();
		cSupC = new TreeMap<String, Categoria>();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Pre: Cert
	 * Post: this.nom = nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna 0 si no existeix ni cP ni pC, 1 si és pC i 2 si es cP
	 */
	public Integer existsCP(String nom_pagina) {
		if(pC.containsKey(nom_pagina)) return 1;
		if(cP.containsKey(nom_pagina)) return 2;
		return 0;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna 0 si no hi ha ni cSupC ni cSubC, 1 si és cSupC i 2 si és cSubC
	 */
	public Integer existsCC(String nom_categoria) {
		if(cSupC.containsKey(nom_categoria)) return 1;
		if(cSubC.containsKey(nom_categoria)) return 2;
		return 0;
	}
	
	/**
	 * Pre: pagina no pertany a cP
	 * Post: pagina pertany a cP
	 */
	public void addCP(Pagina pagina) {
		cP.put(pagina.getNom(), pagina);
	}
	
	/**
	 * Pre: pagina no pertany a pC
	 * Post: pagina pertany a pC
	 */
	public void addPC(Pagina pagina) {
		pC.put(pagina.getNom(), pagina);
	}
	
	/**
	 * Pre: categoria no pertany a cSupC
	 * Post: categoria pertany a cSupC
	 */
	public void addCsupC(Categoria categoria) {
		cSupC.put(categoria.nom, categoria);
	}
	
	/**
	 * Pre: categoria no pertany a cSubC
	 * Post: categoria pertany a cSubC
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