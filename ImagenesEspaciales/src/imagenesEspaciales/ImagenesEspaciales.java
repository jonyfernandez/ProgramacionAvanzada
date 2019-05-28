package imagenesEspaciales;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ImagenesEspaciales extends EjercicioOIA {
	
	private String imagenDescomprimida;
	private String imagenComprimida;
	
	public ImagenesEspaciales(File entrada, File salida){
		super(entrada, salida);
		procesarEntrada();
	}
	
	private void procesarEntrada(){
		
		try {
			Scanner sc = new Scanner(entrada);
			imagenDescomprimida = sc.nextLine();
			imagenComprimida = sc.nextLine();
			
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void resolver() throws IOException {
		
		procesarSalida(this.comprimir(), this.descomprimir());
		
	}
	
	private String comprimir(){
		
		String imagenNueva = "";
		int repeticiones = 0;
		int longitud = imagenDescomprimida.length();
		char letraActual = imagenDescomprimida.charAt(0);
		int i = 0;
		
		while(i < longitud){
			
			if(imagenDescomprimida.charAt(i) == letraActual){
				
				repeticiones++;
				
			}else{
				
				if(repeticiones > 4){
					
					imagenNueva += "("+letraActual+repeticiones+")";
					
				}else{
					
					for(int j = 0; j < repeticiones; j++)
						imagenNueva += letraActual;
				}
				
				repeticiones = 1;
				letraActual = imagenDescomprimida.charAt(i);
			}
			
			i++;
			
			if(i == longitud){
				
				if(repeticiones > 4){
					
					imagenNueva += "("+letraActual+repeticiones+")";
					
				}else{
					
					for(int j = 0; j < repeticiones; j++)
						imagenNueva += letraActual;
				}
			}
		}
		
		return imagenNueva;
		
	}
	
	private String descomprimir(){
		String imagenNueva = "";
		int repeticiones = 0;
		int longitud = imagenComprimida.length();
		char letraActual;
		int i = 0;
		
		while(i < longitud){
			if(imagenComprimida.charAt(i) == '('){
				letraActual = imagenComprimida.charAt(++i);
				repeticiones = imagenComprimida.charAt(++i) - '0';
				
				for(int j = 0; j < repeticiones; j++)
					imagenNueva += letraActual;
				
				i++;
			}else{
				imagenNueva += imagenComprimida.charAt(i);
			}
			i++;
		}
		
		return imagenNueva;
	}
	
	private void procesarSalida(String comprimida, String descomprimida) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		pw.println(comprimida);
		pw.println(descomprimida);
		pw.close();
	}

}
