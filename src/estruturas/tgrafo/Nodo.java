package estruturas.tgrafo;

public class Nodo {

	/*
	 * valor � o valor double que ser� lido do arquivo
	 * e ser� usado para calcular o peso
	 * entre as arestas
	 */
	
	private int key;
	
	public Nodo(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
}
