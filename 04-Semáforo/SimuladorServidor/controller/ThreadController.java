package controller;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	private int idThread;
	private Semaphore semaforo;

	public ThreadController(int id, Semaphore semaforo) {
		this.idThread = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		if(idThread % 3 == 1) {
			int tempoTransicao = 1000;
			for (byte intercalar = 0; intercalar < 2; intercalar++) {
				int tempoCalculo = (int) ((Math.random() * 801) + 200);
				realizarRequisicao(tempoTransicao, tempoCalculo);
			}
		}
		if(idThread % 3 == 2) {
			int tempoTransicao = 1500;
			for (byte intercalar = 0; intercalar < 3; intercalar++) {
				int tempoCalculo = (int) ((Math.random() * 1001) + 500);
				realizarRequisicao(tempoTransicao, tempoCalculo);
			}
		}
		if(idThread % 3 == 0) {
			int tempoTransicao = 1500;
			for (byte intercalar = 0; intercalar < 3; intercalar++) {
				int tempoCalculo = (int) ((Math.random() * 1001) + 1000);
				realizarRequisicao(tempoTransicao, tempoCalculo);
			}
		}
	}

	private void realizarRequisicao(int tempoTransicao, int tempoCalculo) {
		calcular(tempoCalculo);
		try {
			semaforo.acquire();
			transacao(tempoTransicao);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void calcular(int tempoCalculo) {
		System.out.println("#" + idThread + " processando...");
		try {
			sleep(tempoCalculo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void transacao(int tempoTransicao) {
		System.out.println("#" + idThread + " transição BD...");
		try {
			sleep(tempoTransicao);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
