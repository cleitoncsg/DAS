package Refatoracao_1;

import java.util.Enumeration;
import java.util.Vector;

public class Contribuinte {

	private String nome; 
	//private int[] cpf;
	CPF cpf;
	CalculoDeImposto calculoDeImposto = new CalculoDeImposto();

	public Contribuinte(String nome, int[] cpf) {
		this.nome = nome; 
		this.cpf = new CPF(cpf);
		this.calculoDeImposto.rendimentos = new Vector<Rendimento>();
		this.calculoDeImposto.deducoes = new Vector<Deducao>();
	}
	

	public float calcularImposto() {	
	     return calcularImposto();
	}


	private void calcularRendimentos() {
		//1a PARTE: CALCULOS DOS RENDIMENTOS TRIBUTAVEIS
		calculoDeImposto.totalRendimentos = 0; 
		calculoDeImposto.totalRendimentosTributaveis = 0; 
		calculoDeImposto.totalRendimentosIsentos = 0;
		
		//calculo o total de rendimentos, rendimentos tribut�veis e rendimentos isentos
		Enumeration<Rendimento> r  = calculoDeImposto.rendimentos.elements();
		while (r.hasMoreElements()) {
			Rendimento temp = (Rendimento) r.nextElement();
			calculoDeImposto.totalRendimentos += temp.getValor(); 
			if (temp.isTributavel())
				calculoDeImposto.totalRendimentosTributaveis += temp.getValor(); 
			else
				calculoDeImposto.totalRendimentosIsentos += temp.getValor();
		}
	}
	
	public boolean adicionarRendimento(Rendimento rendimento) {
		boolean resposta = calculoDeImposto.rendimentos.add(rendimento);
		calcularImposto();
		return resposta;
	}
	
	
	public boolean excluirRendimento(Rendimento rendimento){
		
		boolean resposta = false;
		
		Enumeration<Rendimento> e = calculoDeImposto.rendimentos.elements();
		while (e.hasMoreElements()){  //percorre o vetor varrendo os elementos
			Rendimento temp = e.nextElement();
			if (temp.getDescricao() == rendimento.getDescricao() &&  //se os elementos forem iguais ...
				temp.getValor() == rendimento.getValor()) {
				resposta = calculoDeImposto.rendimentos.remove(temp); //... excluo o elemento do vetor
			}
		}	
		calcularImposto();
		return resposta; 
	}
	
	
	public boolean adicionarDeducao(Deducao deducao) {
		boolean resposta = calculoDeImposto.deducoes.add(deducao);
		calcularImposto();
		return resposta; 
	}
	
	
	public boolean excluirDeducao(Deducao deducao){
		boolean resposta = false; 
		Enumeration<Deducao> e = calculoDeImposto.deducoes.elements();
		
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
						resposta = calculoDeImposto.deducoes.remove(temp);
					}
				} else {
					resposta = calculoDeImposto.deducoes.remove(temp);
				}
			} 
		}
		
		calcularImposto();
		return resposta;
	}


	public float getTotalRendimentos() {
		return calculoDeImposto.totalRendimentos;
	}


	public float getTotalRendimentosTributaveis() {
		return calculoDeImposto.totalRendimentosTributaveis;
	}
	
	public float getTotalRendimentosIsentos() {
		return calculoDeImposto.totalRendimentosIsentos;
	}


	public double getTotalDeducoes() {
		return calculoDeImposto.totalDeducoes;
	}
	
	public double getBaseDeCalculo() {
		return calculoDeImposto.baseDeCalculo;
	}


	public float getValor1aFaixa() {
		return calculoDeImposto.valor1aFaixa;
	}


	public float getValor2aFaixa() {
		return calculoDeImposto.valor2aFaixa;
	}


	public float getValor3aFaixa() {
		return calculoDeImposto.valor3aFaixa;
	}


	public float getValor4aFaixa() {
		return calculoDeImposto.valor4aFaixa;
	}


	public float getValor5aFaixa() {
		return calculoDeImposto.valor5aFaixa;
	}
	
	
}
