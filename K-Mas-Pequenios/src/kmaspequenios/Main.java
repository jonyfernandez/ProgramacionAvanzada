package kmaspequenios;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		KMasPequenios k = new KMasPequenios(new File("numeros.in"), new File("pequenios.out"));
		k.resolver();

	}

}
