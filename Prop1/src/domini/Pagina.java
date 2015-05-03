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
		nom = "NoIndicat";
		cP = new TreeMap<String, Categoria>();
		pC = new TreeMap<String, Categoria>();
	}
	
	public Pagina(String nom) {
		this.nom = nom;
		cP = new TreeMap<String, Categoria>();
		pC = new TreeMap<String, Categoria>();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna nom
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
	public Integer existsPC(String categoria) {
		if(pC.containsKey(categoria)) return 1;
		if(cP.containsKey(categoria)) return 2;
		return 0;
	}
	
	/**
	 * Pre: categoria no pertany a pC
	 * Post: categoria pertany a pC
	 */
	public void addPC(Categoria categoria) {
		pC.put(categoria.getNom(), categoria);
	}	
	
	/**
	 * Pre: categoria no pertany a cP
	 * Post: categoria pertany a cP
	 */
	public void addCP(Categoria categoria) {
		cP.put(categoria.getNom(), categoria);
	}
	
	/**
	 * Pre: categoria es una key de pC amb un valor assignat
	 * Post: categoria ja no es key de pC
	 */
	public void removePC(String categoria) {
		pC.remove(categoria);
	}
	
	/**
	 * Pre: categoria es una key de cP amb un valor assignat
	 * Post: categoria ja no es key de cP
	 */
	public void removeCP(String categoria) {
		cP.remove(categoria);
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna pC
	 */
	public Map<String, Categoria> getPC() {
		return pC;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna cP
	 */
	public Map<String, Categoria> getCP() {
		return cP;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de categories a les que apunta la Pagina
	 */
	public Integer getNumPC() {
		return pC.size();
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de categories que apunten a la Pagina
	 */
	public Integer getNumCP() {
		return cP.size();
	}
	
}
