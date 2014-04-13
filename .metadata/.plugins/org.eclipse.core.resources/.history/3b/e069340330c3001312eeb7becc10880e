import java.util.Enumeration;


public class CalculoDeImposto {

	//Referencia para o objeto da classe original - classe onde o metodo foi extraido
	Contribuinte c; 
	
	//referencias para cada variavel temporaria e parametro do metodo extraido
	Enumeration<Deducao> d ;
	Deducao temp;
	float temp2;

	protected float totalRendimentos, totalRendimentosTributaveis, totalRendimentosIsentos;
	
	
	//Criar um construtor que receba o objeto fonte e cada parâmetro
	public CalculoDeImposto(Contribuinte c) {
		this.c = c;
	}
	
	public float computar() {
        
		c.calcularRendimentos();
		
		//2a PARTE: CALCULOS DAS DEDUCOES
		c.totalDeducoes = 0; 
		
		d = c.deducoes.elements();
		while (d.hasMoreElements()) {
			temp = d.nextElement();
			c.totalDeducoes += temp.getValor();
		}
		
		//3a PARTE: CALCULO DA BASE DE CALCULO DO IRPF
		c.baseDeCalculo = totalRendimentos - c.totalDeducoes; 
		
		//4a PARTE: CALCULO DO IMPOSTO DEVIDO, FAIXA A FAIXA E TOTAL.
		//Testa se a base de calculo � aplic�vel a cada faixa... 
		//5a faixa: aplicavel se a base de calculo for maior que R$4271,59
		temp2 = c.baseDeCalculo - (float)4271.59; //para calcular o valor que ultrapassou o limite da quinta faixa
		if (temp2 > 0) 
			c.valor5aFaixa = temp2 * (float)0.275;
		else {
			c.valor5aFaixa = 0;
			temp2 = 0; 
		}
		
		//4a faixa: aplicavel se a base de calculo for maior ou igual a R$3418,60 e menor que R$ 4271,59
		temp2 = c.baseDeCalculo - (float)3418.60;
		if (temp2 > 0){
			if (c.baseDeCalculo > 4271.59) 
				temp2 = (float)4271.59 - (float)3418.60; 
			c.valor4aFaixa = temp2 * (float)0.225;
		}			 
		else {
			c.valor4aFaixa = 0;
			temp2 = 0;
		}
		
		//3a faixa: aplicavel se a base de calculo for maior ou igual a R$2563,92 e menor que R$ 3418,60
		temp2 = c.baseDeCalculo - (float) temp2 - (float)2563.92;
		if (temp2 > 0){
			if (c.baseDeCalculo > 3418.60) 
				temp2 = (float)3418.60 - (float)2563.92;
			c.valor3aFaixa = temp2 * (float)0.15;
		} 
		else {
			c.valor3aFaixa = 0;
			temp2 = 0;
		}
		//2a faixa: aplicavel se a base de calculo for maior ou igual a R$1710,79 e menor que R$ 2563,91
		temp2 = c.baseDeCalculo - (float)1710.79;
		if (temp2 > 0){
			if (c.baseDeCalculo > 2563.91) 
				temp2 = (float)2563.91 - (float)1710.79; 
			c.valor2aFaixa = temp2 * (float)0.075;
		}
		else {
			c.valor2aFaixa = 0;
			temp2 = 0;
		}
		//1a faixa: aplicavel se a base de calculo for menor que R$1710,79
		temp2 = c.baseDeCalculo - (float)1710.79;
		if (temp2 <= 0)
			c.valor1aFaixa = temp2 * 0; 
		else {
			c.valor1aFaixa = 0;
			temp2 = 0;
		}
		
		temp2 = c.valor5aFaixa + c.valor4aFaixa + c.valor3aFaixa + c.valor2aFaixa + c.valor1aFaixa;
		
		//4a faixa: aplicavel se a base de calculo for maior ou igual a R$3418,60 e menor que R$4271,79
		
		return temp2;
	}
	
	
	protected void calcularRendimentos(){
		//1a PARTE: CALCULOS DOS RENDIMENTOS TRIBUTAVEIS
		totalRendimentos = 0; 
		totalRendimentosTributaveis = 0; 
	    totalRendimentosIsentos = 0;
				
		//calculo o total de rendimentos, rendimentos tribut�veis e rendimentos isentos
		Enumeration<Rendimento> r  = c.rendimentos.elements();
		while (r.hasMoreElements()) {
			Rendimento temp = (Rendimento) r.nextElement();
			totalRendimentos += temp.getValor(); 
			if (temp.isTributavel())
				totalRendimentosTributaveis += temp.getValor(); 
			else
			totalRendimentosIsentos += temp.getValor();
		}	
	}
	
}
