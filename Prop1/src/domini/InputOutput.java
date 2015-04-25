package domini;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InputOutput {

	public void loadGraph(String rute) throws FileNotFoundException, IOException {
		Graf G = new Graf();
		String s;
		BufferedReader b = new BufferedReader(new FileReader(rute));

		while ((s = b.readLine()) != null) {

			// System.out.println(s);
			StringTokenizer st = new StringTokenizer(s);

			while (st.hasMoreTokens()) {
				String word1 = st.nextToken();
				st.nextToken();
				String link = st.nextToken();
				String word2 = st.nextToken();
				st.nextToken();

				if (link == "CsubC")
					G.addCC(new Categoria(word2), new Categoria(word1));
				else if (link == "CsupC")
					G.addCC(new Categoria(word1), new Categoria(word2));
				else if (link == "CP")
					G.addCP(new Categoria(word1), new Pagina(word2));
				else if (link == "PC")
					G.addPC(new Pagina(word2), new Categoria(word1));
				else
					System.out.println("Error al crear el graf: Comprova la sintaxi de l'entrada");

			}
		}

		b.close();
	}

	public void printGrafAsPicture(Graf G, String ruta) {
		/*
		 * FileWriter fichero = null; PrintWriter pw = null; try { fichero = new
		 * FileWriter("C:/Users/Pau/Downloads/cats2.txt"); pw = new
		 * PrintWriter(fichero);
		 * 
		 * for (int i = 0; i < 10; i++) pw.println("Linea " + i);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } finally { try { // Nos
		 * aseguramos que se cierra el fichero. if (null != fichero)
		 * fichero.close(); } catch (Exception e2) { e2.printStackTrace(); } }
		 */
	}
	public void printGrafAsText(Graf G, String ruta, String nomDoc) {

	}

	public void translateTextToPicture(String textRute, String pictureRute) {
		String s;

		FileWriter fichEscr = null;
		PrintWriter docE = null;

		FileReader fichLect = null;
		BufferedReader docL = null;

		try {
			// Arxiu de lectura
			fichLect = new FileReader(textRute);
			docL = new BufferedReader(fichLect);

			// Arxiu d'escriptura
			fichEscr = new FileWriter(pictureRute);
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

					word1 = word1.replaceAll("[^a-zA-Z]", "_"); // Aixo fa que
																// elimini tots
																// els caracters
																// que no siguin
																// lletres
					word2 = word2.replaceAll("[^a-zA-Z]", "_"); // Perque sino
																// el
																// programa de
																// dibuixar
																// grafs no
																// funciona

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
