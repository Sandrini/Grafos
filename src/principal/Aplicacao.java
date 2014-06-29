package principal;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import estruturas.Veiculo;
import estruturas.tgrafo.Aresta;
import estruturas.tgrafo.Grafo;
import estruturas.tgrafo.Vertice;
import algoritmo.Logistica;
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
		
		ArrayList<Vertice> listaVertice = new ArrayList<>();
		
		for (int i = 0; i < g.getOrdem(); i++) {
			listaVertice.add(g.getVertice(i));
		}
		/*
		listaVertice.add(g.getVertice(0));
		listaVertice.add(g.getVertice(1));
		listaVertice.add(g.getVertice(2));
		listaVertice.add(g.getVertice(3));
		*/
		double[][] vetor = new double[g.getOrdem()][2];
		vetor = new Logistica().newPath(listaVertice, g.getOrdem());
		
		String mensagemCaminho = "";
		double custoTotal = 0;
		
		for (double[] ds : vetor) {
			if (mensagemCaminho.equals("")) {
				mensagemCaminho += "Caminho percorrido : "+(int) ds[0];
			} else {
				mensagemCaminho += ", "+(int) ds[0];
			}
			custoTotal += ds[1];
		}
		
		System.out.println(mensagemCaminho+".");
		System.out.println("Custo total = "+custoTotal);
		
	}

}
