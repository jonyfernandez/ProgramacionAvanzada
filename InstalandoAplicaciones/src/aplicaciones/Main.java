package aplicaciones;

import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		Aplicaciones app = new Aplicaciones(new File("almacenamiento.in"), new File("almacenamiento.out"));
		app.resolver();
		Aplicaciones app2 = new Aplicaciones(new File("almacenamiento02.in"), new File("almacenamiento02.out"));
		app2.resolver();
		Aplicaciones app3 = new Aplicaciones(new File("almacenamiento03.in"), new File("almacenamiento03.out"));
		app3.resolver();
		Aplicaciones app4 = new Aplicaciones(new File("almacenamiento04.in"), new File("almacenamiento04.out"));
		app4.resolver();
		
	}

}
