package domini;

import java.util.ArrayList;

public class Criteris {
	
	private ParaulaValor paraula_clau;
	private int relacions_cat, sembla_nom, algorisme, tipu_cerca;
	private ArrayList<Categoria> subconj_cat, evita_cat;
	private String pare;
	
	
	
	public Criteris(ParaulaValor paraula_clau, int relacions_cat, int sembla_nom, int algorisme, int tipu_cerca, ArrayList<Categoria> subconj_cat, ArrayList<Categoria> evita_cat, String pare) {
		this.paraula_clau = paraula_clau;
		this.relacions_cat = relacions_cat;
		this.sembla_nom = sembla_nom;
		this.algorisme = algorisme;
		this.tipu_cerca = tipu_cerca;
		this.subconj_cat = subconj_cat;
		this.evita_cat = evita_cat;
		this.pare = pare;
	}

	public ParaulaValor getParaula_clau() {
		return paraula_clau;
	}
	
	public void setParaula_clau(ParaulaValor paraula_clau) {
		this.paraula_clau = paraula_clau;
	}
	
	public int getRelacions_cat() {
		return relacions_cat;
	}
	
	public void setRelacions_cat(int relacions_cat) {
		this.relacions_cat = relacions_cat;
	}
	
	public int getSembla_nom() {
		return sembla_nom;
	}
	
	public void setSembla_nom(int sembla_nom) {
		this.sembla_nom = sembla_nom;
	}
	
	public int getAlgorisme() {
		return algorisme;
	}
	
	public void setAlgorisme(int algorisme) {
		this.algorisme = algorisme;
	}
	
	public int getTipu_cerca() {
		return tipu_cerca;
	}
	
	public void setTipu_cerca(int tipu_cerca) {
		this.tipu_cerca = tipu_cerca;
	}
	
	public ArrayList<Categoria> getSubconj_cat() {
		return subconj_cat;
	}
	
	public void setSubconj_cat(ArrayList<Categoria> subconj_cat) {
		this.subconj_cat = subconj_cat;
	}
	
	public ArrayList<Categoria> getEvita_cat() {
		return evita_cat;
	}
	
	public void setEvita_cat(ArrayList<Categoria> evita_cat) {
		this.evita_cat = evita_cat;
	}
	
	public String getPare() {
		return pare;
	}
	
	public void setPare(String pare) {
		this.pare = pare;
	}
	
}

