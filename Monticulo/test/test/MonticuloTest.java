package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tda.Monticulo;

public class MonticuloTest {
	
	Monticulo<Integer> monticulo;
	
	@Before
	public void setUp(){
		monticulo = new Monticulo<Integer>();
	}
	
	@Test
	public void monticulear() {
		monticulo.monticulear(6);
		monticulo.monticulear(2);
		monticulo.monticulear(4);
		monticulo.monticulear(1);
		Assert.assertEquals((Integer)1, monticulo.mostrarPrimero());
	}
	
	@Test
	public void desmonticulear() {
		monticulo.monticulear(6);
		monticulo.monticulear(2);
		monticulo.monticulear(4);
		monticulo.monticulear(1);
		Assert.assertEquals((Integer)1, monticulo.desmonticulear());
	}
	

}
