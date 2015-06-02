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
 * @author Rafa Lucena
 *
 */


public class TraduccioiAlgorisme {	
	/**
	 * Calcula la similaritat entre dues paraules
	 * @param a String a comparar
	 * @param b String a comparar
	 * @return Retorna el numero de canvis que fan falta per a que aquelles paraules siguin iguals
	 */
	  private static double similarity(String a, String b) {
	        a = a.toLowerCase();
	        b = b.toLowerCase();
	        int [] costs = new int [b.length() + 1];
	        for (int j = 0; j < costs.length; j++)
	            costs[j] = j;
	        for (int i = 1; i <= a.length(); i++) {
	            costs[0] = i;
	            int nw = i - 1;
	            for (int j = 1; j <= b.length(); j++) {
	                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
	                nw = costs[j];
	                costs[j] = cj;
	            }
	        }
	        return costs[b.length()];
	    }
	
	/**
	 * Calcula el pes entre dues categories donades
	 * @param c1 Categoria primera
	 * @param c2 Categoria segona
	 * @param cri Criteris passats
	 * @param potenciador Criteri sobre el qual es calcula com de forta serà la relació
	 * @return Retorna el pes de la relacio entre les dues categories C1 i C2
	 */
	private Double calcularpesentrecategories(Categoria c1, Categoria c2, Criteris cri, Integer potenciador){
		Double solucio = new Double(0);	
		Integer temp = potenciador;
		if(temp == 5) solucio += 5;
		else if(temp > 5) solucio += (5+(temp-5));
		else solucio += 5-(5-temp);
		if(cri.getSemblaNom() != 0) {
			Double aux = similarity(c1.getNom(),c2.getNom());
			if(aux > 5) aux = 0.0;
			else aux = 6 - aux;
			solucio += cri.getSemblaNom()+aux;
		}
		if(solucio < 0) solucio = 0.0;
		return solucio;
	}
	
	
	/**
	 * Calcula el pes entre dues categories que apunten a una mateixa pagina
	 * @param cri Criteri passat
	 * @return Retorna el pes que ha de tenir la relacio
	 */
	private Double calcularpesentrecatpag(Criteris cri) {
		Double solucio = new Double(0);	
		Integer temp = cri.getRelacionsPag(); // Criteri de cat-cat i cat-pg
		if(temp == 5) solucio += 5;
		else if(temp > 5) solucio += 5-(temp-5);
		else solucio += (5+(5-temp));
		if(solucio < 0) solucio = 0.0; // Evitem que suigi negatiu
		return solucio;
		
	}
	
	/**
	 * Diu si una relacio és "artificial",es a dir, creades per sub/sup categories comuns
	 * @param c1 Categoria 
	 * @param c2 Categoria
	 * @param jacreat Contenidor controlador de relacions creades
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
	private Graf grafdadestograf (GrafDades graf, Criteris cri) {
		Graf solucio = new Graf();
		Collection<Categoria> llistat = graf.getCategories();
		if(cri.getSubconjCat().size() != 0) {
			for(Categoria cataux : llistat) {
				if(cri.getSubconjCat().contains(cataux.getNom())) {
					solucio.addNode(cataux.getNom());
				}
			}
		}
		else { 
			if(cri.getParaulaClau().getNum() != 0) { 
				if(cri.getParaulaClau().getNum() == 5) {
					String ayuda = cri.getParaulaClau().getParaula().substring(0, (cri.getParaulaClau().getParaula().length())/2); // Partim la paraula /2
					for(Categoria cataux : llistat) {
						if(cataux.getNom().indexOf(ayuda) != -1) {
							solucio.addNode(cataux.getNom());
						}
					}
				}
				else {
					String ayuda = cri.getParaulaClau().getParaula();
					for(Categoria cataux : llistat) {
						if(cataux.getNom().indexOf(ayuda) != -1) {
							solucio.addNode(cataux.getNom());
						}
					}
				}
			}
			else {
				if(cri.getPare().length() != 0) {
					Map<String, Categoria> mapcatsubcat = graf.getCategoria(cri.getPare()).getMapCSubC(); 
					Stack<String> pila = new Stack<String>();
					Stack<String> visitats = new Stack<String>();
					visitats.push(cri.getPare());
					for(Categoria e : mapcatsubcat.values()) {
						pila.push(e.getNom());
						visitats.push(e.getNom());
					}
					solucio.addNode(cri.getPare());
					while(!pila.isEmpty()){
						String aux = new String(pila.peek());
						pila.pop();
						solucio.addNode(aux);
						Map<String, Categoria> mapcatsubcat2 = graf.getCategoria(aux).getMapCSubC();
						for(Categoria e2 : mapcatsubcat2.values()) {
							if(!visitats.contains(e2.getNom()))  pila.push(e2.getNom());
						}
					}
				}
				else {
					for(Categoria cataux : llistat) {
						solucio.addNode(cataux.getNom());
					}
				}
			}
			
			if(cri.getEvitaCat().size() != 0) {
				HashSet<String> llistatactual = solucio.getNodes();
				for(String it : llistatactual) {
					if(cri.getEvitaCat().contains(it)) {
						solucio.removeNode(it);
					}
				}
			}
		}
		
		HashSet<String> llistatactual = solucio.getNodes(); 
		for(String it : llistatactual) {
			Map<String, Categoria> mapcatsubcat = graf.getCategoria(it).getMapCSubC();
			for(Categoria e : mapcatsubcat.values()) { 
				if(solucio.existeixNode(e.getNom()) && !solucio.existeixAresta(it, e.getNom()) && !solucio.existeixAresta(e.getNom(), it)) {
					solucio.addAresta(it, e.getNom(), calcularpesentrecategories(graf.getCategoria(it),e,cri,cri.getRelacionsCat()));
				}
			}
		}
		for(String it : llistatactual) {
			Map<String,ArrayList<String>> jacreat = new HashMap<String,ArrayList<String>>();
			Map<String, Categoria> mapcatsubcat = graf.getCategoria(it).getMapCSubC(); 
			for (Categoria s : mapcatsubcat.values()) {
				for (Categoria q : mapcatsubcat.values()) {
					if(!s.getNom().equals(q.getNom())) {
						if(solucio.addAresta(s.getNom(), q.getNom(), calcularpesentrecategories(s,q,cri, cri.getRelacionsSubs()))){
							ArrayList<String> aux = jacreat.get(s.getNom());
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							
							ArrayList<String> aux2 = jacreat.get(q.getNom());
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
						else if(!mirarartificial(s,q,jacreat)) {
							ArrayList<String> aux = jacreat.get(s.getNom());
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							
							ArrayList<String> aux2 = jacreat.get(q.getNom());
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
							temp += calcularpesentrecategories(s,q,cri,cri.getRelacionsSubs());
							solucio.setPes(s.getNom(), q.getNom(), temp);
						}
					}
				}
			}
		}	
		for(String it : llistatactual) {
			Map<String,ArrayList<String>> jacreat = new HashMap<String,ArrayList<String>>();
			Map<String, Categoria> mapcatsubcat = graf.getCategoria(it).getMapCSupC(); 
			for (Categoria s : mapcatsubcat.values()) {
				for (Categoria q : mapcatsubcat.values()) {
					if(!s.getNom().equals(q.getNom())) {
						if(solucio.addAresta(s.getNom(), q.getNom(), calcularpesentrecategories(s,q,cri,cri.getRelacionsSuper()))){
							ArrayList<String> aux = jacreat.get(s.getNom());
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							ArrayList<String> aux2 = jacreat.get(q.getNom());
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
						else if(!mirarartificial(s,q,jacreat)) {
							ArrayList<String> aux = jacreat.get(s.getNom());
							if(aux == null) {
								ArrayList<String> aux3 = new ArrayList<String>();
								aux3.add(q.getNom());
								jacreat.put(s.getNom(), aux3);
							}
							else {
								aux.add(q.getNom());
								jacreat.put(s.getNom(), aux);
							}
							
							ArrayList<String> aux2 = jacreat.get(q.getNom());
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
							temp += calcularpesentrecategories(s,q,cri,cri.getRelacionsSuper());
							solucio.setPes(s.getNom(), q.getNom(), temp);
						}
					}
				}
			}
		}
		Collection<Pagina> paginat = graf.getPagines();
		for(Pagina p : paginat) {
			Map<String, Categoria> pagacat = p.getCP();
			Collection<Categoria> cates = pagacat.values();
			ArrayList<Categoria> seguiment = new ArrayList<Categoria>();
			for(Categoria ka : cates){
				seguiment.add(ka);
			}
			for(int q = 0; q < seguiment.size(); ++q){
				for(int u = q+1; u < seguiment.size(); ++u) {
					if(solucio.existeixNode(seguiment.get(q).getNom()) && solucio.existeixNode(seguiment.get(u).getNom())) {
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
	public ArrayList<Comunitat> traduiricercar (GrafDades graf, Criteris cri) {
		Graf utilitzable = new Graf();
		utilitzable = grafdadestograf(graf,cri);
		HashSet<HashSet<String>> solucio = new HashSet<HashSet<String>>();
		if(cri.getAlgorisme() == 1) {
			solucio = Louvain.executa(utilitzable, cri.getDada());
		}
		else if (cri.getAlgorisme() == 2) {
			if(cri.getTipuCerca() == 1) solucio = AlgorismeNewmanGirvan.executa(utilitzable,cri.getDada());
			else if(cri.getTipuCerca() == 2) solucio = AlgorismeNewmanGirvan.executaNum(utilitzable,cri.getDada());
                        else solucio = AlgorismeNewmanGirvan.executabet(utilitzable,cri.getDada());
		}
		else solucio = Clique.executa(utilitzable, cri.getDada());
		ArrayList<Comunitat> retorna = new ArrayList<Comunitat>();
		Iterator<HashSet<String>> it = solucio.iterator();
		int idaux = 0;
		while(it.hasNext()) {
			Iterator<String> it2 = it.next().iterator();
			Comunitat aux = new Comunitat();
			while(it2.hasNext()){
                String impr= it2.next();
				aux.addCat(impr);
			}
			aux.setId(idaux);
			++idaux;
			retorna.add(aux);
		}
		return retorna;
	}
}
