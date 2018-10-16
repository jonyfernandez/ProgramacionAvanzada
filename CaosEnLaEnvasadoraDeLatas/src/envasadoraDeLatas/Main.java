package envasadoraDeLatas;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		EnvasadoraDeLatas latas = new EnvasadoraDeLatas(new File("LATAS02.in"), new File("LATAS02.out"));
		latas.resolver();

	}

}
