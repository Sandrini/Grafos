package estruturas.tgrafo;

public class Nodo {

	/*
	 * valor � o valor double que ser� lido do arquivo
	 * e ser� usado para calcular o peso
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
