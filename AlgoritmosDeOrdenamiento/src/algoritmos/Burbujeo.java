package algoritmos;

public class Burbujeo {
	
	public static void ordenar(int vec[]){
		int j = 0, aux;
		boolean cambio = true;
		while(cambio){
			cambio = false;
			j++;
			for(int i = 0; i < vec.length-j; i++){
				if(vec[i] > vec[i+1]){
					aux = vec[i];
					vec[i] = vec[i+1];
					vec[i+1] = aux;
					cambio = true;
				}
			}
		}
		
	}
	
	
	public static void mostrar(int vec[]){
		System.out.println("Ordenamiento por Burbujeo");
		for(int i = 0; i < vec.length; i++){
			System.out.print(vec[i]+"\t");
		}
	}
}
