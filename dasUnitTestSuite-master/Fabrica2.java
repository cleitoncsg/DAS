
public class Fabrica2 extends FabricaAbstrata{

	public ProdutoA criarProdutoA() {
		return new ProdutoA2();
	}
	
	public ProdutoB criarProdutoB() {
		return new ProdutoB2();
	}
}
