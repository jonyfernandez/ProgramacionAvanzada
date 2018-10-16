package juegoConLetras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Rapigrama {

	private char[][] tablero;
	private List<String> palabras;
	
	public Rapigrama(String archivo) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File(archivo));
		
		int dimension = sc.nextInt();
		int cantPalabras = sc.nextInt();
		
		if(cantPalabras > 10000){
			System.out.println("La cantidad de palabras es mayor a 10000, solo puede ser < 10000");
			System.exit(0);
		}
		
		this.tablero = new char[dimension][dimension];
		this.palabras = new LinkedList<String>();
		
		for(int i = 0; i < dimension; i++){
			String linea = sc.next();
			for(int j = 0; j < dimension; j++){
				this.tablero[i][j] = linea.charAt(j);
			}
		}
		
		for(int i = 0; i < cantPalabras; i++){
			this.palabras.add(sc.next());
		}
		
		sc.close();
	}
	
	public void resolver(String salida) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		
		for(int i = 0; i < palabras.size(); i++){
			if(recorrerNorte(palabras.get(i))){
				pw.println((i + 1) + " N");
				continue; //CON ESTO SE ROMPE LA ITERACION DEL FOR PASANDO A LA SIGUIENTE ITERACION
						//IGNORANDO LA SETENCIA POSTERIOR.
			}
			
			if(recorrerEste(palabras.get(i))){
				pw.println((i + 1) + " E");
				continue;
			}
			
			if(recorrerSur(palabras.get(i))){
				pw.println((i + 1) + " S");
				continue;
			}
			
			if(recorrerOeste(palabras.get(i))){
				pw.println((i + 1) + " O");
				continue;
			}
		}
		pw.close();
	}
	
	
	private boolean recorrerNorte(String palabra){
		
		for(int i = 0; i < this.tablero.length; i++){
			/*USO StringBuilder EN VEZ DE String PORQUE VOY A ESTAR HACIENDO REITERADAS OPERACIONES DE MODIFICACION
			COMO LO ES LA CONCATENACION.
			"String" ES INMUTABLE, OSEA NO SE PUEDE MODIFICAR, Y AL ESTAR CONCATENANDO SE LIBERADA EL OBJETO ACTUAL
			Y CREARA UNO NUEVO EN CADA ITERACION CON EL RESULTADO, Y ESTO LLEVA MUCHO TRABAJO DE ASIGNACION, ETC.
			"StringBuilder" ES MUTABLE Y AL ESTAR CONCATENANDO, SE ACTUALIZARA EL CONTENIDO ACTUAL DE LA VARIABLE
			SIN ESTAR LIBERANDO Y CREANDO OTRO OBJETO.
			TAMBIEN PODRÍA USAR "StringBuffer" PERO NO ME INTERESA QUE SEA "SINCRONIZADO".
			*/
			StringBuilder linea = new StringBuilder(); 
			for(int j = this.tablero.length - 1; j >= 0; j--){
				linea.append(Character.toString(this.tablero[j][i])); //CONCATENANDO.
			}
			
			if(linea.toString().contains(palabra)){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean recorrerEste(String palabra){
		
		for(int i = 0; i < this.tablero.length; i++){
			StringBuilder linea = new StringBuilder();
			for(int j = 0; j < tablero.length; j++){
				linea.append(Character.toString(this.tablero[i][j]));
			}
			
			if(linea.toString().contains(palabra)){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean recorrerSur(String palabra){
			
		for(int i = 0; i < this.tablero.length; i++){
			StringBuilder linea = new StringBuilder();
			for(int j = 0; j < tablero.length; j++){
				linea.append(Character.toString(this.tablero[j][i]));
			}
				
			if(linea.toString().contains(palabra)){
					return true;
			}
		}
			
		return false;
	}
	
	private boolean recorrerOeste(String palabra){
		
		for(int i = 0; i < this.tablero.length; i++){
			StringBuilder linea = new StringBuilder();
			for(int j = tablero.length - 1; j >= 0; j--){
				linea.append(Character.toString(this.tablero[i][j]));
			}
			
			if(linea.toString().contains(palabra)){
				return true;
			}
		}
		
		return false;
	}
	
}
