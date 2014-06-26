package principal;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import estruturas.Stack;
import estruturas.tgrafo.Aresta;
import estruturas.tgrafo.Grafo;
import estruturas.tgrafo.GrafoParada;
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
		GrafoParada gparada = new GrafoParada();
		Scanner arquivo = new Arquivo().readFile();
		arquivo.next();
		while (arquivo.hasNextInt()) {
			int a = Integer.parseInt(arquivo.next());
			Double x = Double.parseDouble(arquivo.next());
			Double y = Double.parseDouble(arquivo.next());
			g.addVertice(a, x, y);
			gparada.addVertice(a, x, y);
		}

		arquivo.next();
		while (arquivo.hasNextInt()) {
			int a = Integer.parseInt(arquivo.next());
			int b = arquivo.nextInt();
			double c = Double.parseDouble(arquivo.next());
			g.addArestasToGrafo(new Aresta(c, g.getVertice(a), g.getVertice(b)));
			gparada.addArestasToGrafo(new Aresta(c, g.getVertice(a), g.getVertice(b)));
		}
		/*
		Vertice v = g.getVertice(0);
		
		for (Aresta a : v.getListaAresta()) {
			//if (v.getOtherSide(a).getKey() == 40) {
				System.out.println(a.getPesoTotal()+" "+ a.otherSide(v).getKey());
			//}
			//System.out.println(v.getOtherSide(a).getKey());
		}
		*/
		double[][] melhorCaminho = new double[g.getOrdem()][2]; 
		melhorCaminho = new Dijkstra().shortPathTotal(g.getVertice(0), g.getOrdem());
		System.out.println("Melhor caminho elemento 0");
		for (int i = 0; i < g.getOrdem(); i++) {
			double distancia = melhorCaminho[i][0];
			int anterior = (int) melhorCaminho[i][1];
			System.out.println("Chave: "+(i)+"\tdistancia: "+distancia+"\tanterior: "+anterior);
		}
		
		melhorCaminho = new Dijkstra().shortPathTotal(gparada.getVertice(0), gparada.getOrdem());
		System.out.println("Melhor caminho elemento 0");
		for (int i = 0; i < gparada.getOrdem(); i++) {
			double distancia = melhorCaminho[i][0];
			int anterior = (int) melhorCaminho[i][1];
			System.out.println("Chave: "+(i)+"\tdistancia: "+distancia+"\tanterior: "+anterior);
		}
		
		/*
		double[][] melhorCaminho = new double[g.getOrdem()][2]; 
		melhorCaminho = new Dijkstra().shortPath(g.getVertice(0), g.getOrdem());
		System.out.println("Melhor caminho elemento 0");
		for (int i = 0; i < g.getOrdem(); i++) {
			double distancia = melhorCaminho[i][0];
			int anterior = (int) melhorCaminho[i][1];
			System.out.println("Chave: "+(i)+"\tdistancia: "+distancia+"\tanterior: "+anterior);
		}
		*/
		
	}

}
