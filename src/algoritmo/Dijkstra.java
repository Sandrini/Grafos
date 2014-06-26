package algoritmo;

import java.util.ArrayList;

import estruturas.tgrafo.*;
import estruturas.*;

public class Dijkstra {
	
	public Dijkstra() {
		
	}
	
	public double[][] shortPath(Vertice v, int tamanhoLista) {
		//lista de elementos ja acessados
		ArrayList<Boolean> lista = new ArrayList<>();
		//saida final: custo e elemento anterior
		double[][] saida = new double[tamanhoLista][2];
		
		for (int i = 0; i < tamanhoLista; i++) {
			lista.add(false);
			saida[i][0] = -1.0;
			saida[1][1] = -1.0;
		}
		//inicia com distancia até si de 0 e anterior inexistente
		//saida inicia em 0 enquanto vertice inicia em 1
		saida[v.getKey()][0] = 0.0;
		saida[v.getKey()][1] = -1.0;
		
		//pilha de elementos a serem visitados
		Stack pilha = new Stack(100);
		//adiciona o elemento a ser descoberto na pilha
		pilha.push(v);
		
		while (!pilha.isEmpty()) {
			Vertice vertice = (Vertice) pilha.pop();
			//se ja tiver sido visitado continua
			if (lista.get(vertice.getKey())) 
				continue;
			else
				lista.set(vertice.getKey(), true);
			//System.out.println("Elemento atual = "+vertice.getKey());
			//para cada adjacencia
			for (Aresta a : vertice.getListaAresta()) {
				Vertice adj = a.otherSide(vertice);
				//peso vertice adjacente
				double pesoA = saida[adj.getKey()][0];
				double pesoB = a.getPeso() + saida[vertice.getKey()][0];
				//System.out.println("PesoA: "+pesoA+"\tPesoB: "+pesoB);
				if (ehMaior(pesoA, pesoB)) {
					saida[adj.getKey()][0] = pesoB;
					saida[adj.getKey()][1] = vertice.getKey();
				}
				pilha.push(adj);
			}//fim for each
		}
		return saida;
	}//fim shot path
	
	public boolean ehMaior(double pesoA, double pesoB) {
		if (pesoA == -1 && pesoB!= -1) 
			return true;
		if ((pesoA > pesoB) && (pesoB != -1))
			return true;
		return false;
	}//fim eh maior

	public double[][] shortPathTotal(Vertice v, int tamanhoLista) {
		//lista de elementos ja acessados
		ArrayList<Boolean> lista = new ArrayList<>();
		//saida final: custo e elemento anterior
		double[][] saida = new double[tamanhoLista][2];
		
		for (int i = 0; i < tamanhoLista; i++) {
			lista.add(false);
			saida[i][0] = -1.0;
			saida[1][1] = -1.0;
		}
		//inicia com distancia até si de 0 e anterior inexistente
		//saida inicia em 0 enquanto vertice inicia em 1
		saida[v.getKey()][0] = 0.0;
		saida[v.getKey()][1] = -1.0;
		
		//pilha de elementos a serem visitados
		Stack pilha = new Stack(100);
		//adiciona o elemento a ser descoberto na pilha
		pilha.push(v);
		
		while (!pilha.isEmpty()) {
			Vertice vertice = (Vertice) pilha.pop();
			//se ja tiver sido visitado continua
			if (lista.get(vertice.getKey())) 
				continue;
			else
				lista.set(vertice.getKey(), true);
			//System.out.println("Elemento atual = "+vertice.getKey());
			//para cada adjacencia
			for (Aresta a : vertice.getListaAresta()) {
				Vertice adj = a.otherSide(vertice);
				//peso vertice adjacente
				double pesoA = saida[adj.getKey()][0];
				double pesoB = a.getPesoTotal() + saida[vertice.getKey()][0];
				//System.out.println("PesoA: "+pesoA+"\tPesoB: "+pesoB);
				if (ehMaior(pesoA, pesoB)) {
					saida[adj.getKey()][0] = pesoB;
					saida[adj.getKey()][1] = vertice.getKey();
				}
				pilha.push(adj);
			}//fim for each
		}
		return saida;
	}//fim shot path
	
	
}
