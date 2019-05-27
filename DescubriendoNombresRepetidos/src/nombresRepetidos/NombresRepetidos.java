package nombresRepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class NombresRepetidos extends EjercicioOIA {
	
	private Map<String, Integer> nombres;
	private TreeMap<Integer, String> repetidos;
	private int chicos;
	private int cantABuscar;
	
	public NombresRepetidos(File entrada, File salida){
		super(entrada,salida);
		
		nombres = new TreeMap<String, Integer>();
		repetidos = new TreeMap<Integer, String>();
		
		procesarEntrada();
	}
	
	private void procesarEntrada() {
		
		try {
			Scanner sc = new Scanner(entrada);
			
			chicos = sc.nextInt();
			cantABuscar = sc.nextInt();
			int apariciones;
			
			for(int i = 0; i < chicos; i++){
				String nombre = sc.next();
				
				if(nombres.containsKey(nombre)){
					apariciones = nombres.get(nombre);
					nombres.put(nombre, apariciones + 1);
				}
				else
					nombres.put(nombre, 1);
			}
			
			sc.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void resolver() throws IOException {
		
		/*RECORRO EL TreeMap COMO SI FUERA UNA LISTA.
		Y LO VOY GUARDANDO EN REPETIDOS.
		 */
		for(Entry<String, Integer> nombre : nombres.entrySet()){
			this.repetidos.put(nombre.getValue(), nombre.getKey());
		}
		
		procesarSalida();
		
	}
	
	private void procesarSalida() throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		
		if(this.cantABuscar > this.repetidos.size())
			cantABuscar = this.repetidos.size();
		
		for(int i = 0; i < cantABuscar; i++){
			Entry<Integer, String> nombre = this.repetidos.pollLastEntry();
			pw.println(nombre.getValue()+" "+nombre.getKey());
		}
		
		pw.close();
	}

}
