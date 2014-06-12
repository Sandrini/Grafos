package principal;

import estruturas.Stack;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack pilha = new Stack(1);
		
		pilha.push(1);
		pilha.push(2);
		pilha.pop();
		pilha.push(3);

		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
		System.out.println(pilha.pop());
	}

}
