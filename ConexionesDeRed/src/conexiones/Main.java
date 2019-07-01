package conexiones;

import java.io.IOException;

import grafos.Grafo;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Grafo g = new Grafo("ejercicio.in");
		g.resolver();
	}

}
