package Refatoracao_1;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class Contribuinte5aFaixaTest {

	Contribuinte c1 = new Contribuinte("Fulano de tal", new int[]{1,2,3,4,5,6,7,8,9,0,0});
	Rendimento r1 = new Rendimento("Salario", 5000, true);
	Deducao d1 = new Deducao("Previdencia oficial", 500);
	
	@Before
	public void setUp() {
		c1.adicionarRendimento(r1);
		c1.adicionarDeducao(d1);
	}

	@Test
	public void test() {
		Assert.assertEquals(446.91, (double)c1.calcularImposto(), 0.02);
		Assert.assertEquals(5000.0, (double)c1.getTotalRendimentosTributaveis(), 0.02);
		Assert.assertEquals(500.0, (double)c1.getTotalDeducoes(), 0.02);
		Assert.assertEquals(4500.0, (double)c1.getBaseDeCalculo(), 0.02);
		Assert.assertEquals(0.0, (double)c1.getValor1aFaixa(), 0.02);
		Assert.assertEquals(63.98, (double)c1.getValor2aFaixa(), 0.02);
		Assert.assertEquals(128.20, (double)c1.getValor3aFaixa(), 0.02);
		Assert.assertEquals(191.92, (double)c1.getValor4aFaixa(), 0.02);
		Assert.assertEquals(62.81, (double)c1.getValor5aFaixa(), 0.02);
	}

}
