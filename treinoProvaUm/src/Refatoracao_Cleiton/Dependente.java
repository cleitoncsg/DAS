package Refatoracao_Cleiton;

public class Dependente extends Deducao{

	private static final double valorFaixa = 171.97;
	private String nome;
	private CPF cpf; 
	
		
	public Dependente(String nome, int[] cpf) {
		super("Dependente", (float) valorFaixa);
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
