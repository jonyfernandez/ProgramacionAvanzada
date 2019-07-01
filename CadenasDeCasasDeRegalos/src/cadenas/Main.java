package cadenas;

import java.io.FileNotFoundException;

import grafos.GrafoNDNP;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.println("Lote del ejercicio M");
		GrafoNDNP ejercicio = new GrafoNDNP("ejercicio.in");
		ejercicio.colorearM(10);
		ejercicio.resultadoEjercicio();
		System.out.println();

		System.out.println("Lote del ejercicio WP");
		ejercicio.colorearWP(10);
		ejercicio.resultadoEjercicio();
		System.out.println();
		
		System.out.println("Lote del ejercicio S");
		ejercicio.colorearS(10);
		ejercicio.resultadoEjercicio();
		System.out.println();

	}

}
