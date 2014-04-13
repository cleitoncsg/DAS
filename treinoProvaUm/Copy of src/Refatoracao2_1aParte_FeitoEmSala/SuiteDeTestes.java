package Refatoracao2_1aParte_FeitoEmSala;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ Contribuinte2aFaixaTest.class, Contribuinte3aFaixaTest.class,
		Contribuinte4aFaixaTest.class, Contribuinte5aFaixaTest.class,
		ContribuinteIsentoTest.class, ContribuinteParametrizado.class,
		ContribuinteTest.class, DeducaoTest.class, DependenteTest.class,
		ImpostoTeste.class, RendimentoTest.class, TestesElementares.class })
public class SuiteDeTestes {

}
