package domini;

public class ParaulaValor {
	private String Paraula;
	private int Num;
	
	public ParaulaValor(String paraula, int num) {
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

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

}
