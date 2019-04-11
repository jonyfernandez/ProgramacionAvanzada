package figura;

public abstract class Figura {
	
	public abstract double area();
	
	public final double pinturaParaPintarse() { //final Me esta diciendo que esta funcion queda constante. No la puedo modificar
		return this.area() * 0.25;
	}

}
