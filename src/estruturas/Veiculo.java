package estruturas;

import java.util.ArrayList;

import algoritmo.Dijkstra;
import estruturas.tgrafo.Aresta;
import estruturas.tgrafo.Vertice;

public class Veiculo {

	private final double consumo;
	private final double autonomia;
	private final double velocidadeMedia;
	private final double tempoMaximoSemParada;
	private final double distanciaMaximaSemParada;
	private double tanque;
	private double tempoViagem;
	public Veiculo() {
		consumo = 15;
		autonomia = 600;
		tanque = autonomia / consumo;
		velocidadeMedia = 80;
		tempoMaximoSemParada = 3;
		distanciaMaximaSemParada = velocidadeMedia * (tempoMaximoSemParada);
	}
	
	public void encherTanque() {
		tanque = autonomia / consumo;
	}
	
	public double getDistanciaMaximaSemParada() {
		return distanciaMaximaSemParada;
	}
	
	/*
	 * Verifica melhor rota considerando as condições de ponto de parada
	 * 
	 */
	public String getRoute(Vertice inicio, Vertice fim, int tamanho) {
		int numParadas = 0;
		this.tempoViagem = 0;
		ArrayList<Vertice> listaCaminho = new ArrayList<>();
		double[][] shortPath = new double[tamanho][2];
		shortPath = new Dijkstra().shortPathTotalParada(fim, tamanho);
		Vertice atual = inicio;
		double tempoSemParar = 0;
		String mensagem = "";
		
		while(atual.getKey() != fim.getKey()) {
			
			listaCaminho.add(atual);
			Vertice verticeAux = null;
			double distanciaAux = 0;
			Aresta arestaAtual = null;
			
			for (Aresta a : atual.getListaAresta()) {
				if (atual.getOtherSide(a).getKey() == shortPath[atual.getKey()][1]) {
					//pode ter mais de uma adjacencia, por isso não garante
					//que seja o caminho corrreto
					if(verticeAux == null) {
						verticeAux = atual.getOtherSide(a);
						distanciaAux = a.getDistancia();
						arestaAtual = a;
						//System.out.println(a.otherSide(atual));
					} else {
						//possui mais de uma adjacencia para o nodo e precissa verificar qual a
						//menor distancia
						if (a.getDistancia() < distanciaAux) {
							distanciaAux = a.getDistancia();
							arestaAtual = a;
							//System.out.println(a.otherSide(atual));
						}
						
					}//fim else
					
				}//fim if
			}//fim for
			
			boolean parou = false;
			String auxMensagem = "";
			/*
			 * Se o trajeto for fazer com que tenha que dirigir
			 * mais de 3 horas deve para
			 */
			if ((tempoSemParar + calculaTempoViagem(distanciaAux)) > 3) {
				numParadas++;
				parou = true;
				auxMensagem = "Parou em "+atual.getKey()+" devido ao tempo sem parar";
			}
			
			/*
			 * Sabe a distancia e o nodo, mas precissa descobrir
			 * se precissa reabastecer antes de partir
			 */
			double consumoDistancia = calculaGasolina(distanciaAux);
			if ((tanque - consumoDistancia) <= 0) {
				//tem que reabastecer
				encherTanque();
				if (!parou) {
					numParadas++;
					auxMensagem += "e para abastecer";
				} else {
					auxMensagem = "Parou em "+atual.getKey()+" para abastecer";
				}
			}
			
			if (!parou) {
				tempoSemParar +=calculaTempoViagem(distanciaAux);
			} else {
				tempoSemParar = calculaTempoViagem(distanciaAux);
			}
			tanque -= consumoDistancia;
			tempoViagem += calculaTempoViagem(distanciaAux);
			
			mensagem += "#Trajeto : vertice "+atual.getKey()
					+" - vertice "+arestaAtual.otherSide(atual).getKey()+"\n";
			if (parou) 
				mensagem += auxMensagem+".\n";
			mensagem += "Tempo sem parar = "+tempoSemParar+" horas\n";
			mensagem += "Tanque = "+tanque+" L\n";
			
			atual = arestaAtual.otherSide(atual);
			mensagem += "\n";
			//atual = atual.getOtherSide(arestaAtual);
		}
		listaCaminho.add(atual);
		mensagem += "#######################\n";
		mensagem += "Tempo Total da Viagem = "+ tempoViagem+" horas\n";
		mensagem += "Numero de paradas = "+ numParadas+"\n";
		mensagem += "Tanque = "+tanque+" L\n";
		/*
		System.out.println("Tempo Total = "+ tempoViagem);
		System.out.println("Numero de paradas = "+ numParadas);
		System.out.println("Tanque = "+tanque);
		*/
		return mensagem;
		//return listaCaminho;
	}
	
	public double calculaGasolina(double distancia) {
		return (distancia / consumo);
	}
	public double calculaTempoViagem(double distancia) {
		return (distancia / velocidadeMedia);
	}
	
}
