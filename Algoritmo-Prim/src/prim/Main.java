package prim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner entrada = new Scanner(new FileReader("prim.in"));
		Prim prim = new Prim(entrada);
		entrada.close();
		prim.calcularCosto(1);
		prim.mostrarCosto();
		prim.mostrarArbol();

	}

}
