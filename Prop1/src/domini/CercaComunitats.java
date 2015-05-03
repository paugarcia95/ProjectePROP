package domini;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dani
 *
 */

public class CercaComunitats {
	
	private String nom, comentari, usuari;
	private Date dataCreacio, dataModificacio;
	private Criteris criterisSeleccio;
	private Integer algorisme, nComunitats;
	private ArrayList<Comunitat> comunitats;
	private Queue<Integer> eliminats;
	
	/**
	 * Pre: dataCreacio < dataModif, usuari existeix, no existeix cap CercaComunitats amb el mateix nom per a usuari
	 * Post: Retorna una CercaComunitats
	 */
	public CercaComunitats(String nom, Date dataCreacio, Criteris criteris, String usuari, Date dataModif, Integer algorisme, String comentari, ArrayList<Comunitat> comunitats) {
		this.nom = nom;
		this.dataCreacio = dataCreacio;
		this.criterisSeleccio = criteris;
		this.usuari = usuari;
		dataModificacio = dataModif;
		this.algorisme = algorisme;
		this.comentari = comentari;
		nComunitats = comunitats.size();
		this.comunitats = comunitats;
		eliminats = new LinkedList<Integer>();
	}
	
	public CercaComunitats(String nom) {
		this.nom = nom;
		dataCreacio = new Date();
		nComunitats = 0;
		comunitats = new ArrayList<Comunitat>();
		eliminats = new LinkedList<Integer>();
	}
	
	public CercaComunitats() {
		dataCreacio = new Date();
		nComunitats = 0;
		comunitats = new ArrayList<Comunitat>();
		eliminats = new LinkedList<Integer>();
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
	
	public Integer getAlgorisme() {
		return algorisme;
	}
	
	public void setAlgorisme(Integer i) {
		algorisme = i;
	}
	
	/**
	 * Pre: i es l'índex d'una Comunitat existent a comunitats && i < comunitas.size()
	 * Post: Retorna la Comunitat amb índex i
	 */	 
	public Comunitat getComunitat(Integer i) {
		return comunitats.get(i);		
	}
	
	/**
	 * Pre: Cert
	 * Post: Retorna el nombre de comunitats que componen la cerca
	 */
	public Integer getNumComunitats() {
		return nComunitats;
	}	
	
	/**
	 * Pre: comunitat no pertany a comunitats
	 * Post: comunitat pertanty a comunitats amb índex retornat && nComunitats s'incrementa
	 */
	public Integer addComunitat(Comunitat comunitat) {
		int i;
		if(eliminats.isEmpty()) {
			i = nComunitats;
			if (i == comunitats.size()) { //sempre que eliminats.isEmpty s'ha de complir això
				comunitats.add(i, comunitat);
				++nComunitats;
				return i;
			}
		}
		else {
			i = eliminats.poll(); //primer index buit
		}
		comunitats.set(i, comunitat);
		++nComunitats;
		return i;
	}
	
	/** 
	 * Pre: i es l'índex d'una Comunitat existent a comunitats && i < comunitas.size()
	 * Post: La Comunitat amb índex i ja no pertany a comunitats && nComunitats es decrementada
	 */
	public Boolean removeComunitat(Integer i) {
		comunitats.set(i,null);
		eliminats.add(i);
		--nComunitats;
		return true;
	}
	
	/**
	 * Pre: Cert
	 * Post: comunitats = array i nComunitats = array.size()
	 */
	public void setComunitats(ArrayList<Comunitat> array) {
		nComunitats = array.size();
		this.comunitats = array;
	}
	
}
