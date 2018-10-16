package algoritmos;

public class Insercion {

	public static void ordenar(int vec[]){
		int j;
		for(int i = 1; i < vec.length; i++){
			j = i;
			while(j > 0 && vec[j] < vec[j - 1]){
				int aux = vec[j-1];
				vec[j-1] = vec[j];
				vec[j] = aux;
				j--;
			}
		}
	}
	
	public static void mostrar(int vec[]) {
		System.out.println("Ordenado por Insercion");
		for(int i = 0; i < vec.length; i++){
			System.out.print(vec[i]+"\t");
		}
	}
	
}
