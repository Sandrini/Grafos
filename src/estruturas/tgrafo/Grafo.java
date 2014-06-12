package estruturas.tgrafo;

import java.util.ArrayList;

public class Grafo {
	
	/*
	 * 
	 * 
	 * 
	 */
	ArrayList<Vertice> listaVertice;
	
	public Grafo() {
		listaVertice = new ArrayList<>();
	}
	public void addVertice(Double valor, int key) {
		//adiciona um novo nodo quando conhece a chave
		Nodo nodoVertice = new Nodo(valor);
		listaVertice.add(new Vertice(key, nodoVertice));
	}
	public void addVertice(Double valor) {
		//adiciona um novo nodo quando não conhece a chave
		//neste caso as chaves devem ficar sequencias (1, 2, 3, 4)
		Nodo nodoVertice = new Nodo(valor);
		int key = listaVertice.size() - 1;
		listaVertice.add(new Vertice(key, nodoVertice));
	}
	public int getOrdem() {
		//retorna a ordem de um grafo (numero de elementos)
		return listaVertice.size() - 1;
	}
}
