package estruturas.tgrafo;

public class Aresta {
	
	/*
	 * arestas possuem um peso e representam a ligacao entre duas arestas 
	 * 
	 */

	private double peso;
	private Vertice v1;
	private Vertice v2;
	private double distancia;
	
	public Aresta(double peso, Vertice v1, Vertice v2) {
		this.peso = peso;
		this.v1 = v1;
		this.v2 = v2;
		distancia = setDistancia();
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
	
	private double getCatetoX() {
		double x1 = v1.getCordenadaX();
		double x2 = v2.getCordenadaX();
		if (x1 > x2) {
			return x1 - x2;
		}
		return x2 - x1;
	}
	
	private double getCatetoY() {
		double y1 = v1.getCordenadaY();
		double y2 = v2.getCordenadaY();
		if (y1 > y2) {
			return y1 - y2;
		}
		return y2 - y1;
	}
	
	private double setDistancia() {
		double catetox = getCatetoX();
		double catetoy = getCatetoY();
		catetox = Math.pow(catetox, 2);
		catetoy = Math.pow(catetoy, 2);
		return Math.sqrt((catetox+catetoy));
	}

	public double getDistancia() {
		return distancia;
	}
}
