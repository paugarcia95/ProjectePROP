package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Pagina {
	
	private String nom;
	private Map<String, Categoria> cP, pC; //cP conté les categories que li apunten i el pC les categories a les que apunta
	
	
	public Pagina(String nom, Map<String, Categoria> pC, Map<String, Categoria> cP) {
		this.nom = nom;
		this.pC = pC;
		this.cP = cP;
	}
	
	public Pagina() {
		cP = new TreeMap<String, Categoria>();
		pC = new TreeMap<String, Categoria>();
	}
	
	public Pagina(String nom) {
		this.nom = nom;
		cP = new TreeMap<String, Categoria>();
		pC = new TreeMap<String, Categoria>();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//Pre: cert
	//Post: retorna 0 si no existeix ni cP ni pC, 1 si és pC i 2 si es cP
	public Integer existsPC(String categoria) {
		if(pC.containsKey(categoria)) return 1;
		if(cP.containsKey(categoria)) return 2;
		return 0;
	}
	
	
	//Pre: categoria no pertany a pC
	//Post: categoria pertany a pC
	public Boolean addPC(Categoria categoria) {
		pC.put(categoria.getNom(), categoria);
		return true;
	}	
	
	
	//Pre: categoria no pertany a cP
	//Post: categoria pertany a cP
	public void addCP(Categoria categoria) {
		cP.put(categoria.getNom(), categoria);
	}
	
	//Pre: categoria es una key de pC amb un valor assignat
	//Post: categoria ja no es key de pC
	public Boolean removePC(String categoria) {
		pC.remove(categoria);
		return true;
	}
	
	//Pre: categoria es una key de cP amb un valor assignat
	//Post: categoria ja no es key de cP
	public Boolean removeCP(String categoria) {
		cP.remove(categoria);
		return true;
	}
	
	public Map<String, Categoria> getPC() {
		return pC;
	}
	
	public Map<String, Categoria> getCP() {
		return cP;
	}
	
	public Integer getNumPC() {
		return pC.size();
	}
	
	public Integer getNumCP() {
		return cP.size();
	}
	
}
