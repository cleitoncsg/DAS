import junit.framework.*;

/** Uma classe de teste JUnit para a classe IMath */

public class IMathTest extends TestCase {

  /** Testa isqrt. */
  public void testIsqrt() {
    assertEquals(0, IMath.isqrt(0)); // line 23
    assertEquals(1, IMath.isqrt(1));
    assertEquals(1, IMath.isqrt(2));
    assertEquals(1, IMath.isqrt(3));
    assertEquals(2, IMath.isqrt(4));
    assertEquals(2, IMath.isqrt(7));
    assertEquals(3, IMath.isqrt(9));
    assertEquals(10, IMath.isqrt(100));
  }

  /** Retorna a suite de teste para a classe de teste */
  public static Test suite() {
    return new TestSuite(IMathTest.class);
  }

  /** Executa os testes */
  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}

