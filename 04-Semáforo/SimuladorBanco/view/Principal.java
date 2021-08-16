package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTransacao;

public class Principal {

	public static void main(String[] args) {
		int operacao;
		float saldo, valor;
				
		Semaphore saque = new Semaphore(1); 
		Semaphore deposito = new Semaphore(1);
		
		for(int idConta=0; idConta<20; idConta++){
			operacao = (int) (Math.random() * 2);
			saldo = (float) ((Math.random() * 1001) + 1000);
			valor = (float) ((Math.random() * 101) + 50);
					
			Thread transacao = new ThreadTransacao(idConta, operacao, saldo, valor, saque, deposito);
			transacao.start();
		}

	}

}
