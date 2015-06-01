package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Pagina {
	
	private String nom;
	private Map<String, Categoria> cP, pC; //cP cont� les categories que li apunten i el pC les categories a les que apunta
	
	/**
	 * Crea una Pagina amb el nom especificat sense cap relaci�.
	 * 
	 * @param nom nom de la p�gina
	 */
	public Pagina(String nom) {
		this.nom = nom;
		cP = new TreeMap<String, Categoria>();
		pC = new TreeMap<String, Categoria>();
	}
	
	/**
	 * Crea una Pagina amb nom "NoIndicat" sense cap relaci�.
	 */
	public Pagina() {
		nom = "NoIndicat";
		cP = new TreeMap<String, Categoria>();
		pC = new TreeMap<String, Categoria>();
	}
	
	/**
	 * @return el <code>nom</code> de la p�gina
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param nom el nom de la p�gina
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Retorna 1 si apunta a la categoria, 2 si la categoria l'apunta, 0 si no t� relaci�.
	 * 
	 * @param nomCategoria nom de la categoria amb la qual busca la relaci�
	 * @return 0 si no existeix ni <code>pC</code> ni <code>cP</code>, 1 si �s <code>pC</code> i 2 si es <code>cP</code>
	 */
	public Integer existsPC(String nomCategoria) {
		if(pC.containsKey(nomCategoria)) return 1;
		if(cP.containsKey(nomCategoria)) return 2;
		return 0;
	}
	
	/**
	 * Crea la relaci� "apunta a la categoria".
	 * 
	 * @param categoria la categoria que no pertany a <code>pC</code> i ser� inserida
	 */
	public void addPC(Categoria categoria) {
		pC.put(categoria.getNom(), categoria);
	}	
	
	/**
	 * Crea la relaci� "�s apuntada per la categoria".
	 * 
	 * @param categoria la categoria que no pertany a <code>cP</code> i ser� inserida
	 */
	public void addCP(Categoria categoria) {
		cP.put(categoria.getNom(), categoria);
	}
	
	/**
	 * Pre: categoria es una key de pC amb un valor assignat
	 * Post: categoria ja no es key de pC
	 */
	
	/** 
	 * Elimina la relaci� "apunta a la categoria".
	 * 
	 * @param nomCategoria <code>key</code> que ser� eliminada de <code>pC</code>
	 */
	public void removePC(String nomCategoria) {
		pC.remove(nomCategoria);
	}
	
	/**
	 * Elimina la relaci� "�s apuntada per la categoria".
	 * 
	 * @param nomCategoria <code>key</code> que ser� eliminada de <code>cP</code>
	 */
	public void removeCP(String nomCategoria) {
		cP.remove(nomCategoria);
	}
	
	/**
	 * @return el mapa de relacions "apunta a la categoria"
	 */
	public Map<String, Categoria> getPC() {
		return pC;
	}
	
	/**
	 * @return el mapa de relacions "�s apuntada per la categoria"
	 */
	public Map<String, Categoria> getCP() {
		return cP;
	}
	
}
