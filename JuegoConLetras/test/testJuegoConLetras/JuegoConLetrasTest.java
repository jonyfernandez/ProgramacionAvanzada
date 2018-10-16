package testJuegoConLetras;

import java.io.IOException;

import org.junit.Test;

import juegoConLetras.Rapigrama;

public class JuegoConLetrasTest {

	@Test
	public void testJuego00() throws IOException {
		Rapigrama juego = new Rapigrama("entrada00.in");
		juego.resolver("salida00.out");
	}
	
	@Test
	public void testJuego01() throws IOException {
		Rapigrama juego = new Rapigrama("entrada01.in");
		juego.resolver("salida01.out");
	}

}
