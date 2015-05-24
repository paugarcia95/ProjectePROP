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
	 * Post: Retorna la Comunitat amb índex i
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
			int aux = i;
			comunitats.remove(aux); // el compilador no feia unboxing i no eliminava l'item amb index i
			return true;
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: categoria pertanty a la Comunitat amb índex comunitat i retorna true, retorna false altrament
	 */
	public Boolean addCategoriaComunitat(Integer comunitat, String categoria) {
		if (comunitat >= 0 && comunitat < comunitats.size()) {
			return comunitats.get(comunitat).addCat(categoria);
		}
		return false;
	}
	
	/**
	 * Pre: Cert
	 * Post: categoria no pertany a la Comunitat amb índex comunitat i retorna true, retorna false altrament
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
