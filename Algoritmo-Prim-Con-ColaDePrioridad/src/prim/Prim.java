package prim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

	public class Prim {

	private int cantidadNodos;
	private int cantidadAristas;
	private int aristasEnUso;
	private PriorityQueue<Arista> cola = new PriorityQueue<Arista>();
	private ArrayList<Arista> arbolAbarcadorMinimo = new ArrayList<Arista>();
	private int costo;
	private ArrayList<Integer> noSolucion = new ArrayList<Integer>();
	private ArrayList<Integer> solucion = new ArrayList<Integer>(); 
	
	public Prim(Scanner entrada) {
		int nodo1, nodo2, costo;
		this.cantidadNodos = entrada.nextInt();
		this.cantidadAristas = entrada.nextInt();
		this.aristasEnUso = 0;
		this.costo = 0;
		for(int i=0; i<this.cantidadAristas; i++) {
			nodo1 = entrada.nextInt();
			nodo2 = entrada.nextInt();
			costo = entrada.nextInt();
			cola.offer(new Arista(nodo1, nodo2, costo));
		}
		for(int i=1; i <= this.cantidadNodos; i++)
			this.noSolucion.add(i);
	}

	public void calcularPrim(Integer principio) {
		Arista arista;
		Integer eliminar;
		this.noSolucion.remove(principio);
		this.solucion.add(principio);
		PriorityQueue<Arista> auxiliar = new PriorityQueue<Arista>();
		while(this.aristasEnUso != this.cantidadNodos-1 && this.cola.isEmpty() == false) {
			arista = this.cola.poll();
			if((solucion.contains(arista.getNodo1()) && noSolucion.contains(arista.getNodo2())) ||
					(solucion.contains(arista.getNodo2()) && noSolucion.contains(arista.getNodo1()))	) {
				if(solucion.contains(arista.getNodo1()) && noSolucion.contains(arista.getNodo2())) {
					eliminar = arista.getNodo2();
					this.noSolucion.remove(eliminar);
					this.solucion.add(eliminar);
				}
				else {
					eliminar = arista.getNodo1();
					this.noSolucion.remove(eliminar);
					this.solucion.add(eliminar);
				}
				this.arbolAbarcadorMinimo.add(arista);
				this.costo += arista.getCosto();
				this.aristasEnUso++;
				while(auxiliar.isEmpty() == false)
					this.cola.offer(auxiliar.poll());
			}
			else
				auxiliar.offer(arista);
		}
	}
	
	public void mostrarArbolYCosto() {
		System.out.println("El costo del arbol abarcador minimo es: " + this.costo);
		for (Arista arista : arbolAbarcadorMinimo) {
			System.out.println(arista.getNodo1() + " - " + arista.getNodo2() + " = " + arista.getCosto());
		}
	}
	
}
