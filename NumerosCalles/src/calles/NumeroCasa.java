package calles;

public class NumeroCasa {
	
	public static int metodo1(int n) { //Complejidad Computacional de N^N
		if (n<3) return -1;
		for (int i = 2; i<=n; i++){
			int sumaIzq = 0;
			for(int j=1; j<i; j++) {
				sumaIzq += j;
			}
			int sumaDer = 0;
			for(int k=i+1; k<=n; k++) {
				sumaDer += k;
			}
			if(sumaDer == sumaIzq) return i;
		}
		
		return -1;
	}
	
	public static int metodo2(int n) { //Complejidad Computaciona de N (lineal)
		if (n<3) return -1;
		
		for (int i = 1; i<=n; i++) {
			int sumaIzq = (i*(i-1))/2; //Para mejorar esto, se igualan las sumas y se despeja i
			int sumaDer = ((n*(n-1))-(i*(i+1)))/2; //En el metodo 3 esta el resultado.
			if(sumaDer == sumaIzq) return i;
		}
		return -1;
	}
	
	public static int metodo3(int n) { //Complejidad Computacional de 1.
		if (n<3) return -1;
		double i = Math.sqrt(Math.pow(n, 2)+n)/2;
		int entera = (int)i;
		if((i-entera) == 0) return (int)i;
		///if(i % 1 == 0) return (int)i;
		
		return -1;
		
	}

}
