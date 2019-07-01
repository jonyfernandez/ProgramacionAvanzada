package calles;

import java.io.IOException;

import grafos.Dijkstra;
import grafos.Grafo;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Grafo g = new Grafo("ejercicio.in");
		Dijkstra algoritmo = new Dijkstra(g, g.nodoSalida);
		algoritmo.ejecutar();
	}

}
