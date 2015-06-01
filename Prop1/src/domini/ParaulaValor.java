package domini;

/**
 * @author Dani
 *
 */

public class ParaulaValor {
	private String paraula;
	private Integer num;
	
	/**
	 * Crea una ParaulaValor amb els par�metres especificats.
	 * 
	 * @param paraula paraula clau
	 * @param num pes establert per la relaci� de la paraula
	 */
	public ParaulaValor(String paraula, Integer num) {
		this.paraula = paraula;
		this.num = num;
	}
	
	/**
	 * Crea una ParaulaValor amb <code>paraula</code> "NoIndicat" i pes 0.
	 */
	public ParaulaValor() {
		paraula = "NoIndicat";
		num = 0;
	}

	/**
	 * @return la <code>paraula</code> de ParaulaValor
	 */
	public String getParaula() {
		return paraula;
	}

	/**
	 * 
	 * @param nom la paraula de ParaulaValor
	 */
	public Boolean setParaula(String nom) {
		paraula = nom;
		return true;
	}

	/**
	 * @return el pes de la relaci� de ParaulaValor
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 
	 * @param num el pes de la relaci� de ParaulaValor
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

}
