import static org.junit.Assert.*;
import junit.framework.Assert;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;


public class MetodoFabricaTeste {

	FabricaAbstrata f1, f2, fnull;
	
	@Before
	public void inicializar() {
		f1 = FabricaAbstrata.obterFabrica(1);
		f2 = FabricaAbstrata.obterFabrica(2);
		fnull = FabricaAbstrata.obterFabrica(0);
	}
	
	@Test
	public void testFabrica1() {
		Assert.assertNotNull(f1);
		Assert.assertTrue(Fabrica1.class.isInstance(f1));
	}
	
	@Test
	public void testFabrica2() {
		Assert.assertNotNull(f2);
		Assert.assertTrue(Fabrica2.class.isInstance(f2));
	}
	
	@Test
	public void testeFabricaNula() {
		Assert.assertNull(fnull);
	}

}
