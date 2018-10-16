package envasadoraDeLatas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EnvasadoraDeLatas extends Abstracta {
	
	private ArrayList<Character> latas;
	private Secuencia secuenciaMasLarga;
	private Secuencia segundaSecuenaMasLarga;
	
	
	public EnvasadoraDeLatas(File entrada, File salida) {
		super(entrada,salida);
		latas = new ArrayList<Character>();
		secuenciaMasLarga = new Secuencia(0,0,0);
		segundaSecuenaMasLarga = new Secuencia(0,0,0);
		procesarEntrada();
	}
	
	private void procesarEntrada(){
		
		try {
			Scanner sc = new Scanner(entrada);
			String lata = sc.nextLine(); //GUARDO TODA LA LINEA.
			// -1 PORQUE LA ULTIMA NO SE CUENTA. 
			for(int i = 0; i < lata.length() - 1; i++){
				latas.add(lata.charAt(i)); //ACA LO GUARDO CARACTER POR CARACTER.
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void resolver() throws IOException {
		
		int posInicial, posFinal, longitud = 0;
		
		for(int i = 0; i < latas.size(); i++){
			
			if(latas.get(i).equals('G')){
				
				posInicial = i;
			
				while(i < latas.size() && latas.get(i).equals('G') ){
					longitud++;
					i++;
				}
				
				posFinal = i;
				
				if(longitud > this.secuenciaMasLarga.getLongitud()){
					this.segundaSecuenaMasLarga = this.secuenciaMasLarga;
					this.secuenciaMasLarga = new Secuencia(posInicial, posFinal, longitud);
				}else if(longitud > this.segundaSecuenaMasLarga.getLongitud()){
					segundaSecuenaMasLarga = new Secuencia(posInicial, posFinal, longitud);
				}
				
				longitud = 0;
			}
		}
		
		procesarSalida();
	}
	
	
	private void procesarSalida() throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		pw.println(latas.size());
		pw.println(this.secuenciaMasLarga.getLongitud());
		pw.println(this.segundaSecuenaMasLarga.getLongitud());
		pw.println(distanciaEntreLasDos());
		pw.close();
			
	}
		
	private int distanciaEntreLasDos(){
		
		if(this.secuenciaMasLarga.getLongitud() == 0 || this.segundaSecuenaMasLarga.getLongitud() == 0)
			return 0;
		else
			if(this.secuenciaMasLarga.getPosInicial() > this.segundaSecuenaMasLarga.getPosInicial())
				return this.secuenciaMasLarga.getPosInicial() - this.segundaSecuenaMasLarga.getPosFinal();
			else
				return this.segundaSecuenaMasLarga.getPosInicial() - this.secuenciaMasLarga.getPosFinal();
		
	}

}
