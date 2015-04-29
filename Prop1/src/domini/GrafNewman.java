/**
 * 
 */
package domini;

import java.util.HashSet;
import java.util.Queue;
import java.util.Vector;

/**
 * @author Cristina & Pau
 *
 */
public class GrafNewman extends Graf {
	
	private Queue camiMin(int posiA, int posjA, int posiB, int posjB ){
		return null;	//PAU
	}
	
	protected Vector< Vector<Integer> > NCM;
	int maxi;
	int maxj;
	int maxNumCM;
	
	
	/**
	 * 
	 */
	public GrafNewman() {
		// TODO Auto-generated constructor stub //Cris
	}
	
	//Recalcula el nombre de camins mínims que passen per cada vèrtex, retorna false si hi ha hagut algun error.	
	public Boolean Calculate_edge_between(){	//CRIS
		camiMin(1,2,3,4);
		//Calcula el cami minim de cada node cap a tots els nodes
		
		//un cop trobat cada cami minim, sumar 1 a la pos de NCM
		//mantenir el vertex per on passen mes camins minims (variables maxi, maxj i maxNumCM)
		return null;
	}

	//Fa la inversa dels pesos de les arestes del graf, retorna false si hi ha hagut algun error.	
	public Boolean Invertir_pesos(){
		return null; //Cris
	}

	//Esborra l’aresta per la que passen més camins mínims de tot el graf, retorna false si hi ha hagut algun error.
	public Boolean esborrar_maxim(){
		//del Graf "original", eliminem (posar a null, infinit o lu q sigui) del graf de pesos la posicio que indiqui la variable maxNumCM i la posem a 0 
		return null; //Cris
	}

	//Retorna el nombre de comunitats en les quals està dividit el graf o 1 en cas d’error.
	public Integer Num_comunitats(){
		return null; //Pau
	} 

	//Retorna el conjunt de comunitats existents.
	public HashSet<HashSet<String>> comunitats(){
		return null; //Pau
	}

	
}
