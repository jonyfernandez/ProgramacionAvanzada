package depositoSubterraneo;

import java.io.File;
import java.io.IOException;

public abstract class EjercicioOIA {
	File entrada;
	File salida;
	
	public EjercicioOIA(File entrada, File salida){
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public abstract void resolver() throws IOException;
}
