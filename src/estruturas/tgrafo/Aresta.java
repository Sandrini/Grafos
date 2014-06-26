package estruturas.tgrafo;

public class Aresta {
	
	/*
	 * arestas possuem um peso e representam a ligacao entre duas arestas 
	 * 
	 */

	private double peso;
	private Vertice v1;
	private Vertice v2;
	
	public Aresta(double peso, Vertice v1, Vertice v2) {
		this.peso = peso;
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public Vertice otherSide(Vertice vertice) {
		/*
		 * Retorna o nodo do outro lado da aresta
		 */
		if(v1.getKey() == vertice.getKey()) {
			return v2;
		}
		if(v2.getKey() == vertice.getKey()) {
			return v1;
		}
		//criar excecao
		return null;
		
	}
	
	public Vertice getV1() {
		return v1;
	}
	
	public Vertice getV2() {
		return v2;
	}
	
}
