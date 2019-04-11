import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import complejo.Complejo;

public class ComplejoTest { //LOS TEST SE CORREN EN CUALQUIER ORDEN.
	
	Complejo uno;
	Complejo dos;
	
	@Before //ME DICE QUE ESTO SE EJECUTA ANTES DEL TEST.
	public void setUp() {
		uno = new Complejo(1,1);
		dos = new Complejo (2,1);
	}
	
	@Test
	public void multiplicacion() {
		Complejo tres = new Complejo (1,3);
		
		Assert.assertEquals(tres,uno.multiplicar(dos));
		
		
	}
}
