package depositoSubterraneo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DepositoSubterraneo extends EjercicioOIA {
	
	private Integer[] superficie;
	private Integer[] profundidad;
	private int cantDepositos;
	private int volumenSolicitado;

	public DepositoSubterraneo(File entrada, File salida) {
		super(entrada, salida);
		procesarEntrada();
	}
	
	private void procesarEntrada(){
		try {
			Scanner sc = new Scanner(entrada);
			this.cantDepositos = sc.nextInt();
			this.superficie = new Integer[this.cantDepositos];
			this.profundidad = new Integer[this.cantDepositos];
			
			for(int i = 0; i < this.cantDepositos; i++){
				this.superficie[i] = sc.nextInt();
				this.profundidad[i] = sc.nextInt();
			}
			
			this.volumenSolicitado = sc.nextInt();
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void resolver() throws IOException {
		
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		
		int acum = 0;
		
		for (int i = 0; i < cantDepositos; i++) {
			acum += this.superficie[i]* this.profundidad[i];
		}		
		if(this.volumenSolicitado > acum)
			pw.println("Rebasan :"+ (volumenSolicitado - acum));
		else 
			if(volumenSolicitado == acum){
				pw.println(""+cantDepositos);
				pw.println("0");
			}
			else{
				//calcula la cantidad de depositos utilizados
				acum = 0;
				int acumSup = 0;
				for (int i = 0; i < cantDepositos; i++) {
					acumSup += this.superficie[i];
					int acumAnterior = acum;
					for (int j = 0; j <= i; j++) {
						if(i+1 < cantDepositos)
							acum += ((this.profundidad[i] - this.profundidad[i+1]) * this.superficie[j]);
						else
							acum +=(this.profundidad[i] * this.superficie[j]);
					}
					
					if (acum >=volumenSolicitado){
					//condición de corte, se va a pasar si usa otro tanque mas
						pw.println(i+1);
						pw.println((int)(this.profundidad[i] - (Math.pow((this.volumenSolicitado - acumAnterior)/acumSup, 1/(i+1)))));
						break;
					}
				}	
			}
		
		pw.close();
		
	}
	
}
