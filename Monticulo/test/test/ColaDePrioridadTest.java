package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tda.ColaDePrioridad;;

public class ColaDePrioridadTest { //PRIORIDAD CON NUMEROS MENORES

	ColaDePrioridad<Integer> cola;
	
	@Before
	public void setUp(){
		cola = new ColaDePrioridad<Integer>();
	}
	
	@Test
	public void offerPollPeek() {
		cola.offer(3); 
		cola.offer(2);
		cola.offer(4);
		Assert.assertEquals((Integer)2, cola.peek());
		Assert.assertEquals((Integer)2, cola.poll());
		Assert.assertEquals((Integer)3, cola.peek());
	}
	
	@Test
	public void emptyTest(){
		Assert.assertEquals(true, cola.isEmpty());
		cola.offer(4);
		cola.offer(3);
		Assert.assertEquals(false, cola.isEmpty());
		cola.empty();
		Assert.assertEquals(true, cola.isEmpty());
	}

}
