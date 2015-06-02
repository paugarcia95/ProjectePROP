package domini;

import java.util.ArrayList;

/**
 * @author Dani
 *
 */

public class Criteris {
	
	private ParaulaValor paraulaClau;
	private Integer relacionsCat, relacionsPag, relacionsSubs, relacionsSuper, semblaNom, algorisme, tipuCerca, dada;
	private ArrayList<String> subconjCat, evitaCat;
	private ArrayList<String> evitaPag;
	private String pare;
	private Long temps;

	/**
	 * Crea un Criteris amb els paràmetres especificats.
	 * 
	 * @param paraula paraula clau
	 * @param relacionsCat pes establert per les relacions entre categories
	 * @param relacionsPag pes establert per les relacions entre pàgines
	 * @param relacionsSubs pes establert per les relacions entre subcategories
	 * @param relacionsSuper pes establert per les relacions entre supercategories
	 * @param sembla pes establert per la relació de semblança del nom
	 * @param alg algorisme amb el que es realitza la cerca. 1 Louvain, 2 GirvanNewman, 3 Clique
	 * @param tipus el tipus d'execució, només és significatiu si <code>alg</code> és 2. 1 Dispersió, 2 Nombre de Categories, 3 MaxBetweenness
	 * @param dada per defecte el % de dispersió, si <code>tipus</code> és 2 el nombre de categories máxim i si és 3 el màxim nombre de camins mínims que pot tenir l'aresta amb més camíns mínims
	 * @param subconj el conjunt de categories sobre el qual s'executa la cerca
	 * @param evitaCat el conjunt de categories sobre les que no es farà la cerca
	 * @param evitaPag el conjunt de pàgines sobre les que no es farà la cerca
	 * @param pare la categoria de la qual només és farà la cerca sobre les seves subcategories
	 * @param temps el temps emprat en fer la cerca
	 */
	public Criteris(ParaulaValor paraula, Integer relacionsCat, Integer relacionsPag, Integer relacionsSubs, Integer relacionsSuper, Integer sembla, Integer alg, Integer tipus, Integer dada, ArrayList<String> subconj, ArrayList<String> evitaCat, ArrayList<String> evitaPag, String pare, Long temps) {
		paraulaClau = paraula;
		this.relacionsCat = relacionsCat;
		this.relacionsPag = relacionsPag;
		this.relacionsSubs = relacionsSubs;
        this.relacionsSuper = relacionsSuper;
		semblaNom = sembla;
		algorisme = alg;
		tipuCerca = tipus;
		this.dada = dada;
		subconjCat = subconj;
		this.evitaCat = evitaCat;
		this.evitaPag = evitaPag;
		this.pare = pare;
		this.temps = temps;
	}
	
	/**
	 * Crea un Criteris amb els valors per defecte.
	 */
	public Criteris() {
		paraulaClau = new ParaulaValor();
		relacionsCat = 5;
		relacionsPag = 5;
		relacionsSubs = 5;
        relacionsSuper = 5;
		semblaNom = 0;
		algorisme = 2;
		dada = 5;
		tipuCerca = 1;
		subconjCat = new ArrayList<String>();
		evitaCat = new ArrayList<String>();
		evitaPag = new ArrayList<String>();
		pare = new String();
		temps = 0l;
	}

	/**
	 * @return la<code>paraulaClau</code> dels criteris
	 */
	public ParaulaValor getParaulaClau() {
		return paraulaClau;
	}
	
	/**
	 * 
	 * @param paraula la paraulaClau dels criteris
	 */
	public void setParaulaClau(ParaulaValor paraula) {
		paraulaClau = paraula;
	}
	
	/**
	 * @return el valor de <code>relacionsCat</code> dels criteris
	 */
	public Integer getRelacionsCat() {
		return relacionsCat;
	}
	
	/**
	 * 
	 * @param relacionsCat el valor de <code>relacionsCat</code> dels criteris
	 */
	public void setRelacionsCat(Integer relacionsCat) {
		this.relacionsCat = relacionsCat;
	}
	
	/**
	 * @return el valor de <code>relacionsPag</code> dels criteris
	 */
	public Integer getRelacionsPag() {
		return relacionsPag;
	}
	
	/**
	 * 
	 * @param relacionsPag el valor de <code>relacionsPag</code> dels criteris
	 */
	public void setRelacionsPag(Integer relacionsPag) {
		this.relacionsPag = relacionsPag;
	}
	
	/**
	 * @return el valor de <code>relacionsSubs</code> dels criteris
	 */
	public Integer getRelacionsSubs() {
		return relacionsSubs;
	}

	/**
	 * 
	 * @param relacionsSubs el valor de <code>relacionsSubs</code> dels criteris
	 */
	public void setRelacionsSubs(Integer relacionsSubs) {
		this.relacionsSubs = relacionsSubs;
	}

	/**
	 * @return el valor de <code>relacionsSuper</code> dels criteris
	 */
	public Integer getRelacionsSuper() {
		return relacionsSuper;
	}

	/**
	 * 
	 * @param relacionsSuper el valor de <code>relacionsSuper</code> dels criteris
	 */
	public void setRelacionsSuper(Integer relacionsSuper) {
		this.relacionsSuper = relacionsSuper;
	}
	
	/**
	 * @return el valor de <code>semblaNom</code> dels criteris
	 */
	public Integer getSemblaNom() {
		return semblaNom;
	}
	
	/**
	 * 
	 * @param sembla el valor de <code>semblaNom</code> dels criteris
	 */
	public void setSemblaNom(Integer sembla) {
		semblaNom = sembla;
	}
	
	/**
	 * @return el valor d'<code>algorisme</code> dels criteris
	 */
	public Integer getAlgorisme() {
		return algorisme;
	}
	
	/**
	 * 
	 * @param alg el valor de <code>algorisme</code> dels criteris
	 */
	public void setAlgorisme(Integer alg) {
		algorisme = alg;
	}
	
	/**
	 * @return el valor de <code>tipuCerca</code> dels criteris
	 */
	public Integer getTipuCerca() {
		return tipuCerca;
	}
	
	/**
	 * 
	 * @param tipus el valor de <code>tipuCerca</code> dels criteris
	 */
	public void setTipuCerca(Integer tipus) {
		tipuCerca = tipus;
	}
	
	/**
	 * @return el valor de <code>dada</code> dels criteris
	 */
	public Integer getDada() {
		return dada;
	}
	
	/**
	 * 
	 * @param dada el valor de <code>dada</code> dels criteris
	 */
	public void setDada(Integer dada) {
		this.dada = dada;
	}
	
	/**
	 * @return el <code>subconjCat</code> dels criteris
	 */
	public ArrayList<String> getSubconjCat() {
		return subconjCat;
	}
	
	/**
	 * 
	 * @param subconj <code>subconjCat</code> dels criteris
	 */
	public void setSubconjCat(ArrayList<String> subconj) {
		subconjCat = subconj;
	}
	
	/**
	 * @return el <code>evitaCat</code> dels criteris
	 */
	public ArrayList<String> getEvitaCat() {
		return evitaCat;
	}
	
	/**
	 * 
	 * @param evita <code>evitaCat</code> dels criteris
	 */
	public void setEvitaCat(ArrayList<String> evita) {
		evitaCat = evita;
	}
	
	/**
	 * @return el <code>evitaPag</code> dels criteris
	 */
	public ArrayList<String> getEvitaPag() {
		return evitaPag;
	}
	
	/**
	 * 
	 * @param evita <code>evitaPag</code> dels criteris
	 */
	public void setEvitaPag(ArrayList<String> evita) {
		evitaPag = evita;
	}
	
	/**
	 * @return el <code>pare</code> dels criteris
	 */
	public String getPare() {
		return pare;
	}
	
	/**
	 * 
	 * @param pare <code>pare</code> dels criteris
	 */
	public void setPare(String pare) {
		this.pare = pare;
	}
	
	/**
	 * @return el <code>temps</code> dels criteris
	 */
	public Long getTemps() {
		return temps;
	}

	/**
	 * 
	 * @param temps <code>temps</code> dels criteris
	 */
	public void setTemps(Long temps) {
		this.temps = temps;
	}
	
}

