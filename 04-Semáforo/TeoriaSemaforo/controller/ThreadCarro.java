package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	
	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
//		======= Paralelo =======================
		carroAndando();
//		======= In�cio Se��o Cr�tica ===========
		try { 								// Tenta executar linhas.
//			A thread tenta pegar o sem�foro, se conseguir roda carroEstacionado(), sen�o espera em fila.
			semaforo.acquire();		 
			carroEstacionado();	
		} catch (InterruptedException e) {	// Tratamento de exce��o.
			e.printStackTrace();	
		} finally {							// Mesmo se der try ou catch passa no finally. === n�o prende o sem�foro
//			Terminou carroEstacionado() ele libera o sem�foro para o pr�ximo.
			semaforo.release();
//			======= Fim Se�ao Cr�tica ==============
			carroSaindo();
		}

	}
	
//	Paralelo ==> Um Carro n�o impacta no outro -- v�rias threads pode executar a opera��o
	
	private void carroAndando() {
//		Math.random() <0 a 0,9999999...> -- de 1000 a 2000
		int distanciaTotal = (int) ((Math.random() * 1001) + 1000); 
		int distanciaPercorrida = 0;
		int deslocamento = 100;			//velocidade m�dia do carro (m/s)
		int tempo = 1000; 				//tempo em milissegundo
		
		while(distanciaPercorrida< distanciaTotal){
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo); 			
//				Acrescenta velocidade a cada um segundo -- simula a passagem do tempo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("#" + idCarro + " j� andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idCarro + " foi o " + posChegada + "� a chegar.");
	}

//	Cr�tico ==> S� pode acontecer para tr�s carros por vez -- quando um carro sair o outro entra -- mas sempre tr�s carros por vez.
	private void carroEstacionado() {
		System.out.println("#" + idCarro + " estacionou.");
		int tempo = (int) ((Math.random() * 2001) + 1000); 	// Estacionado em 1 a 3 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	Paralelo ==> independente a sa�da entre os carros
	private void carroSaindo() {
		posSaida++;
		System.out.println("#" + idCarro + " foi o " + posSaida + "� a sair.");
	}


}
