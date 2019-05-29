package aplicaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aplicaciones extends EjercicioOIA {
	
	private int totalesInstaladas;
	private int mbNecesarios;
	private int[] ocupados;
	
	public Aplicaciones(File entrada, File salida){
		
		super(entrada, salida);
		
		procesarEntrada();
	}
	
	private void procesarEntrada(){
		try {
			Scanner sc = new Scanner(entrada);
			this.totalesInstaladas = sc.nextInt();
			this.mbNecesarios = sc.nextInt();
			this.ocupados = new int[this.totalesInstaladas];
			for(int i = 0; i < this.totalesInstaladas; i++)
				this.ocupados[i] = sc.nextInt();
			
			sc.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void resolver() throws IOException {
		
		int secuenciaMinima = this.totalesInstaladas;
		int secuenciaActual = 0;
		int suma = 0;
		int j = 0;
			
		for(int i = 0; i < this.totalesInstaladas; i++){
			
			suma = 0;
			j = i;
			
			while(j < this.totalesInstaladas){
				
				if(this.ocupados[j] >= this.mbNecesarios){
					procesarSalida(1);
					return;
				}
				
				if(suma < this.mbNecesarios){
					suma += this.ocupados[j];
					secuenciaActual++;
				}else{
					
					if(secuenciaActual < secuenciaMinima){
						secuenciaMinima = secuenciaActual;
						
					}
					
					secuenciaActual = 0;
					break;
				}
				
				j++;
				
				if(j == this.totalesInstaladas){
					
					if(suma >= this.mbNecesarios){
					
						if(secuenciaActual < secuenciaMinima){
							secuenciaMinima = secuenciaActual;
						
						}
					}
					secuenciaActual = 0;
				}
				
				
				
			}
		}
		
		procesarSalida(secuenciaMinima);
		
	}
	
	private void procesarSalida(int cantidadMinima) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		pw.print(cantidadMinima);
		pw.close();		
	}

}
