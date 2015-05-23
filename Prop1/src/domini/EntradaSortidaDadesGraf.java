package domini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Pau
 *
 */

public class EntradaSortidaDadesGraf {

	/**
	 * Creadora per defecte.
	 * 
	 */
	public EntradaSortidaDadesGraf() {
		super();
	}


	/**
	 * Carrega les dades d'un fitxer de text a un graf. El fitxer te el format
	 * predeterminat d'una Wikipedia
	 * 
	 * S'afegeixen a G els nodes i/o arestes indicats pel fitxer de text a
	 * "ruta"
	 * 
	 * @param G
	 *            S'afegeixen a aquest graf els nous nodes i arestes
	 * @param ruta
	 *            Adreca on es troba el fitxer de text
	 * @return Un GrafDades amb les dades de "ruta"
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void llegirGrafDades(GrafDades G, File ruta) {
		BufferedReader b = null;
		String s;

		try {
			b = new BufferedReader(new FileReader(ruta));

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
					else {
						error(4);
						return;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			error(3);
		} catch (IOException e) {
			System.out.println(e);
			error(1);
		} finally {
			try {
				if (b != null) {
					b.close();
				}
			} catch (IOException e) {
				System.out.println(e);
				error(7);
			}
		}
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
				// Aquest ultim no cal ja que nom�s amb els enlla�os CsupC ja es
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
			error(3);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				System.out.println(e2);
				error(7);
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
						error(4);
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
			error(3);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				System.out.println(e2);
				error(7);
			}
			try {
				if (null != docL)
					docL.close();
			} catch (Exception e2) {
				System.out.println(e2);
				error(7);
			}
		}
	}

	/**
	 * Llegeix del canal standard d'entrada una aresta (en format: node1
	 * tipusEnllac node2) i l'afegeix a G.
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

	public void carregarGrafDades(GrafDades G, File ruta) {
		BufferedReader b = null;
		try {
			b = new BufferedReader(new FileReader(ruta));
			String s;
			int nCats=0;
			int nPags=0;
			int iter = 0;
			
			if ((s = b.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s);
				if (!st.hasMoreTokens() || !st.nextToken().equals("|CATEGORIES|")) {
					error(5);
					return;
				}
				if (st.hasMoreTokens()) {
					try {
						nCats = Integer.valueOf(st.nextToken());
					} catch (NumberFormatException e) {
						error(4);
						return;
					}
				} else {
					error(4);
					return;
				}
				
			} else {
				error(5);
				return;
			}
			
			while (iter < nCats && (s = b.readLine()) != null) {
				// linia a linia
				String[] enllacos = s.split("\\|");
				if (enllacos.length < 1) {
					error(4);
					return;
				} else if (enllacos.length == 1) {
					if (!G.existsCategoria(enllacos[0]))
						G.addCategoria(new Categoria(enllacos[0]));
				}
				String c = enllacos[0];

				for (int i = 1; i < enllacos.length; ++i) {
					// de "|" a "|"
					String[] c2 = enllacos[i].split(" ");

					if (i == 1) {
						// CP
						for (int j = 0; j < c2.length; ++j) {
							// de categoria en categoria
							if (!c2[j].equals("")) {
								G.addCP(c, c2[j]);
							}
						}
					} else if (i == 2) {
						// PC
						for (int k = 0; k < c2.length; ++k) {
							if (!c2[k].equals("")) {
								G.addPC(c2[k], c);
							}
						}
					} else if (i == 3) {
						// CC
						for (int k = 0; k < c2.length; ++k) {
							if (!c2[k].equals("")) {
								G.addCC(c2[k], c);
							}
						}
					} else if (i != 0) {
						error(4);
						return;
					}
				}
				++iter;
			}

			if ((s = b.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s);
				if (!st.hasMoreTokens() || !st.nextToken().equals("|PAGINES|")) {
					error(6);
					// Intenta recuperar l'error
					while (((s = b.readLine()) != null)) {
						if ((st = new StringTokenizer(s)).hasMoreTokens() 
								&& st.nextToken().equals("|PAGINES|")) {
							break;
						}
					}
				}
				if (st.hasMoreTokens()) {
					try {
						nPags = Integer.valueOf(st.nextToken());
					} catch (NumberFormatException e) {
						error(4);
						return;
					}
				} else {
					error(4);
					return;
				}

			} else {
				error(5);
				return;
			}

			iter = 0;
			while (iter < nPags && (s = b.readLine()) != null) {
				if (s.contains(" ")) {
					error(4);
					return;
				}
				if (!G.existsPagina(s))
					G.addPagina(new Pagina(s));
				++iter;
			}

			if (!b.readLine().equals("**FIN**")) {
				error(6);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
			error(3);
		} catch (IOException e) {
			System.out.println(e);
			error(1);
		} finally {
			try {
				if (b != null) {
					b.close();
				}
			} catch (IOException e) {
				System.out.println(e);
				error(7);
			}
		}
	}

	public void guardarGrafDades(GrafDades G, File ruta) {
		FileWriter fichEscr = null;
		PrintWriter docE = null;

		try {
			// Arxiu d'escriptura
			fichEscr = new FileWriter(ruta);
			docE = new PrintWriter(fichEscr);

			docE.print("|CATEGORIES| " + G.getNombreCategories());

			Iterator<Categoria> it = G.getCategories().iterator();

			while (it.hasNext()) {
				docE.println();
				Categoria c = it.next();
				String c1 = c.getNom();

				docE.print(c1);

				Iterator<Pagina> CP = c.getMapCP().values().iterator();
				Iterator<Pagina> PC = c.getMapPC().values().iterator();
				Iterator<Categoria> CsupC = c.getMapCSupC().values().iterator();

				docE.print("|");

				while (CP.hasNext()) {
					Pagina p = CP.next();
					docE.print(p.getNom() + " ");
				}

				docE.print("|");

				while (PC.hasNext()) {
					Pagina p = PC.next();
					docE.print(p.getNom() + " ");
				}

				docE.print("|");

				while (CsupC.hasNext()) {
					Categoria c2 = CsupC.next();
					docE.print(c2.getNom() + " ");
				}
			}
			docE.println();
			docE.println("|PAGINES| " + G.getNombrePagines());

			Iterator<Pagina> it2 = G.getPagines().iterator();

			while (it2.hasNext()) {
				docE.println(it2.next().getNom());
			}
			docE.print("**FIN**");

		} catch (Exception e) {
			System.out.println(e);
			error(2);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				System.out.println(e2);
				error(7);
			}
		}
	}

	public void carregarUsuaris(Map<String, Usuari> usuaris, File ruta) {

	}

	public void guardarUsuaris(Map<String, Usuari> usuaris, File ruta) {

	}

	/**
	 * Escriu l'error amb codi d'error e per pantalla
	 * 
	 * @exception 1: Error de lectura
	 * @exception 2: Error d'escrpitura
	 * @exception 3: No s'ha trobat el fitxer
	 * @exception 4: Error en la sintaxi del fitxer d'entrada
	 * @exception 5: Fitxer d'entrada sense dades
	 * @exception 6: L'arxiu s'ha llegit correctament però pot contenir errors.
	 *            Revisa la sintaxi per si de cas
	 * @exception 7: Error al tancar l'arxiu
	 * @exception default: Error indeterminat
	 * 
	 * @param e
	 *            Codi de l'error
	 */
	private void error(int e) {
		switch (e) {
			case 1 :
				System.out.println("Error de lectura");
				return;
			case 2 :
				System.out.println("Error d'escrpitura");
				return;
			case 3 :
				System.out.println("No s'ha trobat el fitxer");
				return;
			case 4 :
				System.out.println("Error en la sintaxi del fitxer d'entrada");
				return;
			case 5 :
				System.out.println("Fitxer d'entrada sense dades");
				return;
			case 6 :
				System.out
						.println("L'arxiu s'ha llegit correctament però pot contenir errors. Revisa la sintaxi per si de cas");
				return;
			case 7 :
				System.out.println("Error al tancar l'arxiu");
				return;
			default :
				System.out.println("Error indeterminat");
		}
	}

}

