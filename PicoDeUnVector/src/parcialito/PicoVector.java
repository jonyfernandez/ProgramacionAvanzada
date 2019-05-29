package parcialito;

public class PicoVector {
	
	public static int buscarPico(int[] vector){
		int medio;
		int inferior = 0;
		int superior = vector.length - 1;
		
		while(inferior <= superior){
			medio = (superior + inferior) / 2;
			if(vector[medio] > vector[medio + 1] && vector[medio] > vector[medio - 1]) 
				return medio;
			
			if(vector[medio] < vector[medio + 1])
				inferior = medio + 1;
			else 
				superior = medio - 1;
		}
		
		return -1;
	}

	public static void main(String[] args) {

		int vector[] = {1,2,3,4,5,6,5,4,3,2,1,0,-1};
		System.out.println(vector[buscarPico(vector)]);

	}

}
