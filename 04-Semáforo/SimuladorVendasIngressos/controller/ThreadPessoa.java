package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {

	private int idPessoa;
	private int qtdIngresso;
	private static int totalIngressos = 100;
	private Semaphore semaforo;

	public ThreadPessoa(int idThread, Semaphore semaforo) {
		this.idPessoa = idThread;
		this.qtdIngresso = 0;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		do {
			if (totalIngressos > 0) {
				comprarIngresso();
			} else {
				System.err.println("Ingressos Acabaram!");
			}
		} while (totalIngressos > 0);
	}

	private void comprarIngresso() {
		int tempo = tempoLogin();
		loginSistema(tempo);

		if (tempo < 1000) {
			tempo = tempoProcesso();
			processoCompra(tempo);

			if (tempo < 1500) {
				try {
					semaforo.acquire();
					validacaoCompra();
				} catch (InterruptedException e) {
					System.err.println("Erro no Servidor!");
					e.printStackTrace();
				} finally {
					semaforo.release();
				}
			} else {
				System.err.println("Id #" + idPessoa + " - Final de tempo de sessão.");
			}
		} else {
			System.err.println("Id #" + idPessoa + " - Não foi possível fazer o login.");
		}

	}

	private int tempoLogin() {
		int tempo = (int) ((Math.random() * 1501) + 500);
		return tempo;
	}

	private void loginSistema(int tempo) {
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			System.err.println("Erro no Servidor!");
		}
	}

	private int tempoProcesso() {
		int tempo = (int) ((Math.random() * 2001) + 1000);
		return tempo;
	}

	private void processoCompra(int tempo) {
		this.qtdIngresso = (int) ((Math.random() * 4) + 1);
	}

	private void validacaoCompra() {
		if ((totalIngressos - this.qtdIngresso) >= 0) {
			totalIngressos -= this.qtdIngresso;
			System.out.println(
					"Id #" + idPessoa + " - comprou: " + this.qtdIngresso + " - resta: " + totalIngressos);
		} else {
			System.err.println("Id #" + idPessoa + " - Ingressos Indisponíveis!");
		}
	}
}
