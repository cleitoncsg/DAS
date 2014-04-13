
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


/**
 * Esse Caso de Teste � extremamente simples. Ele testa uma �nica unidade do projeto, no caso a classe Rendimento. O 
 * teste � feito com base na interface p�blica do objeto Rendimento, e testar� coisas como instancia��o de objetos, 
 * atribui��o de valores, etc...
 * @author Andre
 *
 */
public class RendimentoTest {

	Rendimento tributavel, naoTributavel;
	
	@Before
	public void setUp() {
		tributavel = new Rendimento("Salario", 1000, true);
		naoTributavel = new Rendimento("Bolsa de estudos", 1000, false);
	}
	
	@Test
	public void testRendimento() {
		assertNotNull(tributavel);
		assertNotNull(naoTributavel);
	}

	@Test
	public void testGetDescricao() {
		Assert.assertEquals("Salario", tributavel.getDescricao());
		Assert.assertEquals("Bolsa de estudos", naoTributavel.getDescricao());
	}

	@Test
	public void testGetValor() {
		Assert.assertEquals(1000.0, (double)tributavel.getValor());
		Assert.assertEquals(1000.0, (double)naoTributavel.getValor());
	}

	@Test
	public void testIsTributavel() {
		Assert.assertTrue(tributavel.isTributavel());
		Assert.assertFalse(naoTributavel.isTributavel());
	}

}
