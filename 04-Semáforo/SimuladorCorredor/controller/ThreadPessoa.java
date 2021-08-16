package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread{
	
	private int idPessoa;
	private static int max;
	private static int min;
	private static int comprimentoCorredor;
	private Semaphore porta;
	
	public ThreadPessoa(int idPessoa, Semaphore porta) {
		this.idPessoa = idPessoa;
		this.porta = porta;
		max = 3;
		min = 4;
		comprimentoCorredor = 200;
	}
	
	@Override
	public void run() {
		caminhar();
		try {
			porta.acquire();
			passarPorta();
		} catch (InterruptedException e) {
			System.err.println("ERRO! - " + e.getMessage());
		} finally {
			porta.release();
		}
		
	}

	private void caminhar() {
		int caminhoPercorrido = 0;
		while(caminhoPercorrido<comprimentoCorredor){
			int passo = (int) ((Math.random() * max) + min);
			caminhoPercorrido += passo;
			if(caminhoPercorrido> comprimentoCorredor){
				int aux = caminhoPercorrido - comprimentoCorredor;
				caminhoPercorrido -= aux;
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Erro na espera de passos!");
			}
			
			System.out.println("Pessoa #" + idPessoa + "\tPasso:  " + passo + 
					" m/s\tDistância percorrida: " + caminhoPercorrido + "m");
		}
		
	}
	
	private void passarPorta() {
		System.out.println("Pessoa #" + idPessoa + " abriu a porta");
		int tempoPorta = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempoPorta);
		} catch (InterruptedException e) {
			System.err.println("Erro no tempo de espera!");
		}
		System.out.println("Pessoa #" + idPessoa + " cruzou a porta");
	}
	
	
}
