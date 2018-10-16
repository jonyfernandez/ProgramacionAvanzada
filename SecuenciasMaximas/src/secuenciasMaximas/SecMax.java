package secuenciasMaximas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SecMax {
	
	private int[] vector;
	private int cantElem;
	
	public SecMax(String entrada) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(entrada));
		
		cantElem = sc.nextInt();
		vector = new int[cantElem];
		
		for(int i = 0; i < cantElem; i++){
			vector[i] = sc.nextInt();
		}
		
		sc.close();
		
	}
	
	public void resolver(String salida) throws IOException{
		int cantValidos = 0;
		int secActual = 0;
		int secMax = 0;
		int posi = 0;
		
		while(posi < cantElem){
			
			if(esValido(vector[posi])){
				cantValidos++;
				secActual++;
				posi++;
				
				while(secActual != 0 && posi < cantElem){
					
					if(esValido(vector[posi])){
						cantValidos++;
						secActual++;	
					}
					else{
						
						if(secMax < secActual)
							secMax = secActual;
						
						secActual = 0;
					}
					
					posi++;
				}
				
				if(posi == cantElem)
					if(secMax < secActual)
						secMax = secActual;
			}
			else
				posi++;
		}
		
		procesarSalida(salida, cantValidos, secMax);
		
	}
	
	private boolean esValido(int n){
		
		if(n == 0) 
			return true;
		
		if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
			return false;
		
		return true;
		
	}
	
	private void procesarSalida(String salida, int cantV, int secMax) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		pw.println(cantV);
		pw.println(secMax);
		pw.close();
		
	}

}
