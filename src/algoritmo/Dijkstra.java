package algoritmo;

<<<<<<< HEAD
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
	
	
	
=======
import java.util.ArrayList;

import estruturas.tgrafo.*;
import estruturas.*;

public class Dijkstra {
	
	
	
	public Dijkstra() {
		
	}
	
	public int[][] shortPath(Vertice v, int tamanhoLista) {
		//lista de elementos ja acessados
		ArrayList<Boolean> lista = new ArrayList<>();
		//saida final: custo e elemento anterior
		int[][] saida = new int[tamanhoLista][2];
		
		for (int i = 0; i < tamanhoLista; i++) {
			lista.add(false);
			saida[i][0] = -1;
			saida[1][1] = -1;
		}
		//inicia com distancia at� si de 0 e anterior inesistente
		//saida inicia em 0 enquanto vertice inicia em 1
		saida[v.getKey() - 1][0] = 0;
		saida[v.getKey() - 1][1] = -1;
		
		//pilha de elementos a serem visitados
		Stack pilha = new Stack(100);
		//adiciona o elemento a ser descoberto na pilha
		pilha.push(v);
		
		while (!pilha.isEmpty()) {
			Vertice vertice = (Vertice) pilha.pop();
			//se ja tiver sido visitado continua
			if (lista.get(vertice.getKey() - 1)) 
				continue;
			else
				lista.set(vertice.getKey() - 1, true);
			//System.out.println("Elemento atual = "+vertice.getKey());
			//para cada adjacencia
			for (Aresta a : vertice.getListaAresta()) {
				Vertice adj = a.otherSide(vertice);
				//pesso vertice adjacente
				int pesoA = saida[adj.getKey() - 1][0];
				int pesoB = a.getPeso() + saida[vertice.getKey() - 1][0];
				//System.out.println("PesoA: "+pesoA+"\tPesoB: "+pesoB);
				if (ehMaior(pesoA, pesoB)) {
					saida[adj.getKey() - 1][0] = pesoB;
					saida[adj.getKey() - 1][1] = vertice.getKey();
				}
				pilha.push(adj);
			}
		}
		return saida;
	}//fim shot path
	
	public boolean ehMaior(int a, int b) {
		if (a == -1 && b!= -1) 
			return true;
		if ((a > b) && (b != -1))
			return true;
		return false;
	}//fim eh maior
	
	
	

>>>>>>> 8a94907c5a630b453ebd9b6fcfaca0eb89a0755f
}
