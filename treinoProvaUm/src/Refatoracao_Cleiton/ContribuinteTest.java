package Refatoracao_Cleiton;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Esse caso de teste realiza os testes para as funcionalidades mais triviais (CRUD) de Contribuinte, alem de testar a 
 * instanciacao de um contribuinte. 
 * @author Andre
 *
 */
public class ContribuinteTest {

	Contribuinte c1; 
	Rendimento r1, r2, r3;
	Deducao ddc1, ddc2, ddc3; 
	Dependente dpd1, dpd2;
	
	@Before
	public void setUp(){
		c1 = new Contribuinte("Fulano de tal", new int[]{1,2,3,4,5,6,7,8,9,0,0});
		r1 = new Rendimento("Salario", 5000, true);
		ddc1 = new Deducao("Contribuicao Oficial", 300); 
		dpd1 = new  Dependente("Fulano Jr.", new int[]{9,9,9,8,8,8,7,7,7,1,6});
		
		c1.adicionarRendimento(r1);
		c1.adicionarDeducao(ddc1);
		c1.adicionarDeducao(dpd1);
	}
	
	@Test
	public void testContribuinte() {
		Assert.assertNotNull(c1);
	}

	@Test
	public void testAdicionarRendimento() {
		r2 = new Rendimento("Alugueis", 8000, true);
		r3 = new Rendimento("Bolsa de Estudo", 9600, false);
		
		Assert.assertTrue(c1.adicionarRendimento(r2));
		Assert.assertTrue(c1.adicionarRendimento(r2));
	}

	@Test
	public void testExcluirRendimento() {
		//teste de exclusao de um rendimento existente para o contribuinte 
		Assert.assertTrue(c1.excluirRendimento(r1));
		//teste de exclusao de um rendimento inexistente para o contribuinte
		r2 = new Rendimento("Alugueis", 8000, true);
		Assert.assertFalse(c1.excluirRendimento(r2));
	}

	@Test
	public void testAdicionarDeducao() {
		ddc2 = new Deducao("Previdencia privada", 500);
		ddc3 = new Deducao("Pensao", 1000);
		
		Assert.assertTrue(c1.adicionarDeducao(ddc2));
		Assert.assertTrue(c1.adicionarDeducao(ddc3));
	}

	@Test
	public void testExcluirDeducao() {
		//teste de exclusao de uma deducao existente para o contribuinte
		Assert.assertTrue(c1.excluirDeducao(ddc1));
		//teste de exclusao de uma deducao inexistente para o contribuinte
		ddc2 = new Deducao("Previdencia privada", 500);
		Assert.assertFalse(c1.excluirDeducao(ddc2));
	}
	
//	@Test
//	public void testCalculoImposto() {
//		Assert.assertEquals(454.63, (double)c1.calcularImposto(), 0.01);
//	}
//	
//	@Test
//	public void test5aFaixa() {
//		Assert.assertEquals(23.23, (double)c1.getValor5aFaixa()); 
//	}

}
