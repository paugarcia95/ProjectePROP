/**
 * 
 */
package domini;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import sun.security.util.Password;

/**
 * @author cristina.fontanet
 *
 */
public class MainProvisional {
//Declaro els controladors aqui per a poder-los fer servir des de les funcions privades, ja veurem si funciona, en java nse
	 ControladorUsers cu;
	 String useractual;
	 Scanner s = new Scanner(System.in);
	//+ Cotnroladors
	 
	 
/*
 		System.out.println("PANTALLA :");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println(" ");
		System.out.print("Numero d'opció:");
		int n = 0;
		n = s.nextInt();
		while(1<=n && n <= ) {
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
	 
	private void EsborraDades(){}
	private void IntroduirDesDeFitxer() {}
	private void IntroduirDadesManual() {}
	private void BuscaEntreCategories(Boolean admin) {}
	private void BuscarEntreCategoriesPagines(Boolean admin) {}
	private void BuscarEntrePagines(Boolean admin) {}
	private void CrearConjuntComunitats() {}
	private void VisualitzarConjuntsComunitats() {}
	//private void {}
	
	private void CreaAdmin(){
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
				String nom = s.nextLine();
				if(cu.existsUser(nom)) {
					cu.addAdmin(nom);				
					System.out.print("Feliciats, aquest usuari ja es administrador ");
				}
				OpcionsAdmin();
			break;
			case 2:
				CrearClient(true);
			break;
			default:
			System.out.println("Opcio erronia, has d'introduir el numero de l'operacio que desitjes:");
			n = s.nextInt();
			break;
			}
		}
		
	}
	
	private void EsborraClients() {
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
			System.out.print("nom del "+ i + " usuari a eliminar: ");
			nom = s.nextLine();
			if(! cu.removeUser(nom)) System.out.println("error, aquest usuari no s'ha pogut eliminar.");	
		}
		OpcionsAdmin();
	}
	
	private void OpcionsAdmin(){
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
		while(1<=n && n <=8) {
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
	 	 
	private void OpcionsClient(){
		System.out.println("PANTALLA D'OPCIONS D'ADMIN:");
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
		while(1<=n && n <=6) {
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
	
	private void Login() {
		System.out.println("PANTALLA DE LOGIN:");
		System.out.println("Introdueix les dades requerides: ");
		int error=1;		//es una marranada, ja ho se, pero com q es provisional, no ens importa i ho faig aixi
		while(error==1) {
			System.out.print("Username: ");
			String user;
			user = s.nextLine();
			System.out.print("Password: ");
			Password pass;
			//he de trobar la manera de llegir la password pass.readPassword(am);
			if( cu.login(user,pass) ){
				error=0;
				useractual = user;
				if(cu.esAdmin(user) ) OpcionsAdmin();
				else OpcionsClient();
			}
			else {
				System.out.println("Error, o l'usuari no existeix o la password es erronia; tria 1 si vols tornar a introduir les dades o 2 si vols sortir");
				int op = s.nextInt();
				if(op==2) PantallaInici();
			}
		}
		
		
	}
	
	//admin es true quan el nou client sera admin, fals si es un client normal
	private void CrearClient(Boolean admin) {
		System.out.println("PANTALLA DE CREACIO DE NOUS CLIENTS:");
		int error=1;
		while (error==1) {
			System.out.print("Introdueix el nom d'usuari que desitgis: ");
			String nom = s.nextLine();
			if(cu.existsUser(nom)) System.out.println("Aquest usuari ja existeix.");
			else {
				System.out.print("Introdueix la contrassenya: ");
				Password pass;
				//cin password
				cu.addUser(nom, pass);
				if(admin) { 
					cu.addAdmin(nom);
					OpcionsAdmin();
				}
				else OpcionsClient();
			}
			
		}
	}
	
	private void PantallaInici() {
		System.out.println("PANTALLA D'INICI:");
		System.out.println("Tria entre les seguents opcions:");
		System.out.println("1. Login");
		System.out.println("2. Crear Client");
		System.out.println("3. Tancar Programa");
		System.out.print("Numero d'opció:");
		int n=0;
		n = s.nextInt();
		while(n>=1 && n<=3) {
			switch(n) {
				case 1:
					Login();
				break;
				case 2:
					CrearClient(false);
				break;
				case 3:
					n=40;		//la intenció és retornar al main i acabar el programa, segur q hi ha maners mes maques de fer-ho.
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
	public  void main(String[] args) {
		cu = new ControladorUsers();
		//+ Cotnroladors
		System.out.println("Acabes d'entrar al main provisional del projecte de la Wikipedia, es mostraran les mateixes funcionalitats que en el projecte final però en mode consola.");
		System.out.println("Prem enter per continuar");
		s.next();
		PantallaInici();
		
	}
	
	
	/*public class Main {

		  public static void main(String[] args) {
		    GA ga = new GA();
		    ga.algoritmoGenetico();
		  }
-------------		 
char c;
int n;
cin >> c >> n;
----------------
Scanner s = new Scanner(System.in);
char c = s.findInLine(".").charAt(0);
int n = s.nextInt();
--------------------
		}*/

}
