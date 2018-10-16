package luchadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Torneo {
	
	private Luchador[] luchadores;
	private int[] dominados;
	private int cantidad;
	
	public Torneo(String archivo) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(archivo));
		
		cantidad = sc.nextInt();
		luchadores = new Luchador[cantidad];
		dominados = new int[cantidad]; //Se inicializa con 0
		
		
		
		for (int i = 0; i < cantidad ; i++) {
			luchadores[i] = new Luchador(sc.nextInt(),sc.nextInt());
			System.out.println(luchadores[i].toString());
		}
		
		sc.close();			
	}
	
	public void resolver(){
			
		for(int i = 0; i < cantidad; i++){
			for(int j = i+1 ; j < cantidad; j++){
				if(luchadores[i].domina(luchadores[j]))
					dominados[i]++;
				else
					if(luchadores[j].domina(luchadores[i]))
						dominados[j]++;					
							
			}			
		}
	}
	
	public void imprimir(String output) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(output));
		
		for(int i = 0; i < dominados.length; i++)
			pw.println(dominados[i]);
		
		pw.close();
		
	}

}
