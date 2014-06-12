package estruturas;

//pilha
public class Stack {

	/*
	 * posicao inicial da pilha sempre igual a zero
	 * posicao final igual ao tamanho -1
	 * 
	 * Pilha auto incrementavel, quando verifica que nao pode inserir um
	 * novo objeto incrementa o valor da pilha
	 */
	
	private int posicao;//posicao atual da pilha
	private int tamanho;
	private Object [] pilha;
	
	public Stack(int tamanho) {
		this.tamanho = tamanho;
		pilha = new Object[tamanho];
		posicao = -1;
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
		} else {
			//se pilha estiver cheia...
			//...aumenta tamanho da pilha e insere o novo objeto
			stackGrown();
			push(obj);
		}
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
	//aumenta o tamanho da pilha
	public void stackGrown() {
		int newTamanho = tamanho + 1;
		Object[] newPilha = new Object[newTamanho];
		for (int i = 0; i < tamanho; i++) {
			newPilha[i] = pilha[i];
		}
		tamanho = newTamanho;
		pilha = newPilha;
	}
}
