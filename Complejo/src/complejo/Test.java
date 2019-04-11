package complejo;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Complejo miComplejo = new Complejo(1.0,2.0);
		Complejo c2 = new Complejo(2.0,3.0);
		Complejo c3;
		double modulo;
		
		System.out.println(miComplejo);
		c3 = c2.sumar(c2);
		System.out.println(c3);
		
		modulo = miComplejo.modulo();
		System.out.println(modulo);
		
		c3 = c2.clone();
		
		System.out.println(c2);
		
		Complejo [] miVector = new Complejo[5];
		
		for(int i = 0; i < miVector.length; i++)
			miVector[i] = new Complejo(10 * Math.random(),10 * Math.random());
		
		//No puedo ordenar Complejos
		System.out.println(Arrays.toString(miVector));
		
		//Para ordenarlo tengo que ordenarlo con el metodo modulo.
		
		System.out.println(Arrays.toString(miVector));
		
		
	}

}
