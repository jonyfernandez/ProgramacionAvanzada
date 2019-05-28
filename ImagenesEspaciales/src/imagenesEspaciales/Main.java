package imagenesEspaciales;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		ImagenesEspaciales imagen = new ImagenesEspaciales(new File("imagenes02.in"), new File("imagenes02.out"));
		imagen.resolver();

	}

}
