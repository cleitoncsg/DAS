package Refatoracao2_1aParte;

public class CPF {

	/**
	 * Refatoracao 2 - transformar a representacao por um vetor do CPF em uma série de atributos do tipo inteiro. 
	 * Ao final dessa refatoração temos uma classe que representa um CPF e nos permitirá adicionar metodos rela-
	 * cionados, como validação do numero de CPF, por exemplo. 
	 * 
	 * NOTA: Aplicando a operacao de refatoracao AO PE DA LETRA, temos que criar uma classe para armazenar o 
	 * array. Essa classe será alterada aos poucos para desmembrar o array em atributos dessa classe. 
	 * No entanto, nesse caso em específico, a classe fica em duplicidade com a classe CPF anteriormente criada. 
	 * Podemos entao aplicar uma nova operação de refatoração "Introduzir Classe" para eliminar a classe em 
	 * duplicidade.
	 */
	
	//final int[] cpf;  //antiga representacao do CPF por vetor... 
	NovoCPF novoCPF;
	
	public CPF(int[] cpf) {
		//this.cpf = cpf;
		this.novoCPF = new NovoCPF();
		this.novoCPF.set1oDigito(cpf[0]);
		this.novoCPF.set2oDigito(cpf[1]);
		this.novoCPF.set3oDigito(cpf[2]);
		this.novoCPF.set4oDigito(cpf[3]);
		this.novoCPF.set5oDigito(cpf[4]);
		this.novoCPF.set6oDigito(cpf[5]);
		this.novoCPF.set7oDigito(cpf[6]);
		this.novoCPF.set8oDigito(cpf[7]);
		this.novoCPF.set9oDigito(cpf[8]);
		this.novoCPF.set10oDigito(cpf[9]);
		this.novoCPF.set11oDigito(cpf[10]);		
	}
	
	public int[] getCPF() {
		return new int[]{novoCPF.get1oDigito(), 
				         novoCPF.get2oDigito(), 
				         novoCPF.get3oDigito(), 
				         novoCPF.get4oDigito(), 
				         novoCPF.get5oDigito(), 
				         novoCPF.get6oDigito(), 
				         novoCPF.get7oDigito(), 
				         novoCPF.get8oDigito(), 
				         novoCPF.get9oDigito(), 
				         novoCPF.get10oDigito(), 
				         novoCPF.get11oDigito()};
	}
	
	
}
