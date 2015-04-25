/**
 * 
 */
package domini;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author cristina.fontanet
 *
 */
public class MainProvisional {
//Declaro els controladors aqui per a poder-los fer servir des de les funcions privades, ja veurem si funciona, en java nse
	 static ControladorUsers cu;
	 static ControladorAdminUsers ca;
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
	 
	private static void EsborraDades(){}
	private static void IntroduirDesDeFitxer() {}
	private static void IntroduirDadesManual() {}
	private static void BuscaEntreCategories(Boolean admin) {}
	private static void BuscarEntreCategoriesPagines(Boolean admin) {}
	private static void BuscarEntrePagines(Boolean admin) {}
	private static void CrearConjuntComunitats() {}
	private static void VisualitzarConjuntsComunitats() {
		
	}
	//private void {}
	
	private static void CreaAdmin(){
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
				OpcionsAdmin();
			break;
			case 2:
				CrearClient(true);
			break;
			case 3:
				OpcionsAdmin();
			break;
			default:
			System.out.println("Opcio erronia, torna a introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
		
	}
	
	private static void EsborraClients() {
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
		OpcionsAdmin();
	}
	
	private static void OpcionsAdmin(){
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
		System.out.println("11. Sortir");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				CreaAdmin();
			break;
			case 2:
				EsborraDades();
			break;
			case 3:
				IntroduirDesDeFitxer();
				break;
			case 4:
				EsborraClients();
				break;
			case 5:
				IntroduirDadesManual();
				break;
			case 6:
				BuscaEntreCategories(true);
				break;
			case 7:
				BuscarEntreCategoriesPagines(true);
				break;
			case 8:
				BuscarEntrePagines(true);
				break;
			case 9:
				CrearConjuntComunitats();
				break;
			case 10:
				VisualitzarConjuntsComunitats();
				break;
			case 11:
				PantallaInici();
				break;
			default:
			System.out.print("Opcio erronia, has d'introduir el numero de l'operacio que desitjes: ");
			n = s.nextInt();
			break;
			}
		}
	} 
	 	 
	private static void OpcionsClient(){
		System.out.println("PANTALLA D'OPCIONS DE CLIENT:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Buscar entre les categories ");
		System.out.println("2. Buscar entre les categories i pagines ");
		System.out.println("3. Buscar entre les pagines ");
		System.out.println("4. Crear un nou conjunt de comunitats ");
		System.out.println("5. Visualitzar Conjunts de comunitats realitzats anteriorment ");
		System.out.println("6. Sortir");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(true) {
			switch(n) {
			case 1:
				BuscaEntreCategories(false);
				break;
			case 2:
				BuscarEntreCategoriesPagines(false);
				break;
			case 3:
				BuscarEntrePagines(false);
				break;
			case 4:
				CrearConjuntComunitats();
				break;
			case 5:
				VisualitzarConjuntsComunitats();
				break;
			case 6:
				PantallaInici();
				break;
			default:
			System.out.print("Opcio erronia, has d'introduir el numero de l'operacio que desitjes: ");
			n = s.nextInt();
			break;
			}
		}
	}
	
	private static void Login() {
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
					if(cu.esAdmin(user) ) OpcionsAdmin();
					else OpcionsClient();
				}
				else {
					System.out.println("Error, la password es erronia; tria 1 si vols tornar a introduir les dades o 2 si vols sortir");
					int op = s.nextInt();
					if(op==2) PantallaInici();
				}
			}
		}
		
		
	}
	
	//admin es true quan el nou client sera admin, fals si es un client normal
	private static void CrearClient(Boolean admin) {
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
				/*System.out.print("User: "+ nom+ " pass: " + pass);
				if(admin)System.out.println("Creo un admin");
				else if(nom==pass) System.out.println("Es un admin apanyat");
				else System.out.println("No sera admin");
				*/
				if(admin) {
					cu.addAdmin(nom);
					OpcionsAdmin();
				}
				else OpcionsAdmin(); //OpcionsClient();
			}
			
		}
	}
	
	private static void PantallaInici() {
		System.out.println("PANTALLA D'INICI:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Login");
		System.out.println("2. Crear Client");
		System.out.println("3. Tancar Programa");
		System.out.print("Numero d'opció:");
		int n=0;
		n = s.nextInt();
		boolean sortida = false;
		while(sortida==false) {
			switch(n) {
				case 1:
					Login();
				break;
				case 2:
					CrearClient(false);
				break;
				case 3:
					sortida=true;
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
		ca = new ControladorAdminUsers();
		ca.inici_carregarDades();
		//+ Cotnroladors
		cu.addUser("admin", "admin");
		cu.addUser("client", "client");
		cu.addAdmin("admin");
		System.out.println("Acabes d'entrar al main provisional del projecte de la Wikipedia, es mostraran les mateixes funcionalitats que en el projecte final però en mode consola.");
		System.out.println("Escriu alguna cosa per continuar");
		s.next();
		PantallaInici();
		
	}

}
