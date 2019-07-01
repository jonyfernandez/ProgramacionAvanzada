package reserva;

import java.io.IOException;

import grafos.DFS;
import grafos.GrafoDP;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		GrafoDP ejercicio = new GrafoDP("ejercicio.in");
		//GrafoDP ejercicio = new GrafoDP("1camino.in");
		//GrafoDP ejercicio = new GrafoDP("2caminos.in");
		//GrafoDP ejercicio = new GrafoDP("3caminos.in");
		DFS algoritmo = new DFS(ejercicio, 1);
		algoritmo.ejecutar();
	}

}
