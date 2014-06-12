package estruturas.tgrafo;

import java.util.ArrayList;

public class Vertice {
	
	/*
	 * Nodo do vertice
	 * key vai ser a chave para representar e facilitar o entendimento...
	 * ...ex: vertice 1, 2, 3.
	 * 
	 * Em tendencia o vertice conhece os vertices ao qual consegue estabelecer
	 * vizinhanca, mas para facilitar ele vai conhecer cada aresta
	 * que o liga aos vizinhos.
	 * Pode descobrir os vizinhos pelo metodo getListaDeVizinhos()
	 */
	
	private Nodo nodo;
	private int key;
	private ArrayList<Aresta> listaAresta;
	
	public Vertice(int key, Nodo nodo) {
		this.key = key;
		this.nodo = nodo;
		listaAresta = new ArrayList<>();
	}

	public Nodo getNodo() {
		return nodo;
	}

	public int getKey() {
		return key;
	}

	public ArrayList<Aresta> getListaAresta() {
		return listaAresta;
	}

	public void setListaAresta(ArrayList<Aresta> listaAresta) {
		this.listaAresta = listaAresta;
	}
	
	public Vertice getOtherSide(Aresta a) {
		/*
		 * retorna o vertice do outro lado da aresta passada
		 */
		return a.otherSide(this);
	}
	
	public ArrayList<Vertice> getListaDeVizinho() {
		ArrayList<Vertice> lista = new ArrayList<>();
		//para cada aresta
		for (int i = 0; i < listaAresta.size(); i++) {
			//procura o vertice do outro lado da aresta
			Vertice v = this.getOtherSide(listaAresta.get(i));
			//adiciona a lista de vizinhancas
			lista.add(v);
		}
		return lista;
	}
}
