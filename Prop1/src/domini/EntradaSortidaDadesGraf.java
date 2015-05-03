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
	private String rutaPerDefecte;

	/**
	 * Creadora per defecte. La ruta per defecte d'inicialitza a null.
	 * 
	 */
	public EntradaSortidaDadesGraf() {
		this.rutaPerDefecte = null;
	}

	/**
	 * Es crea una nova instància de la classe on la ruta per defecte és la
	 * indicada
	 * 
	 */
	public EntradaSortidaDadesGraf(String rutaPerDefecte) {
		this.rutaPerDefecte = rutaPerDefecte;
	}

	/**
	 * Retorna la ruta per defecte
	 * 
	 * @return rutaPerDefecte
	 */
	public String getRutaPerDefecte() {
		return rutaPerDefecte;
	}

	/**
	 * S'estableix com a rutaPerDefecte la indicada
	 * 
	 * @param rutaPerDefecte
	 *            ruta des d'on es carregaran els fitxers a l'iniciar el
	 *            programa
	 */
	public void setRutaPerDefecte(String rutaPerDefecte) {
		this.rutaPerDefecte = rutaPerDefecte;
	}

	/**
	 * Carrega les dades d'un fitxer de text a un graf.
	 * 
	 * Si inici==TRUE:
	 * 
	 * S'utilitza la rutaPerDefecte de la classe per carregar les dades del
	 * graf. Si la rutaPerDefecte no està inicialitzada, s'inicialitza
	 * utilitzant "ruta". En aquest cas, es crea un nou GrafDades (s'ignora G),
	 * s'omple amb les dades indicades al fitxer i es retorna aquest graf.
	 * 
	 * Si inici==FALSE:
	 * 
	 * S'afegeixen a G els nodes i/o arestes indicats pel fitxer de text a
	 * "ruta"
	 * 
	 * @param inici
	 *            Booleà que indica si és la primera vegada que es carreguen
	 *            fitxers al graf G
	 * @param G
	 *            Només es té en compte si inici==FALSE; si és així, s'afegeixen
	 *            a aquest graf els nous nodes i arestes
	 * @param ruta
	 *            Adreça on es troba el fitxer de text
	 * @return Un GrafDades amb les dades de "ruta"
	 */
	public GrafDades carregarGrafDades(Boolean inici, GrafDades G, String ruta) throws FileNotFoundException,
			IOException {

		if (inici) {
			G = new GrafDades();
			if (rutaPerDefecte != null)
				ruta = rutaPerDefecte;
			else {
				rutaPerDefecte = ruta;
			}
		}

		BufferedReader b = new BufferedReader(new FileReader(ruta));
		String s;

		while ((s = b.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);

			while (st.hasMoreTokens() && st.countTokens() >= 4) {
				String word1 = st.nextToken();
				st.nextToken();
				String link = st.nextToken();
				String word2 = st.nextToken();

				if (link.equals("CsubC"))
					G.addCC(new Categoria(word2), new Categoria(word1));
				else if (link.equals("CsupC"))
					G.addCC(new Categoria(word1), new Categoria(word2));
				else if (link.equals("CP"))
					G.addCP(new Categoria(word1), new Pagina(word2));
				else if (link.equals("PC"))
					G.addPC(new Pagina(word1), new Categoria(word2));
				else
					System.out.println("Error al crear el graf: Comprova la sintaxi de l'entrada");
			}
		}
		b.close();
		return G;
	}

	/**
	 * Guarda la configuració del graf G a un fitxer de text a "ruta"
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
					docE.println(c2.getNom() + " cat CsupC " + c1 + " cat");
				}

				/*
				 * Aquest no cal perquè sinó es replicarien les dades, igual que
				 * només imprimeixo les categories
				 * 
				 * while (CsubC.hasNext()) {
				 * 
				 * Categoria c2 = CsubC.next(); docE.println(c2.getNom() +
				 * " cat CsubC " + c1 + " cat");
				 * 
				 * }
				 */

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

	/**
	 * Tradueix un fitxer de dades d'un graf a un fitxer que permet al programa
	 * DOT representar graficament un graf. El programa DOT només funciona
	 * correctament si el graf té menys de 100 nodes aproximadament.
	 * 
	 * @param rutaGraf
	 *            Ruta de directoris que indica on es troba el fitxer amb les
	 *            dades del graf.
	 * @param rutaImatgeTXT
	 *            La ruta de l'arxiu de text de destí.
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

	/**
	 * Llegeix del canal standard d'entrada una aresta (en format: node1
	 * tipusEnllaç node2) i l'afegeix a G.
	 * 
	 * @param G
	 *            El graf al que es vol afegir una Aresta.
	 * @param OK
	 *            Indica si la dada s'ha inserit correctament al graf G
	 * @return Retorna true si l'usuari no ha indicat el final de l'entrada;
	 *         false en cas contrari
	 */
	public Boolean entrarUnaDada(GrafDades G, Boolean OK) {
		Scanner in = new Scanner(System.in);
		OK = true;

		String element1 = in.next();

		if (element1.equals("#")) {
			OK = false;
			return false;
		}

		String link = in.next();
		String element2 = in.next();

		if (link.equals("CP")) {
			OK = G.addCP(new Categoria(element1), new Pagina(element2));
		} else if (link.equals("PC")) {
			OK = G.addPC(new Pagina(element1), new Categoria(element2));
		} else if (link.equals("CsubC")) {
			OK = G.addCC(new Categoria(element1), new Categoria(element2));
		} else if (link.equals("CsupC")) {
			OK = G.addCC(new Categoria(element2), new Categoria(element1));
		} else
			OK = false;

		return true;
	}
}
