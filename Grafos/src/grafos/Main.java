package grafos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		GeneradorGrafo grafo = new GeneradorGrafo(10,0.9);
		grafo.generar();
		
		/*MatrizSimetrica matriz = new MatrizSimetrica(3);
		matriz.setFC(1, 2, true);
		matriz.mostrar();*/
		/*System.out.println(matriz.getFC(1, 2));

		
	}

}
