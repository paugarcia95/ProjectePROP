/**
 * 
 */
package drivers;

import java.util.Scanner;

import cercaComunitats.GrafNewman;

/**
 * @author Pau
 *
 */
public class driverGrafNewman extends GrafNewman {

	public static void main(String[] args) {

		System.out.println("Crea Graf");
		System.out.println("---------");
		System.out.println("");
		System.out.println("Introdueix els nodes (Per indicar que has acabat escriu el caracter  \"#\"");

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		GrafNewman G = new GrafNewman();

		String word = in.next();
		while (!word.equals("#")) {
			G.addNode(word);
			word = in.next();
		}

		System.out.println("");
		System.out.println("Introdueix les Arestes (Per indicar que has acabat escriu el caracter \"#\"");
		System.out.println("Format d'entrada: node1 node2 pes");

		word = in.next();
		while (!word.equals("#")) {
			String word2 = in.next();
			Double pes = in.nextDouble();
			G.addAresta(word, word2, pes);
			word = in.next();
		}

		System.out.println("");
		System.out.println("Quina funció vol provar?");
		System.out.println("1. Queue<Aresta> camiMin(int nodeA, int nodeB)");
		System.out.println("2. Integer getMaxBet()");
		System.out.println("3. Boolean Calculate_edge_between()");
		System.out.println("4. Boolean Invertir_pesos()");
		System.out.println("5. Boolean esborrar_maxim()");
		System.out.println("6. Integer numComunitats()");
		System.out.println("7. HashSet<HashSet<String>> comunitats()");

		switch (in.nextInt()) {
			case 1 :
				System.out.println(G.getCamiMinim(in.nextInt(), in.nextInt()));
				break;
			case 2 :
				System.out.println(G.getMaxBetween());
				break;
			case 3 :
				System.out.println(G.calcularEdgeBetween());
				break;
			case 4 :
				System.out.println(G.invertirPesos());
				break;
			case 5 :
				System.out.println(G.invertirPesos());
				break;
			case 6 :
				System.out.println(G.numComunitats());
				break;
			case 7 :
				System.out.println(G.comunitats());
				break;
		}
		System.out.println(G.getNodes());
	}
}
