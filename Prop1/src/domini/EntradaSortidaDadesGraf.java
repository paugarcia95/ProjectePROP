package domini;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * @author Pau
 *
 */

public class EntradaSortidaDadesGraf {

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
					G.addCC(new Categoria(word2), new Categoria(word1));
				else if (link.equals("CsupC"))
					G.addCC(new Categoria(word1), new Categoria(word2));
				else if (link.equals("CP"))
					G.addCP(new Categoria(word1), new Pagina(word2));
				else if (link.equals("PC"))
					G.addPC(new Pagina(word2), new Categoria(word1));
				else
					System.out.println("Error al crear el graf: Comprova la sintaxi de l'entrada");
			}
		}
		b.close();
		return G;
	}

	public void escriureGrafDadesEnFitxer(GrafDades G, String ruta) throws FileNotFoundException, IOException {
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
				Iterator<Categoria> CsubC = c.getMapCSubC().values().iterator();
				Iterator<Categoria> CsupC = c.getMapCSupC().values().iterator();

				while (CP.hasNext()) {
					Pagina p = CP.next();
					docE.println(c1 + " cat CP " + p.getNom() + " pag");
				}

				while (PC.hasNext()) {
					Pagina p = PC.next();
					docE.println(c1 + " pag PC " + p.getNom() + " cat");
				}

				while (CsubC.hasNext()) {
					Categoria c2 = CsubC.next();
					docE.println(c2.getNom() + " cat CsubC " + c1 + " cat");
				}

				while (CsupC.hasNext()) {
					Categoria c2 = CsupC.next();
					docE.println(c2.getNom() + " cat CsupC " + c1 + " cat");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

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
					// lletres
					word2 = word2.replaceAll("[^a-zA-Z]", "_");
					// Perque sino el programa de dibuixargrafs no funciona

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
			e.printStackTrace();
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (null != docL)
					docL.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
