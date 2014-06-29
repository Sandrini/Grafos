package principal;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import estruturas.Veiculo;
import estruturas.tgrafo.Aresta;
import estruturas.tgrafo.Grafo;
import estruturas.tgrafo.GrafoParada;
import estruturas.tgrafo.Vertice;
import algoritmo.*;
import arquivo.Arquivo;

public class Aplicacao {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Grafo g = new Grafo();
		//Grafo gparada = new Grafo();
		Scanner arquivo = new Arquivo().readFile();
		//le e adiciona os vertices
		arquivo.next();
		while (arquivo.hasNextInt()) {
			int a = Integer.parseInt(arquivo.next());
			Double x = Double.parseDouble(arquivo.next());
			Double y = Double.parseDouble(arquivo.next());
			g.addVertice(a, x, y);
		}

		//le e adiciona as arestas
		arquivo.next();
		while (arquivo.hasNextInt()) {
			int a = Integer.parseInt(arquivo.next());
			int b = arquivo.nextInt();
			double c = Double.parseDouble(arquivo.next());
			g.addArestasToGrafo(new Aresta(c, g.getVertice(a), g.getVertice(b)));
		}
		
		//realiza o algoritmo de ponto de parada
		String mensagem = new Veiculo().getRoute(g.getVertice(0), g.getVertice(49), g.getOrdem());
		System.out.println(mensagem);
		
	}

}
