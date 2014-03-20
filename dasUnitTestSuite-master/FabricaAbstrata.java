
public abstract class FabricaAbstrata {

	public abstract ProdutoA criarProdutoA();
	public abstract ProdutoB criarProdutoB();
	public static FabricaAbstrata instancia1 = null, 
								  instancia2 = null; 
	
	public static FabricaAbstrata obterFabrica(int num) {
		
		switch (num) {
		case 1: 
			if (instancia1 == null) 
				instancia1 = new Fabrica1();
			return instancia1;
		
		case 2: 
			if (instancia2 == null) 
				instancia2 = new Fabrica2();
			return instancia2;
			
		default: 
			return null;
		}
	}
}
