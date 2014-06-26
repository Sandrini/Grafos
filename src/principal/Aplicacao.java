package principal;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import estruturas.Stack;
import estruturas.tgrafo.Aresta;
import estruturas.tgrafo.Grafo;
import estruturas.tgrafo.Vertice;
import algoritmo.*;
import arquivo.Arquivo;

public class Aplicacao {

	public static void main(String[] args) throws FileNotFoundException {
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
		Scanner arquivo = new Arquivo().readFile();
		arquivo.next();
		while (arquivo.hasNextInt()) {
			int a = Integer.parseInt(arquivo.next());
			Double x = Double.parseDouble(arquivo.next());
			Double y = Double.parseDouble(arquivo.next());
			g.addVertice(a, x, y);
		}

		arquivo.next();
		while (arquivo.hasNextInt()) {
			int a = Integer.parseInt(arquivo.next());
			int b = arquivo.nextInt();
			double c = Double.parseDouble(arquivo.next());
			g.addArestasToGrafo(new Aresta(c, g.getVertice(a), g.getVertice(b)));
		}
		/*
		Vertice v = g.getVertice(0);
		int i = 0;
		for (Aresta a : v.getListaAresta()) {
			if (v.getOtherSide(a).getKey() == 49) {
				System.out.println(a.getPeso());
			}
			//System.out.println(v.getOtherSide(a).getKey());
		}
		*/
		
		double[][] melhorCaminho = new double[g.getOrdem()][2]; 
		melhorCaminho = new Dijkstra().shortPath(g.getVertice(0), g.getOrdem());
		System.out.println("Melhor caminho elemento 0");
		for (int i = 0; i < g.getOrdem(); i++) {
			double distancia = melhorCaminho[i][0];
			int anterior = (int) melhorCaminho[i][1];
			System.out.println("Chave: "+(i)+"\tdistancia: "+distancia+"\tanterior: "+anterior);
		}
		
		/*
		while (arquivo.hasNextLine()) {
			System.out.println(arquivo.nextLine());
		}
		*/
		/*
		Grafo g = new Grafo();
		//adiciona os vertices ao grafo
		g.addVertice(1.0, 1);
		g.addVertice(2.0, 2);
		g.addVertice(3.0, 3);
		
		//adiciona as arestas aos vertices
		g.addArestasToGrafo(new Aresta(1, g.getVertice(1), g.getVertice(2)));
		g.addArestasToGrafo(new Aresta(1, g.getVertice(2), g.getVertice(3)));
		g.addArestasToGrafo(new Aresta(3, g.getVertice(1), g.getVertice(3)));
		
		
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
		
		*/
	}

}
