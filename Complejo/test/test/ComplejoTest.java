package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import complejo.Complejo;
import complejo.ComplejoPorParteImaginaria;
import complejo.ComplejoPorParteReal;

public class ComplejoTest {

	@Test
	public void sumar() {
		Complejo c1 = new Complejo(2,3);
		Complejo c2 = new Complejo(2,3);
		Complejo c3 = new Complejo(4,6);
		Assert.assertEquals(c3, c1.sumar(c2));
		
	}
	@Test
	public void multiplicar() {
		Complejo c1 = new Complejo(3,2);
		Complejo c2 = new Complejo(2,5);
		Complejo c3 = new Complejo(-4,19);
		Assert.assertEquals(c3, c1.multiplicar(c2));
		
	}
	
	@Test
	public void modulo() {
		Complejo c1 = new Complejo(2,2);
		Assert.assertEquals(2.8284, c1.modulo(),0.0001);		
	}
	
	
	@Test
	public void queOrdena() {
		ArrayList<Complejo> vec = new ArrayList<Complejo>();
		Complejo c1 = new Complejo(3,2);
		vec.add(c1);
		Complejo c2 = new Complejo(2,5);
		vec.add(c2);
		Complejo c3 = new Complejo(-4,19);
		
		Assert.assertEquals(c3, c1.multiplicar(c2));
		
	}
	
	@Test
	public void ordenarParteReal() {
		Complejo[] original = {new Complejo(-3,2),
								new Complejo(1,2),
								new Complejo(2,3)
								
				
								};		
		Complejo[] ordenado = {new Complejo(-3,2),
								new Complejo(1,2),
								new Complejo(2,3)

				};	
		
		Arrays.sort(original, new ComplejoPorParteReal());
		
		Assert.assertArrayEquals(ordenado, original);
	}
	
	@Test
	public void ordenarParteImaginaria() {
		Complejo[] original = {new Complejo(-3,7),
								new Complejo(2,3),
								new Complejo(1,4),
				
								};		
		Complejo[] ordenado = {new Complejo(2,3),
							new Complejo(1,4),
							new Complejo(-3,7),

				};	
		
		Arrays.sort(original, new ComplejoPorParteImaginaria());
		Assert.assertArrayEquals(ordenado, original);
	}

}
