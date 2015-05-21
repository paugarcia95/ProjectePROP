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
	 * Pre: dataCreacio < dataModif, usuari existeix, no existeix cap CercaComunitats amb el mateix nom per a usuari
	 * Post: Retorna una CercaComunitats
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
	
	public CercaComunitats(String nom) {
		this.nom = nom;
		dataCreacio = new Date();
		comunitats = new ArrayList<Comunitat>();
	}
	
	public CercaComunitats() {
		dataCreacio = new Date();
		comunitats = new ArrayList<Comunitat>();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String s) {
		nom = s;
	}
	
	public Date getDataCreacio() {
		return dataCreacio;
	}
	
	public void setDataCreacio(Date d) {
		dataCreacio = d;
	}
	
	public Criteris getCriterisSeleccio() {
		return criterisSeleccio;
	}
	
	public void setCriterisSeleccio(Criteris c) {
		criterisSeleccio = c;
	}
	
	public String getComentari() {
		return comentari;
	}
	
	public void setComentari(String s) {
		comentari = s;
	}
	
	public String getUsuari() {
		return usuari;
	}	
	
	public void setUsuari(String s) {
		usuari = s;
	}
	
	public Date getDataModificacio() {
		return dataModificacio;
	}
	
	public void setDataModificacio(Date d) {
		dataModificacio = d;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna la Comunitat amb �ndex i
	 */	 
	public Comunitat getComunitat(Integer i) {
		if (i >= 0 && i < comunitats.size()) return comunitats.get(i);
		return null;
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de comunitats que componen la cerca i les ordena per nombre de categories
	 */
	public Integer getNumComunitats() {
		Collections.sort(comunitats, new CustomComparator());
		return comunitats.size();
	}	
	
	/**
	 * Pre: comunitat no pertany a comunitats
	 * Post: comunitat pertanty a comunitats amb �ndex retornat
	 */
	public Integer addComunitat(Comunitat comunitat) {
		comunitats.add(comunitat);
		return comunitats.size() - 1;
	}
	
	/** 
	 * Pre: i es l'�ndex d'una Comunitat existent a comunitats && i < comunitas.size()
	 * Post: La Comunitat amb �ndex i ja no pertany a comunitats && nComunitats es decrementada
	 */
	public Boolean removeComunitat(Integer i) {
		if (i >= 0 && i < comunitats.size()) {
			comunitats.remove(i);
			return true;
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
	
	
	private class CustomComparator implements Comparator<Comunitat> {
		@Override
		public int compare(Comunitat c1, Comunitat c2) {
			return c1.getNumeroDeCategories()-c2.getNumeroDeCategories(); //crec que s'ha d'invertir per ordenar descendentment
		}
	}
	
}
