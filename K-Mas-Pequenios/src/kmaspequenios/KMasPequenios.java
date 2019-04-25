package kmaspequenios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class KMasPequenios extends Abstracta {
	
	private int cantValores;
	private int cantPequenios;
	private TreeSet<Integer> numeros = new TreeSet<Integer>();
	
	public KMasPequenios(File entrada, File salida){
		super(entrada,salida);
	}

	@Override
	public void resolver() throws IOException {
		Scanner sc = new Scanner(entrada);
		this.cantValores = sc.nextInt();
		this.cantPequenios = sc.nextInt();
		
		for(int i = 0; i < cantValores; i++){
			this.numeros.add(sc.nextInt());
		}
		
		sc.close();
		
		PrintWriter pw = new PrintWriter(new FileWriter(salida));
		
		if(this.cantPequenios > this.numeros.size())
			this.cantPequenios = this.numeros.size();
		
		pw.println(cantPequenios);
		
		for(int i = 0; i < cantPequenios; i++){
			pw.println(numeros.first());
			numeros.remove(numeros.first());
		}
		
		pw.close();
		
	}

}
