package topCorredores;

/*Dado un vector T de tiempo de corredores, mostrar los M mejores jugadores con el menor tiempo.
 */

public class Maraton {
	
	public static void topCorredores(double[] t,int[] top ,int m){
		
		int menor = 0;
		int n = t.length;
		
		for(int i = 0; i < m; i++){ //O(M*N)
			menor = i;
			for(int j = i + 1; j < n; j++){
				if(t[j] < t[menor]) menor = j;
			}
			
			double aux = t[i];
			t[i] = t[menor];
			t[menor] = aux;
			
			int aux2 = top[i];
			top[i] = top[menor];
			top[menor] = aux2;
		}
		
		for(int i = 0; i < m; i++){
			System.out.print(" "+top[i]);
		}
		
	}
	
	public static void main(String[] args) {
		
		double[] corredores = {1.2,0.5,3,4.1,3.5,5,7,1.5,0.7,2};
		int[] top = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		Maraton.topCorredores(corredores, top,7);
	}

}
