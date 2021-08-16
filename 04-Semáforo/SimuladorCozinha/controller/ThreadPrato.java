package controller;

import java.util.concurrent.Semaphore;

public class ThreadPrato extends Thread {

	private int idPrato;
	private String nome;
	private int tempoTotalCozimento;
	private final int tempoMinimo;
	private final int tempoMaximo;
	private Semaphore semaforoEntrega;

	public ThreadPrato(int idPrato, Semaphore semaforoEntrega) {
		this.idPrato = idPrato;
		this.semaforoEntrega = semaforoEntrega;
		if (idPrato % 2 == 0) {
			idPar();
		} else {
			idImpar();
		}
		this.tempoMinimo = ((tempoTotalCozimento * 5) / 100);
		this.tempoMaximo = ((tempoTotalCozimento * 15) / 100);
		System.out.println("Prato #" + idPrato + ": " + nome + " começou a cozinhar");
	}

	@Override
	public void run() {
		cozinharPrato(); // ======== Parelelo ==========
		try {
			semaforoEntrega.acquire();
			entregaPrato(); // ====== Seção Crítica =======
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoEntrega.release();
		}
	}

	private void cozinharPrato() {
		int progresso = 0;
		while (progresso < tempoTotalCozimento) {
			progresso += (int) (Math.random() * tempoMaximo) + tempoMinimo;
			
			int percentual = (int) ((progresso * 100) / tempoTotalCozimento);
			if (percentual > 100) {
				int aux = (percentual - 100);
				percentual -= aux;
			}
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Prato #" + idPrato + ": " + nome + " cozinhou " + percentual + "%");
		}

	}

	private void entregaPrato() {
		System.out.println("Prato #" + idPrato + ": " + nome + " está pronta. Entregando...");
		
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Prato #" + idPrato + ": " + nome + " foi entregue.");
	}

	private void idPar() {
		this.nome = "Lasanha a Bolonhesa"; // 0,6 a 1,2 segundos.
		this.tempoTotalCozimento = (int) ((Math.random() * 601) + 600);
	}

	private void idImpar() {
		this.nome = "Sopa de Cebola"; // 0,5 a 0,8 segundos.
		this.tempoTotalCozimento = (int) ((Math.random() * 301) + 500);
	}

}
