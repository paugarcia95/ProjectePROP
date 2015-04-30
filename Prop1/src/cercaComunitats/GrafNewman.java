/**
 * 
 */
package cercaComunitats;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;

/**
 * @author Cristina & Pau
 *
 */
public class GrafNewman extends Graf {
	
	protected Vector< Vector<Integer> > NCM;
	int maxi;
	int maxj;
	int maxNumCM;
	
	class Aresta {			//NSE SI ES POT FER D'UNA ALTRA MANERA! (CRIS)
	    public Integer posi; 
	    public Integer posj;   
	 };
	
	//Calcula el camí minim des del node posiA-posjA a el node posiB-posjB, retorna una cua de les arestes per on passa
	private Queue<Aresta> camiMin(int nodeA, int nodeB ){
		return null;	//PAU
	}
	
	
	/**
	 * 
	 */
	public GrafNewman() { //Cris
		// TODO Auto-generated constructor stub 
	}
	
	//Recalcula el nombre de camins mínims que passen per cada vèrtex, retorna false si hi ha hagut algun error.	
	public Boolean Calculate_edge_between(){	//CRIS
		//Posem a 0 tots els camins minims per "començar" la nova ronda
		for(int i = 0; i < NCM.size(); ++i) {
			for(int j = 0; i < NCM.size();++j) {
				NCM.get(i).set(j,0);
			}
		}
		//Calcula el cami minim de cada node cap a tots els nodes
		for(int i = 0; i < NCM.size(); ++i) {
			for(int j = 0; i < NCM.size();++j) {
				if(i !=j ) {
					Queue<Aresta> cami = camiMin(i,j); 
					Iterator<Aresta> itc = cami.iterator();
					while (itc.hasNext()) {
						//Aresta aux = 
						//NCM.get(itc.)
					}
				}
			}
		}
		
		//un cop trobat cada cami minim, sumar 1 a la pos de NCM
		//mantenir el vertex per on passen mes camins minims (variables maxi, maxj i maxNumCM)
		return null;
	}

	//Fa la inversa dels pesos de les arestes del graf, retorna false si hi ha hagut algun error.	
	public Boolean Invertir_pesos(){ //Cris
		int mida = Matriu.size();
		if(mida < 2) return false;
		else {
			for(int i = 0;i < mida; ++i) {
				for(int j = 0; j < mida; ++j) {
					double act = Matriu.get(i).get(j);
					Matriu.get(i).set(j,1/act);
				}
			}
			return true;
		} 
	}

	//Esborra l’aresta per la que passen més camins mínims de tot el graf, retorna false si hi ha hagut algun error.
	public Boolean esborrar_maxim(){ //Cris
		//del Graf "original", eliminem (posar a null, infinit o lu q sigui) del graf de pesos la posicio que indiqui la variable maxNumCM i la posem a 0 
		
		return null; 
	}

	//Retorna el nombre de comunitats en les quals està dividit el graf o 1 en cas d’error.
	public Integer Num_comunitats(){ //Pau
		return null; 
	} 

	//Retorna el conjunt de comunitats existents.
	public HashSet<HashSet<String>> comunitats(){ //Pau
		return null; 
	}

	
}
