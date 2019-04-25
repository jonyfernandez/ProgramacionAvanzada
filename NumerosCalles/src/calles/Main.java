package calles;

public class Main {

	public static void main(String[] args) {
		
		int numeros = 8;
		int calle;
		
		calle = NumeroCasa.metodo2(numeros);
		
		if(calle!=-1){
			System.out.println("La calle es: " + calle);
		}else
			System.out.println("No hay");

	}

}
