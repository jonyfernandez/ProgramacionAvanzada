package depositoSubterraneo;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		DepositoSubterraneo deposito = new DepositoSubterraneo(new File("depositos.in"), new File("depositos.out"));
		deposito.resolver();

	}

}
