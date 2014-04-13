package Refatoracao_1;
import java.util.Enumeration;
import java.util.Vector;


public class Contribuinte {

	private String nome; 
	//private int[] cpf;
	CPF cpf;
	private float totalRendimentos, totalRendimentosTributaveis, totalRendimentosIsentos;
	private float totalDeducoes; 
	private float baseDeCalculo;
	private float valor1aFaixa, 
	              valor2aFaixa, 
	              valor3aFaixa, 
	              valor4aFaixa, 
	              valor5aFaixa;
	private Vector<Rendimento> rendimentos;
	private Vector<Deducao> deducoes; 
	
	public Contribuinte(String nome, int[] cpf) {
		this.nome = nome; 
		//this.cpf = cpf;
		this.cpf = new CPF(cpf);
		this.rendimentos = new Vector<Rendimento>();
		this.deducoes = new Vector<Deducao>();
	}
	

	public float calcularImposto() {
		
		calcularRendimentos();
		
		//2a PARTE: CALCULOS DAS DEDUCOES
		totalDeducoes = 0; 
		
		Enumeration<Deducao> d = deducoes.elements();
		while (d.hasMoreElements()) {
			Deducao temp = d.nextElement();
			totalDeducoes += temp.getValor();
		}
		
		//3a PARTE: CALCULO DA BASE DE CALCULO DO IRPF
		baseDeCalculo = totalRendimentos - totalDeducoes; 
		
		//4a PARTE: CALCULO DO IMPOSTO DEVIDO, FAIXA A FAIXA E TOTAL.
		//Testa se a base de calculo � aplic�vel a cada faixa... 
		//5a faixa: aplicavel se a base de calculo for maior que R$4271,59
		float temp = baseDeCalculo - (float)4271.59; //para calcular o valor que ultrapassou o limite da quinta faixa
		if (temp > 0) 
			valor5aFaixa = temp * (float)0.275;
		else {
			valor5aFaixa = 0;
			temp = 0; 
		}
		
		//4a faixa: aplicavel se a base de calculo for maior ou igual a R$3418,60 e menor que R$ 4271,59
		temp = baseDeCalculo - (float)3418.60;
		if (temp > 0){
			if (baseDeCalculo > 4271.59) 
				temp = (float)4271.59 - (float)3418.60; 
			valor4aFaixa = temp * (float)0.225;
		}			 
		else {
			valor4aFaixa = 0;
			temp = 0;
		}
		
		//3a faixa: aplicavel se a base de calculo for maior ou igual a R$2563,92 e menor que R$ 3418,60
		temp = baseDeCalculo - (float) temp - (float)2563.92;
		if (temp > 0){
			if (baseDeCalculo > 3418.60) 
				temp = (float)3418.60 - (float)2563.92;
			valor3aFaixa = temp * (float)0.15;
		} 
		else {
			valor3aFaixa = 0;
			temp = 0;
		}
		//2a faixa: aplicavel se a base de calculo for maior ou igual a R$1710,79 e menor que R$ 2563,91
		temp = baseDeCalculo - (float)1710.79;
		if (temp > 0){
			if (baseDeCalculo > 2563.91) 
				temp = (float)2563.91 - (float)1710.79; 
			valor2aFaixa = temp * (float)0.075;
		}
		else {
			valor2aFaixa = 0;
			temp = 0;
		}
		//1a faixa: aplicavel se a base de calculo for menor que R$1710,79
		temp = baseDeCalculo - (float)1710.79;
		if (temp <= 0)
			valor1aFaixa = temp * 0; 
		else {
			valor1aFaixa = 0;
			temp = 0;
		}
		
		temp = valor5aFaixa + valor4aFaixa + valor3aFaixa + valor2aFaixa + valor1aFaixa;
		
		//4a faixa: aplicavel se a base de calculo for maior ou igual a R$3418,60 e menor que R$4271,79
		
		return temp;
		
	}


	private void calcularRendimentos() {
		//1a PARTE: CALCULOS DOS RENDIMENTOS TRIBUTAVEIS
		totalRendimentos = 0; 
		totalRendimentosTributaveis = 0; 
		totalRendimentosIsentos = 0;
		
		//calculo o total de rendimentos, rendimentos tribut�veis e rendimentos isentos
		Enumeration<Rendimento> r  = rendimentos.elements();
		while (r.hasMoreElements()) {
			Rendimento temp = (Rendimento) r.nextElement();
			totalRendimentos += temp.getValor(); 
			if (temp.isTributavel())
				totalRendimentosTributaveis += temp.getValor(); 
			else
				totalRendimentosIsentos += temp.getValor();
		}
	}
	
	public boolean adicionarRendimento(Rendimento rendimento) {
		boolean resposta = rendimentos.add(rendimento);
		calcularImposto();
		return resposta;
	}
	
	
	public boolean excluirRendimento(Rendimento rendimento){
		
		boolean resposta = false;
		
		Enumeration<Rendimento> e = rendimentos.elements();
		while (e.hasMoreElements()){  //percorre o vetor varrendo os elementos
			Rendimento temp = e.nextElement();
			if (temp.getDescricao() == rendimento.getDescricao() &&  //se os elementos forem iguais ...
				temp.getValor() == rendimento.getValor()) {
				resposta = rendimentos.remove(temp); //... excluo o elemento do vetor
			}
		}	
		calcularImposto();
		return resposta; 
	}
	
	
	public boolean adicionarDeducao(Deducao deducao) {
		boolean resposta = deducoes.add(deducao);
		calcularImposto();
		return resposta; 
	}
	
	
	public boolean excluirDeducao(Deducao deducao){
		boolean resposta = false; 
		Enumeration<Deducao> e = deducoes.elements();
		
		while (e.hasMoreElements()){
			Deducao temp = e.nextElement();
			
			if (temp.getDescricao() == deducao.getDescricao() && 
			    temp.getValor() == deducao.getValor()){  // se descricao e valor s�o iguais...
				if (temp.getClass().getName().equals(Dependente.class.getName())) {  //...verifique se o objeto � da classe DEPENDENTE ... 
					//... se forem da classe dependente, certifique se ambos objetos referem-se ao mesmo dependente.
					Dependente temp2, temp3; 
					temp2 = (Dependente) temp; 
					temp3 = (Dependente) deducao; 
					
					if (temp2.getNome().equals(temp3.getNome())) {
						resposta = deducoes.remove(temp);
					}
				} else {
					resposta = deducoes.remove(temp);
				}
			} 
		}
		
		calcularImposto();
		return resposta;
	}


	public float getTotalRendimentos() {
		return totalRendimentos;
	}


	public float getTotalRendimentosTributaveis() {
		return totalRendimentosTributaveis;
	}
	
	public float getTotalRendimentosIsentos() {
		return totalRendimentosIsentos;
	}


	public double getTotalDeducoes() {
		return totalDeducoes;
	}
	
	public double getBaseDeCalculo() {
		return baseDeCalculo;
	}


	public float getValor1aFaixa() {
		return valor1aFaixa;
	}


	public float getValor2aFaixa() {
		return valor2aFaixa;
	}


	public float getValor3aFaixa() {
		return valor3aFaixa;
	}


	public float getValor4aFaixa() {
		return valor4aFaixa;
	}


	public float getValor5aFaixa() {
		return valor5aFaixa;
	}
	
	
}
