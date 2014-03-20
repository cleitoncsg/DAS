import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class Fabrica2Testes {

	private FabricaAbstrata f;
	private ProdutoA pa; 
	private ProdutoB pb;
	
	@Before
	public void inicializar(){
		f = FabricaAbstrata.obterFabrica(2);
		pa = f.criarProdutoA();
		pb = f.criarProdutoB();
	}

	@Test
	public void testeCriarProdutoA() {
		Assert.assertNotNull(f);
		Assert.assertNotNull(pa);
		Assert.assertTrue(ProdutoA2.class.isInstance(pa));
	}
	
	@Test
	public void testeCriarProdutoB() {
		Assert.assertNotNull(f);
		Assert.assertNotNull(pb);
		Assert.assertTrue(ProdutoB2.class.isInstance(pb));
	}

}
