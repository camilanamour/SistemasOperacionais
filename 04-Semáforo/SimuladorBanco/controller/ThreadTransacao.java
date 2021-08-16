package controller;

import java.util.concurrent.Semaphore;

public class ThreadTransacao extends Thread {

	private int operacao, idConta;
	private float saldoConta, valorTransitado;

	private static Semaphore semaforoSaque;
	private static Semaphore semaforoDeposito;

	public ThreadTransacao(int idConta, int operacao, float saldo, float valor, Semaphore saque, Semaphore deposito) {
		this.idConta = idConta;
		this.operacao = operacao;
		this.saldoConta = saldo;
		this.valorTransitado = valor;
		
		semaforoSaque = saque;
		semaforoDeposito = deposito;		
	}

	@Override
	public void run() {
		
		if(operacao == 0){
			try {
				semaforoSaque.acquire();
				operacaoSaque();
			} catch (InterruptedException e) {
				System.err.println("ERRO NO SAQUE!");
			} finally {
				semaforoSaque.release();
			}
		} else {
			try {
				semaforoDeposito.acquire();
				operacaoDeposito();
			} catch (InterruptedException e) {
				System.err.println("ERRO NO DEPÓSITO!");
			} finally {
				semaforoDeposito.release();
			}
		}		

	}
	
	private int tempoEspera(){
		int tempo = (int) ((Math.random() * 501) + 500);
		return tempo;
	}
	
	private void operacaoSaque() {
		try {
			sleep(tempoEspera());
			saldoConta -= valorTransitado;
			imprimir("efetuou o saque");
		} catch (InterruptedException e) {
			System.err.println("ERRO NA ESPERA DO SAQUE!");
		}
		
	}

	private void operacaoDeposito() {
		try {
			sleep(tempoEspera());
			saldoConta += valorTransitado;
			imprimir("efetuou o deposito");
		} catch (InterruptedException e) {
			System.err.println("ERRO NA ESPERA DO DEPÓSITO!");
		}
	}
	
	private void imprimir(String tipo) {
		System.out.printf("Conta %d %s \tsaldo atual: %.2f\n", idConta, tipo, valorTransitado, saldoConta);
	}

}
