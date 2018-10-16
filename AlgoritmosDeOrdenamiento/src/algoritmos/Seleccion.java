package algoritmos;

public class Seleccion {
	
	public static void ordenar(int vec[]){
		int menor;
		for(int i = 0; i < vec.length - 1; i++){
			menor = i;
			for(int j = i + 1; j < vec.length; j++){
				if(vec[j] < vec[menor]){
					menor = j;
				}
			}
			
			int aux = vec[i];
			vec[i] = vec[menor];
			vec[menor] = aux;
		}
	}
	
	public static void mostrar(int vec[]){
		System.out.println("Ordenado por Seleccion");
		for(int i = 0; i < vec.length; i++){
			System.out.print(vec[i]+"\t");
		}
	}

}
