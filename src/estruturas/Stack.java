package estruturas;

//pilha
public class Stack {

	//private int inicio; sempre = a 0
	//private int fim; fim = tamanho - 1
	private int posicao;//posicao atual da pilha
	private int tamanho;
	private Object [] pilha;
	
	public Stack(int tamanho) {
		this.tamanho = tamanho;
		pilha = new Object[tamanho];
		posicao = -1;
		//this.inicio = 0;
		//this.fim = tamanho -1;
	}
	//verifica se a pilha esta vazia
	public boolean isEmpty() {
		return posicao == -1;
	}
	//verifica se a pilha esta cheia
	public boolean isFull() {
		return posicao == (tamanho - 1);
	}
	//adiciona elemento ao topo
	public void push(Object obj) {
		if (!isFull()) {
			posicao++;
			pilha[posicao] = obj;
		}// else excecao pilha cheia
	}
	//remove o valor do topo
	public Object pop() {
		Object obj;
		if(!isEmpty()) {
			obj = pilha[posicao];
			posicao--;
			return obj;
		}//else excecao pilha vazia
		return null;
	}
	//consulta o topo da pilha
	public Object peak() {
		return pilha[posicao];
	}
}
