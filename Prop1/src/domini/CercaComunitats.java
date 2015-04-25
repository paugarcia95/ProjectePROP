package domini;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class CercaComunitats {
	
	private String Nom, Comentari, Usuari;
	private Date DataCreacio, Data_Modificacio;
	private Criteris Criteris_seleccio;
	private Integer Algorisme, nComunitats;
	private ArrayList<Comunitat> Comunitats;
	private Queue<Integer> eliminats;
	
	//Pre: dataCreacio < data_modif, usuari existeix, ¿¿no existeix cap CercaComunitats amb el mateix nom??
	//Post: retorna una CercaComunitats amb...
	public CercaComunitats(String nom, Date dataCreacio, Criteris criteris, String usuari, Date data_modif, Integer algorisme, String comentari, ArrayList<Comunitat> Comunitats) {
		Nom = nom;
		DataCreacio = dataCreacio;
		Criteris_seleccio = criteris;
		Usuari = usuari;
		Data_Modificacio = data_modif; //hauriem de decidir si posem una data nul·la o com s'implementa
		Algorisme = algorisme;
		Comentari = comentari;
		nComunitats = Integer.valueOf(0);
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
	
	public Criteris getCriteris_seleccio() {
		return Criteris_seleccio;
	}
	
	public void setCriteris_seleccio(Criteris c) {
		Criteris_seleccio = c;
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
	
	public Date getData_modificacio() {
		return Data_Modificacio;
	}
	
	public void setData_modificacio(Date d) {
		Data_Modificacio = d;
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
		return Comunitats.get(i.intValue());		
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de comunitats que componen la cerca
	public Integer getNumComunitats() {
		return nComunitats;
	}	
	
	//Pre: comunitat no pertany a Comunitats
	//Post: comunitat pertanty a Comunitats amb index retornat && nComunitats s'incrementa
	public Integer addComunitat(Comunitat comunitat) {
		Integer i;
		if(eliminats.isEmpty()) {
			if (nComunitats.intValue() == Comunitats.size()) {
				Comunitats.ensureCapacity(nComunitats.intValue()+5);
			}
			i = nComunitats;
		}
		else {
			i = eliminats.poll(); //primer index buit
		}
		Comunitats.set(i.intValue(), comunitat);
		nComunitats = Integer.valueOf(nComunitats.intValue()+1);
		return i;
	}
	
	//Pre: i es l'index d'una comunitat existent a Comunitats && i < Comunitas.size()
	//Post: la comunitat amb index i ja no pertany a aquesta cerca && nComunitats es decrementada
	public Boolean removeComunitat(Integer i) {
		Comunitats.set(i.intValue(),null);
		eliminats.add(i);
		nComunitats = Integer.valueOf(nComunitats.intValue()-1);
		return Boolean.valueOf(true);
	}
	
}
