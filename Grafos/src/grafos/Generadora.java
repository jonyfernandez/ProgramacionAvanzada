package grafos;

public abstract class Generadora {
	
	private int cantNodos;
	private int gradoMaximo, minimo, cantAristas;
	private double porceAdy;
	protected MatrizSimetrica matriz;
	
	public abstract void generar();
	
	public Generadora(int n) {
		this.cantNodos = n;
		this.matriz = new MatrizSimetrica(n);
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}
	
	public void gradoMaximoMinimoCa() {
		int[] vecGrado = new int[this.cantNodos];
		for(int i = 0; i < this.cantNodos - 1; i++) {
			for(int j = 0; j < this.cantNodos - 1; j++) {
				if(matriz.getFC(i, j)) vecGrado[i]++;
			}
		}
		
		this.gradoMaximo = 0;
		this.minimo = this.cantNodos;
		for(int i = 0; i < this.cantNodos; i++) {
			this.cantAristas += vecGrado[i];
			if(gradoMaximo < vecGrado[i]) 
				this.gradoMaximo = vecGrado[i];
			else if(minimo > vecGrado[i])
					minimo = vecGrado[i];
		}
		
		this.cantAristas = this.cantAristas / 2 ;
		
	}
	
	public double getPorceAdy() {
		int aristas = this.cantNodos * (this.cantNodos - 1) / 2;
		return (double)this.cantAristas / (double) aristas;
	}
}
