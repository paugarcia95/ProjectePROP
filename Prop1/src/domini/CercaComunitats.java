package domini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * @author Dani
 *
 */

public class CercaComunitats {
	
	private String nom, comentari, usuari;
	private Date dataCreacio, dataModificacio;
	private Criteris criterisSeleccio;
	private ArrayList<Comunitat> comunitats;
	
	/**
	 * Crea una CercaComunitats amb el paràmetres especificats.
	 * 
	 * @param nom nom de la cerca
	 * @param dataCreacio data de creació de la cerca
	 * @param criteris criteris de busqueda de la cerca
	 * @param usuari usuari que realitza la cerca
	 * @param dataModif última data de modificació de la cerca
	 * @param comentari comentari de la cerca
	 * @param comunitats conjunt de comunitats resultants de la cerca
	 */
	public CercaComunitats(String nom, Date dataCreacio, Criteris criteris, String usuari, Date dataModif, String comentari, ArrayList<Comunitat> comunitats) {
		this.nom = nom;
		this.dataCreacio = dataCreacio;
		this.criterisSeleccio = criteris;
		this.usuari = usuari;
		dataModificacio = dataModif;
		this.comentari = comentari;
		this.comunitats = comunitats;
	}
	
	/**
	 * Crea una CercaComunitats amb el nom especificat.
	 * 
	 * @param nom nom de la cerca
	 */
	public CercaComunitats(String nom) {
		this.nom = nom;
		dataCreacio = new Date();
		comunitats = new ArrayList<Comunitat>();
	}
	
	/**
	 * Crea una CercaComunitats sense nom.
	 */
	public CercaComunitats() {
		dataCreacio = new Date();
		comunitats = new ArrayList<Comunitat>();
	}
	
	/**
	 * @return el <code>nom</code> de la cerca
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param s el nom de la cerca
	 */
	public void setNom(String s) {
		nom = s;
	}
	
	/**
	 * @return la <code>dataCreacio</code> de la cerca
	 */
	public Date getDataCreacio() {
		return dataCreacio;
	}
	
	/**
	 * 
	 * @param d la dataCreacio de la cerca
	 */
	public void setDataCreacio(Date d) {
		dataCreacio = d;
	}
	
	/**
	 * @return els <code>criterisSeleccio</code> de la cerca
	 */
	public Criteris getCriterisSeleccio() {
		return criterisSeleccio;
	}
	
	/**
	 * 
	 * @param c els criterisSeleccio de la cerca
	 */
	public void setCriterisSeleccio(Criteris c) {
		criterisSeleccio = c;
	}
	
	/**
	 * @return el <code>comentari</code> de la cerca
	 */
	public String getComentari() {
		return comentari;
	}
	
	/**
	 * 
	 * @param s el comentari de la cerca
	 */
	public void setComentari(String s) {
		comentari = s;
	}
	
	/**
	 * @return l'<code>usuari</code> de la cerca
	 */
	public String getUsuari() {
		return usuari;
	}	
	
	/**
	 * 
	 * @param s l'usuari de la cerca
	 */
	public void setUsuari(String s) {
		usuari = s;
	}
	
	/**
	 * @return la <code>dataModificacio</code> de la cerca
	 */	
	public Date getDataModificacio() {
		return dataModificacio;
	}
	
	/**
	 * 
	 * @param d la dataModifiacio de la cerca
	 */
	public void setDataModificacio(Date d) {
		dataModificacio = d;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna la Comunitat amb índex i
	 */
	
	/**
	 * Elimina la relació "és supercategoria".
	 * 
	 * @param nomCategoria <code>key</code> que serà eliminada de <code>cSupC</code>
	 * @return 
	 */
	public Comunitat getComunitat(Integer i) {
		if (i >= 0 && i < comunitats.size()) return comunitats.get(i);
		return null;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de comunitats que componen la cerca
	 */
	public Integer getNumComunitats() {
		return comunitats.size();
	}	
	
	/**
	 * Pre: comunitat no pertany a comunitats
	 * Post: comunitat pertanty a comunitats amb índex retornat
	 */
	public Integer addComunitat(Comunitat comunitat) {
		comunitats.add(comunitat);
		return comunitats.size() - 1;
	}
	
	/** 
	 * Pre: i es l'índex d'una Comunitat existent a comunitats && i < comunitas.size()
	 * Post: La Comunitat amb índex i ja no pertany a comunitats
	 */
	public Boolean removeComunitat(Integer i) {
		if (i >= 0 && i < comunitats.size()) {
			comunitats.remove(i.intValue());
			return true;
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: categoria pertanty a la Comunitat amb índex comunitat i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean addCategoriaComunitat(Integer comunitat, String categoria) {
		if (comunitat >= 0 && comunitat < comunitats.size()) {
			return comunitats.get(comunitat).addCat(categoria);
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: categoria no pertany a la Comunitat amb índex comunitat i retorna <code>true</code>, retorna <code>false</code> altrament
	 */
	public Boolean removeCategoriaComunitat(Integer comunitat, String categoria) {
		if (comunitat >= 0 && comunitat < comunitats.size()) {
			return comunitats.get(comunitat).removeCat(categoria);
		}
		return false;
	}
		
	/**
	 * Pre: Cert
	 * Post: comunitats = array i nComunitats = array.size()
	 */
	public void setComunitats(ArrayList<Comunitat> array) {
		if (array == null) comunitats = new ArrayList<Comunitat>();
		comunitats = array;
	}
	
	/**
	 * Pre: Cert
	 * Post: Les comunitats estan ordenades de més a menys categories
	 */
	public void ordenaComunitats() {
		Collections.sort(comunitats, new CustomComparator());
	}
	
	
	private class CustomComparator implements Comparator<Comunitat> {
		@Override
		public int compare(Comunitat c1, Comunitat c2) {
			return c2.getNumeroDeCategories()-c1.getNumeroDeCategories();
		}
	}
	
}
