import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class TesteSingletonFabrica {

	FabricaAbstrata f1, f2, f3, f4, f5; 
	
	@Before
	public void inicializar() {
		f1 = FabricaAbstrata.obterFabrica(1);
		f2 = FabricaAbstrata.obterFabrica(1);
		f3 = FabricaAbstrata.obterFabrica(2);
		f4 = FabricaAbstrata.obterFabrica(2);
		f5 = FabricaAbstrata.obterFabrica(0);
	}
	
	@Test
	public void testeFabrica1() {
		Assert.assertSame(f1, f2);
		Assert.assertSame(f2, f1);
		Assert.assertSame(FabricaAbstrata.obterFabrica(1), f1);
		Assert.assertSame(FabricaAbstrata.obterFabrica(1), f2);
	}
	
	@Test
	public void testeFabrica2() {
		Assert.assertSame(f3, f4);
		Assert.assertSame(f4, f3);
		Assert.assertSame(FabricaAbstrata.obterFabrica(2), f3);
		Assert.assertSame(FabricaAbstrata.obterFabrica(2), f4);
	}
	
	@Test
	public void testeFabricaNula() {
		Assert.assertNull(f5);
	}

}
