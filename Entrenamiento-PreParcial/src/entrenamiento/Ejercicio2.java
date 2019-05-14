package entrenamiento;

/*
Dado un vector V de N (N > 1) componentes y un entero positivo M < N V = [a(1),a(2),...,a(M),a(M+1),...,a(N)]
escribir un programa que lo lleve a la forma:

W = [a(M+1),a(M+2),...,a(N),a(1),...,a(M)]

o sea, si consideramos:

A = [a(1),a(2),...,a(M)] B = [a(M+1),a(M+2),...,a(N)]

podemos pensar que se trata de llevar el vector

V = AB

a la forma W = BA

Nota: Ningún otro vector adicional podrá usarse y deberá hacerse la menor cantidad de reordenamientos de los elementos de V. 
Llamamos "reordenamiento" a cada sentencia en la que se han intercambiado dos elementos de V.
*/


public class Ejercicio2 {

	public static void main(String[] args) {
		
		int [] vector = {1,2,3,4,5,6,7,8,9};
		mostrar(vector);
		reordenanamiento(vector,9,6);
		mostrar(vector);

	}
	
	public static void reordenanamiento(int[] vec, int n, int m) {
		
		int i;
		int aux;
		int j = m;
		int tam = n-m;
		
		for(i = 0; i < tam ; i++) { //Intercambio desde 0 a N-M con las de M hasta N
				
			aux=vec[i];
			vec[i]=vec[j];
			vec[j]=aux;						
			j++;
		}
		
		j = m;
		
		while(i < m){ //Intercambio desde N-M a M con las de M hasta N
			aux=vec[i];
			vec[i]=vec[j];
			vec[j]=aux;
			j++;
			i++;
		}
		
	}
	
	public static void mostrar(int[] vec) {
		int tam = vec.length;
		
		for(int i=0;i<tam;i++) {
	    	 System.out.print(""+vec[i]);
	     }
		System.out.println("");
	}

}
