package domini;

/**
 * @author Dani
 *
 */

public class ParaulaValor {
	private String Paraula;
	private Integer Num;
	
	public ParaulaValor(String paraula, Integer num) {
		Paraula = paraula;
		Num = num;
	}

	public String getParaula() {
		return Paraula;
	}

	public boolean setParaula(String nom) {
		Paraula = nom;
		return true;
	}

	public Integer getNum() {
		return Num;
	}

	public void setNum(Integer num) {
		Num = num;
	}

}
