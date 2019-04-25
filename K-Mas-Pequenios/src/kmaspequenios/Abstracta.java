package kmaspequenios;

import java.io.File;
import java.io.IOException;

public abstract class Abstracta {
	
	protected File entrada;
	protected File salida;
	
	public Abstracta(File entrada, File salida){
		this.entrada = entrada;
		this.salida = salida;
	}
	
	public abstract void resolver() throws IOException;
}
