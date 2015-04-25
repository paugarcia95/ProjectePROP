package domini;

import java.util.HashSet;

public class Graf {

	
	//Classe Graf (els atributs de la classe Graf han de ser protected)

	//Crea un graf buit.
	protected Graf() {}
	
	//Crea un graf nou amb atributs idèntics als del graf G.
	protected Graf(Graf G) {}

	//Retorna el nombre de nodes del graf.
	protected Integer size(){
		return null;
	}
	//Retorna el conjunt d’identificadors dels nodes del graf.
	protected HashSet<String> getNodes(){
		return null;
	} 
	
	//Si no hi ha cap node al graf amb aquest identificador, afegeix un nou node i retorna el valor true. Altrament, retorna el valor false.
	protected Boolean addNode(String id){
		return null;
	} 

	//Si hi ha un node al graf amb aquest identificador, s’elimina (conjuntament amb les seves arestes) i es retorna el valor true. Altrament, retorna el valor false.
	protected Boolean removeNode(String id){
		return null;
	}

	//Si el graf conté un node amb identificador id, retorna el valor true. Altrament, retorna el valor false.
	protected Boolean existeixNode(String id){
		return null;
	}

	//Si els nodes a i b existeixen al graf, no hi ha aresta entre a i b i Pes és major que 0, afegeix l’aresta entre a i b amb pes Pes i retorna el valor true. Si alguna de les condicions anteriors no es compleix, retorna el valor false.
	protected Boolean addAresta(String a, String b, Double Pes){
		return null;
	}
	
	//Si hi ha una aresta entre els nodes a i b al graf, s’elimina i es retorna el valor true. Altrament, retorna el valor false.
	protected Boolean removeAresta(String a,String b){
		return null;
	}

	//Si hi ha una aresta entra els nodes a i b al graf, retorna el valor true. Altrament, retorna el valor false.
	protected Boolean existeixAresta(String a, String b){
		return null;
	}

	//Si hi ha una aresta entra els nodes a i b al graf i Pes és major que 0, modifica el pes de l’aresta amb Pes i retorna el valor true. Altrament, retorna el valor false.
	protected Boolean setPes(String a, String b, Double Pes){
		return null;
	}
	
	//Retorna el Pes de l’aresta entre a i b. Si no hi ha aresta entre a i b, retorna el valor -1.
	protected Double getPes(String a, String b) {
		return null;
	}
	
	//Retorna el conjunt de nodes adjacents al node amb identificador id. Si el node no existeix al graf, retorna un conjunt buit.
	protected	HashSet<String> getAdjacents(String id) {
		return null;
	} 
	
}
