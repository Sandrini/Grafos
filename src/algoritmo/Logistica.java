package algoritmo;

import java.util.ArrayList;
import estruturas.tgrafo.Vertice;

public class Logistica {
	
	ArrayList<Vertice> listaVertice;
	
	//recebe lista de vertices e tamanho do grafo
	public double[][] newPath(ArrayList<Vertice> v, int tamanho) {
		
		listaVertice = v;
		double[][] shortPath = new double[tamanho][2];
		double[][] saida = new double[listaVertice.size()][2];
		double menorCaminho = 0;
		int indiceMenorCaminho;
		int indiceAuxiliar = -1;
		
		Vertice atual = v.remove(0);
		
		
		
		
		
		while (listaVertice.size() != 0) {
			
			indiceAuxiliar++;
			menorCaminho = 0;
			indiceMenorCaminho = -1;
			shortPath = new Dijkstra().shortPathTotal(atual, tamanho);
			
			/* Compara os elementos da lista
			 * para ver qual tem a menor distancia para
			 * o vertice atual
			 */
			for (Vertice ve : listaVertice) {
				//ignora adjacencias próprias
				if (ve.getKey() != atual.getKey()) {
					if (menorCaminho == 0) {
						menorCaminho = shortPath[ve.getKey()][0];
						indiceMenorCaminho = ve.getKey();
					} else {
						if (shortPath[ve.getKey()][0] < menorCaminho) {
							menorCaminho = shortPath[ve.getKey()][0];
							indiceMenorCaminho = ve.getKey();
						}
					}
				}
			}//fim for
			
			saida[indiceAuxiliar][0] = atual.getKey();
			saida[indiceAuxiliar][1] = menorCaminho;
			for (int i = 0; i < listaVertice.size(); i++) {
				if (listaVertice.get(i).getKey() == indiceMenorCaminho) {
					atual = listaVertice.remove(i);
					break;
				}
			}
		}//fim while
		indiceAuxiliar++;
		
		shortPath = new Dijkstra().shortPathTotal(atual, tamanho);
		
		
		
		saida[indiceAuxiliar][0] = atual.getKey();
		saida[indiceAuxiliar][1] = shortPath[(int) saida[0][0]][0];
		
		return saida;
	}

}
