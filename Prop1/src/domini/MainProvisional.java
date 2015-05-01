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
	 static ControladorUsers cu;
	 static ControladorAdminUsers cau;
	 static String useractual;
	 static Scanner s = new Scanner(System.in);
	//+ Cotnroladors
	 
	 
/*
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
	 
	private static void esborraDades(){}
	private static void introduirDesDeFitxer() {}
	private static void introduirDadesManual() {}
	private static void buscaEntreCategories(Boolean admin) {}
	private static void buscarEntreCategoriesPagines(Boolean admin) {}
	private static void buscarEntrePagines(Boolean admin) {}
	private static void visualitzarCategoria(String quina){}

	private static void visualitzarCercaComunitats(String quina, Boolean admin) {
		Integer cercaactual = cu.getNumCerca(quina);
		System.out.println(" ");
		System.out.println("PANTALLA DE VISUALITZACIO D'UNA CERCA DE COMUNITATS");
		System.out.println("Nom de la cerca: "+ cu.getNomCerca(useractual, cercaactual));
		System.out.println("Comentari: "+cu.getComentariCerca(useractual, cercaactual));
		System.out.println("Data Creacio: "+ cu.getDataCreacioCerca(useractual, cercaactual));
		System.out.println("Data Modificacio: "+cu.getDataModificacioCerca(useractual, cercaactual));
		System.out.println("Criteris de cerca: ");
		Integer alg = cu.getAlgCerca(useractual, cercaactual);
		Integer dada = cu.getAlgDadaCerca(useractual, cercaactual);
			if(alg==1) {
				System.out.println("	1. Algorisme: Louvain ");
				System.out.println("	2. Amb el percentatge de dispersio: "+dada);
			}
			else if(alg==2) {
				System.out.println("	1. Algorisme: Newmann-Girvan ");
				Integer tipu = cu.getAlgTipuCerca(useractual, cercaactual);
				if(tipu==0) System.out.println("	2. Amb el percentatge de dispersio: "+dada);
				else if(tipu==1) System.out.println("2. Amb el numero de comunitats: "+dada);
				else System.out.println("	2. Amb el maxim Between: "+dada);
			}
			else {
				System.out.println("	1. Algorisme: Clique percolation ");
				System.out.println("	2. Amb el percentatge de dispersio: "+dada);
			}
		System.out.println("	3. Amb la importancia a les relacions entre categories: "+cu.getRelacioCerca(useractual, cercaactual));
		System.out.println(" 	4. Amb la importancia entre la semblansa dels noms: "+cu.getSembCerca(useractual, cercaactual));
		System.out.println("	5. Amb " +cu.getParaulaImpCerca(useractual, cercaactual)+ " importancia a la paraula clau "+cu.getParaulaClauCerca(useractual, cercaactual));
		System.out.println(" 	6. Categoria a partir de la qual s'ha fet la cerca: "+cu.getPareCerca(useractual, cercaactual));
		System.out.println(" 	7. Restringida a les comunitats:");
		ArrayList<String> aux = cu.getSubCerca(useractual, cercaactual);
		Iterator<String> it = aux.iterator();
		while(it.hasNext()) System.out.println(it.next());
		
		System.out.println(" 	8. Evitant les comunitats: ");
		aux = cu.getEvitaCerca(useractual, cercaactual);
		Iterator<String> it2 = aux.iterator();
		while(it2.hasNext())System.out.println(it.next());
		
		Integer numcom =  cu.getNumComunitatsCerca(useractual, cercaactual);
		System.out.println("Hi ha "+numcom+ " comunitats: ");
		for(Integer i = 1; i <= numcom; ++i) {
			System.out.println("	A la " + i+ " comunitat hi ha les categories: ");
			Integer comunitat = cu.getNumCatCerca(useractual, cercaactual, i-1);
			for (Integer j = 0; j < comunitat; ++j) {
				Set<String> aux1 = cu.getCatCerca(useractual, cercaactual, i-1);
				Iterator<String> it3 = aux1.iterator();
				while(it3.hasNext())System.out.println(it.next());
			}
		}
		
		
		
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Modificar Cerca");		
		System.out.println("2. Eliminar Cerca ");
		System.out.println("3. Visualitzar Categoria");
		System.out.println("4. Enrere ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				System.out.println("Tria entre les seguents opcions de modificacio:");
				System.out.println("1. Modificar el nom de la Cerca ");
				System.out.println("2. Modificar el comentari ");
				System.out.println("3. Modificar els criteris ");
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
						cu.addNomCerca(useractual, cercaactual, nom);
						break;
					case 2:
						
						break;
					case 3:
						
						break;
					case 4:
						modifica = false;
						break;
					default:
					System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
					n1 = s.nextInt();
					break;
					}
				}
				break;
			case 2:
				if(!cu.removeCerca(useractual, quina)) System.out.println("No s'ha pogut eliminar");
				break;
			case 3:
				System.out.print("Escriu el nom de la categoria que vols visualitzar: ");
				String categor = s.next();
				visualitzarCategoria(categor);
				break;
			case 4:
				if(admin) opcionsAdmin();
				else opcionsClient();
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n1 = s.nextInt();
			break;
			}
		}
		
	}
	
	private static void crearConjuntComunitats(Boolean admin) {
		System.out.println("PANTALLA DE CREACIO D'UNA CERCA DE COMUNITATS:");
		Integer cercaactual= cu.novaCerca(useractual);
		System.out.print("Indica el nom que li vols posar a la nova cerca: ");
		String nom = s.next();
		cu.addNomCerca(useractual, cercaactual, nom);
		
		System.out.println("Indica amb un numero del 0 al 10 la importancia que li vols donar als seguents criteris: ");
		Integer relacions, sembla, alg, tipus, paraulain, dada;
		ArrayList<Categoria> subconj, evita;
		String pare, paraulast;
		
		System.out.print("Importancia a les relacions entre categories: ");
		relacions= s.nextInt();
		
		System.out.print("Importancia en la semblansa de nom de les categories");
		sembla = s.nextInt();
		
		System.out.println("Importancia que li vols donar a una paraula clau determinada");
		System.out.print("Introdueix la paraula clau: ");
		paraulast = s.next();
		System.out.print("Com de fort vols que la tingui en compte: ");
		paraulain = s.nextInt();
		
		System.out.println("Categoria a partir de la qual es vol fer la cerca (nomes es tindran en compte les categories i pagines a partir dels seus fills): ");
		pare = s.next();
		
		System.out.print("Numero de categories a partir de les quals es vol fer la cerca, ignorant la resta. Si no vols restringir, marca 0:");
		int num = s.nextInt();
		for(int i = 1; i <= num; ++i) {
			System.out.print("Nom de la "+ i + " categoria a tenir en compte: ");
			String nom2 = s.next();
		//	subconj.add(nom);
		}
		
		System.out.print("Numero de categories que vols evitar: ");
		int num2 = s.nextInt();
		for(int i = 1; i <= num; ++i) {
			System.out.print("Nom de la "+ i + " categoria a evitar: ");
			String nom3 = s.next();
		//	evita.add();
		}
		
		System.out.println("Tria amb quin dels tres algorismes vols fer la Cerca: ");
		System.out.println("1. Algorisme Louvain");
		System.out.println("2. Algorisme Newmann-Girvan");
		System.out.println("2. Algorisme Clique percolation");
		System.out.print("Numero d'opció:");
		alg = s.nextInt();
		while(true) {
			switch(alg) {
			case 1:
				tipus = 0;
				System.out.println("Digues amb un numero del 0 al 100, la dispersió desitjada");
				dada = s.nextInt();
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
						break;
					case 2:
						tipus = 1;
						System.out.print("Digues el nombre de comunitats desitjades: ");
						dada = s.nextInt();
						break;
					case 3:
						tipus = 2;
						System.out.print("Digues la maxima Betweenes desitjada: ");
						dada = s.nextInt();
						break;
					default:
					System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
					n = s.nextInt();
					break;
					}
				}
				break;
			case 3:
				tipus = 0;
				System.out.print("Digues amb un numero del 0 al 100, la dispersió desitjada: ");
				dada = s.nextInt();
				break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
			cu.addCriterisCerca(false, useractual, cercaactual, paraulast, paraulain, relacions, sembla, alg, tipus, dada, subconj, evita, pare);
		}
		System.out.println("Escriu sense espais el comentari que vulguis guardar: ");
		String com = s.next();
		cu.addComentariCerca(useractual, cercaactual, com);
	}
	
	private static void visualitzarConjuntsComunitats(Boolean admin) {
		System.out.println("PANTALLA DE VISUALITZACIO DE CERQUES ANTIGUES:");
		ArrayList<String> cats= cu.getCerquesComunitats(useractual);
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
				if(!cu.removeCerca(useractual, elimina)) System.out.println("No s'ha pogut eliminar");
			break;
			case 2:
				System.out.print("Digues quina vols visualitzar: ");
				String visualitza = s.next();
				visualitzarCercaComunitats(visualitza, admin);
				break;
			case 3:
				crearConjuntComunitats(admin);
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
	//private void {}
	
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
					if(cu.existsUser(nom)) System.out.println("Aquest nom d'usuari ja existeix.");
					else {
						Boolean error = cu.setUsername(useractual, nom);
						if(!error) System.out.println("Hi ha hagut algun error en intentar canviar el nom, torna a provar mes tard");
						else useractual = nom;
						canviu = false;
					}
				}
				break;
			case 2:
				System.out.print("Introdueix la nova contrassenya que desitges: ");
				String pass = s.next();
				cu.setPassword(useractual, pass);
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
				ArrayList<String> usuaris =	cu.getUsers();
				System.out.println("Aquests son els usuaris registrats: ");
				Iterator<String> it = usuaris.iterator();
				while(it.hasNext()) System.out.println(it.next());
				System.out.print("Escriu el nom del client que vols fer admin: ");
				String nom = s.next();
				if(cu.existsUser(nom)) {
					cu.addAdmin(nom);				
					System.out.println("Feliciats, aquest usuari ja es administrador, clica enter per a continuar ");
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
	
	private static void esborraClients() {
		ArrayList<String> usuaris =	cu.getUsers();
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
			if(! cu.removeUser(nom)) System.out.println("error, aquest usuari no s'ha pogut eliminar.");
			else System.out.println("Usuari eliminat");
		}
		opcionsAdmin();
	}
	
	private static void opcionsAdmin(){
		System.out.println("PANTALLA D'OPCIONS D'ADMIN:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Crear altres administradors");
		System.out.println("2. Esborrar totes les dades");
		System.out.println("3. Introduir dades a partir de fitxers");
		System.out.println("4. Esborrar clients ");
		System.out.println("5. Instroduir dades manualment ");
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
				buscaEntreCategories(true);
				break;
			case 7:
				buscarEntreCategoriesPagines(true);
				break;
			case 8:
				buscarEntrePagines(true);
				break;
			case 9:
				crearConjuntComunitats(true);
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
				buscaEntreCategories(false);
				break;
			case 2:
				buscarEntreCategoriesPagines(false);
				break;
			case 3:
				buscarEntrePagines(false);
				break;
			case 4:
				crearConjuntComunitats(false);
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
			if(!cu.existsUser(user)) System.out.println("Aquest usuari no existeix");
			else {
				System.out.print("Password: ");
				String pass;
				pass = s.next();
				if(cu.login(user,pass) ){
					error=0;
					useractual = user;
					if(cu.esAdmin(user) ) opcionsAdmin();
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
	
	//admin es true quan el nou client sera admin, fals si es un client normal
	private static void crearClient(Boolean admin) {
		System.out.println("PANTALLA DE CREACIO DE NOUS CLIENTS:");
		int error=1;
		while (error==1) {
			System.out.print("Introdueix el nom d'usuari que desitgis: ");
			String nom = s.next();
			if(cu.existsUser(nom)) System.out.println("Aquest usuari ja existeix.");
			else {
				System.out.print("Introdueix la contrassenya: ");
				String pass = s.next();
				cu.addUser(nom, pass);
				if(admin) {
					cu.addAdmin(nom);
					opcionsAdmin();
				}
				else opcionsClient();
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
		cu = new ControladorUsers();
		cau = new ControladorAdminUsers();
		cau.inici_carregarDades();
		//+ Cotnroladors
		cu.addUser("admin", "admin");
		cu.addUser("client", "client");
		cu.addAdmin("admin");
		System.out.println("Acabes d'entrar al main provisional del projecte de la Wikipedia, es mostraran les mateixes funcionalitats que en el projecte final però en mode consola.");
		System.out.println("Escriu alguna cosa per continuar");
		s.next();
		pantallaInici();
		
	}

}
