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
	
	private String Nom, Comentari, Usuari;
	private Date DataCreacio, DataModificacio;
	private Criteris CriterisSeleccio;
	private Integer Algorisme, nComunitats;
	private ArrayList<Comunitat> Comunitats;
	private Queue<Integer> eliminats;
	
	//Pre: dataCreacio < data_modif, usuari existeix, ¿¿no existeix cap CercaComunitats amb el mateix nom??
	//Post: retorna una CercaComunitats amb...
	public CercaComunitats(String nom, Date dataCreacio, Criteris criteris, String usuari, Date dataModif, Integer algorisme, String comentari, ArrayList<Comunitat> Comunitats) {
		Nom = nom;
		DataCreacio = dataCreacio;
		CriterisSeleccio = criteris;
		Usuari = usuari;
		DataModificacio = dataModif; //hauriem de decidir si posem una data nul·la o com s'implementa
		Algorisme = algorisme;
		Comentari = comentari;
		nComunitats = 0;
		this.Comunitats = Comunitats;
		eliminats = new LinkedList<Integer>();
	}
	
	public CercaComunitats() {
		DataCreacio = new Date();
	}
	
	public String getNom() {
		return Nom;
	}
	
	public void setNom(String s) {
		Nom = s;
	}
	
	public Date getDataCreacio() {
		return DataCreacio;
	}
	
	public void setDataCreacio(Date d) {
		DataCreacio = d;
	}
	
	public Criteris getCriterisSeleccio() {
		return CriterisSeleccio;
	}
	
	public void setCriterisSeleccio(Criteris c) {
		CriterisSeleccio = c;
	}
	
	public String getComentari() {
		return Comentari;
	}
	
	public void setComentari(String s) {
		Comentari = s;
	}
	
	public String getUsuari() {
		return Usuari;
	}	
	
	public void setUsuari(String s) {
		Usuari = s;
	}
	
	public Date getDataModificacio() {
		return DataModificacio;
	}
	
	public void setDataModificacio(Date d) {
		DataModificacio = d;
	}
	
	public Integer getAlgorisme() {
		return Algorisme;
	}
	
	public void setAlgorisme(Integer i) {
		Algorisme = i;
	}
	
	//Pre: i es l'index d'una comunitat existent a Comunitats && i < Comunitas.size()
	//Post: es retorna la comunitat amb index i
	public Comunitat getComunitat(Integer i) {
		return Comunitats.get(i);		
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de comunitats que componen la cerca
	public Integer getNumComunitats() {
		return nComunitats;
	}	
	
	//Pre: comunitat no pertany a Comunitats
	//Post: comunitat pertanty a Comunitats amb index retornat && nComunitats s'incrementa
	public Integer addComunitat(Comunitat comunitat) {
		int i;
		if(eliminats.isEmpty()) {
			i = nComunitats;
			if (i == Comunitats.size()) { //sempre que eliminats.isEmpty s'ha de complir això
				Comunitats.add(i, comunitat);
				++nComunitats;
				return i;
			}
		}
		else {
			i = eliminats.poll(); //primer index buit
		}
		Comunitats.set(i, comunitat);
		++nComunitats;
		return i;
	}
	
	//Pre: i es l'index d'una comunitat existent a Comunitats && i < Comunitas.size()
	//Post: la comunitat amb index i ja no pertany a aquesta cerca && nComunitats es decrementada
	public Boolean removeComunitat(Integer i) {
		Comunitats.set(i,null);
		eliminats.add(i);
		--nComunitats;
		return true;
	}
	
}
