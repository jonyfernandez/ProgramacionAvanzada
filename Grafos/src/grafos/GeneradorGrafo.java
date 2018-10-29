package grafos;

import java.util.ArrayList;
import java.util.Collections;

public class GeneradorGrafo extends Generadora{
	private double probabilidad;
	private ArrayList<Nodo> nodo;
	private ArrayList<Arista> aristas;
	
	
	public GeneradorGrafo(int n, double probabilidad) {
		super(n);
		this.probabilidad = probabilidad;
		nodo = new ArrayList<Nodo>(n);
	}

	@Override
	public void generar() { //ALEATORIA CON PROBABILIDAD
		
		
		for(int i = 0; i <= super.getCantNodos() - 2; i++) {
			for(int j = i + 1; i < super.getCantNodos() - 1; j++) {
				
				Arista arista = new Arista(i, j);
				aristas.add(arista);
				
			}			
		}
		
		Collections.shuffle(aristas);
		
		for(int i = 0; i < super.getCantNodos(); i++)
			super.matriz.setFC(i, i, true);
	}
	
	public static void aleatorioConPorceAdy(int cantNodo, double porcentaje) {
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		int cantArista = cantNodo * (cantNodo - 1) / 2;
	}
	
	public void coloreoSecuencialAleatorio() {
		Collections.shuffle(nodo);
		
		for(int i = 0; i < super.getCantNodos(); i++) {
			int color = 1;
			
			while(!colorear(nodo.get(i),color)) {
				color++;
			}
			
			nodo.get(i).setColor(color);
			
		}
		
	}
	
	private boolean colorear(Nodo nodo, int color) {
		//.....................
	return false;
	}
}
