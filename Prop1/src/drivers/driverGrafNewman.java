/**
 * 
 */
package drivers;

import cercaComunitats.GrafNewman;

/**
 * @author Pau
 *
 */
public class driverGrafNewman {

	public static void main(String[] args) {
		GrafNewman G = new GrafNewman();
		G.addNode("A");
		G.addNode("B");
		G.addNode("C");
		G.addNode("D");
		G.addNode("E");
		G.addNode("F");
		G.addNode("G");

		G.addNode("K1");
		G.addNode("K2");
		G.addNode("K3");
		G.addNode("K4");

		G.addAresta("A", "B", 3.0);
		G.addAresta("B", "F", 4.0);
		G.addAresta("F", "G", 5.0);
		G.addAresta("A", "C", 1.0);
		G.addAresta("A", "D", 1.0);
		G.addAresta("C", "E", 2.0);
		G.addAresta("D", "E", 3.0);
		G.addAresta("E", "G", 1.0);
		/*
		 * Queue<Aresta> a = G.camiMin(0, 6); while (!a.isEmpty()) { Aresta b =
		 * a.poll(); System.out.println(b.posi + " " + b.posj); }
		 */
		System.out.println(G.Num_comunitats());
	}
}
