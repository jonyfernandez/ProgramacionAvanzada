package tarzan;

import java.io.IOException;

import grafos.Dijkstra;
import grafos.Grafo;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Grafo g = new Grafo("01_SoloUnArbol.in");
		Dijkstra algoritmo = new Dijkstra(g);
		algoritmo.ejecutar();
	}

}
