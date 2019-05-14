package entrenamiento;

public class Ejercicio4 {
	
	public static double calcularValorIntermedio(double a, double b, double error){
		
		if(evaluarPolinomio(a) * evaluarPolinomio(b) >= 0){
			System.out.println("No existe un punto medio en el intervalo ["+a+","+b+"]");
			System.exit(0);
		}
		
		double puntoMedio = (a + b) / 2;
		double anterior = a;
		while(Math.abs(anterior - puntoMedio) > error){
			if(evaluarPolinomio(anterior) * evaluarPolinomio(puntoMedio) > 0)
				a = puntoMedio;
			else
				b = puntoMedio;
			
			anterior = puntoMedio;
			puntoMedio = (a + b) / 2;
		}
		return puntoMedio;
	}
	
	public static double evaluarPolinomio(double x){
		return -Math.pow(x, 4) - Math.pow(x, 3) + 1;
	}

	public static void main(String[] args) {
		double error = 0.01;
		System.out.println(evaluarPolinomio(-1));
		System.out.println(evaluarPolinomio(1));
		System.out.println("El punto medio es: "+calcularValorIntermedio(-1, 1, error));

	}

}
