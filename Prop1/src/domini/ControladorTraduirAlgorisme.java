/**
 * 
 */
package domini;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import cercaComunitats.Algorisme_NewmanGirvan;
import cercaComunitats.Clique;
import cercaComunitats.Graf;
import cercaComunitats.Louvain;


/**
 * @author Rafa
 *
 */
public class ControladorTraduirAlgorisme {

	
	  private static double similarity(String s1, String s2) {
	        Double solu = new Double (0);
	        
	        String ayuda = s1.substring(0,s1.length()/2);
	        System.out.print("LA PALABRA CORATDA1 ES: ");
        	System.out.println(ayuda);
	        if(s2.indexOf(ayuda) != -1) {
	        	solu += ayuda.length();
	        	
	        }
	        else {
	        	ayuda = s2.substring(0,s2.length()/2);
	        	System.out.print("LA PALABRA CORATDA2 ES: ");
	        	System.out.println(ayuda);
	        	if(s1.indexOf(ayuda) != -1){
	        		solu += ayuda.length();
	        	}
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
	private Double CalcularPesEntreCategories(Categoria c1, Categoria c2, Criteris cri){
		Double solucio = new Double(0);	
		
		////////////**************Criteri de cat-cat i cat-pg********/////////////
		Integer temp = cri.getRelacionsCat(); // Criteri de cat-cat i cat-pg
		if(temp == 5) solucio += 5;
		else if(temp > 5) solucio += (5+(temp-5));
		else solucio += 5-(5-temp);
		/////////////*********************************************///////////
		
		
		/////////// Criteri Semblança //////////////////
		System.out.print("Relacio entre: ");
		System.out.print(c1.getNom());
		System.out.print(" i ");
		System.out.print(c2.getNom());
		Double aux = similarity(c1.getNom(),c2.getNom());
		System.out.print(" té semblança de ");
		System.out.println(aux);
		solucio += cri.getSemblNom()*aux;
		/////////////////////////////////////////////////
		
		
		if(solucio < 0) solucio = 0.0; // Evitem que suigi negatiu
		return solucio;
	}
	
	
	/**
	 * Calcula el pes entre dues categories que apunten a una mateixa pagina
	 * @param cri Criteri passat
	 * @return Retorna el pes que ha de tenir la relacio
	 */
	private Double CalcularPesEntreCatPag(Criteris cri) {
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
	 * Transforma un graf de dades a un graf
	 * @param graf GrafDades que hem de transformar
	 * @param cri Criteris passats
	 * @return Retorna un graf transformat a partir de l'original
	 */
	public Graf GrafDadestoGraf (GrafDades graf, Criteris cri) {
		Graf solucio = new Graf();
		Collection<Categoria> llistat = graf.getCategories();
		
		///////////////////////ANEM A AFEGIR ELS NODES AL GRAF //////////////////////////
		
		if(cri.getSubconjCat().size() != 0) {// Si aquest criteri està actiu...(subconjunt)
			for(Categoria cataux : llistat) {
				if(cri.getSubconjCat().contains(cataux)) {// I està a la llista d'acceptats
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
			else { // Si no hi ha cap criteri, ho afegim tot
				for(Categoria cataux : llistat) {
					solucio.addNode(cataux.getNom());
				}
			}
			if(cri.getEvitaCat().size() != 0) { // Si el criteri d'ignorar està actiu
				HashSet<String> llistatactual = solucio.getNodes(); // Agafo tots els nodes afegits fins llavors
				for(String it : llistatactual) {
					if(cri.getEvitaCat().contains(graf.getCategoria(it))) { // Miro si estan a la llista d'ignorats
						solucio.removeNode(it); // I l'elimino si escau
					}
				}
			}
		}
		////////////////////////FI AFEGIR NODES////////////////////////////
		
		
		///////////////ANEM A CREAR LES ARESTES AMB PESOS////////////////////////
		
		//////////////////ENTRE CATEGORIES////////////////////////
		HashSet<String> llistatactual = solucio.getNodes(); // Llista dels nodes a Solució (Graf)
		for(String it : llistatactual) { // Per a cada node del graf( a seques)
			Map<String, Categoria> mapcatsubcat = graf.getCategoria(it).getMapCSubC(); //Adquireixo totes les seves subcategories
			for(Categoria e : mapcatsubcat.values()) { // Per a cadascuna de les seves categories
				if(solucio.existeixNode(e.getNom()) && !solucio.existeixAresta(it, e.getNom()) && !solucio.existeixAresta(e.getNom(), it)) { // Miro si està al graf Solució
					solucio.addAresta(it, e.getNom(), CalcularPesEntreCategories(graf.getCategoria(it),e,cri)); // I si hi està, afageixo el pes
				}
			}
			Map<String, Categoria> mapcatsubcat2 = graf.getCategoria(it).getMapCSupC(); //Adquireixo totes les seves subcategories
			for(Categoria e : mapcatsubcat2.values()) { // Per a cadascuna de les seves categories
				if(solucio.existeixNode(e.getNom()) && !solucio.existeixAresta(it, e.getNom()) && !solucio.existeixAresta(e.getNom(), it)) { // Miro si està al graf Solució
					solucio.addAresta(it, e.getNom(), CalcularPesEntreCategories(graf.getCategoria(it),e,cri)); // I si hi està, afageixo el pes
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
							pesactual += CalcularPesEntreCatPag(cri);
							solucio.setPes(seguiment.get(q).getNom(), seguiment.get(u).getNom(), pesactual);
						}
						else {
							Double calc = new Double(CalcularPesEntreCatPag(cri));
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
	public ArrayList<Comunitat> Traduir_i_buscar (GrafDades graf, Criteris cri) {
		Graf utilitzable = new Graf();
		utilitzable = GrafDadestoGraf(graf,cri);
		HashSet<HashSet<String>> solucio = new HashSet<HashSet<String>>();
		if(cri.getAlgorisme() == 1) {
			solucio = Louvain.executa(utilitzable, cri.getDada());
		}
		else if (cri.getAlgorisme() == 2) {
			if(cri.getTipuCerca() == 1) solucio = Algorisme_NewmanGirvan.executa(utilitzable,cri.getDada());
			else if(cri.getTipuCerca() == 2) solucio = Algorisme_NewmanGirvan.executa_num(utilitzable,cri.getDada());
			else solucio = Algorisme_NewmanGirvan.executa_bet(utilitzable,cri.getDada());
		}
		else {
			solucio = Clique.executa(utilitzable, cri.getDada());
		}
		ArrayList<Comunitat> retorna = new ArrayList<Comunitat>();
		//it es un iterador que va recorrent el primer HashSet de HashSet<HashSet<String>> (el conjunt de comunitats
		Iterator<HashSet<String>> it = solucio.iterator();
		while(it.hasNext()) {
			//it2 es un iterador que va recorrent el segon HashSet de HashSet<HashSet<String>> (les comunitats)
			Iterator<String> it2 = it.next().iterator();
			Comunitat aux = new Comunitat();
			//afegim a la comunitat aux totes les categories del HashSet<String>
			while(it2.hasNext()) aux.addCat(graf.getCategoria(it2.next()));
			//la comunitat aux ja conte totes les categories i l'afegim al retorna
			retorna.add(aux);
		}
		return retorna;
	}
}
