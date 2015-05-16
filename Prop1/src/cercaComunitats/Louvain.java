package cercaComunitats;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class Louvain {
	private static GrafLouvain G;
	private static HashSet<HashSet<String> > Comunidades;
	//Potser cal un diccionari<Node, Punter a Comunitat>. Per quan volem saber a quina comunitat pertany un cert node en un cert moment.
	//O potser no :)
	private static Vector<HashMap<String,HashSet<String> > > Historia;
	
	
	
	private static void init(GrafLouvain G)  {
		Historia = new Vector<HashMap<String,HashSet<String> > >();
		Comunidades = new HashSet< HashSet<String> >();
		HashSet<String> Nodes = G.getNodes();
		Iterator<String> It = Nodes.iterator();
		HashMap<String,HashSet<String> > Mapa = new HashMap<String, HashSet<String>>();
		while(It.hasNext()) {
			HashSet<String> primera = new HashSet<String>();
			String act = new String(It.next());
			primera.add(act);
			Comunidades.add(primera);
			Mapa.put(act, primera);
			
		}
		Historia.addElement(Mapa);
	}
	
	private static void agregaGraf() {
		GrafLouvain NouGraf = new GrafLouvain();
		Iterator<HashSet<String> >  iHS = Comunidades.iterator();
		HashMap<String, HashSet<String>> Mapa = new HashMap<String, HashSet<String>>();
		
		for (Integer i = 0; iHS.hasNext(); ++i) {
			HashSet<String> Comunidad = new HashSet<String>(iHS.next()); 
			if (Comunidad.size() > 0) {
				NouGraf.addNode(i.toString());
				Mapa.put(i.toString(), Comunidad);
			}
		}
		Historia.addElement(Mapa); //Actualitzem la Història de l'algorisme amb un nou pas
		HashSet<String> Nodes = new HashSet<String> (Historia.get(Historia.size()-1).keySet()); //Agafa els noms tots els noms que se li ha donat als diversos nodes agregats de comunitats.
		Comunidades = HSStoHSHSS(Nodes); //Reiniciem les comunitats a comunitats individuals
		for (String a : Nodes) { //Omplim d'arestes el NouGraf
			for(String b : Nodes) {
				if(!NouGraf.existeixAresta(a, b)) {
					Double Pes = G.sumaPesosAdjacents(Historia.get(Historia.size()-1).get(a), Historia.get(Historia.size()-1).get(b));
					if (Pes > 0) {
						NouGraf.addAresta(a, b, Pes);
						
					}
				}
				
			}
		}
		G = NouGraf; //Graf actualitzat
	}
	

	private static boolean IncrementModularity() {
		HashSet<String> Nodes = G.getNodes();
		Boolean optimitzada = true;
		for (String Node : Nodes) {
			Boolean sehaincrementado = false;
			HashSet<String> actual = getComunitat(Node);
			HashSet<String> maxCom = actual;
			Double max = 0.0;
			for(String nodeAdjacent : G.getAdjacents(Node)) {
				HashSet<String> aTractar = getComunitat(nodeAdjacent);
				if (actual == aTractar) continue;
				Double Inc = ModularityInc(Node, actual, aTractar);
				//sC.Write(Inc);
				if (Inc > max) {
					//sC.Write(Inc);
					max = Inc;
					maxCom = aTractar;
					sehaincrementado = true;
					
				}
			}
			if (sehaincrementado) {  
				actual.remove(Node);
				maxCom.add(Node);
				optimitzada = false;
				if (actual.size() == 0) Comunidades.remove(actual);
			}
		}
		return !optimitzada;
	}
	
	private static Double ModularityInc(String node, HashSet<String> origen,
			HashSet<String> destino) {
		Double m = G.sumaPesos();
		Double pesReflexiu = 0.0;
		if(G.existeixAresta(node, node)) {
			pesReflexiu = G.getPes(node, node);
		}
		Double grauNode = G.sumaPesosAdjacents(node);
		Double res = (G.sumaPesosAdjacents(node, destino) - G.sumaPesosAdjacents(node, origen)+pesReflexiu)*2; 
		res -= (G.sumaPesosAdjacentsInclusiva(destino)-G.sumaPesosAdjacentsInclusiva(origen) + grauNode)*grauNode/m;
		res /= 2*m;	
		return res;
	}

	private static HashSet<String> getComunitat(String node) {
		for (HashSet<String> Comunidad : Comunidades) {
			if (Comunidad.contains(node)) return Comunidad;
		}
		return null; //Nunca llegará aquí.
		
	}

	private static HashSet<HashSet<String>> retorna(Integer percentatge) {
		Integer Total = Historia.size();
		Integer Interesante = (100-percentatge)*Total/100;
		HashSet<String> Generacion = new HashSet<String>(Historia.get(Interesante).keySet());
		HashSet<HashSet<String> >  hs = HSStoHSHSS(Generacion);
		HashSet<HashSet<String>> ret = new HashSet<HashSet<String>>();
		for (HashSet<String> comunitat : hs) {
			ret.add(historiador(Interesante, comunitat));
		}
		return ret;
	}
	
	
	
	private static HashSet<String> historiador(Integer Posicion, HashSet<String> Com) {
		HashSet<String> Merged = new HashSet<String>();
		if (Posicion == 0) {
		Merged.addAll(Com);	
		}
		else {
			Iterator<String> It = Com.iterator();
			while (It.hasNext()) {
				Merged.addAll(historiador(Posicion-1, Historia.get(Posicion).get(It.next())));
			}
		}
		return Merged;	
	}

	private static HashSet<HashSet<String>> HSStoHSHSS(HashSet<String> seed) {
		HashSet< HashSet<String> > Plant = new HashSet< HashSet<String> >();
		Iterator<String> iS = seed.iterator();
		while(iS.hasNext()) {
			HashSet<String> unit = new HashSet<String>();
			String act = new String(iS.next());
			unit.add(act);
			Plant.add(unit);
		}
		return Plant;
	}
	/**
	 * Executa l'algorisme Louvain fent el percentatge% dels passos que faria l'algorisme si no se l'aturés.
	 * @param Gr Graf sobre el que s'executarà l'algorisme.
	 * @param percentatge 
	 * @return Conjunt de Comunitats resultant de l'execució.
	 */
	public static HashSet< HashSet<String> > executa(Graf Gr, Integer percentatge) {
		G = new GrafLouvain(Gr);
		init(G); 
		boolean modificacion = true;
		while(Comunidades.size() > 1 && modificacion) {
			modificacion = false;
			while(IncrementModularity()) modificacion = true; 
			agregaGraf();
			
		}
		//G.print(sC);
		return retorna(percentatge);
		
	}

	
}