package domini;

/**
 * @author Dani
 *
 */

public class ParaulaValor {
	private String paraula;
	private Integer num;
	
	public ParaulaValor(String paraula, Integer num) {
		this.paraula = paraula;
		this.num = num;
	}
	
	public ParaulaValor() {
		paraula = "NoIndicat";
		num = 0;
	}

	public String getParaula() {
		return paraula;
	}

	public Boolean setParaula(String nom) {
		paraula = nom;
		return true;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
