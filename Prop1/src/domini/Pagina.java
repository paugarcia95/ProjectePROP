package domini;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dani
 *
 */

public class Pagina {
	
	private String Nom;
	private Map<String, Categoria> CP, PC; //CP conté les categories que li apunten i el PC les categories a les que apunta
	
	
	public Pagina(String nom, Map<String, Categoria> PC, Map<String, Categoria> CP) {
		Nom = nom;
		this.PC = PC;
		this.CP = CP;
	}
	
	public Pagina() {
		CP = new TreeMap<String, Categoria>();
		PC = new TreeMap<String, Categoria>();
	}
	
	public Pagina(String nom) {
		Nom = nom;
		CP = new TreeMap<String, Categoria>();
		PC = new TreeMap<String, Categoria>();
	}
	
	public String getNom() {
		return Nom;
	}
	
	public void setNom(String nom) {
		Nom = nom;
	}
	
	//Pre: cert
	//Post: retorna 0 si no existeix ni CP ni PC, 1 si és PC i 2 si es CP
	public Integer existsPC(String categoria) {
		if(PC.containsKey(categoria)) return 1;
		if(CP.containsKey(categoria)) return 2;
		return 0;
	}
	
	/*
	//Pre: i < PC.size()
	//Post: retorna la pàgina que hi ha a la posició i
	public Pagina consultarPC(int i) {
		List keys = new ArrayList(PC.keySet()); 
	//MOOOLT INEFICIENT i hauriem d'implementar tots aquests maps com LinkedHashMap 
	//per que els elements conservin els índexs
		return keys.get(i);
	}
	
	No he implementat la resta:
	+ consultar CP(i:int): &Categoria
	
	perque no crec que per índex estiguin bé
	*/
	
	
	//Pre: categoria no pertany a PC
	//Post: categoria pertany a PC
	public Boolean addPC(Categoria categoria) {
		PC.put(categoria.getNom(), categoria);
		return true;
	}	
	
	
	//Pre: categoria no pertany a CP
	//Post: categoria pertany a CP
	public void addCP(Categoria categoria) {
		CP.put(categoria.getNom(), categoria);
	}
	
	//Pre: categoria es una key de PC amb un valor assignat
	//Post: categoria ja no es key de PC
	public Boolean removePC(String categoria) {
		PC.remove(categoria);
		return true;
	}
	
	//Pre: categoria es una key de CP amb un valor assignat
	//Post: categoria ja no es key de CP
	public Boolean removeCP(String categoria) {
		CP.remove(categoria);
		return true;
	}
	
	public Integer getNumPC() {
		return PC.size();
	}
	
	public Integer getNumCP() {
		return CP.size();
	}
	
}
