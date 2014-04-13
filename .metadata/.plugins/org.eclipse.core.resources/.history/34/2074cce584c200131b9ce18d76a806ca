package Refatoracao_1;

public class Dependente extends Deducao{

	private String nome; 
	//private int[] cpf;
	CPF cpf; 
	
	/**
	 * note que nao foi necessario definir valor novamente em dependente, apesar de ser apresentado no Modelo do 
	 * Projeto (diagrama de classes). O valor fixado em R$171.79 foi passado ao construtor da super classe (Deducao).
	 */
		
	public Dependente(String nome, int[] cpf) {
		super("Dependente", (float) 171.97);
		this.nome = nome;
		this.cpf = new CPF(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getCpf() {
		return cpf.getCPF();
	}

	public void setCpf(int[] cpf) {
		this.cpf = new CPF(cpf);
	}
	
}
