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
	private Long temps;
	
	/**
	 * Crea una CercaComunitats amb els paràmetres especificats.
	 * 
	 * @param nom nom de la cerca
	 * @param dataCreacio data de creació de la cerca
	 * @param criteris criteris de busqueda de la cerca
	 * @param usuari usuari que realitza la cerca
	 * @param dataModif última data de modificació de la cerca
	 * @param comentari comentari de la cerca
	 * @param comunitats conjunt de comunitats resultants de la cerca
	 * @param temps el temps emprat per fer la cerca
	 */
	public CercaComunitats(String nom, Date dataCreacio, Criteris criteris, String usuari, Date dataModif, String comentari, ArrayList<Comunitat> comunitats, Long temps) {
		this.nom = nom;
		this.dataCreacio = dataCreacio;
		this.criterisSeleccio = criteris;
		this.usuari = usuari;
		dataModificacio = dataModif;
		this.comentari = comentari;
		this.comunitats = comunitats;
		this.temps = temps;
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
		temps = 0l;
	}
	
	/**
	 * Crea una CercaComunitats sense nom.
	 */
	public CercaComunitats() {
		dataCreacio = new Date();
		comunitats = new ArrayList<Comunitat>();
		temps = 0l;
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
	 * 
	 * @param i l'índex de la comunitat que retorna
	 * @return la comunitat amb índex especificat. <code>null</code> si l'índex no és positiu i inferior al nombre de comunitats
	 */
	public Comunitat getComunitat(Integer i) {
		if (i >= 0 && i < comunitats.size()) return comunitats.get(i);
		return null;
	}
	
	/**
	 * @return el nombre de comunitats que té la cerca com a resultat
	 */	
	public Integer getNumComunitats() {
		return comunitats.size();
	}	
	
	/**
	 * Afegeix una nova comunitat al resultat de la cerca.
	 * 
	 * @param comunitat la comunitat que serà afegida
	 */
	public Integer addComunitat(Comunitat comunitat) {
		comunitats.add(comunitat);
		return comunitats.size() - 1;
	}
	
	/**
	 * Elimina la comunitat amb índex especificat.
	 * 
	 * @param i l'índex de la comunitat que elimina
	 * @return <code>true</code> si s'ha eliminat la comunitat amb índex especificat. <code>false</code> si l'índex no és positiu i inferior al nombre de comunitats
	 */
	public Boolean removeComunitat(Integer i) {
		if (i >= 0 && i < comunitats.size()) {
			comunitats.remove(i.intValue());
			return true;
		}
		return false;
	}
	
	/**
	 * Afegeix una nova categoria a una comunitat del resultat de la cerca.
	 * 
	 * @param comunitat l'índex de la comunitat a la que se li afegeix la categoria
	 * @param categoria la categoria que serà afegida a la comunitat
	 * @return <code>true</code> si s'ha afegit la categoria. <code>false</code> si l'índex no és positiu i inferior al nombre de comunitats o si la categoria ja pertanyia a la comunitat especificada
	 */
	public Boolean addCategoriaComunitat(Integer comunitat, String categoria) {
		if (comunitat >= 0 && comunitat < comunitats.size()) {
			return comunitats.get(comunitat).addCat(categoria);
		}
		return false;
	}

	/**
	 * Elimina una categoria d'una comunitat del resultat de la cerca.
	 * 
	 * @param comunitat l'índex de la comunitat a la que se li elimina la categoria
	 * @param categoria la categoria que serà eliminada de la comunitat
	 * @return <code>true</code> si s'ha eliminat la categoria. <code>false</code> si l'índex no és positiu i inferior al nombre de comunitats o si la categoria no pertanyia a la comunitat especificada
	 */
	public Boolean removeCategoriaComunitat(Integer comunitat, String categoria) {
		if (comunitat >= 0 && comunitat < comunitats.size()) {
			return comunitats.get(comunitat).removeCat(categoria);
		}
		return false;
	}
	
	/**
	 * @return el <code>temps</code> dels criteris
	 */
	public Long getTemps() {
		return temps;
	}

	/**
	 * 
	 * @param temps <code>temps</code> dels criteris
	 */
	public void setTemps(Long temps) {
		this.temps = temps;
	}
	
	/**
	 * Assigna a la cerca un nou conjunt de comunitats.
	 * 
	 * @param array el resultat de la cerca
	 */
	public void setComunitats(ArrayList<Comunitat> array) {
		if (array == null) comunitats = new ArrayList<Comunitat>();
		comunitats = array;
	}
	
	/**
	 * Ordena el resultat de la cerca per ordre decreixent en funció del nombre de categories. 
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
