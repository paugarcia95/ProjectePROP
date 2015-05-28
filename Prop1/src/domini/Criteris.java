package domini;

import java.util.ArrayList;

/**
 * @author Dani
 *
 */

public class Criteris {
	
	private ParaulaValor paraulaClau;
	private Integer relacionsCat, relacionsSubs, relacionsSuper, semblaNom, algorisme, tipuCerca, dada;
	private ArrayList<String> subconjCat, evitaCat;
	private ArrayList<String> evitaPag;
	private String pare;
	
	
	
	public Criteris(ParaulaValor paraula, Integer relacions, Integer sembla, Integer alg, Integer tipus, Integer dada, ArrayList<String> subconj, ArrayList<String> evitaCat, ArrayList<String> evitaPag, String pare,Integer relacionsSubs,Integer relacionsSuper) {
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
                this.relacionsSubs = relacionsSubs;
                this.relacionsSuper = relacionsSuper;
	}
	
	public Criteris() {
		paraulaClau = new ParaulaValor();
		relacionsCat = 5;
		semblaNom = 0;
		algorisme = 2;
		dada = 5;
		tipuCerca = 1;
                relacionsSubs = 5;
                relacionsSuper = 5;
		subconjCat = new ArrayList<String>();
		evitaCat = new ArrayList<String>();
		evitaPag = new ArrayList<String>();
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
	
	public Integer getRelacionsSubs() {
		return relacionsSubs;
	}

	public void setRelacionsSubs(Integer relacionsSubs) {
		this.relacionsSubs = relacionsSubs;
	}

	public Integer getRelacionsSuper() {
		return relacionsSuper;
	}

	public void setRelacionsSuper(Integer relacionsSuper) {
		this.relacionsSuper = relacionsSuper;
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
	
	public ArrayList<String> getSubconjCat() {
		return subconjCat;
	}
	
	public void setSubconjCat(ArrayList<String> subconj) {
		subconjCat = subconj;
	}
	
	public ArrayList<String> getEvitaCat() {
		return evitaCat;
	}
	
	public void setEvitaCat(ArrayList<String> evita) {
		evitaCat = evita;
	}
	
	public ArrayList<String> getEvitaPag() {
		return evitaPag;
	}
	
	public void setEvitaPag(ArrayList<String> evita) {
		evitaPag = evita;
	}
	
	public String getPare() {
		return pare;
	}
	
	public void setPare(String pare) {
		this.pare = pare;
	}
	
}

