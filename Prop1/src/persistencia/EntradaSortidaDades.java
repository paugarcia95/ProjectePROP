package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import domini.Categoria;
import domini.CercaComunitats;
import domini.Comunitat;
import domini.Criteris;
import domini.GrafDades;
import domini.Pagina;
import domini.ParaulaValor;
import domini.Usuari;

/**
 * @author Pau
 *
 */

public class EntradaSortidaDades {

	private File rutaPerDefecte;
	private String codiError = "Error?";
	private Boolean errorEnExecucio = false;
	
	private final String DIRECTORI_USERS 		= "\\userData\\";
	private final String DIRECTORI_GRAF 		= "\\graphData\\";
	private final String ARXIU_DADES_GRAF 		= DIRECTORI_GRAF  + "graf.wdb";
	private final String ARXIU_DADES_USUARIS 	= DIRECTORI_USERS + "usuaris.wdb";
	private final String EXTENSIO_DADES_CERQUES = ".udb";

	/**
	 * Creadora per defecte.
	 * 
	 */
	public EntradaSortidaDades() {
		super();
		rutaPerDefecte = new File(".\\data\\");
	}

	/**
	 * Creadora amb ruta per defecte.
	 * 
	 * @param rutaPerDefecte
	 *            Directori on es guardaran les dades del programa
	 */
	public EntradaSortidaDades(File rutaPerDefecte) {
		super();
		this.rutaPerDefecte = rutaPerDefecte;
	}

	/**
	 * Estableix la ruta per defecte on es guarden les dades de persistencia.
	 * 
	 * @param rutaPerDefecte
	 *            Directori on es guardaran les dades del programa
	 */
	public void setRutaPerDefecte(File rutaPerDefecte) {
		this.rutaPerDefecte = rutaPerDefecte;
	}

	/**
	 * Consultora de la ruta per defecte on es guarden les dades.
	 * 
	 * @return La ruta per defecte
	 */
	public File getRutaPerDefecte() {
		return rutaPerDefecte;
	}

	/**
	 * Retorna l'error que hi ha hagut en l'execucio anterior. Si no n'hi ha
	 * hagut cap, retorna el de la ultima amb error o "Error?".
	 * 
	 * @return Un String amb l'error que s'ha produit
	 */
	public String getError() {
		return codiError;
	}

	/**
	 * Carrega les dades d'un fitxer de text (escrit en format usuari) a un
	 * graf. El fitxer te el format predeterminat d'una Wikipedia.
	 * 
	 * S'afegeixen a G els nodes i/o arestes indicats pel fitxer de text a
	 * "ruta"
	 * 
	 * @param G
	 *            S'afegeixen a aquest graf els nous nodes i arestes
	 * @param ruta
	 *            Adreca on es troba el fitxer de text
	 * @return Un boolea que indica si hi ha hagut un error en la
	 *         lectura/escriptura.
	 */
	public Boolean llegirGrafDades(GrafDades G, File ruta) {
		errorEnExecucio = false;

		if (G == null)
			return error(-1);

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
						return error(4);
					}
				}
			}
		} catch (FileNotFoundException e) {
			error(9);
		} catch (IOException e) {
			error(1);
		} finally {
			try {
				if (b != null) {
					b.close();
				}
			} catch (IOException e) {
				error(7);
			}
		}
		return errorEnExecucio;
	}

	/**
	 * Guarda la configuracio del graf G a un fitxer de text a "ruta".
	 * 
	 * @param G
	 *            Indica el graf de dades que es vol emmagatzemar en format
	 *            usuari
	 * @param ruta
	 *            Indica la ruta de directoris i el fitxer on es vol guardar el
	 *            graf
	 * @return Un boolea que indica si hi ha hagut un error en la
	 *         lectura/escriptura.
	 */
	public Boolean escriureGrafDades(GrafDades G, File ruta) {
		errorEnExecucio = false;
		FileWriter fichEscr = null;
		PrintWriter docE = null;

		if (G == null)
			return error(-1);

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
				// Aquest ultim no cal ja que nomes amb els enllacos CsupC ja es
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

		} catch (FileNotFoundException e) {
			error(9);
		} catch (IOException e2) {
			error(2);
		} catch (Exception e3) {
			error(0);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				error(7);
			}
		}
		return errorEnExecucio;
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

	/**
	 * Carrega les dades d'un fitxer de text a un graf. El fitxer te el format
	 * intern del programa.
	 * 
	 * S'afegeixen a G els nodes i/o arestes indicats pel fitxer de text a la
	 * rutaPerDefecte
	 * 
	 * @param G
	 *            S'afegeixen a aquest graf els nous nodes i arestes
	 * @return Un boolea que indica si hi ha hagut un error en la
	 *         lectura/escriptura.
	 */
	public Boolean carregarGrafDades(GrafDades G) {
		errorEnExecucio = false;

		if (G == null)
			return error(-1);

		BufferedReader b = null;
		try {
			b = new BufferedReader(new FileReader(rutaPerDefecte + ARXIU_DADES_GRAF));
			String s;
			int nCats=0;
			int nPags=0;
			int iter = 0;
			
			if ((s = b.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s);
				if (!st.hasMoreTokens() || !st.nextToken().equals("|CATEGORIES|")) {
					return error(5);
				}
				if (st.hasMoreTokens()) {
					nCats = Integer.valueOf(st.nextToken());
				} else {
					return error(4);
				}
			} else {
				return error(5);
			}
			
			while (iter < nCats && (s = b.readLine()) != null) {
				// linia a linia
				String[] enllacos = s.split("\\|");
				if (enllacos.length < 1) {
					return error(4);
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
						return error(4);
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
					nPags = Integer.valueOf(st.nextToken());

				} else {
					return error(4);
				}

			} else {
				return error(5);
			}

			iter = 0;
			while (iter < nPags && (s = b.readLine()) != null) {
				if (s.contains(" ")) {
					return error(4);
				}
				if (!G.existsPagina(s))
					G.addPagina(new Pagina(s));
				++iter;
			}

			if (!b.readLine().equals("**END**")) {
				error(6);
			}

		} catch (FileNotFoundException e) {
			// No fa res perque no es un error no trobar l'arxiu, ja que pot ser
			// que sigui la primera vegada que inici el programa
		} catch (IOException e) {
			error(1);
		} catch (NumberFormatException e) {
			error(8);
		} finally {
			try {
				if (b != null) {
					b.close();
				}
			} catch (IOException e) {
				error(7);
			}
		}
		return errorEnExecucio;
	}

	/**
	 * Guarda la configuracio del graf G a un fitxer de text a la rutaPerDefecte
	 * 
	 * @param G
	 *            Indica el graf de dades que es vol emmagatzemar en format
	 *            usuari
	 * @return Un boolea que indica si hi ha hagut un error en la
	 *         lectura/escriptura.
	 */
	public Boolean guardarGrafDades(GrafDades G) {
		errorEnExecucio = false;

		if (G == null)
			return error(-1);

		FileWriter fichEscr = null;
		PrintWriter docE = null;

		try {
			// Creo el directori si no existeix i esborro tots els arxius que hi
			// havia

			File ubicacioDades = new File(rutaPerDefecte + DIRECTORI_GRAF);
			if (!ubicacioDades.exists()) {
				ubicacioDades.mkdirs();
			}
			File[] ficheros = ubicacioDades.listFiles();
			File f = null;
			if (ubicacioDades.exists()) {
				for (int x = 0; x < ficheros.length; x++) {
					f = new File(ficheros[x].toString());
					f.delete();
				}
			}

			// Arxiu d'escriptura
			fichEscr = new FileWriter(rutaPerDefecte + ARXIU_DADES_GRAF);
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
			docE.print("**END**");

		} catch (IOException e) {
			error(2);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				error(7);
			}
		}
		return errorEnExecucio;
	}

	/**
	 * Carrega la informacio dels usuaris que es troba a RutaPerDefecte
	 * 
	 * @param MapUsuaris
	 *            Map on s'emmagatzemaran totes les dades llegides
	 * @return Un boolea que indica si hi ha hagut un error en la
	 *         lectura/escriptura.
	 */
	public Boolean carregarUsuaris(Map<String, Usuari> MapUsuaris) {
		errorEnExecucio = false;

		if (MapUsuaris == null) {
			return error(-1);
		}

		BufferedReader b = null;

		try {
			b = new BufferedReader(new FileReader(rutaPerDefecte + ARXIU_DADES_USUARIS));
			String s;

			int iter = 0;
			final int nUsuaris;

			if ((s = b.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s);
				if (st.hasMoreTokens()) {
					nUsuaris = Integer.valueOf(st.nextToken());

				} else {
					return error(8);
				}
			} else {
				return error(5);
			}

			while (iter < nUsuaris && (s = b.readLine()) != null) {
				Usuari user;
				String[] userData = s.split(" ");

				if (userData.length != 3) {
					return error(8);
				}

				user = new Usuari(userData[0].replace('+', ' '), userData[1].replace('+', ' '),
						userData[2].equals("true"));

				ArrayList<CercaComunitats> cerques = carregaDadesUsuari(user);
				if (cerques != null) {
					for (int i = 0; i < cerques.size(); ++i) {
						if (cerques.get(i) != null)
							user.addCerca(cerques.get(i));
					}
				} else {
					error(8);
				}
				MapUsuaris.put(user.getUsername(), user);
				++iter;
			}

			String aux;
			if ((aux = b.readLine()) != null && !aux.equals("**END**") || iter < nUsuaris) {
				error(6);
			}

		} catch (FileNotFoundException e) {
			// No fa res perque no es un error no trobar l'arxiu, ja que pot ser
			// que sigui la primera vegada que inici el programa
		} catch (IOException e) {
			error(1);
		} catch (NumberFormatException e) {
			error(8);
		} finally {
			try {
				if (b != null) {
					b.close();
				}
			} catch (IOException e) {
				error(7);
			}
		}
		return errorEnExecucio;
	}

	/**
	 * Retorna la informacio carregada de l'usuari "user" que es troba en
	 * RutaPerDefecte. Si succeeix algun error, retorna una arrayList nul·la.
	 * 
	 * @param user
	 *            usuari del qual es vol llegir la informacio
	 * @return Una ArrayList de totes les cerques de comunitats que te
	 *         emmagatzemades l'usuari en el seu fitxer
	 */
	private ArrayList<CercaComunitats> carregaDadesUsuari(Usuari user) {
		BufferedReader b = null;
		boolean error = false;
		ArrayList<CercaComunitats> result = new ArrayList<CercaComunitats>();
		
		try {
			b = new BufferedReader(new FileReader(rutaPerDefecte + DIRECTORI_USERS
					+ user.getUsername().replace(" ", "+")
					+ EXTENSIO_DADES_CERQUES));
			String s;

			int iter = 0;
			int nCerques = 0;

			if ((s = b.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s);
				if (st.hasMoreTokens()) {
					nCerques = Integer.valueOf(st.nextToken());
				} else
					return errorAuxiliar(8);
			} else
				return errorAuxiliar(5);

			while (iter < nCerques && (s = b.readLine()) != null && !error) {

				String[] info = ((String) s).split(" ");

				if (info.length != 11)
					return errorAuxiliar(8);


				Date creacio = carregarData(info[2]);
				Date modificacio = carregarData(info[3]);
				String[] aux = info[4].split("\\+");
				int[] criteris = new int[aux.length];
				int SIZEevitaCat, SIZEevitaPag, SIZEsubconj;

				for (int i = 0; i < aux.length; ++i) {
					criteris[i] = Integer.valueOf(aux[i]);
				}
				
				SIZEevitaCat = Integer.valueOf(info[5]);
				SIZEevitaPag = Integer.valueOf(info[6]);
				SIZEsubconj = Integer.valueOf(info[7]);


				// alg, dada, rel, semb, tipus;
				// 1 2 3 4 5

				if (creacio != null && !error && criteris.length == 8) {
					int iter2 = 0;
					ArrayList<String> subconj, evitaCat, evitaPag;
					subconj = new ArrayList<String>();
					evitaCat = new ArrayList<String>();
					evitaPag = new ArrayList<String>();
					ArrayList<Comunitat> comunitats = new ArrayList<Comunitat>();

					// Llegeixo el vector evitaCat
					while (iter2 < SIZEevitaCat && (s = b.readLine()) != null && !error) {
						evitaCat.add((String) s);
						++iter2;
					}

					if (iter2 < SIZEevitaCat || !b.readLine().equals("*")) {
							return errorAuxiliar(8);
					}

					// Llegeixo el vector evitaPag
					iter2 = 0;
					while (iter2 < SIZEevitaPag && (s = b.readLine()) != null && !error) {
						evitaPag.add((String) s);
						++iter2;
					}
					if (iter2 < SIZEevitaPag || !b.readLine().equals("*")) {
							return errorAuxiliar(8);
					}

					// Llegeixo el vector subconj
					iter2 = 0;
					while (iter2 < SIZEsubconj && (s = b.readLine()) != null && !error) {
						subconj.add((String) s);
						++iter2;
					}
					if (iter2 < SIZEsubconj || !b.readLine().equals("*")) {
							return errorAuxiliar(8);
					}
					
					//Llegeixo les comunitats
					iter2 = 0;
					int numComunitats = Integer.parseInt(b.readLine());
					while (iter2 < numComunitats && (s = b.readLine()) != null && !error) {
						String[] auxi = s.split(" ");
						if (auxi.length != 2) {
								return errorAuxiliar(8);
						}
						int id = Integer.parseInt(auxi[0]);
						int nCats = Integer.parseInt(auxi[1]);

						Comunitat c = new Comunitat(id);
						int iter3 = 0;
						while (iter3 < nCats) {
							c.addCat(b.readLine());
							++iter3;
						}
						comunitats.add(c);
						++iter2;
					}
					if (iter2 < numComunitats || !b.readLine().equals("*")) {
							return errorAuxiliar(8);
					}

					// Amb la informació de tot el fitxer munto la
					// cercaDeComunitats
					Criteris cri = new Criteris(
							new ParaulaValor(info[8].replace("NULL", ""), Integer.valueOf(info[9])), criteris[0],
							criteris[1], criteris[2], criteris[3], criteris[4], criteris[5], criteris[6], criteris[7],
							subconj, evitaCat, evitaPag, info[10].replace("NULL", ""));
					CercaComunitats cerca = new CercaComunitats(info[0].replace('+', ' '), creacio, cri,
							user.getUsername(), modificacio, info[1].replace('+', ' '),
							comunitats);
					result.add(cerca);
				}
				else {
						return errorAuxiliar(8);
				}
				++iter;
			}
			String aux;
			if (((aux = b.readLine()) != null && !aux.equals("**END**")) || iter < nCerques) {
				error(6);
			}
		} catch (FileNotFoundException e) {
			error(3);
		} catch (IOException e) {
			error(1);
		} catch (NumberFormatException e) {
			error(8);
		} finally {
			try {
				if (b != null) {
					b.close();
				}
			} catch (IOException e) {
				error(7);
			}
		}
		return result;
	}

	/**
	 * Guarda la informacio dels usuaris que es troben al MapUsuaris a un fitxer
	 * de text a rutaPerDefecte
	 * 
	 * @param MapUsuaris
	 *            Conte la informacio de tots els usuaris que es desitja
	 *            emmagatzemar
	 * @return Un boolea que indica si hi ha hagut un error en la
	 *         lectura/escriptura.
	 */
	public Boolean guardarUsuaris(Map<String, Usuari> MapUsuaris) {
		errorEnExecucio = false;

		if (MapUsuaris == null) {
			return error(-1);
		}

		PrintWriter docE = null;

		try {
			File ubicacioDades = new File(rutaPerDefecte + DIRECTORI_USERS);

			if (!ubicacioDades.exists()) {
				ubicacioDades.mkdirs();
			}

			File[] ficheros = ubicacioDades.listFiles();
			if (ubicacioDades.exists()) {
				for (int i = 0; i < ficheros.length; i++) {
					ficheros[i].delete();
				}
			}

			docE = new PrintWriter(new FileWriter(rutaPerDefecte + ARXIU_DADES_USUARIS));
			Iterator<Usuari> usuaris = MapUsuaris.values().iterator();

			// Numero Usuaris
			docE.println(MapUsuaris.size());

			while (usuaris.hasNext()) {
				Usuari user = usuaris.next();
				docE.println(
						user.getUsername().replace(" ", "+")	 + " " + 
						user.getPassword().replace(" ", "+")	 + " " +
						user.esAdmin() + " "
						);
				guardaDadesUsuari(user);
			}
			docE.println("**END**");
		} catch (FileNotFoundException e) {
			// No es error
		} catch (IOException e2) {
			error(2);
		} catch (Exception e3) {
			error(0);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				error(7);
			}
		}
		return errorEnExecucio;
	}

	/**
	 * Guarda la informacio de l'usuari en la rutaPerDefecte
	 * 
	 * @param user
	 *            Conte la informacio de l'usuari
	 */
	private void guardaDadesUsuari(Usuari user) {
		PrintWriter docE = null;

		try {
			docE = new PrintWriter(new FileWriter(rutaPerDefecte + DIRECTORI_USERS
					+ user.getUsername().replace(" ", "+")
					+ EXTENSIO_DADES_CERQUES));

			// Num Cerques
			docE.println(user.getNumCerques());

			for (int i = 0; i < user.getNumCerques(); ++i) {
				CercaComunitats c = user.getCerca(i);

				// NomCerca
				if (c.getNom().equals(""))
					docE.print("NULL ");
				else
					docE.print(c.getNom().replace(" ", "+") + " ");
				// ComentariCerca
				if (c.getComentari().equals(""))
					docE.print("NULL ");
				else
					docE.print(c.getComentari().replace(" ", "+") + " ");

				// DataCreacio DataModificacio
				docE.print(
						escriuData(c.getDataCreacio()) 		+ " " + 
						escriuData(c.getDataModificacio()) 	+ " "
						);

				// CreiterisSeleccio: algorisme dada relacionsCat semblaNom
				// tipuCerca
				Criteris criteris = c.getCriterisSeleccio();
				docE.print(
						criteris.getRelacionsCat() 	+ "+" +
						criteris.getRelacionsPag()	+ "+" +
						criteris.getRelacionsSubs() + "+" +
						criteris.getRelacionsSuper()+ "+" +
						criteris.getSemblaNom() 	+ "+" + 
						criteris.getAlgorisme()		+ "+" + 
						criteris.getTipuCerca() 	+ "+" +
						criteris.getDada() 			+ " "
						);

				ArrayList<String> evitaCat = criteris.getEvitaCat();
				ArrayList<String> evitaPag = criteris.getEvitaPag();
				ArrayList<String> subconj = criteris.getSubconjCat();

				String pare = "NULL";
				String paraula = "NULL";
				if (!criteris.getPare().equals(""))
					pare = criteris.getPare();
				if (!criteris.getParaulaClau().getParaula().equals("")) 
					paraula = criteris.getParaulaClau().getParaula();

				// SIZEevitaCat SIZEevitaPag SIZEsubconj paraula clau
				docE.println(
						evitaCat.size() 						+ " " + 
						evitaPag.size() 						+ " " + 
						subconj.size() 							+ " " +
						paraula								 	+ " " + 
						criteris.getParaulaClau().getNum() 		+ " " +
						pare
						);

				// VECTORevitaCat
				for (int j = 0; j < evitaCat.size(); ++j) {
					docE.println(evitaCat.get(j));
				}
				docE.println("*");

				// VECTORevitaPag
				for (int j = 0; j < evitaPag.size(); ++j) {
					docE.println(evitaPag.get(j));
				}
				docE.println("*");

				// VECTORsubconj
				for (int j = 0; j < subconj.size(); ++j) {
					docE.println(subconj.get(j));
				}
				docE.println("*");

				// numComunitats
				docE.println(c.getNumComunitats());

				// LES_COMUNITATS
				for (int j = 0; j < c.getNumComunitats(); ++j) {
					Comunitat com = c.getComunitat(j);
					// ID NumCategories
					docE.println(
							com.getId()						+ " " + 
							com.getNumeroDeCategories() 	+ " "
							);
					
					ArrayList<String> cats = com.getCategories();
					// Categories
					for (int k = 0; k < com.getNumeroDeCategories(); ++k) {
						docE.println(cats.get(k));
					}
				}
				docE.println("*");
			}
			docE.println("**END**");
		} catch (IOException e) {
			error(2);
		} catch (Exception e1) {
			error(0);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				error(7);
			}
		}
	}
	
	/**
	 * Transforma la data en String
	 * 
	 * @param data
	 *            es una data
	 */
	@SuppressWarnings("deprecation")
	private String escriuData(Date data) {
		if (data == null)
			return "NULL";

		return
		data.getDay() 		+ "+" + 
		data.getMonth() 	+ "+" + 
		data.getYear() 		+ "+" + 
		data.getHours() 	+ "+" +
		data.getMinutes() 	+ "+" + 
		data.getSeconds();
	}
	
	/**
	 * Transforma una cadena de numeros de llargada 6 separada per "+" en una
	 * data
	 * 
	 * @param data
	 *            String que te el format correcte d'una data
	 */
	@SuppressWarnings("deprecation")
	private Date carregarData(String data) {
		if (data.equals("NULL"))
			return null;

		String[] aux = data.split("\\+");
		if (aux.length != 6) {
			error(8);
			return null;
		}
		Date result = new Date();
		try {
			result.setDate		(Integer.valueOf(aux[0]));
			result.setMonth		(Integer.valueOf(aux[1]));
			result.setYear		(Integer.valueOf(aux[2]));
			result.setHours		(Integer.valueOf(aux[3]));
			result.setMinutes	(Integer.valueOf(aux[4]));
			result.setSeconds	(Integer.valueOf(aux[5]));
		} catch (NumberFormatException e) {
			error(8);
			return null;
		}
		return result;
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
	 * @exception 8: Error al carregar les dades del programa
	 * @exception 9: L'arxiu no existeix, tria'n un altre
	 * @exception default
	 *                : Error indeterminat
	 * 
	 * @param e
	 *            Codi de l'error
	 */
	private Boolean error(int e) {
		switch (e) {
			case 1 :
				codiError = "Error amb el fitxer de lectura (Algun error amb el sistema de fitxers del sistema operatiu)";
				break;
			case 2 :
				codiError = "Error amb el fitxer d'escrpitura (Algun error amb el sistema de fitxers del sistema operatiu)";
				break;
			case 3 :
				codiError = "No s'ha trobat el fitxer";
				break;
			case 4 :
				codiError = "Error en la sintaxi del fitxer d'entrada";
				break;
			case 5 :
				codiError = "El fitxer d'on s'havien de carregar les dades està buit, es crearà un nou fitxer quan es tanqui el programa";
				break;
			case 6 :
				codiError = "L'arxiu s'ha llegit correctament però pot contenir errors. Revisa la sintaxi per si de cas";
				break;
			case 7 :
				codiError = "Error al tancar l'arxiu (Algun error amb el sistema de fitxers del sistema operatiu)";
				break;
			case 8:
				codiError = "Error al carregar les dades del programa: les dades han estat danyades";
				break;
			case 9 :
				codiError = "L'arxiu no existeix, tria'n un altre";
				break;
			case -1 :
				codiError = "La variable que m'has passat per guardar les dades es nul·la!";
				break;
			default :
				codiError = "Error indeterminat";
		}
		errorEnExecucio = true;
		return true; // Sempre retorna true per marcar l'error
	}

	private ArrayList<CercaComunitats> errorAuxiliar(int i) {
		error(i);
		return null;
	}
	
	
	///////////////////// FUNCIO QUE AL FINAL NO HEM UTILITZAT AL PROGRAMA PRINCIPAL ///////////
	
	/**
	 * Tradueix un fitxer de dades d'un graf a un fitxer que permet al programa
	 * DOT representar graficament un graf. El programa DOT nomes funciona
	 * correctament si el graf te menys de 100 nodes aproximadament.
	 * 
	 * @param rutaGraf
	 *            Ruta de directoris que indica on es troba el fitxer amb les
	 *            dades del graf.
	 * @param rutaImatgeTXT
	 *            La ruta de l'arxiu de text de dest�.
	 * @return Un boolea que indica si hi ha hagut un error en la
	 *         lectura/escriptura.
	 */
	public Boolean traduirGrafDadesAImatge(String rutaGraf, String rutaImatgeTXT) {
		errorEnExecucio = false;
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
						return error(4);
					}

					if (type1.equals("page"))
						docE.println(word1 + " [shape=box]");
					if (type2.equals("page"))
						docE.println(word2 + " [shape=box]");
				}
			}
			docE.println("}");

		} catch (Exception e) {
			error(3);
		} finally {
			try {
				// Nos aseguramos que se cierra el fichero.
				if (null != docE)
					docE.close();
			} catch (Exception e2) {
				error(7);
			}
			try {
				if (null != docL)
					docL.close();
			} catch (Exception e2) {
				error(7);
			}
		}
		return errorEnExecucio;
	}

}


/*
 *                NORMES DE CARACTERS AL GUARDAR UN ARXIU:
 * 
 * 
 * noms categories i pagines sense | ni * (NO pot tenir espais) nom usuari sense
 * |/\:*?<>"+ (pot tenir espais) password sense | i * ni + (pot tenir espais)
 * nom, comentari de cercaComunitats sense | ni * ni + (pot tenir espais)
 * paraula clau igual, sense | ni * ni + (tmb pot tenir espais)
 * 
 * O sigui com a resum: 1) MAI ni | ni * ni + (etcepte les pags i cats que el +
 * si que poden)
 * 
 * 2) Espais es pot a tot arreu menys a cats i pags
 * 
 * 3) |/\:*?<>"+ cap d'aquets a un nom d'usuari (això es per culpa de windows
 * que com creo un arxiu amb el nom de l'usuari si tingues aixo petaria (pero
 * espais SI que poden tenir))
 * 
 * 4) I MAI pot no tenir nom!!, o sigui un caràcter com a mínim
 */

