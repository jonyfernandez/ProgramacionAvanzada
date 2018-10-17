package reinas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Reinas extends EjercicioOIA{
	
	private int[][] tablero;
	private int dimension;
	private Map<Integer, List<Integer>> conflictos = new HashMap<Integer, List<Integer>>();

	public Reinas(File entrada, File salida) {
		super(entrada,salida);
		procesarEntrada();
	}

	private void procesarEntrada() {
		
		try {
			
			Scanner sc = new Scanner(entrada);
			this.dimension = sc.nextInt();
			if (this.dimension < 1 || this.dimension > 10000) {
				sc.close();
				System.out.println("El tamaño del tablero no es válido.");
				System.exit(0);					
			}
			
			int cantidadReinas = sc.nextInt();
			if (cantidadReinas < 1 || cantidadReinas > 50000) {
				sc.close();
				System.out.println("La cantidad de Reinas no es válida.");
				System.exit(0);	
			}
			this.tablero = new int[this.dimension][this.dimension];
			
			for (int reinaActual = 1; reinaActual <= cantidadReinas; reinaActual++) {
				
				this.tablero[sc.nextInt() - 1][sc.nextInt() - 1] = reinaActual;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void resolver() {
		int filaAux, columnaAux;
		boolean colision = false;
		List<Integer> conflicto;
		
		for (int fila = 0; fila < this.dimension; fila++) {
			for (int columna = 0; columna < this.dimension; columna++) {
				// Genero una lista por cada Reina.
				conflicto = new ArrayList<Integer>();
				// Si hay una reina empiezo a comparar en todas las direcciones.
				if (this.tablero[fila][columna] != 0) {
					
					// Reviso por filas superiores.
					filaAux = fila - 1;
					while (filaAux >= 0 && !colision) {
						if (this.tablero[filaAux][columna] != 0) {
							conflicto.add(this.tablero[filaAux][columna]);
							colision = true;
						}
						filaAux--;
					}
					colision = false;

					// Reviso por filas inferiores.
					filaAux = fila + 1;
					while (filaAux < this.dimension && !colision) {
						if (this.tablero[filaAux][columna] != 0) {
							conflicto.add(this.tablero[filaAux][columna]);
							colision = true;
						}
						filaAux++;
					}
					colision = false;

					// Reviso columnas inferiores.
					columnaAux = columna - 1;
					while (columnaAux >= 0 && !colision) {
						if (this.tablero[fila][columnaAux] != 0) {
							conflicto.add(this.tablero[fila][columnaAux]);
							colision = true;
						}
						columnaAux--;
					}
					colision = false;

					// Reviso columnas superiores.
					columnaAux = columna + 1;
					while (columnaAux < this.dimension && !colision) {
						if (this.tablero[fila][columnaAux] != 0) {
							conflicto.add(this.tablero[fila][columnaAux]);
							colision = true;
						}
						columnaAux++;
					}
					colision = false;

					// Recorro la diagonal superior izquierda.
					filaAux = fila - 1;
					columnaAux = columna - 1;
					while (columnaAux >= 0 && filaAux >= 0 && !colision) {
						if (this.tablero[filaAux][columnaAux] != 0) {
							conflicto.add(this.tablero[filaAux][columnaAux]);
							colision = true;
						}
						columnaAux--;
						filaAux--;
					}
					colision = false;

					// Recorro la diagonal superior derecha.
					filaAux = fila - 1;
					columnaAux = columna + 1;
					while (columnaAux < this.dimension && filaAux >= 0 && !colision) {
						if (this.tablero[filaAux][columnaAux] != 0) {
							conflicto.add(this.tablero[filaAux][columnaAux]);
							colision = true;
						}
						columnaAux++;
						filaAux--;
					}
					colision = false;

					// Recorro la diagonal inferior izquierda.
					filaAux = fila + 1;
					columnaAux = columna - 1;
					while (filaAux < this.dimension && columnaAux >= 0 && !colision) {
						if (this.tablero[filaAux][columnaAux] != 0) {
							conflicto.add(this.tablero[filaAux][columnaAux]);
							colision = true;
						}
						columnaAux--;
						filaAux++;
					}
					colision = false;

					// Recorro la diagonal inferior derecha.
					filaAux = fila + 1;
					columnaAux = columna + 1;
					while (columnaAux < this.dimension && filaAux < this.dimension && !colision) {
						if (this.tablero[filaAux][columnaAux] != 0) {
							conflicto.add(this.tablero[filaAux][columnaAux]);
							colision = true;
						}
						columnaAux++;
						filaAux++;
					}
					colision = false;
					//Ordeno las reinas
					Collections.sort(conflicto);
					//Inserto las reinas y los conflictos
					this.conflictos.put(this.tablero[fila][columna], new ArrayList<Integer>(conflicto));
				}
			}
		}
		procesarSalida();
	}

	private void procesarSalida() {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(salida));
			Iterator<Entry<Integer, List<Integer>>> iterator = this.conflictos.entrySet().iterator();
			while (iterator.hasNext()) { //hasNext devuelve true si existe un siguiente elemento.
				Entry<Integer, List<Integer>> actual = iterator.next();
				pw.print(actual.getValue().size() + " ");
				for (Integer reina : actual.getValue()) {
					
					pw.print(reina + " ");
				}
				pw.println("");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
