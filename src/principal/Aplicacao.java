package principal;

import estruturas.Stack;
import estruturas.tgrafo.Aresta;
import estruturas.tgrafo.Grafo;
import algoritmo.*;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Stack pilha = new Stack(1);
		
		pilha.push(1);
		pilha.push(2);
		pilha.pop();
		pilha.push(3);

		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		*/
		Grafo g = new Grafo();
		//adiciona os vertices ao grafo
		g.addVertice(1.0, 1);
		g.addVertice(2.0, 2);
		g.addVertice(3.0, 3);
		
		//adiciona as arestas aos vertices
		g.addArestasToGrafo(new Aresta(1, g.getVertice(1), g.getVertice(2)));
		g.addArestasToGrafo(new Aresta(1, g.getVertice(2), g.getVertice(3)));
		g.addArestasToGrafo(new Aresta(3, g.getVertice(1), g.getVertice(3)));
		
		//adiciona as arestas aos vertices
		/*
		g.getVertice(1).addAresta(a1);
		g.getVertice(1).addAresta(a3);
		g.getVertice(2).addAresta(a2);
		g.getVertice(2).addAresta(a1);
		g.getVertice(3).addAresta(a2);
		g.getVertice(3).addAresta(a3);
		*/
		
		int[][] melhorCaminho = new int[g.getOrdem()][2]; 
		melhorCaminho = new Dijkstra().shortPath(g.getVertice(1), g.getOrdem());
		System.out.println("Melhor caminho elemento 1");
		for (int i = 0; i < g.getOrdem(); i++) {
			int distancia = melhorCaminho[i][0];
			int anterior = melhorCaminho[i][1];
			System.out.println("Chave: "+(i + 1)+"\tdistancia: "+distancia+"\tanterior: "+anterior);
		}
		System.out.println("\nMelhor caminho elemento 2");
		melhorCaminho = new Dijkstra().shortPath(g.getVertice(2), g.getOrdem());
		for (int i = 0; i < g.getOrdem(); i++) {
			int distancia = melhorCaminho[i][0];
			int anterior = melhorCaminho[i][1];
			System.out.print("Chave: "+(i + 1)+"\tdistancia: "+distancia+"\tanterior: "+anterior+"\n");
		}
		System.out.println("\nMelhor caminho elemento 3");
		melhorCaminho = new Dijkstra().shortPath(g.getVertice(3), g.getOrdem());
		for (int i = 0; i < g.getOrdem(); i++) {
			int distancia = melhorCaminho[i][0];
			int anterior = melhorCaminho[i][1];
			System.out.println("Chave: "+(i + 1)+"\tdistancia: "+distancia+"\tanterior: "+anterior);
		}
	}

}
