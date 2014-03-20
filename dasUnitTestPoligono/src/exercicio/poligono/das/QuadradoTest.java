package exercicio.poligono.das;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuadradoTest {
	private Quadrado quadrado;

	@Before
	public void setUp(){
		quadrado = new Quadrado();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQuadradoLadoPar() {
		quadrado.setLado(2);
		assertEquals(4, quadrado.calculaArea(), 0.001);
		assertTrue(quadrado.getLado() % 2 == 0);
		System.out.println("TESTE LADO PAR: " + quadrado.toString());
	}
	@Test
	public void testQuadradoLadoImpar() {
		quadrado.setLado(3);
		assertEquals(9, quadrado.calculaArea(), 0.001);
		assertTrue(quadrado.getLado() % 2 == 1);
		System.out.println("TESTE LADO PAR: " + quadrado.toString());
	}

}
