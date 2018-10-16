package luchadores;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Torneo t = new Torneo("Entrada.in");
		t.resolver();
		t.imprimir("Salida.out");

	}

}
