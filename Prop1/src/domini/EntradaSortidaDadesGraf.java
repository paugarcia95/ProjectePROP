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
	private String rutaPerDefecte = null;

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
	 * Si utilitzarRutaPerDefecte==TRUE:
	 * 
	 * S'utilitza la rutaPerDefecte de la classe per carregar les dades del
	 * graf. Si la rutaPerDefecte no està inicialitzada, s'inicialitza
	 * utilitzant "ruta". En aquest cas, es crea un nou GrafDades (s'ignora G),
	 * s'omple amb les dades indicades al fitxer i es retorna aquest graf.
	 * 
	 * Si utilitzarRutaPerDefecte==FALSE:
	 * 
	 * S'afegeixen a G els nodes i/o arestes indicats pel fitxer de text a
	 * "ruta"
	 * 
	 * @param utilitzarRutaPerDefecte
	 *            Booleà que indica si es vol utilitzar la ruta per defecte
	 * @param G
	 *            Només es té en compte si utilitzarRutaPerDefecte==FALSE; si és
	 *            així, s'afegeixen a aquest graf els nous nodes i arestes
	 * @param ruta
	 *            Adreça on es troba el fitxer de text
	 * @return Un GrafDades amb les dades de "ruta"
	 */
	public GrafDades carregarGrafDades(Boolean utilitzarRutaPerDefecte, GrafDades G, String ruta) {

		if (utilitzarRutaPerDefecte) {
			G = new GrafDades();
			if (rutaPerDefecte != null)
				ruta = rutaPerDefecte;
			else {
				rutaPerDefecte = ruta;
			}
		}

		BufferedReader b = null;
		String s;
		try {
			b = new BufferedReader(new FileReader(ruta));
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.out.println("Fitxer no trobat");
		}

		try {
			while ((s = b.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s);

				while (st.hasMoreTokens() && st.countTokens() >= 4) {
					String word1 = st.nextToken();
					st.nextToken();
					String link = st.nextToken();
					String word2 = st.nextToken();

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
				b.close();
			}
		} catch (IOException e) {
			System.out.println(e);
			System.out.println("Error en la sintaxi d'entrada");
		}
		return G;
	}

	/**
	 * Guarda la configuració del graf G a un fitxer de text a "ruta".
	 * 
	 * Si utilitzarRutaPerDefecte==TRUE:
	 * 
	 * El graf es guarda a RutaPerDefecte. En cas que aquesta sigui nul·la,
	 * s'assigna com a ruta per defecte "ruta".
	 * 
	 * Si utilitzarRutaPerDefecte==FALSE:
	 * 
	 * El graf es guarda a "ruta".
	 * 
	 * @param utilitzarRutaPerDefecte
	 *            Booleà que indica si es vol utilitzar la ruta per defecte
	 * @param G
	 *            Indica el graf de dades que es vol emmagatzemar
	 * @param ruta
	 *            Indica la ruta de directoris i el fitxer on es vol guardar el
	 *            graf
	 */
	public void escriureGrafDadesEnFitxer(Boolean utilitzarRutaPerDefecte, GrafDades G, String ruta) {
		if (utilitzarRutaPerDefecte) {
			if (rutaPerDefecte != null)
				ruta = rutaPerDefecte;
			else {
				rutaPerDefecte = ruta;
			}
		}

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
				// Aquest últim no cal ja que només amb els enllaços CsupC ja es
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
