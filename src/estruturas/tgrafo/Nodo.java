package estruturas.tgrafo;

public class Nodo {

	/*
	 * valor é o valor double que será lido do arquivo
	 * e será usado para calcular o peso
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
