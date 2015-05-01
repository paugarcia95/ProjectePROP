package domini;

import java.util.ArrayList;

/**
 * @author Dani
 *
 */

public class Criteris {
	
	private ParaulaValor paraulaClau;
	private Integer relacionsCat, semblaNom, algorisme, tipuCerca;
	private ArrayList<Categoria> subconjCat, evitaCat;
	private String pare;
	
	
	
	public Criteris(ParaulaValor paraula, Integer relacions, Integer sembla, Integer alg, Integer tipus, ArrayList<Categoria> subconj, ArrayList<Categoria> evita, String pare) {
		paraulaClau = paraula;
		relacionsCat = relacions;
		semblaNom = sembla;
		algorisme = alg;
		tipuCerca = tipus;
		subconjCat = subconj;
		evitaCat = evita;
		this.pare = pare;
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
	
	public Integer getSemblNom() {
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
	
	public String getPare() {
		return pare;
	}
	
	public void setPare(String pare) {
		this.pare = pare;
	}
	
}

