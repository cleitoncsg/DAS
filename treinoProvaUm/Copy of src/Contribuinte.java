
import java.util.Enumeration;
import java.util.Vector;


public class Contribuinte {
	
	private String nome; 
	//private int[] cpf;
	CPF cpf;
	protected float totalDeducoes; 
	protected float baseDeCalculo;
	protected float valor1aFaixa, 
	                valor2aFaixa, 
	                valor3aFaixa, 
	                valor4aFaixa, 
	                valor5aFaixa;
	protected Vector<Rendimento> rendimentos;
	protected Vector<Deducao> deducoes; 
	
	protected CalculoDeImposto calculo;
	
	
	public Contribuinte(String nome, int[] cpf) {
		this.nome = nome; 
		//this.cpf = cpf;
		this.cpf = new CPF(cpf);
		this.rendimentos = new Vector<Rendimento>();
		this.deducoes = new Vector<Deducao>();
		calculo = new CalculoDeImposto(this);
	}
	

	public float calcularImposto() {
		return new CalculoDeImposto(this).computar();
	}


	protected void calcularRendimentos() {
		calculo.calcularRendimentos();
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
		return calculo.totalRendimentos;
	}


	public float getTotalRendimentosTributaveis() {
		return calculo.totalRendimentosTributaveis;
	}
	
	public float getTotalRendimentosIsentos() {
		return calculo.totalRendimentosIsentos;
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
