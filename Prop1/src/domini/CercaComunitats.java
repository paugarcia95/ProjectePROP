package domini;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class CercaComunitats {
	
	//COMENTARI
	
	private String Nom, Comentari, Usuari;
	private Date DataCreacio, Data_Modificacio;
	private Criteris Criteris_seleccio;
	private int Algorisme, nComunitats;
	private ArrayList<Comunitat> Comunitats;
	private Queue<Integer> eliminats;
	
	//Pre: dataCreacio < data_modif, usuari existeix, ¿¿no existeix cap CercaComunitats amb el mateix nom??
	//Post: retorna una CercaComunitats amb...
	public CercaComunitats(String nom, Date dataCreacio, Criteris criteris, String usuari, Date data_modif, int algorisme, String comentari, ArrayList<Comunitat> Comunitats) {
		Nom = nom;
		DataCreacio = dataCreacio;
		Criteris_seleccio = criteris;
		Usuari = usuari;
		Data_Modificacio = data_modif; //hauriem de decidir si posem una data nul·la o com s'implementa
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
	
	public int getAlgorisme() {
		return Algorisme;
	}
	
	public void setAlgorisme(int i) {
		Algorisme = i;
	}
	
	//Pre: i es l'index d'una comunitat existent a Comunitats && i < Comunitas.size()
	//Post: es retorna la comunitat amb index i
	public Comunitat getComunitat(int i) {
		return Comunitats.get(i);		
	}
	
	//Pre: Cert
	//Post: Retorna el nombre de comunitats que componen la cerca
	public int getNumComunitats() {
		return nComunitats;
	}	
	
	//Pre: comunitat no pertany a Comunitats
	//Post: comunitat pertanty a Comunitats amb index retornat && nComunitats s'incrementa
	public int addComunitat(Comunitat comunitat) {
		int i;
		if(eliminats.isEmpty()) {
			if (nComunitats == Comunitats.size()) {
				Comunitats.ensureCapacity(nComunitats+5);
			}
			i = nComunitats;
		}
		else {
			i = eliminats.poll().intValue(); //primer index buit
		}
		Comunitats.set(i, comunitat);
		++nComunitats;
		return i;
	}
	
	//Pre: i es l'index d'una comunitat existent a Comunitats && i < Comunitas.size()
	//Post: la comunitat amb index i ja no pertany a aquesta cerca && nComunitats es decrementada
	public boolean removeComunitat(int i) {
		Comunitats.set(i,null);
		eliminats.add(new Integer(i));
		--nComunitats;
		return true;
	}
	
	
	
}
