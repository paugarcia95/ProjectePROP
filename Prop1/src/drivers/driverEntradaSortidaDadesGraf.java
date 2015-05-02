package drivers;

import java.io.FileNotFoundException;
import java.io.IOException;

import domini.EntradaSortidaDadesGraf;
import domini.GrafDades;

public class driverEntradaSortidaDadesGraf {

	public static void main(String[] args) {
		EntradaSortidaDadesGraf obj = new EntradaSortidaDadesGraf();
		GrafDades G = new GrafDades();
		try {
			G = obj.loadGraph("C:/Users/Pau/Downloads/inp.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			obj.printGrafAsText(G, "C:/Users/Pau/Downloads/hh.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
