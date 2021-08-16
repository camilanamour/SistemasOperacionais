package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	
	private int idCarro;
	private Semaphore semaforo;
	private String inicio;
	private String fim;
	
	public ThreadCarro(int idCarro, Semaphore semaforo, String inicio, String fim) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.inicio = inicio;
		this.fim = fim;
		
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			imprimirDirecao();
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

	private void imprimirDirecao() {
		System.out.println("Carro #" + idCarro + " está cruzando do " + inicio + " para o " + fim);
		
	}
}
