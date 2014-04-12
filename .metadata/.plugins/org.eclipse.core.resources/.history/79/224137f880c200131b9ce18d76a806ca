package Refatoracao2_1aParte_FeitoEmSala;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class ImpostoTeste {

	Contribuinte c1; 
	Rendimento r1, r2, r3, r4, r5;
	Deducao d1, d2, d3, d4, d5; 
	
	@Before
	public void setUp() {
		c1 = new Contribuinte("Fulano de tal", new int[]{1,2,3,4,5,6,7,8,9,0,0});
		r1 = new Rendimento("Sal�rio", 1500, true);
		r2 = new Rendimento("Bolsa de estudo", 1000, false);
		d1 = new Deducao("Previd�ncia oficial", 150);
		d2 = new Deducao("Previd�ncia privada", 150);
		d3 = new Dependente("Fulano de tal Junior", new int[]{9,9,9,8,8,8,7,7,7,1,6});
		
		
		c1.adicionarRendimento(r1);
		c1.adicionarRendimento(r2);
		c1.adicionarDeducao(d1);
		c1.adicionarDeducao(d2);
		c1.adicionarDeducao(d3);
	}
	
	@Test
	public void testeValorRendimentos() {
		Assert.assertEquals(2500.0, (double)c1.getTotalRendimentos());
	}
	
	@Test
	public void testeValorRendimentosTributaveis() {
		Assert.assertEquals(1500.00, (double)c1.getTotalRendimentosTributaveis());
	}

	@Test
	public void testeValorRendimentosIsentos() {
		Assert.assertEquals(1000.00, (double)c1.getTotalRendimentosIsentos());
	}
	
	@Test 
	public void testeValorDeducoes() {
		Assert.assertEquals(471.97, (double)c1.getTotalDeducoes(), 0.001);  //471 = 150 + 150 + 171.79 (um dependente)
	}
	
	@Test
	public void testeBaseDeCalculo() {
		Assert.assertEquals(2028.03, (double)c1.getBaseDeCalculo(), 0.001); 
	}
}
