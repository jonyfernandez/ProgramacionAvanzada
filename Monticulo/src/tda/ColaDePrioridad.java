package tda;

public class ColaDePrioridad<T extends Comparable<T>> {

	Monticulo<T> cola;
	
	public ColaDePrioridad(){
		
		cola = new Monticulo<T>();
		
	}
	
	
	public void offer(T dato) {
		
		cola.monticulear(dato);
		
	}
	
	public T poll() {
		
		return cola.desmonticulear();
		
	}
	
	public T peek() {
		
		return cola.mostrarPrimero();
		
	}
	
	public boolean isEmpty() {
		
		return cola.isEmpty();
	}

	public void empty() {
		
		cola.empty();
	}
	
}
