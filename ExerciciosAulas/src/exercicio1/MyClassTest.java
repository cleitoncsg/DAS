package exercicio1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyClassTest {
	
	private MyClass myClass;

	@Before
	public void setUp() throws Exception {
		myClass = new MyClass();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMultiply() {
		assertEquals(2, myClass.multiply(4, 2));
	}

}
