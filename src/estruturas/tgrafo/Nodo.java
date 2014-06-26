package estruturas.tgrafo;

public class Nodo {

	/*
	 * valor é o valor double que será lido do arquivo
	 * e será usado para calcular o peso
	 * entre as arestas
	 */
	
	
	private Double cordenadaX;
	private Double cordenadaY;
	
	public Nodo(Double x, Double y) {
		this.cordenadaX = x;
		this.cordenadaY = y;
	}

	public Double getCordenadaX() {
		return cordenadaX;
	}

	public Double getCordenadaY() {
		return cordenadaY;
	}

	
	
}
