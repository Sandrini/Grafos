package algoritmo;

import estruturas.Stack;
import estruturas.tgrafo.Aresta;
import estruturas.tgrafo.Vertice;

public class Dijkstra {

	
	
	public void shortestPath(Vertice v, int numVertices) {
		
		Stack pilha = new Stack(100);
		//ArrayList<Vertice> listaAuxiliar = new ArrayList<>();
		Boolean[] visitados = new Boolean[numVertices];
		//vetor de custos:
		//[e][1] elemento anterior com menor custo
		int[][] shortPath = new int[numVertices][2];
		for (int i = 0; i < numVertices; i++) {
			//inicia a lista de nodos visitados com nenhum nodo visitado
			visitados[i] = false;
			//inicia todos os caminhos com custo infinito
			shortPath[i][0] = -1;
		}
		
		shortPath[v.getKey() - 1][0] = 0;
		pilha.push(v);
		while (!pilha.isEmpty()) {
			//pega o elemento do topo da pilha para verificar
			Vertice vertice = (Vertice) pilha.pop();
			//se vertice ja tiver sido visitado continua
			//senao marca como visitado (pode ser colocado no final)
			if (visitados[vertice.getKey() - 1])
				continue;
			else
				visitados[vertice.getKey() - 1] = true;
			//para cada aresta conhecida
			for (Aresta a : vertice.getListaAresta()) {
				//a.otherSide(vertice);
			}
			
		}
		
		
	}
	
	
	
}
