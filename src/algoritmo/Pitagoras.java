package algoritmo;

import estruturas.tgrafo.Vertice;

public class Pitagoras {
	
	public Pitagoras() {
		
	}

	private double getCatetoX(Vertice v1, Vertice v2) {
		double x1 = v1.getCordenadaX();
		double x2 = v2.getCordenadaX();
		if (x1 > x2) {
			return x1 - x2;
		}
		return x2 - x1;
	}
	
	private double getCatetoY(Vertice v1, Vertice v2) {
		double y1 = v1.getCordenadaY();
		double y2 = v2.getCordenadaY();
		if (y1 > y2) {
			return y1 - y2;
		}
		return y2 - y1;
	}
	
	public double getHipotenusa(Vertice v1, Vertice v2) {
		double catetox = getCatetoX(v1, v2);
		double catetoy = getCatetoY(v1, v2);
		catetox = Math.pow(catetox, 2);
		catetoy = Math.pow(catetoy, 2);
		return Math.sqrt((catetox+catetoy));
	}
}
