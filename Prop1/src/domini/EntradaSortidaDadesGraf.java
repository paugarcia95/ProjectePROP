package domini;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Pau
 *
 */

public class EntradaSortidaDadesGraf {

	/**
	 * Creadora per defecte. La ruta per defecte d'inicialitza a null.
	 * 
	 */
	public EntradaSortidaDadesGraf() {
		super();
	}


	/**
	 * Carrega les dades d'un fitxer de text a un graf.
	 * 
	 * S'afegeixen a G els nodes i/o arestes indicats pel fitxer de text a
	 * "ruta"
	 * 
	 * @param G
	 *            S'afegeixen a aquest graf els nous nodes i arestes
	 * @param ruta
	 *            Adre�a on es troba el fitxer de text
	 * @return Un GrafDades amb les dades de "ruta"
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public GrafDades carregarGrafDades(String ruta) throws FileNotFoundException, IOException {
		GrafDades G = new GrafDades();
		BufferedReader b = new BufferedReader(new FileReader(ruta));
		String s;

		while ((s = b.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);

			while (st.hasMoreTokens() && st.countTokens() >= 4) {
				String word1 = st.nextToken();
				st.nextToken();
				String link = st.nextToken();
				String word2 = st.nextToken();
				st.nextToken();

				if (link.equals("CsubC"))
					G.addCC(word1, word2);
				else if (link.equals("CsupC"))
					G.addCC(word2, word1);
				else if (link.equals("CP"))
					G.addCP(word1, word2);
				else if (link.equals("PC"))
					G.addPC(word1, word2);
				else
					System.out.println("Error al crear el graf: Comprova la sintaxi de l'entrada");
			}
		}
		b.close();
		return G;
	}

	/**
	 * Guarda la configuraci� del graf G a un fitxer de text a "ruta".
	 * 
	 * @param G
	 *            Indica el graf de dades que es vol emmagatzemar
	 * @param ruta
	 *            Indica la ruta de directoris i el fitxer on es vol guardar el
	 *            graf
	 */
	public void escriureGrafDadesEnFitxer(GrafDades G, String ruta) {
		FileWriter fichEscr = null;
		PrintWriter docE = null;

		try {
			// Arxiu d'escriptura
			fichEscr = new FileWriter(ruta);
			docE = new PrintWriter(fichEscr);

			Iterator<Categoria> it = G.getCategories().iterator();

			while (it.hasNext()) {
				Categoria c = it.next();
				String c1 = c.getNom();

				Iterator<Pagina> CP = c.getMapCP().values().iterator();
				Iterator<Pagina> PC = c.getMapPC().values().iterator();
				Iterator<Categoria> CsupC = c.getMapCSupC().values().iterator();
				// Iterator<Categoria> CsubC = c.getMapCSubC().values().iterator();
				// Aquest �ltim no cal ja que nom�s amb els enlla�os CsupC ja es
				// pot representar tot el graf

				while (CP.hasNext()) {
					Pagina p = CP.next();
					docE.println(c1 + " cat CP " + p.getNom() + " pag");
				}

				while (PC.hasNext()) {
					Pagina p = PC.next();
					docE.println(p.getNom() + " pag PC " + c1 + " cat");
				}

				while (CsupC.hasNext()) {
					Categoria c2 = CsupC.next();
					docE.println(c1 + " cat CsupC " + c2.getNom() + " cat");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error a l'escriure a l'arxiu");
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				System.out.println(e2);
				System.out.println("Error al tancar l'arxiu");
			}
		}
	}

	/**
	 * Tradueix un fitxer de dades d'un graf a un fitxer que permet al programa
	 * DOT representar graficament un graf. El programa DOT nom�s funciona
	 * correctament si el graf t� menys de 100 nodes aproximadament.
	 * 
	 * @param rutaGraf
	 *            Ruta de directoris que indica on es troba el fitxer amb les
	 *            dades del graf.
	 * @param rutaImatgeTXT
	 *            La ruta de l'arxiu de text de dest�.
	 */
	public void traduirGrafDadesAImatge(String rutaGraf, String rutaImatgeTXT) {
		String s;

		FileWriter fichEscr = null;
		PrintWriter docE = null;

		FileReader fichLect = null;
		BufferedReader docL = null;

		try {
			// Arxiu de lectura
			fichLect = new FileReader(rutaGraf);
			docL = new BufferedReader(fichLect);

			// Arxiu d'escriptura
			fichEscr = new FileWriter(rutaImatgeTXT);
			docE = new PrintWriter(fichEscr);

			docE.println("digraph Graf {");

			while ((s = docL.readLine()) != null) {

				StringTokenizer st = new StringTokenizer(s);

				while (st.hasMoreTokens() && st.countTokens() >= 4) {
					String word1 = st.nextToken();
					String type1 = st.nextToken();
					String link = st.nextToken();
					String word2 = st.nextToken();
					String type2 = st.nextToken();

					word1 = word1.replaceAll("[^a-zA-Z]", "_");
					// Aixo fa que elimini tots els caracters que no siguin
					// lletres o barra_baixes
					word2 = word2.replaceAll("[^a-zA-Z]", "_");
					// Perque sino el programa de dibuixar grafs no funciona

					if (link.equals("CsubC") || link.equals("CP") || link.equals("PC"))
						docE.println(word1 + " -> " + word2);
					else if (link.equals("CsupC")) {
						docE.println(word2 + " -> " + word1);
					} else {
						System.out.println("Error al crear el graf: Comprova la sintaxi de l'entrada");
						docE.close();
						docL.close();
						return;
					}

					if (type1.equals("page"))
						docE.println(word1 + " [shape=box]");
					if (type2.equals("page"))
						docE.println(word2 + " [shape=box]");
				}
			}
			docE.println("}");

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error: no s'ha trobat el fitxer o no s'hi pot escriure");
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				System.out.println(e2);
				System.out.println("Error: no es pot tancar el fitxer d'escriptura");
			}
			try {
				if (null != docL)
					docL.close();
			} catch (Exception e2) {
				System.out.println(e2);
				System.out.println("Error: no es pot tancar el fitxer de lectura");
			}
		}
	}

	/**
	 * Llegeix del canal standard d'entrada una aresta (en format: node1
	 * tipusEnlla� node2) i l'afegeix a G.
	 * 
	 * @param G
	 *            El graf al que es vol afegir una Aresta.
	 * @param OK
	 *            Indica si la dada s'ha inserit correctament al graf G
	 * @return Retorna true si l'usuari no ha indicat el final de l'entrada;
	 *         false en cas contrari
	 */
	public Boolean entrarUnaDada(GrafDades G, Boolean OK) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		OK = true;

		String element1 = "#";
		if (in.hasNext())
			element1 = in.next();

		if (element1.equals("#")) {
			OK = false;
			return false;
		}

		String link = null;
		if (in.hasNext())
			link = in.next();
		String element2 = null;
		if (in.hasNext())
			element2 = in.next();

		if (link.equals("CP"))
			OK = G.addCP(element1, element2);
		else if (link.equals("PC"))
			OK = G.addPC(element1, element2);
		else if (link.equals("CsubC"))
			OK = G.addCC(element1, element2);
		else if (link.equals("CsupC"))
			OK = G.addCC(element2, element1);
		else
			OK = false;

		return true;
	}
}
