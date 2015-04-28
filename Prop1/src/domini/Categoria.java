package domini;

import java.util.Map;
import java.util.TreeMap;

public class Categoria {
	
	private String nom;
	private Map<String, Pagina> CP, PC; //CP conté les pàgines a les que apunta i PC les pàgines que li apunten
	private Map<String, Categoria> CsubC, CsupC; //CsubC conté les seves subcategories, CsupC conté les seves supercategories
	
	
	public Categoria(String nom) {
		this.nom = nom;
		CP = new TreeMap<String, Pagina>();
		PC = new TreeMap<String, Pagina>();
		CsubC = new TreeMap<String, Categoria>();
		CsupC = new TreeMap<String, Categoria>();
	}
	
	public Categoria() {
		nom = "NoIndicat";
		CP = new TreeMap<String, Pagina>();
		PC = new TreeMap<String, Pagina>();
		CsubC = new TreeMap<String, Categoria>();
		CsupC = new TreeMap<String, Categoria>();
	}
	
	//Pre: Cert
	//Post: Retorna el Nom
	public String getNom() {
		return nom;
	}
	
	//Pre: Cert
	//Post: Nom = nom
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//Pre: Cert
	//Post: Retorna 0 si no existeix ni CP ni PC, 1 si és PC i 2 si es CP
	public Integer existsCP(String nom_pagina) {
		if(PC.containsKey(nom_pagina)) return 1;
		if(CP.containsKey(nom_pagina)) return 2;
		return 0;
	}
	
	//Pre: Cert
	//Post: Retorna 0 si no hi ha ni CsupC ni CsubC, 1 si és CsupC i 2 si és CsubC
	public Integer existsCC(String nom_categoria) {
		if(CsupC.containsKey(nom_categoria)) return 1;
		if(CsubC.containsKey(nom_categoria)) return 2;
		return 0;
	}
	
	//Pre: pagina no pertany a CP
	//Post: pagina pertany a CP
	public void addCP(Pagina pagina) {
		CP.put(pagina.getNom(), pagina);
	}
	
	//Pre: pagina no pertany a PC
	//Post: pagina pertany a PC
	public void addPC(Pagina pagina) {
		PC.put(pagina.getNom(), pagina);
	}
	
	//Pre: categoria no pertany a CsupC
	//Post: categoria pertany a CsupC
	public void addCsupC(Categoria categoria) {
		CsupC.put(categoria.nom, categoria);
	}
	
	//Pre: categoria no pertany a CsubC
	//Post: categoria pertany a CsubC
	public void addCsubC(Categoria categoria) {
		CsubC.put(categoria.nom, categoria);
	}
	
	
	//Pre: nom_pagina es una key de CP amb un valor assignat
	//Post: nom_pagina ja no es key de CP
	public void removeCP(String nom_pagina) {
		CP.remove(nom_pagina);
	}
	
	//Pre: nom_pagina es una key de PC amb un valor assignat
	//Post: nom_pagina ja no es key de PC
	public void removePC(String nom_pagina) {
		PC.remove(nom_pagina);
	}
	
	//Pre: nom_categoria es una key de CsubC amb un valor assignat
	//Post: nom_categoria ja no es key de CsubC
	public void removeCsubC(String nom_categoria) {
		CsubC.remove(nom_categoria);
	}
	
	//Pre: nom_categoria es una key de CsupC amb un valor assignat
	//Post: nom_categoria ja no es key de CsupC
	public void removeCsupC(String nom_categoria) {
		CsupC.remove(nom_categoria);
	}
	
	/*
	public Map<String, Pagina> getMapCP() {
		return CP;
	}
	
	No he implementat la resta:
	+ getMapCC(): &map<string, *Categoria>
	+ setMapCP(mapa: &map<string, *Pagina>): void
	+ setMapCC(mapa: &map<string, *Categoria>): void
	
	perque no se quin es el MapCC, si es l'agregació del CsupC amb el CsubC o com
	*/

}