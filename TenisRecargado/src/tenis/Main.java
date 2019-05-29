package tenis;

import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		TenisRecargado tenis = new TenisRecargado(new File("prehistorico.in"), new File("resultado.out"));
		tenis.resolver();
		TenisRecargado tenis2 = new TenisRecargado(new File("prehistorico02.in"), new File("resultado02.out"));
		tenis2.resolver();

	}

}
