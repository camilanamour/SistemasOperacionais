package controller;

import java.util.concurrent.Semaphore;

public class ThreadSapo extends Thread{
	
	private int sapo;
	private final int maximopulo; 		//tamanho maximo para cada pulo
	private final int minimopulo;  		//tamanho minimo do pulo
	private final int maximadistancia; 	//distância da corrida
	private int totalpulo;				//total de pulos
	private static int posicao;
	private Semaphore semaforo;

	
	//Método Construtor
	public ThreadSapo(int numero, Semaphore semaforo){
		this.sapo = numero;
		this.maximopulo = 10;
		this.minimopulo = 1;
		this.totalpulo = 0;
		this.maximadistancia = 100;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		InicioCorrida();
		try {
			semaforo.acquire();
			posicoesCorrida();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo.release();
		}
				
	}
	
	private void posicoesCorrida() {
		posicao++;
		System.out.println("\n================== Sapo " + this.sapo + " chegou em " + posicao + "º lugar ==================\n");
	}

	private void InicioCorrida(){
		while(this.totalpulo < this.maximadistancia ){
			int salto = (int) ((Math.random() * maximopulo ) + minimopulo);
			this.totalpulo += salto;
			System.out.println("O sapo " + this.sapo + "\tTamanho do pulo: " + salto + "cm \tDistância percorrida: "
								+ (this.totalpulo) + "cm");
		}		
	}			
}

