package drivers;

import java.util.Scanner;

import domini.EntradaSortidaDadesGraf;
import domini.GrafDades;

/**
 * @author Pau
 *
 */

public class driverEntradaSortidaDadesGraf {

	private static Scanner in;

	public static GrafDades creaGraf(EntradaSortidaDadesGraf io) {
		GrafDades G = new GrafDades();

		System.out.println("Crea Graf");
		System.out.println("---------");
		System.out.println("");

		System.out.println("Introdueix les Arestes (Per indicar que has acabat escriu el caracter \"#\"");
		System.out.println("Format d'entrada: node1 tipusEnllaç node2");

		while (io.entrarUnaDada(G, true));
		return G;
	}

	public static GrafDades llegirFitxer(EntradaSortidaDadesGraf io) {
		in = new Scanner(System.in);
		System.out.println("Llegir Graf");
		System.out.println("---------");
		System.out.println("");
		System.out.println("Vols utilitzar la ruta per defecte? (s/n)");
		String rutaPerDefecte = in.next();
		String ruta = null;
		GrafDades G = new GrafDades();

		if (rutaPerDefecte.equals("n")) {
			System.out.println("Escriu la ruta on vols llegir el graf");
			ruta = in.next();
		}
		return io.carregarGrafDades((rutaPerDefecte.equals("s")), G, ruta);
	}
	// C:/Users/Pau/Desktop/cats.txt
	public static void escriureGraf(EntradaSortidaDadesGraf io, GrafDades G) {
		in = new Scanner(System.in);
		System.out.println("Escriure Graf");
		System.out.println("---------");
		System.out.println("");
		System.out.println("Vols utilitzar la ruta per defecte? (s/n)");
		String rutaPerDefecte = in.next();
		String ruta = null;

		if (rutaPerDefecte.equals("n")) {
			System.out.println("Escriu la ruta on vols escriure el graf");
			ruta = in.next();
		}
		io.escriureGrafDadesEnFitxer((rutaPerDefecte.equals("s")), G, ruta);
	}

	public static void main(String[] args) {

		while (true) {
			System.out.println("");
			System.out.println("Quina funció vol provar?");
			System.out.println("1. Llegir des d'un fitxer i escriure graf a un fitxer de text");
			System.out.println("2. Llegir les entrades del graf una a una i escriure'l a un fitxer");
			System.out.println("3. Llegir des d'un fitxer i escriure la representació en imatge del graf (cal haver especificat una ruta per defecte per guardar el graf auxiliar)");
			System.out.println("4. Llegir les entrades del graf una a una i escriure'n la seva representació gràfica (cal haver especificat una ruta per defecte per guardar el graf auxiliar)");
			System.out.println("5. Definir ruta per defecte");
			System.out.println("6. Sortir");

			EntradaSortidaDadesGraf io = new EntradaSortidaDadesGraf();
			in = new Scanner(System.in);
			switch (in.nextInt()) {
				case 1 :
					GrafDades G = llegirFitxer(io);
					escriureGraf(io, G);
					break;
				case 2 :
					GrafDades G2 = creaGraf(io);
					escriureGraf(io, G2);
					break;
				case 3 :
					GrafDades G3 = llegirFitxer(io);
					if (io.getRutaPerDefecte() == null)
						break;
					io.escriureGrafDadesEnFitxer(false, G3, io.getRutaPerDefecte());
					System.out.println("Escriu la ruta de destí");
					io.traduirGrafDadesAImatge(in.next(), in.next());
					break;
				case 4 :
					GrafDades G4 = creaGraf(io);
					if (io.getRutaPerDefecte() == null)
						break;
					io.escriureGrafDadesEnFitxer(false, G4, io.getRutaPerDefecte());
					System.out.println("Escriu la ruta de destí");
					io.traduirGrafDadesAImatge(in.next(), in.next());
					break;
				case 5 :
					io.setRutaPerDefecte(in.next());
					break;
				default :
					return;
			}
		}
	}
}
