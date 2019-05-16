package tda;

//MONTICULO DE MÍNIMO
public class Monticulo<T extends Comparable<T>> {
	
	private T[] vector;
	private int tam = 2; //es 2 porque la primera posicion del vector no se usa.
	private int cantElementos;
	
	public Monticulo(){
		tam = 2;
		cantElementos = 0;
		vector = (T[])new Comparable[tam];
	}
	
	public void monticulear(T dato){
		
		if(cantElementos == tam - 1)
			redimensionar();
		
		cantElementos++;
		vector[cantElementos] = dato;
		int i = cantElementos;
		T aux;
		
		//Veo si el elemento ingresado cumple con la condicion de que el PADRE tiene que ser Menor a sus HIJOS.
		while(i > 1 && vector[i].compareTo(vector[padre(i)]) < 0){ 
			
			aux = vector[i];
			vector[i] = vector[padre(i)];
			vector[padre(i)] = aux;
			i = padre(i);
		}
		
	}
	
	public T desmonticulear(){
		
		if(this.cantElementos == 0)
			return null;
		
		T dato = vector[1];
		vector[1] = vector[cantElementos--];
		int i = 1;
		T aux;
		
		while(cantElementos >= i * 2 + 1 ){ //Me fijo que no me pase del tamaño del vector.
			
			T menor;
			
			//Si el Hijo Izquierdo es menor al Derecho voy por el lado Izquierdo, sino me voy para el Derecho.
			if(vector[hijoIzquierdo(i)].compareTo(vector[hijoDerecho(i)]) < 0){
				
				menor = vector[hijoIzquierdo(i)];
				vector[hijoIzquierdo(i)] = vector[i];
				vector[i] = menor;
				i = hijoIzquierdo(i);
				
			}else {
				
				menor = vector[hijoDerecho(i)];
				vector[hijoDerecho(i)] = vector[i];
				vector[i] = menor;
				i = hijoDerecho(i);
				
			}
		}
		
		//Cuando el ultimo nodo solo tiene un Hijo Izquierdo.
		if(cantElementos >= i * 2 && vector[i].compareTo(vector[hijoIzquierdo(i)]) > 0){
			
			aux = vector[i];
			vector[i] = vector[hijoIzquierdo(i)];
			vector[hijoIzquierdo(i)] = aux;
		}
			
		
		return dato;
	}
	
	public T mostrarPrimero(){
		return vector[1];
	}
	
	public boolean isEmpty(){
		
		return cantElementos == 0;
		
	}
	
	public void empty(){
		
		cantElementos = 0;
		
	}
	
	public int padre(int i){
		return (int)i/2;
	}
	
	public int hijoIzquierdo(int i){
		return i * 2;
	}
	
	public int hijoDerecho(int i){
		return i * 2 + 1;
	}
	
	public void redimensionar(){
		
		T[] nuevo = (T[])new Comparable[tam * 2];
		
		for(int i = 1; i< tam; i++){
			nuevo[i] = vector[i];
		}
		tam *= 2;
		vector = nuevo;
	}

}
