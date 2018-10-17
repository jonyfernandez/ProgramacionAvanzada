package reinas;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		Reinas conflicto = new Reinas(new File("00_conflictos.in"),new File("00_conflictos.out"));
		conflicto.resolver();
		Reinas conflicto2 = new Reinas(new File("01_conflictos.in"),new File("01_conflictos.out"));
		conflicto2.resolver();

	}

}
