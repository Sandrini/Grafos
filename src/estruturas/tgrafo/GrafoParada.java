package estruturas.tgrafo;

import java.util.ArrayList;

import algoritmo.Pitagoras;

public class GrafoParada extends Grafo{

	
	
	@Override
	public void addArestasToGrafo(Aresta a) {
		
		double distancia = new Pitagoras().getHipotenusa(a.getV1(), a.getV2());
		
		if (distancia <= 300) {
			for (Vertice v: listaVertice) {
				if(v.getKey() == a.getV1().getKey()) {
					v.addAresta(a);
					v.getOtherSide(a).addAresta(a);
					break;
				}
			}//fim for each
		}//fim if
		
		
		
	}
	
}