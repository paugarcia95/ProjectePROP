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
	
	
	private Vector< Vector<Integer> > NCM;
	@SuppressWarnings("unused")
	private Integer maxi;
	@SuppressWarnings("unused")
	private Integer maxj;
	private Integer maxNumCM;
	
	private class Aresta {			//NSE SI ES POT FER D'UNA ALTRA MANERA! (CRIS)
	    public Integer posi; 
	    public Integer posj;   
	 };
	
	//Calcula el camí minim des del node posiA-posjA a el node posiB-posjB, retorna una cua de les arestes per on passa
	private Queue<Aresta> camiMin(int nodeA, int nodeB ){
		return null;	//PAU
	}
	
	
	/**
	 * Creadora per defecte.
	 */
	public GrafNewman() { //Cris
		super();
		NCM = new Vector< Vector<Integer> > (super.Matriu.size() );	//crea NCM de la mateixa mida que Matriu
		maxNumCM = maxi = maxj = 0;
	}
	
	/**
	 *  Calcula el nombre de camins minims que passen per cada vertex.
	 * @return true si s'ha pogut calcular tot correctament, false si hi ha hagut algun error.
	 */
	public Integer getMaxBet() {
		return maxNumCM;
	}
	/**
	 *  Calcula el nombre de camins minims que passen per cada vertex.
	 * @return true si s'ha pogut calcular tot correctament, false si hi ha hagut algun error.
	 */
	public Boolean Calculate_edge_between(){	//CRIS
		if(NCM.size() < 2) return false;
		//Posem a 0 tots els camins minims per "començar" la nova ronda
		for(int i = 0; i < NCM.size(); ++i) {
			for(int j = 0; i < NCM.size();++j) NCM.get(i).set(j,0);
		}
		//Calcula el cami minim de cada node cap a tots els nodes
		for(int i = 0; i < NCM.size(); ++i) {
			for(int j = 0; i < NCM.size(); ++j) {
				if(i !=j) {
					Queue<Aresta> cami = camiMin(i,j); 
					//un cop trobat cada cami minim, sumar 1 a la pos de NCM
					if(cami.size()>0) {
						Iterator<Aresta> itc = cami.iterator();
						while (itc.hasNext()) {
							Aresta aux = itc.next();
							Integer act = NCM.get(aux.posi).get(aux.posj);
							NCM.get(aux.posi).set(aux.posj,act+1);
							//mantenir el vertex per on passen mes camins minims (variables maxi, maxj i maxNumCM)
							if(maxNumCM <= act) { maxi = aux.posi; maxj = aux.posj; }
						}
					}
				}
		}}
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
