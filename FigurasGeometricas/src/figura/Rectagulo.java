package figura;

public class Rectagulo extends Figura {
	
	private double base;
	private double altura;

	public Rectagulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}



	@Override
	public double area() {
		
		return this.base * this.altura;
	}
	

}
