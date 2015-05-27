/**
 * 
 */
package domini;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import cercaComunitats.AlgorismeNewmanGirvan;
import cercaComunitats.Clique;
import cercaComunitats.Graf;
import cercaComunitats.Louvain;


/**
 * @author Rafa
 *
 */
public class TraduccioiAlgorisme {

	
	  private static double similarity(String s1, String s2) {
	        Double solu = new Double (0);
	        

	        if(s2.indexOf(s1) != -1) { //Si l'inclou sencer
	        	solu += s1.length();
	        	return solu;
	        }
	        if(s1.indexOf(s2) != -1) {//Si l'inclou sencer
	        	solu += s2.length();
	        	return solu;
	        }
	        
	        String ayuda = s1.substring(0,s1.length()/2);
	        if(s2.indexOf(ayuda) != -1) {//Si l'inclou partit
	        	solu += ayuda.length();
	        	return solu;
	        }
	        ayuda = s2.substring(0,s2.length()/2);
	        if(s1.indexOf(ayuda) != -1){//Si l'inclou partit
	        	solu += ayuda.length();
	        	return solu;
	        }
	        ayuda = s1.substring(s1.length()/2,s1.length());
	        if(s2.indexOf(ayuda) != -1){//Si l'inclou partit ( altre meitat)
		        solu += ayuda.length();
		        return solu;
		    }
	        ayuda = s2.substring(s2.length()/2,s2.length());
		    if(s1.indexOf(ayuda) != -1) {//Si l'inclou partit ( altre meitat)
		    	solu += ayuda.length();
		    	return solu;
	        }
	        
	        return solu;
	    }
	
	
	/**
	 * Calcula el pes entre dues categories donades
	 * @param c1 Categoria primera
	 * @param c2 Categoria segona
	 * @param cri Criteris passats
	 * @return Retorna el pes de la relacio entre les dues categories C1 i C2
	 */
	  
	/*private Double calcularpespares(Categoria c1, Categoria c2, Criteris cri, GrafDades graf){
		Double solucio = new Double(0);
		Integer temp2 = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg FUTUR CANVI DE VARIABLE PER AQUEST CRITERI
		Map<String, Categoria> mapcatsubcat = graf.getCategoria(c1.getNom()).getMapCSupC(); //Adquireixo totes les seves supercategories
		Map<String, Categoria> mapcatsubcat2 = graf.getCategoria(c2.getNom()).getMapCSupC(); //Adquireixo totes les seves supercategories
		for(Categoria e : mapcatsubcat.values()) { // Per a cadascuna de les seves supercategories
			for(Categoria s : mapcatsubcat2.values()) { // Per a cadascuna de les seves supercategories
				if(e.getNom().equals(s.getNom())) { // Si el pare es el mateix
					if(temp2 == 5) solucio += 5;
					else if(temp2 > 5) solucio += (5+(temp2-5));
					else solucio += 5-(5-temp2);
				}
			}
		}
		return solucio;
	}*/
	private Double calcularpesentrecategories(Categoria c1, Categoria c2, Criteris cri){
		Double solucio = new Double(0);	
		
		////////////**************Criteri de cat-cat i cat-pg********/////////////
		Integer temp = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg
		if(temp == 5) solucio += 5;
		else if(temp > 5) solucio += (5+(temp-5));
		else solucio += 5-(5-temp);
		/////////////*********************************************///////////
		
		
		/////////// Criteri Semblança //////////////////
		if(cri.getSemblaNom() != 0) { // Si  està actiu
			Double aux = similarity(c1.getNom(),c2.getNom());
			solucio += cri.getSemblaNom()*aux;
		}
		/////////////////////////////////////////////////
		
		if(solucio < 0) solucio = 0.0; // Evitem que suigi negatiu
		return solucio;
	}
	
	
	/**
	 * Calcula el pes entre dues categories que apunten a una mateixa pagina
	 * @param cri Criteri passat
	 * @return Retorna el pes que ha de tenir la relacio
	 */
	private Double calcularpesentrecatpag(Criteris cri) {
		Double solucio = new Double(0);	
		
		////////////**************Criteri de cat-cat i cat-pg********/////////////
		Integer temp = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg
		if(temp == 5) solucio += 5;
		else if(temp > 5) solucio += 5-(temp-5);
		else solucio += (5+(5-temp));
		/////////////*********************************************///////////
		
		
		if(solucio < 0) solucio = 0.0; // Evitem que suigi negatiu
		return solucio;
		
	}
	
	/**
	 * Diu si una relacio és "artificial",e sa  dir, creades per sub/sup categories comuns
	 * @param c1 Categoria c2 Categoria
	 * @return True si es artificial, false si no ho és
	 */
	private Boolean mirarartificial(Categoria c1, Categoria c2, Map<String,ArrayList<String>> jacreat) {
		ArrayList<String> aux = jacreat.get(c1.getNom());
		if(aux != null && aux.contains(c2.getNom())) return true;
		ArrayList<String> aux2 = jacreat.get(c2.getNom());
		if(aux2 != null && aux2.contains(c1.getNom())) return true;
		return false;
	}
	
	
	
	/**
	 * Transforma un graf de dades a un graf
	 * @param graf GrafDades que hem de transformar
	 * @param cri Criteris passats
	 * @return Retorna un graf transformat a partir de l'original
	 */
	public Graf grafdadestograf (GrafDades graf, Criteris cri) {
		Graf solucio = new Graf();
		Collection<Categoria> llistat = graf.getCategories();
		
		///////////////////////ANEM A AFEGIR ELS NODES AL GRAF //////////////////////////
		
		if(cri.getSubconjCat().size() != 0) {// Si aquest criteri està actiu...(subconjunt)
			for(Categoria cataux : llistat) {
				if(cri.getSubconjCat().contains(cataux.getNom())) {// I està a la llista d'acceptats
					solucio.addNode(cataux.getNom()); // L'afegim
				}
			}
		}
		else { // Si no està actiu el criteri de subconjunt, fem servir la resta
			if(cri.getParaulaClau().getNum() != 0) { // Si està activat el criteri de paraula clau
				if(cri.getParaulaClau().getNum() == 5) {
					String ayuda = cri.getParaulaClau().getParaula().substring(0, (cri.getParaulaClau().getParaula().length())/2); // Partim la paraula /2
					for(Categoria cataux : llistat) { // Recorrem els nodes
						if(cataux.getNom().indexOf(ayuda) != -1) { // Si la paraula/2 està inclosa al nom de la categoria
							solucio.addNode(cataux.getNom()); //L'afegim al graf
						}
					}
				}
				else { // Si el criteri val 10 és molt estricte
					String ayuda = cri.getParaulaClau().getParaula();
					for(Categoria cataux : llistat) {
						if(cataux.getNom().indexOf(ayuda) != -1) { // mirem q continguin exactament aquella paraula
							solucio.addNode(cataux.getNom());
						}
					}
				}
			}
			else {
				if(cri.getPare().length() != 0) { // Criteri Pare actiu
					Map<String, Categoria> mapcatsubcat = graf.getCategoria(cri.getPare()).getMapCSubC(); //Adquireixo totes les seves subcategories de pare
					Stack<String> pila = new Stack<String>(); // Monto una pila
					Stack<String> visitats = new Stack<String>(); // Monto una pila
					visitats.push(cri.getPare()); // Fico al pare com a visitat
					for(Categoria e : mapcatsubcat.values()) { // Per a cadascuna de les seves subcategories
						pila.push(e.getNom()); // Les guardo a la pila;
						visitats.push(e.getNom());//Guardo també els seus fills com a visitats
					}
					solucio.addNode(cri.getPare()); /// Afageixo al pare al node solució
					while(!pila.isEmpty()){
						String aux = new String(pila.peek());
						pila.pop();
						solucio.addNode(aux);
						Map<String, Categoria> mapcatsubcat2 = graf.getCategoria(aux).getMapCSubC();
						for(Categoria e2 : mapcatsubcat2.values()) { // Per a cadascuna de les seves subcategories
							if(!visitats.contains(e2.getNom()))  pila.push(e2.getNom()); // Les guardo a la pila;
						}
					}
				}
				else { // Si no hi ha cap criteri, ho afegim tot
					for(Categoria cataux : llistat) {
						solucio.addNode(cataux.getNom());
					}
				}
			}
			
			if(cri.getEvitaCat().size() != 0) { // Si el criteri d'ignorar està actiu
				HashSet<String> llistatactual = solucio.getNodes(); // Agafo tots els nodes afegits fins llavors
				for(String it : llistatactual) {
					if(cri.getEvitaCat().contains(it)) { // Miro si estan a la llista d'ignorats
						solucio.removeNode(it); // I l'elimino si escau
					}
				}
			}
		}
		////////////////////////FI AFEGIR NODES////////////////////////////
		
		
		///////////////ANEM A CREAR LES ARESTES AMB PESOS////////////////////////
		
		//////////////////ENTRE SUBCATEGORIES////////////////////////
		HashSet<String> llistatactual = solucio.getNodes(); // Llista dels nodes a Solució (Graf)
		for(String it : llistatactual) { // Per a cada node del graf( a seques)
			Map<String, Categoria> mapcatsubcat = graf.getCategoria(it).getMapCSubC(); //Adquireixo totes les seves subcategories
			for(Categoria e : mapcatsubcat.values()) { // Per a cadascuna de les seves categories
				if(solucio.existeixNode(e.getNom()) && !solucio.existeixAresta(it, e.getNom()) && !solucio.existeixAresta(e.getNom(), it)) { // Miro si està al graf Solució
					solucio.addAresta(it, e.getNom(), calcularpesentrecategories(graf.getCategoria(it),e,cri)); // I si hi està, afageixo el pes
				} // ESTO ES CREAR UNICAMENTE LAS RELACIONES ENTRE SUBCATS
			}
		}
		
		/////////////// CREAR RELACIONS ENTRE LES SUBCATS DE UNA CAT ////////////
		
		for(String it : llistatactual) { // Per a cada node del graf( a seques)
			Map<String,ArrayList<String>> jacreat = new HashMap<String,ArrayList<String>>();
			Map<String, Categoria> mapcatsubcat = graf.getCategoria(it).getMapCSubC(); 
			for (Categoria s : mapcatsubcat.values()) { // RELACIONES ENTRE SI LES SUBCATS DE IT
				for (Categoria q : mapcatsubcat.values()) {
					if(!s.getNom().equals(q.getNom())) {
						if(solucio.addAresta(s.getNom(), q.getNom(), calcularpesentrecategories(s,q,cri))){ // Si no existeix l'aresta la creem
							ArrayList<String> aux = jacreat.get(s.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL"
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							
							ArrayList<String> aux2 = jacreat.get(q.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL"
							if(aux2 == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(s.getNom());
								jacreat.put(q.getNom(), aux3);
							}
							else {
								aux2.add(s.getNom());
								jacreat.put(q.getNom(), aux2);
							}
						}
						else if(!mirarartificial(s,q,jacreat)) { // En el cas de q no hagi pogut crear l'aresta perq aquesta ja existia, mirem si No era artificial
							ArrayList<String> aux = jacreat.get(s.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL" ( tot i q no ho sigui, ho maquem)
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							
							ArrayList<String> aux2 = jacreat.get(q.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL"
							if(aux2 == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(s.getNom());
								jacreat.put(q.getNom(), aux3);
							}
							else {
								aux2.add(s.getNom());
								jacreat.put(q.getNom(), aux2);
							}
							
							Double temp = solucio.getPes(s.getNom(), q.getNom());
							temp += calcularpesentrecategories(s,q,cri);
							System.out.println("UNO ES" + s.getNom() +" Y MAS "+ q.getNom() + " VALORSITO " +temp);
							solucio.setPes(s.getNom(), q.getNom(), temp);
						}
					}
				}
			}
		}
		

		//////////////////////////////////////////////////////////////
		
		/////////////// CREAR RELACIONS ENTRE LES SUPERCATS DE UNA CAT ////////////
			
		for(String it : llistatactual) { // Per a cada node del graf( a seques)
			Map<String,ArrayList<String>> jacreat = new HashMap<String,ArrayList<String>>();
			Map<String, Categoria> mapcatsubcat = graf.getCategoria(it).getMapCSupC(); 
			for (Categoria s : mapcatsubcat.values()) { // RELACIONES ENTRE SI LES SUBCATS DE IT
				for (Categoria q : mapcatsubcat.values()) {
					if(!s.getNom().equals(q.getNom())) {
						if(solucio.addAresta(s.getNom(), q.getNom(), calcularpesentrecategories(s,q,cri))){ // Si no existeix l'aresta la creem
							ArrayList<String> aux = jacreat.get(s.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL"
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							
							ArrayList<String> aux2 = jacreat.get(q.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL"
							if(aux2 == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(s.getNom());
								jacreat.put(q.getNom(), aux3);
							}
							else {
								aux2.add(s.getNom());
								jacreat.put(q.getNom(), aux2);
							}
						}
						else if(!mirarartificial(s,q,jacreat)) { // En el cas de q no hagi pogut crear l'aresta perq aquesta ja existia, mirem si No era artificial
							ArrayList<String> aux = jacreat.get(s.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL" ( tot i q no ho sigui, ho maquem)
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							
							ArrayList<String> aux2 = jacreat.get(q.getNom()); // LA GUARDEM COM A ARESTA "ARTIFICIAL"
							if(aux2 == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(s.getNom());
								jacreat.put(q.getNom(), aux3);
							}
							else {
								aux2.add(s.getNom());
								jacreat.put(q.getNom(), aux2);
							}
							
							Double temp = solucio.getPes(s.getNom(), q.getNom());
							temp += calcularpesentrecategories(s,q,cri);
							System.out.println("UNO ES" + s.getNom() +" Y MAS "+ q.getNom() + " VALORSITO " +temp);
							solucio.setPes(s.getNom(), q.getNom(), temp);
						}
					}
				}
			}
		}
		
	
		//////////////////////////////////////////////////////////////
		
		
		/////////////ENTRE PAGINES//////////////////
		Collection<Pagina> paginat = graf.getPagines();
		
		for(Pagina p : paginat) {
			Map<String, Categoria> pagacat = p.getCP(); // Cosneguim les categories a les q apunta la pag
			Collection<Categoria> cates = pagacat.values(); // Agafo les categories i les paso a una Collection
			ArrayList<Categoria> seguiment = new ArrayList<Categoria>(); // Creo una arraylist
			for(Categoria ka : cates){
				seguiment.add(ka);
			}
			for(int q = 0; q < seguiment.size(); ++q){
				for(int u = q+1; u < seguiment.size(); ++u) {
					if(solucio.existeixNode(seguiment.get(q).getNom()) && solucio.existeixNode(seguiment.get(u).getNom())) { // Si les categories existeixen al graf Solució
						if(solucio.existeixAresta(seguiment.get(q).getNom(), seguiment.get(u).getNom())) {
							Double pesactual = solucio.getPes(seguiment.get(q).getNom(), seguiment.get(u).getNom());
							pesactual += calcularpesentrecatpag(cri);
							solucio.setPes(seguiment.get(q).getNom(), seguiment.get(u).getNom(), pesactual);
						}
						else {
							Double calc = new Double(calcularpesentrecatpag(cri));
							solucio.addAresta(seguiment.get(q).getNom(), seguiment.get(u).getNom(),calc );
						}
					}
				}
			}
		}
		return solucio;
	}
	
	/**
	 * Tradueix un graf i invoca al algorisme requerit
	 * @param graf GrafDades que volem tractar
	 * @param cri Criteris passats
	 * @return Retorna un conjunt de comunitats resultant d'aplicar els algorismes al graf transformat
	 */
	public ArrayList<Comunitat> traduiricercar (GrafDades graf, Criteris cri) { // ÉS PRIVADA, ESTÀ EN PUBLICA PEL DRIVER
		Graf utilitzable = new Graf();
                long t1,t2,t3,t4;
                t1= System.currentTimeMillis();
		utilitzable = grafdadestograf(graf,cri);
                t2= System.currentTimeMillis();
		HashSet<HashSet<String>> solucio = new HashSet<HashSet<String>>();
                System.out.println("Temps traducció: "+(t2-t1));
                System.out.println("En el graf de l'algorisme hi ha "+utilitzable.getNodes().size()+" nodes");
                t3= System.currentTimeMillis();
		if(cri.getAlgorisme() == 1) {
                    System.out.println("Executo Louvain amb dispersio "+cri.getDada());
			solucio = Louvain.executa(utilitzable, cri.getDada());
		}
		else if (cri.getAlgorisme() == 2) {
                    System.out.print("Executo Newman amb ");
			if(cri.getTipuCerca() == 1){
                            System.out.println("dispersio: "+cri.getDada());
                            solucio = AlgorismeNewmanGirvan.executa(utilitzable,cri.getDada());
                        }
			else if(cri.getTipuCerca() == 2){
                            System.out.println("Num comunitats: "+cri.getDada());
                            solucio = AlgorismeNewmanGirvan.executaNum(utilitzable,cri.getDada());
                        }
                        else{
                            System.out.println("Max num de camins minims: "+cri.getDada());
                            solucio = AlgorismeNewmanGirvan.executabet(utilitzable,cri.getDada());
                        }
		}
		else {
                     System.out.println("Executo Clique amb dispersio "+cri.getDada());
                    solucio = Clique.executa(utilitzable, cri.getDada());
                } 
                t4= System.currentTimeMillis();
                System.out.println("Temps algorisme: "+(t4-t3));
		ArrayList<Comunitat> retorna = new ArrayList<Comunitat>();
		//it es un iterador que va recorrent el primer HashSet de HashSet<HashSet<String>> (el conjunt de comunitats
		Iterator<HashSet<String>> it = solucio.iterator();
		int idaux = 0;
		while(it.hasNext()) {
			//it2 es un iterador que va recorrent el segon HashSet de HashSet<HashSet<String>> (les comunitats)
			Iterator<String> it2 = it.next().iterator();
			Comunitat aux = new Comunitat();
                        System.out.println("Comunitat "+idaux+":");
			//afegim a la comunitat aux totes les categories del HashSet<String>
			while(it2.hasNext()){
                            String impr= it2.next();
                            System.out.println("    "+impr);
				aux.addCat(impr);
			}
			aux.setId(idaux);
			++idaux;
			//la comunitat aux ja conte totes les categories i l'afegim al retorna
			retorna.add(aux);
		}
		return retorna;
	}
}
