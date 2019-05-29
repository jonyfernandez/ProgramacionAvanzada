package tenis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TenisRecargado extends EjercicioOIA {
	
	private int cantidadJuegos;
	//private int cantSetParaGanarPartido;
	private int cantJuegosParaGanarSet;
	private int diferencia;
	private String juegos;
	
	
	public TenisRecargado(File entrada, File salida) {
		super(entrada, salida);
		procesarEntrada();
	}
	
	private void procesarEntrada(){
		try {
			Scanner sc = new Scanner(entrada);
			cantidadJuegos = sc.nextInt();
			/*cantSetParaGanarPartido =*/ sc.nextInt();
			cantJuegosParaGanarSet = sc.nextInt();
			diferencia = sc.nextInt();
			juegos = sc.next();
			
			sc.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public void resolver() throws IOException {
		int jugadorA = 0;
		int jugadorB = 0;
		int setGanadosPorA = 0;
		int setGanadosPorB = 0; 
		
		for(int i = 0; i < this.cantidadJuegos; i++){
			if(this.juegos.charAt(i) == 'A')
				jugadorA++;
			else
				jugadorB++;
			
			if(jugadorA >= this.cantJuegosParaGanarSet && (jugadorA - jugadorB) >= this.diferencia){
				setGanadosPorA++;
				jugadorA = 0;
				jugadorB = 0;
			}
			
			if(jugadorB >= this.cantJuegosParaGanarSet && (jugadorB - jugadorA) >= this.diferencia){
				setGanadosPorB++;
				jugadorA = 0;
				jugadorB = 0;
			}
		
		}
		
		procesarSalida(setGanadosPorA, setGanadosPorB);
		
	}
	
	private void procesarSalida(int setGanadosPorA, int setGanadosPorB) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		pw.print(setGanadosPorA + " " + setGanadosPorB);
		pw.close();
	}

}
