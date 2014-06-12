package estruturas.tgrafo;

public class Nodo {

	/*
	 * valor é o valor double que será lido do arquivo
	 * e será usado para calcular o peso
	 * entre as arestas
	 */
	
	
	Double valor;
	
	public Nodo(Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}
	
}
