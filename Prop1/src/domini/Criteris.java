package domini;

import java.util.ArrayList;

/**
 * @author Dani
 *
 */

public class Criteris {
	
	private ParaulaValor paraulaClau;
	private Integer relacionsCat, semblaNom, algorisme, tipuCerca, dada;
	private ArrayList<Categoria> subconjCat, evitaCat;
	private ArrayList<Pagina> evitaPag;
	private String pare;
	
	
	
	public Criteris(ParaulaValor paraula, Integer relacions, Integer sembla, Integer alg, Integer tipus, Integer dada, ArrayList<Categoria> subconj, ArrayList<Categoria> evitaCat, ArrayList<Pagina> evitaPag, String pare) {
		paraulaClau = paraula;
		relacionsCat = relacions;
		semblaNom = sembla;
		algorisme = alg;
		tipuCerca = tipus;
		this.dada = dada;
		subconjCat = subconj;
		this.evitaCat = evitaCat;
		this.evitaPag = evitaPag;
		this.pare = pare;
	}
	
	public Criteris() {
		paraulaClau = new ParaulaValor();
		relacionsCat = 5;
		semblaNom = 0;
		algorisme = 2;
		dada = 5;
		tipuCerca = 1;
		subconjCat = new ArrayList<Categoria>();
		evitaCat = new ArrayList<Categoria>();
		evitaPag = new ArrayList<Pagina>();
		pare = new String();
	}

	public ParaulaValor getParaulaClau() {
		return paraulaClau;
	}
	
	public void setParaulaClau(ParaulaValor paraula) {
		paraulaClau = paraula;
	}
	
	public Integer getRelacionsCat() {
		return relacionsCat;
	}
	
	public void setRelacionsCat(Integer relacions) {
		relacionsCat = relacions;
	}
	
	public Integer getSemblaNom() {
		return semblaNom;
	}
	
	public void setSemblaNom(Integer sembla) {
		semblaNom = sembla;
	}
	
	public Integer getAlgorisme() {
		return algorisme;
	}
	
	public void setAlgorisme(Integer alg) {
		algorisme = alg;
	}
	
	public Integer getTipuCerca() {
		return tipuCerca;
	}
	
	public void setTipuCerca(Integer tipus) {
		tipuCerca = tipus;
	}
	
	public Integer getDada() {
		return dada;
	}
	
	public void setDada(Integer dada) {
		this.dada = dada;
	}
	
	public ArrayList<Categoria> getSubconjCat() {
		return subconjCat;
	}
	
	public void setSubconjCat(ArrayList<Categoria> subconj) {
		subconjCat = subconj;
	}
	
	public ArrayList<Categoria> getEvitaCat() {
		return evitaCat;
	}
	
	public void setEvitaCat(ArrayList<Categoria> evita) {
		evitaCat = evita;
	}
	
	public ArrayList<Pagina> getEvitaPag() {
		return evitaPag;
	}
	
	public void setEvitaPag(ArrayList<Pagina> evita) {
		evitaPag = evita;
	}
	
	public String getPare() {
		return pare;
	}
	
	public void setPare(String pare) {
		this.pare = pare;
	}
	
}

