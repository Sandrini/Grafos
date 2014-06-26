package estruturas.tgrafo;

public class Nodo {

	/*
	 * valor � o valor double que ser� lido do arquivo
	 * e ser� usado para calcular o peso
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
