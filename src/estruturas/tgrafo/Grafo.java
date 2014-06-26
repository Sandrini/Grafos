package estruturas.tgrafo;

import java.util.ArrayList;

public class Grafo {
	
	/*
	 * 
	 * 
	 * 
	 */
	private ArrayList<Vertice> listaVertice;
	
	public Grafo() {
		listaVertice = new ArrayList<>();
	}
	public void addVertice(int key, Double x, Double y) {
		//adiciona um novo nodo quando conhece a chave
		Nodo nodoVertice = new Nodo(key);
		listaVertice.add(new Vertice(nodoVertice, x, y));
	}
	public void addVertice(Double x, Double y) {
		//adiciona um novo nodo quando não conhece a chave
		//neste caso as chaves devem ficar sequencias (1, 2, 3, 4)
		int key = listaVertice.size() - 1;
		Nodo nodoVertice = new Nodo(key);
		listaVertice.add(new Vertice(nodoVertice, x, y));
	}
	
	public int getOrdem() {
		//retorna a ordem de um grafo (numero de elementos)
		return listaVertice.size();
	}
	
	public Vertice getVertice(int key) {
		for (Vertice v : listaVertice) {
			if(v.getKey() == key)
				return v;
		}
		return null;
	}
	
	public void addArestasToGrafo(Aresta a) {
		
		for (Vertice v: listaVertice) {
			if(v.getKey() == a.getV1().getKey()) {
				v.addAresta(a);
				v.getOtherSide(a).addAresta(a);
				break;
			}
		}
		
	}
	
}
