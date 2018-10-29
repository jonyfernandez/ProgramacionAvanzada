package grafos;

public class Nodo {
	private int nodo;
	private int grado;
	private int color;
	
	public Nodo(int nodo, int grado) {
		this.nodo = nodo;
		this.grado = grado;
		this.color = 0;
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	

}
