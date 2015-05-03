package drivers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import domini.EntradaSortidaDadesGraf;
import domini.GrafDades;

/**
 * @author Pau
 *
 */

public class driverEntradaSortidaDadesGraf {

	public static GrafDades creaGraf() {
		Scanner in = new Scanner(System.in);
		GrafDades G = new GrafDades();
		EntradaSortidaDadesGraf obj = new EntradaSortidaDadesGraf();

		System.out.println("Crea Graf");
		System.out.println("---------");
		System.out.println("");

		System.out.println("");
		System.out.println("Introdueix les Arestes (Per indicar que has acabat escriu el caracter \"#\"");
		System.out.println("Format d'entrada: node1 tipusEnlla� node2");

		String node1 = in.next();
		while (obj.entrarUnaDada(G, true));
		return G;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println("");
		 * System.out.println("Quina funci� vol provar?");
		 * System.out.println("1. Queue<Aresta> camiMin(int nodeA, int nodeB)");
		 * System.out.println("2. Integer getMaxBet()");
		 * System.out.println("3. Boolean Calculate_edge_between()");
		 * System.out.println("4. Boolean Invertir_pesos()");
		 * System.out.println("5. Boolean esborrar_maxim()");
		 * System.out.println("6. Integer numComunitats()");
		 * System.out.println("7. HashSet<HashSet<String>> comunitats()");
		 * 
		 * Scanner in = new Scanner(System.in); switch (in.nextInt()) { case 1 :
		 * GrafDades G = creaGraf(); (new
		 * EntradaSortidaDadesGraf()).escriureGrafDadesEnFitxer(G,
		 * "C:/Users/Pau/Downloads/ENTRADA.txt"); break; case 2 :
		 * System.out.println(); break; case 3 : System.out.println(); break;
		 * case 4 : System.out.println(); break; case 5 : System.out.println();
		 * break; case 6 : System.out.println(); break; case 7 :
		 * System.out.println(); break; } System.out.println();
		 */

		EntradaSortidaDadesGraf obj = new EntradaSortidaDadesGraf();
		GrafDades G = new GrafDades();
		try {
			G = obj.carregarGrafDades(true, G, "C:/Users/Pau/Downloads/inp.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		obj.escriureGrafDadesEnFitxer(G, "C:/Users/Pau/Downloads/out.txt");
	}
}
