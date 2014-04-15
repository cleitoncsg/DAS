package Refatoracao_Cleiton;

import java.util.Enumeration;
import java.util.Vector;

public class ContribuinteTributo {
	private static final double baseFaixa1 = 4271.59;
	private static final double baseFaixa2 = 3418.60;
	private static final double baseFaixa4 = 2563.92;
	private static final double baseFaixa5 = 1710.79;
	Contribuinte c;
	Enumeration<Rendimento> rendimentos;
	Enumeration<Deducao> d; 
	float temp;
	
	public ContribuinteTributo(Contribuinte c){
		this.c = c;
	}
	
	public float computarTributo(){
		c.totalDeducoes = 0; 
		
		d = c.deducoes.elements();
		
		while (d.hasMoreElements()) {
			Deducao temp = d.nextElement();
			c.totalDeducoes += temp.getValor();
		}
		
		c.baseDeCalculo = c.totalRendimentos - c.totalDeducoes; 
		
		calculoFaixa1();
		calculoFaixa2();
		calculoFaixa3();
		calculoFaixa4();
		calculoFaixa5();
	
		return c.valor5aFaixa + c.valor4aFaixa + c.valor3aFaixa + c.valor2aFaixa + c.valor1aFaixa;
	}

	private void calculoFaixa5() {
		if (c.baseDeCalculo - (float)baseFaixa5 <= 0)
			c.valor1aFaixa = 0; 
	}

	private void calculoFaixa4() {
		temp = c.baseDeCalculo - (float)baseFaixa5;
		if (temp > 0){
			if (c.baseDeCalculo > 2563.91) 
				temp = (float)baseFaixa4 - (float)baseFaixa5; 
			c.valor2aFaixa = temp * (float)0.075;
		}
		else {
			c.valor2aFaixa = 0;
		}
	}

	private void calculoFaixa3() {
		temp = c.baseDeCalculo - (float) temp - (float)baseFaixa4;
		if (temp > 0){
			if (c.baseDeCalculo > 3418.60) 
				temp = (float)3418.60 - (float)baseFaixa4;
			c.valor3aFaixa = temp * (float)0.15;
		} 
		else {
			c.valor3aFaixa = 0;
		}
	}

	private void calculoFaixa2() {
		temp = c.baseDeCalculo - (float)baseFaixa2;
		if (temp > 0){
			if (c.baseDeCalculo > baseFaixa1) 
				temp = (float)baseFaixa1 - (float)baseFaixa2; 
			c.valor4aFaixa = temp * (float)0.225;
		}			 
		else {
			c.valor4aFaixa = 0;
			temp = 0;
		}
	}

	private void calculoFaixa1() {
		temp = c.baseDeCalculo - (float)baseFaixa1; 
		if (temp > 0) 
			c.valor5aFaixa = temp * (float)0.275;
	}

}
