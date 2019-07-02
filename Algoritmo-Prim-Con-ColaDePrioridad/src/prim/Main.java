package prim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner entrada = new Scanner(new FileReader("grafo.in"));
		Prim prim = new Prim(entrada);
		entrada.close();
		prim.calcularPrim(1);
		prim.mostrarArbolYCosto();

	}

}
