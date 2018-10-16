package nombresRepetidos;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		NombresRepetidos campamento = new NombresRepetidos(new File("nombres.in"), new File("nombres.out"));
		campamento.resolver();

	}

}
