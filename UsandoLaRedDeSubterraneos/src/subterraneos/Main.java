package subterraneos;

import java.io.IOException;

import grafos.Grafo;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Grafo g = new Grafo("mismaLinea.in");
		ClaseIntermedia algoritmo = new ClaseIntermedia(g, g.desde, g.hasta);
		algoritmo.ejecutar();
	}

}
