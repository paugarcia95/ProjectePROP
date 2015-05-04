/**
 * 
 */
package domini;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author cristina.fontanet
 *
 */
public class MainProvisional {
//Declaro els controladors aqui per a poder-los fer servir des de les funcions privades, ja veurem si funciona, en java nse
	 static MacroControlador mc;
	 static Scanner s = new Scanner(System.in);
	//+ Cotnroladors
	 
	 
/*
 * mc.getContUser().isAdmin(mc.getUserActual())
 * 
 		System.out.println("PANTALLA :");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println(" ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
 */
	 
	
	private static void visualitzarCategoria(String quina){System.out.print("Funció no implementada encara ");}
	private static void visualitzarPagina(String quina) {System.out.print("Funció no implementada encara ");}
	
	private static void modificaCriterisConjuntComunitats(Integer cercaactual) {
		System.out.println("PANTALLA DE MODIFICACIO DELS CRITERIS D'UNA CERCA DE COMUNITATS:");
		
		System.out.println("Indica amb un numero del 0 al 10 la importancia que li vols donar als seguents criteris: ");
		System.out.println("Atencio! Si es fa servir el criteri de triar un subconjunt de categories, nomes es tindran en compte, a mes a mes, els criteris de relacio i semblança ");
		Integer relacions, sembla, alg, tipus, paraulain, dada;
		ArrayList<String> subconj, evitaCat, evitaPag;
		String pare, paraulast;
		
		System.out.println("Importancia a les relacions entre categories (sent 0 mirar nomes a la relacio entre pagines, 5 totes amb la mateixa importancia i 10 mirar nomes les relacions entre categories, ignorant les pagines ): ");
		System.out.print("Abans tenies " + mc.getContUser().getRelacioCerca(mc.getUserActual(), cercaactual)+ ", valor nou?");
		relacions= s.nextInt();
		
		System.out.print("Importancia en la semblansa de nom de les categories, sent 0 a no donar-li importancia a que els noms s'assemblint i 10 el maxim de semblanca");
		System.out.print("Abans tenies " + mc.getContUser().getSembCerca(mc.getUserActual(), cercaactual)+ ", valor nou?");
		sembla = s.nextInt();
		
		System.out.println("Importancia que li vols donar a una paraula clau determinada");
		System.out.print("Introdueix la paraula clau: ");
		System.out.print("Abans tenies " + mc.getContUser().getParaulaClauCerca(mc.getUserActual(), cercaactual)+ ", valor nou?");
		paraulast = s.next();
		System.out.print("Com de fort vols que la tingui en compte: 0 si no es vol tenir en compte, 5 si han de tenir com a minim mitja paraula igual o 10 si totes l'han de contenir ");
		System.out.print("Abans tenies " + mc.getContUser().getParaulaImpCerca(mc.getUserActual(), cercaactual)+ ", valor nou?");
		paraulain = s.nextInt();
		if(paraulain==0) paraulast = null;
		
		System.out.println("Categoria a partir de la qual es vol fer la cerca (nomes es tindran en compte les categories i pagines a partir dels seus fills): ");
		System.out.print("Abans tenies " + mc.getContUser().getPareCerca(mc.getUserActual(), cercaactual)+ ", valor nou?");
		pare = s.next();
		
		System.out.print("Numero de categories a partir de les quals es vol fer la cerca, ignorant la resta. Si no vols restringir, marca 0:");
		int num = s.nextInt();
		subconj = new ArrayList<String>();
		for(int i = 1; i <= num; ++i) {
			System.out.print("Nom de la "+ i + " categoria a tenir en compte: ");
			String nom2 = s.next();
			subconj.add(nom2);
		}
		
		System.out.print("Numero de categories que vols evitar: ");
		int num2 = s.nextInt();
		evitaCat = new ArrayList<String>();
		for(int i = 1; i <= num2; ++i) {
			System.out.print("Nom de la "+ i + " categoria a evitar: ");
			String nom3 = s.next();
			evitaCat.add(nom3);
		}
		
		System.out.print("Numero de Pagines que vols evitar: ");
		int num3 = s.nextInt();
		evitaPag = new ArrayList<String>();
		for(int i = 1; i <= num3; ++i) {
			System.out.print("Nom de la "+ i + " Pagina a evitar: ");
			String nom4 = s.next();
			evitaCat.add(nom4);
		}
		
		System.out.println("Tria amb quin dels tres algorismes vols fer la Cerca: ");
		System.out.println("1. Algorisme Louvain");
		System.out.println("2. Algorisme Newmann-Girvan");
		System.out.println("2. Algorisme Clique percolation");
		System.out.print("Abans tenies " + mc.getContUser().getAlgCerca(mc.getUserActual(), cercaactual)+ ", valor nou?");
		System.out.print("Numero d'opció:");
		alg = s.nextInt();
		tipus = dada= 0;
		boolean omplint = true;
		while(omplint) {
			switch(alg) {
			case 1:
				tipus = 0;
				System.out.println("Digues amb un numero del 0 al 100, la dispersió desitjada");
				dada = s.nextInt();
				omplint = false;
				break;
			case 2:
				System.out.println("has seleccionat fer la cerca amb l'algorisme de Newmann-Girvan :");
				System.out.println("Tria entre les seguents opcions:");
				System.out.println("1. Buscar a partir de la dispersió: ");
				System.out.println("2. Buscar a partir d'un nombre de comunitats desitjat");
				System.out.println("3. Buscar a partir de la max Betweenes");
				System.out.print("Numero d'opció:");
				int n = 0;
				n = s.nextInt();
				boolean fet = false;
				while(!fet) {
					switch(n) {
					case 1:
						tipus = 0;
						System.out.print("Digues amb un numero del 0 al 100, la dispersió desitjada: ");
						dada = s.nextInt();
						fet = true;
						break;
					case 2:
						tipus = 1;
						System.out.print("Digues el nombre de comunitats desitjades: ");
						dada = s.nextInt();
						fet = true;
						break;
					case 3:
						tipus = 2;
						System.out.print("Digues la maxima Betweenes desitjada: ");
						dada = s.nextInt();
						fet = true;
						break;
					default:
					System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
					n = s.nextInt();
					break;
					}
				}
				omplint = false;
				break;
			case 3:
				tipus = 0;
				System.out.print("Digues amb un numero del 0 al 100, la dispersió desitjada: ");
				dada = s.nextInt();
				omplint = false;
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
			mc.getContUser().addCriterisCerca(true, mc.getUserActual(), cercaactual, paraulast, paraulain, relacions, sembla, alg, tipus, dada, subconj, evitaCat, evitaPag, pare);
		}
		System.out.println("Comença la Cerca de Comunitats, aquest procés pot tardar uns minuts, si us plau, tingues paciencia");
		mc.getContUser().ferCerca(mc.getUserActual(), cercaactual);
		visualitzarNovaCercaComunitats(cercaactual);
	}
	private static void modificarCerca(Integer cercaactual, Boolean guardada) {
		if(guardada) {
			System.out.println("Tria entre les seguents opcions de modificacio:");
			System.out.println("1. Modificar el nom de la Cerca ");
			System.out.println("2. Modificar el comentari ");
			System.out.println("3. Modificar els criteris ");
			//mes modificar les comunitats obtingudes!!!!!
			System.out.println("4. Enrere ");
			System.out.print("Numero d'opció:");
			int n1 = 0;
			n1 = s.nextInt();
			Boolean modifica = true;
			while(modifica) {
				switch(n1) {
				case 1:
					System.out.print("Indica el nom que li vols posar: ");
					String nom = s.next();
					mc.getContUser().addNomCerca(mc.getUserActual(), cercaactual, nom);
					break;
				case 2:
					System.out.print("Indica el comentari que vols posar: ");
					String comentari = s.next();
					mc.getContUser().addComentariCerca(mc.getUserActual(), cercaactual, comentari);
					break;
				case 3:
					modificaCriterisConjuntComunitats(cercaactual);
					break;
				case 4:
					String quina = mc.getContUser().getNomCerca(mc.getUserActual(), cercaactual);
					visualitzarExistentCercaComunitats(quina);
					break;
				default:
				System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
				n1 = s.nextInt();
				break;
				}
			}
		}
		else {
			System.out.println("Tria entre les seguents opcions de modificacio:");
			System.out.println("1. Modificar els criteris ");
			System.out.println("2. Enrere ");
			System.out.print("Numero d'opció:");
			int n1 = 0;
			n1 = s.nextInt();
			Boolean modifica = true;
			while(modifica) {
				switch(n1) {
				case 1:
					modificaCriterisConjuntComunitats(cercaactual);
					break;
				case 2:
					visualitzarNovaCercaComunitats(cercaactual);
					break;
				default:
				System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
				n1 = s.nextInt();
				break;
				}
			}
		}	
	}
	private static void guardaCerca(Integer cercaactual){
		System.out.print("Indica el nom que li vols posar a la nova cerca: ");
		String nomC = s.next();
		mc.getContUser().addNomCerca(mc.getUserActual(), cercaactual, nomC);
		System.out.println("Escriu sense espais el comentari que vulguis guardar: ");
		String com = s.next();
		mc.getContUser().addComentariCerca(mc.getUserActual(), cercaactual, com);
	}
	
	
	private static void visualitzarNovaCercaComunitats(Integer cercaactual) {
		visualitzarCriterisCerca(cercaactual, false);
	}
	private static void visualitzarCriterisCerca(Integer cercaactual, Boolean guardada) {
		System.out.println("Criteris de cerca: ");
		Integer alg = mc.getContUser().getAlgCerca(mc.getUserActual(), cercaactual);
		Integer dada = mc.getContUser().getAlgDadaCerca(mc.getUserActual(), cercaactual);
			if(alg==1) {
				System.out.println("	1. Algorisme: Louvain ");
				System.out.println("	2. Amb el percentatge de dispersio: "+dada);
			}
			else if(alg==2) {
				System.out.println("	1. Algorisme: Newmann-Girvan ");
				Integer tipu = mc.getContUser().getAlgTipuCerca(mc.getUserActual(), cercaactual);
				if(tipu==0) System.out.println("	2. Amb el percentatge de dispersio: "+dada);
				else if(tipu==1) System.out.println("2. Amb el numero de comunitats: "+dada);
				else System.out.println("	2. Amb el maxim Between: "+dada);
			}
			else {
				System.out.println("	1. Algorisme: Clique percolation ");
				System.out.println("	2. Amb el percentatge de dispersio: "+dada);
			}
		System.out.println("	3. Amb la importancia a les relacions entre categories: "+mc.getContUser().getRelacioCerca(mc.getUserActual(), cercaactual));
		System.out.println(" 	4. Amb la importancia entre la semblansa dels noms: "+mc.getContUser().getSembCerca(mc.getUserActual(), cercaactual));
		System.out.println("	5. Amb " +mc.getContUser().getParaulaImpCerca(mc.getUserActual(), cercaactual)+ " importancia a la paraula clau "+mc.getContUser().getParaulaClauCerca(mc.getUserActual(), cercaactual));
		System.out.println(" 	6. Categoria a partir de la qual s'ha fet la cerca: "+mc.getContUser().getPareCerca(mc.getUserActual(), cercaactual));
		System.out.println(" 	7. Restringida a les comunitats:");
		ArrayList<String> aux = mc.getContUser().getSubCerca(mc.getUserActual(), cercaactual);
		Iterator<String> it = aux.iterator();
		while(it.hasNext()) System.out.println(it.next());
		
		System.out.println(" 	8. Evitant les comunitats: ");
		aux = mc.getContUser().getEvitaCatCerca(mc.getUserActual(), cercaactual);
		Iterator<String> it2 = aux.iterator();
		while(it2.hasNext())System.out.println(it2.next());
		
		System.out.println(" 	9. Evitant les pagines: ");
		aux = mc.getContUser().getEvitaPagCerca(mc.getUserActual(), cercaactual);
		Iterator<String> it3 = aux.iterator();
		while(it3.hasNext()) System.out.println(it3.next());
		
		Integer numcom =  mc.getContUser().getNumComunitatsCerca(mc.getUserActual(), cercaactual);
		System.out.println("Hi ha "+numcom+ " comunitats: ");
		for(Integer i = 1; i <= numcom; ++i) {
			System.out.println("	A la " + i+ " comunitat hi ha les categories: ");
				Set<String> aux1 = mc.getContUser().getCatCerca(mc.getUserActual(), cercaactual, i-1);
				Iterator<String> it4 = aux1.iterator();
				while(it4.hasNext())System.out.println(it4.next());
		}
		
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Modificar Cerca");		
		System.out.println("2. Eliminar Cerca ");
		System.out.println("3. Visualitzar Categoria");
		System.out.println("4. Guardar la Cerca");
		System.out.println("5. Enrere ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				modificarCerca(cercaactual, guardada);
				break;
			case 2:
				if(!mc.getContUser().removeCerca(mc.getUserActual(), cercaactual)) System.out.println("No s'ha pogut eliminar");
				break;
			case 3:
				System.out.print("Escriu el nom de la categoria que vols visualitzar: ");
				String categor = s.next();
				visualitzarCategoria(categor);
				break;
			case 4:
				if(!guardada)guardaCerca(cercaactual);
				//si ja esta guardada, no passa res
				System.out.println("Felicitats, Cerca guardada amb exit");
				guardada = true;
				System.out.println("Tria entre les seguents opcions:");
				System.out.println("1. Modificar Cerca");		
				System.out.println("2. Eliminar Cerca ");
				System.out.println("3. Visualitzar Categoria");
				System.out.println("4. Guardar la Cerca");
				System.out.println("5. Enrere ");
				System.out.print("Numero d'opció:");
				n = s.nextInt();
				break;
			case 5:
				if(mc.getContUser().isAdmin(mc.getUserActual())) opcionsAdmin();
				else opcionsClient();
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
	}
	
	private static void visualitzarExistentCercaComunitats(String quina) {
		Integer cercaactual = mc.getContUser().getNumCerca(mc.getUserActual(), quina);
		System.out.println(" ");
		System.out.println("PANTALLA DE VISUALITZACIO D'UNA CERCA DE COMUNITATS JA GUARDADA");
		System.out.println("Nom de la cerca: "+ mc.getContUser().getNomCerca(mc.getUserActual(), cercaactual));
		System.out.println("Comentari: "+mc.getContUser().getComentariCerca(mc.getUserActual(), cercaactual));
		System.out.println("Data Creacio: "+ mc.getContUser().getDataCreacioCerca(mc.getUserActual(), cercaactual));
		System.out.println("Data Modificacio: "+mc.getContUser().getDataModificacioCerca(mc.getUserActual(), cercaactual));
		visualitzarCriterisCerca(cercaactual, true);
		
	}
	
//OPCIONS ADMIN	
	private static void creaAdmin(){
		System.out.println("PANTALLA CREACIO ADMIN:");
		System.out.println("Tria com vols crear el nou administrador: ");
		System.out.println("1. Fer admin a un usuari ja existent ");
		System.out.println("2. Crear un nou usuari admin");
		System.out.println("3. Tornar Enrere");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				ArrayList<String> usuaris =	mc.getContUser().getUsers();
				System.out.println("Aquests son els usuaris registrats: ");
				Iterator<String> it = usuaris.iterator();
				while(it.hasNext()) System.out.println(it.next());
				System.out.print("Escriu el nom del client que vols fer admin: ");
				String nom = s.next();
				if(mc.getContUser().existsUser(nom)) {
					mc.getContUser().addAdmin(nom);				
					System.out.println("Feliciats, aquest usuari ja es administrador, escriu alguna cosa per a continuar ");
				}
				else System.out.println("Aquest usuari ja era admin, clica enter per a continuar");
				s.next();
				opcionsAdmin();
			break;
			case 2:
				crearClient(true);
			break;
			case 3:
				opcionsAdmin();
			break;
			default:
			System.out.println("Opcio erronia, torna a introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
	}
	private static void esborraDades(){System.out.print("Funció no implementada encara ");}
	private static void introduirDesDeFitxer() {System.out.print("Funció no implementada encara ");}
	
	private static void esborraClients() {
		ArrayList<String> usuaris =	mc.getContUser().getUsers();
		System.out.println("Aquests son els usuaris registrats: ");
		Iterator<String> it = usuaris.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.print("Digues el nombre d'usuaris que vols eliminar: ");
		int num = s.nextInt();
		String nom;
		for(int i = 0; i < num; ++i) {
			System.out.print("nom del "+ (i+1) + " usuari a eliminar: ");
			nom = s.next();
			if(!mc.getContUser().removeUser(nom)) System.out.println("error, aquest usuari no s'ha pogut eliminar.");
			else System.out.println("Usuari eliminat");
		}
		opcionsAdmin();
	}
	
	private static void introduirDadesManual() {System.out.print("Funció no implementada encara ");}
//OPCIONS CLIENT + ADMIN	
	private static void buscaEntreCategoriesAdmin() {System.out.print("Funció no implementada encara ");}	
	private static void buscaEntreCategoriesClient() {System.out.print("Funció no implementada encara ");}
	private static void buscarEntreCategoriesPaginesAdmin() {System.out.print("Funció no implementada encara ");}
	private static void buscarEntreCategoriesPaginesClient() {System.out.print("Funció no implementada encara ");}
	private static void buscarEntrePaginesAdmin() {
		System.out.println("PANTALLA DE VISUALITZACIO D'UN ADMIN DE LES PAGINES EXISTENTS:");
		ArrayList<String> pags = mc.getContAdUs().getPagines();
		Iterator<String> it = pags.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Veure una de les pagines ");
		System.out.println("2. Eliminar pagines ");
		System.out.println("3. Enrere ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				System.out.print("Selecciona la pagina que vols visualitzar: ");
				String pag = s.next();
				visualitzarPagina(pag);
				break;
			case 2:
				System.out.print("Escriu quantes pagines vols eliminar:");
				int quantes= s.nextInt();
				String pagin;
				for(int i = 0; i < quantes; ++i){
					System.out.print("Escriu el nom de la pagina que vols eliminar:");
					pagin= s.next();
					mc.getContAdUs().removePag(pagin);
				}
				buscarEntrePaginesAdmin();
				break;
			case 3:
				opcionsAdmin();
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
	}
	private static void buscarEntrePaginesClient() {
		System.out.println("PANTALLA DE VISUALITZACIO D'UN CLIENT DE LES PAGINES EXISTENTS:");
		ArrayList<String> pags = mc.getContAdUs().getPagines();
		Iterator<String> it = pags.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Veure una de les pagines ");
		System.out.println("2. Enrere ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				System.out.print("Selecciona la pagina que vols visualitzar: ");
				String pag = s.next();
				visualitzarPagina(pag);
				break;
			case 2:
				opcionsClient();
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
	}
	private static void crearConjuntComunitats() {
		System.out.println("PANTALLA DE CREACIO D'UNA CERCA DE COMUNITATS:");
		Integer cercaactual= mc.getContUser().addNovaCerca(mc.getUserActual());
		
		System.out.println("Indica amb un numero del 0 al 10 la importancia que li vols donar als seguents criteris: ");
		System.out.println("Atencio! Si es fa servir el criteri de triar un subconjunt de categories, nomes es tindran en compte, a mes a mes, els criteris de relacio i semblança ");
		Integer relacions, sembla, alg, tipus, paraulain, dada;
		ArrayList<String> subconj, evitaCat, evitaPag;
		String pare, paraulast;
		
		System.out.print("Importancia a les relacions entre categories (sent 0 mirar nomes a la relacio entre pagines, 5 totes amb la mateixa importancia i 10 mirar nomes les relacions entre categories, ignorant les pagines ): ");
		relacions= s.nextInt();
		
		System.out.print("Importancia en la semblansa de nom de les categories, sent 0 a no donar-li importancia a que els noms s'assemblint i 10 el maxim de semblanca");
		sembla = s.nextInt();
		
		System.out.println("Importancia que li vols donar a una paraula clau determinada");
		System.out.print("Introdueix la paraula clau: ");
		paraulast = s.next();
		System.out.print("Com de fort vols que la tingui en compte: 0 si no es vol tenir en compte, 5 si han de tenir com a minim mitja paraula igual o 10 si totes l'han de contenir ");
		paraulain = s.nextInt();
		if(paraulain==0) paraulast = null;
		
		System.out.println("Categoria a partir de la qual es vol fer la cerca (nomes es tindran en compte les categories i pagines a partir dels seus fills), escriu null si no en vols cap: ");
		pare = s.next();
		
		System.out.print("Numero de categories a partir de les quals es vol fer la cerca, ignorant la resta. Si no vols restringir, marca 0:");
		int num = s.nextInt();
		subconj = new ArrayList<String>();
		for(int i = 1; i <= num; ++i) {
			System.out.print("Nom de la "+ i + " categoria a tenir en compte: ");
			String nom2 = s.next();
			subconj.add(nom2);
		}
		
		System.out.print("Numero de categories que vols evitar: ");
		int num2 = s.nextInt();
		evitaCat = new ArrayList<String>();
		for(int i = 1; i <= num2; ++i) {
			System.out.print("Nom de la "+ i + " categoria a evitar: ");
			String nom3 = s.next();
			evitaCat.add(nom3);
		}
		
		System.out.print("Numero de Pagines que vols evitar: ");
		int num3 = s.nextInt();
		evitaPag = new ArrayList<String>();
		for(int i = 1; i <= num3; ++i) {
			System.out.print("Nom de la "+ i + " Pagina a evitar: ");
			String nom4 = s.next();
			evitaCat.add(nom4);
		}
		
		System.out.println("Tria amb quin dels tres algorismes vols fer la Cerca: ");
		System.out.println("1. Algorisme Louvain");
		System.out.println("2. Algorisme Newmann-Girvan");
		System.out.println("2. Algorisme Clique percolation");
		System.out.print("Numero d'opció:");
		alg = s.nextInt();
		tipus = dada= 0;
		boolean omplint = true;
		while(omplint) {
			switch(alg) {
			case 1:
				tipus = 0;
				System.out.println("Digues amb un numero del 0 al 100, la dispersió desitjada");
				dada = s.nextInt();
				omplint = false;
				break;
			case 2:
				System.out.println("has seleccionat fer la cerca amb l'algorisme de Newmann-Girvan :");
				System.out.println("Tria entre les seguents opcions:");
				System.out.println("1. Buscar a partir de la dispersió: ");
				System.out.println("2. Buscar a partir d'un nombre de comunitats desitjat");
				System.out.println("3. Buscar a partir de la max Betweenes");
				System.out.print("Numero d'opció:");
				int n = 0;
				n = s.nextInt();
				boolean fet = false;
				while(!fet) {
					switch(n) {
					case 1:
						tipus = 0;
						System.out.print("Digues amb un numero del 0 al 100, la dispersió desitjada: ");
						dada = s.nextInt();
						fet = true;
						break;
					case 2:
						tipus = 1;
						System.out.print("Digues el nombre de comunitats desitjades: ");
						dada = s.nextInt();
						fet = true;
						break;
					case 3:
						tipus = 2;
						System.out.print("Digues la maxima Betweenes desitjada: ");
						dada = s.nextInt();
						fet = true;
						break;
					default:
					System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
					n = s.nextInt();
					break;
					}
				}
				omplint = false;
				break;
			case 3:
				tipus = 0;
				System.out.print("Digues amb un numero del 0 al 100, la dispersió desitjada: ");
				dada = s.nextInt();
				omplint = false;
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
			mc.getContUser().addCriterisCerca(false, mc.getUserActual(), cercaactual, paraulast, paraulain, relacions, sembla, alg, tipus, dada, subconj, evitaCat, evitaPag, pare);
		}
		/*
		Criteris cri = new Criteris();
		cri.setAlgorisme(2);
		cri.setDada(7);
		
		cri.setRelacionsCat(5); // Relacions cat-pg
		cri.setTipuCerca(2); ///???
		ArrayList<Categoria> c2 = new ArrayList<Categoria>(); // Subconjunt
		ArrayList<Categoria> c = new ArrayList<Categoria>(); // Evitar
		ArrayList<Pagina> s = new ArrayList<Pagina>();
		cri.setSubconjCat(c2);
		ParaulaValor utilitzable = new ParaulaValor("se", 0);
		cri.setParaulaClau(utilitzable);
		cri.setEvitaCat(c);
		cri.setEvitaPag(s);
		cri.setSemblaNom(0);
		String sa = new String();
		cri.setPare(sa);
		mc.getConjUsers().getUser(mc.getUserActual()).getCerca(cercaactual).setCriterisSeleccio(cri);*/
		System.out.println("Comença la Cerca de Comunitats, aquest procés pot tardar uns minuts, si us plau, tingues paciencia");
		if(!mc.getContUser().ferCerca(mc.getUserActual(), cercaactual)) System.out.println("Error, no s'ha pogut executar la Cerca");
		else visualitzarNovaCercaComunitats(cercaactual);
	}
	private static void visualitzarConjuntsComunitats(Boolean admin) {
		System.out.println("PANTALLA DE VISUALITZACIO DE CERQUES ANTIGUES:");
		ArrayList<String> cats= mc.getContUser().getCerquesComunitats(mc.getUserActual());
		System.out.println("Els Conjunts de Comunitats antics creats per l'usuari actual son:");
		Iterator<String> it = cats.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			//S'ha de comprovar en quin format surt
		}
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Esborrar una de les Cerques Antigues.");
		System.out.println("2. Entrar en una de les Cerques Antigues.");
		System.out.println("3. Crear una nova Cerca de Comunitats ");
		System.out.println("4. Enrere ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				System.out.print("Digues quina vols eliminar:");
				String elimina = s.next();
				if(!mc.getContUser().removeCerca(mc.getUserActual(), elimina)) System.out.println("No s'ha pogut eliminar");
			break;
			case 2:
				System.out.print("Digues quina vols visualitzar: ");
				String visualitza = s.next();
				visualitzarExistentCercaComunitats(visualitza);
				break;
			case 3:
				crearConjuntComunitats();
				break;
			case 4:
				if(admin) opcionsAdmin();
				else opcionsClient();
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
	}
	
	private static void modificarDadesUser(Boolean admin){
		System.out.println("PANTALLA DE MODIFICACIO DE DADES D'USUARI:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Canviar username");
		System.out.println("2. Canviar password");
		System.out.println("3. Sortir ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				Boolean canviu = true;
				while (canviu) {
					System.out.print("Introdueix el nou nom d'usuari que desitges: ");
					String nom = s.next();
					if(mc.getContUser().existsUser(nom)) System.out.println("Aquest nom d'usuari ja existeix.");
					else {
						Boolean error = mc.getContUser().setUsername(mc.getUserActual(), nom);
						if(!error) System.out.println("Hi ha hagut algun error en intentar canviar el nom, torna a provar mes tard");
						else mc.setUserActual(nom);
						canviu = false;
					}
				}
				break;
			case 2:
				System.out.print("Introdueix la nova contrassenya que desitges: ");
				String pass = s.next();
				mc.getContUser().setPassword(mc.getUserActual(), pass);
				break;
			case 3:
				if(admin) opcionsAdmin();
				else opcionsClient();
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
	}
	
	private static void opcionsAdmin(){
		System.out.println("PANTALLA D'OPCIONS D'ADMIN:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Crear altres administradors");
		System.out.println("2. Esborrar totes les dades");
		System.out.println("3. Introduir dades a partir de fitxers");
		System.out.println("4. Esborrar clients");
		System.out.println("5. Instroduir dades manualment");
		System.out.println("6. Buscar entre les categories ");
		System.out.println("7. Buscar entre les categories i pagines ");
		System.out.println("8. Buscar entre les pagines ");
		System.out.println("9. Crear un nou conjunt de comunitats ");
		System.out.println("10. Visualitzar Conjunts de comunitats realitzats anteriorment ");
		System.out.println("11. Modificar les propies dades d'usuari");
		System.out.println("12. Sortir");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				creaAdmin();
			break;
			case 2:
				esborraDades();
			break;
			case 3:
				introduirDesDeFitxer();
				break;
			case 4:
				esborraClients();
				break;
			case 5:
				introduirDadesManual();
				break;
			case 6:
				buscaEntreCategoriesAdmin();
				break;
			case 7:
				buscarEntreCategoriesPaginesAdmin();
				break;
			case 8:
				buscarEntrePaginesAdmin();
				break;
			case 9:
				crearConjuntComunitats();
				break;
			case 10:
				visualitzarConjuntsComunitats(true);
				break;
			case 11:
				modificarDadesUser(true);
				break;
			case 12:
				pantallaInici();
				break;
			default:
			System.out.print("Opcio erronia, has d'introduir el numero de l'operacio que desitjes: ");
			n = s.nextInt();
			break;
			}
		}
	} 
	private static void opcionsClient(){
		System.out.println("PANTALLA D'OPCIONS DE CLIENT:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Buscar entre les categories ");
		System.out.println("2. Buscar entre les categories i pagines ");
		System.out.println("3. Buscar entre les pagines ");
		System.out.println("4. Crear un nou conjunt de comunitats ");
		System.out.println("5. Visualitzar Conjunts de comunitats realitzats anteriorment ");
		System.out.println("6. Modificar les propies dades d'usuari");
		System.out.println("7. Sortir");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				buscaEntreCategoriesClient();
				break;
			case 2:
				buscarEntreCategoriesPaginesClient();
				break;
			case 3:
				buscarEntrePaginesClient();
				break;
			case 4:
				crearConjuntComunitats();
				break;
			case 5:
				visualitzarConjuntsComunitats(false);
				break;
			case 6:
				modificarDadesUser(false);
				break;
			case 7:
				pantallaInici();
				break;
			default:
			System.out.print("Opcio erronia, has d'introduir el numero de l'operacio que desitjes: ");
			n = s.nextInt();
			break;
			}
		}
	}
	
	
	private static void login() {
		System.out.println("PANTALLA DE LOGIN:");
		System.out.println("Introdueix les dades requerides: ");
		int error=1;		//es una marranada, ja ho se, pero com q es provisional, no ens importa i ho faig aixi
		while(error==1) {
			System.out.print("Username: ");
			String user;
			user = s.next();
			if(!mc.getContUser().existsUser(user)) System.out.println("Aquest usuari no existeix");
			else {
				System.out.print("Password: ");
				String pass;
				pass = s.next();
				if(mc.getContUser().login(user,pass) ){
					error=0;
					mc.setUserActual(user);
					if(mc.getContUser().isAdmin(user) ) opcionsAdmin();
					else opcionsClient();
				}
				else {
					System.out.println("Error, la password es erronia; tria 1 si vols tornar a introduir les dades o 2 si vols sortir");
					int op = s.nextInt();
					if(op==2) pantallaInici();
				}
			}
		}
		
		
	}	
	private static void crearClient(Boolean admin) {
		System.out.println("PANTALLA DE CREACIO DE NOUS CLIENTS:");
		int error=1;
		while (error==1) {
			System.out.print("Introdueix el nom d'usuari que desitgis: ");
			String nom = s.next();
			if(mc.getContUser().existsUser(nom)) System.out.println("Aquest usuari ja existeix.");
			else {
				System.out.print("Introdueix la contrassenya: ");
				String pass = s.next();
				mc.getContUser().addUser(nom, pass);
				if(admin) {
					mc.getContUser().addAdmin(nom);
					opcionsAdmin();
				}
				else {
					mc.setUserActual(nom);
					opcionsClient();
				}
			}
			
		}
	}
	
	private static void pantallaInici() {
		System.out.println("PANTALLA D'INICI:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Login");
		System.out.println("2. Crear Client");
		System.out.println("3. Tancar Programa");
		System.out.print("Numero d'opció:");
		int n=0;
		n = s.nextInt();
		while(true) {
			//System.out.print("Entro al while");
			switch(n) {
				case 1:
					login();
				break;
				case 2:
					crearClient(false);
				break;
				case 3:
					System.exit(0);
				break;
				default:
					System.out.print("Opcio erronia, has d'introduir el numero de l'operacio que desitjes: ");
					n = s.nextInt();
				break;
			}
		}
	}
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		mc = new MacroControlador();
		if(!mc.carregaDades()) System.out.println("Hi ha hagut algun problema al carregar les dades de la wiki");
		if(!mc.carregaUsers()) System.out.println("Hi ha hagut algun problema al carregar les dades dels usuaris");
		/*Categoria aux1 = new Categoria("sexualitat"); // Prova Sexualitat
		Categoria aux2 = new Categoria("asexual");
		GrafDades G = mc.getGraf();
		G.addCC(aux1,aux2);
		Categoria aux3 = new Categoria("heterosexual");
		G.addCC(aux1,aux3);
		Categoria aux4 = new Categoria("homosexual");
		G.addCC(aux1, aux4);
		Categoria aux5 = new Categoria("sexe");
		G.addCC(aux1,aux5);
		Categoria aux6 = new Categoria("embaras");
		G.addCC(aux3,aux6);
		G.addCC(aux5, aux6);
		Categoria aux7 = new Categoria("infertil");
		G.addCC(aux4, aux7);
		G.addCC(aux2, aux7);
		G.addCC(aux3,aux4);*/
		mc.getContUser().addUser("admin", "admin");
		mc.getContUser().addUser("client", "client");
		mc.getContUser().addAdmin("admin");
		System.out.println("Acabes d'entrar al main provisional del projecte de la Wikipedia, es mostraran les mateixes funcionalitats que en el projecte final però en mode consola.");
		System.out.println("Escriu alguna cosa per continuar");
		s.next();
		pantallaInici();
	}
}
