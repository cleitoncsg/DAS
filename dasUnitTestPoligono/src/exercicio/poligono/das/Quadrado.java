package exercicio.poligono.das;


public class Quadrado extends Poligono{
	
	private int lado;

	@Override
	public double calculaArea() {
		return lado*lado;
	}

	public double getLado(){
		return lado;
	}
	public void setLado(int lado){
		this.lado = lado;
	}

}
