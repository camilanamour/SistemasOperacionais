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
//		======= Início Seção Crítica ===========
		try { 								// Tenta executar linhas.
//			A thread tenta pegar o semáforo, se conseguir roda carroEstacionado(), senão espera em fila.
			semaforo.acquire();		 
			carroEstacionado();	
		} catch (InterruptedException e) {	// Tratamento de exceção.
			e.printStackTrace();	
		} finally {							// Mesmo se der try ou catch passa no finally. === não prende o semáforo
//			Terminou carroEstacionado() ele libera o semáforo para o próximo.
			semaforo.release();
//			======= Fim Seçao Crítica ==============
			carroSaindo();
		}

	}
	
//	Paralelo ==> Um Carro não impacta no outro -- várias threads pode executar a operação
	
	private void carroAndando() {
//		Math.random() <0 a 0,9999999...> -- de 1000 a 2000
		int distanciaTotal = (int) ((Math.random() * 1001) + 1000); 
		int distanciaPercorrida = 0;
		int deslocamento = 100;			//velocidade média do carro (m/s)
		int tempo = 1000; 				//tempo em milissegundo
		
		while(distanciaPercorrida< distanciaTotal){
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo); 			
//				Acrescenta velocidade a cada um segundo -- simula a passagem do tempo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("#" + idCarro + " já andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idCarro + " foi o " + posChegada + "º a chegar.");
	}

//	Crítico ==> Só pode acontecer para três carros por vez -- quando um carro sair o outro entra -- mas sempre três carros por vez.
	private void carroEstacionado() {
		System.out.println("#" + idCarro + " estacionou.");
		int tempo = (int) ((Math.random() * 2001) + 1000); 	// Estacionado em 1 a 3 segundos
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	Paralelo ==> independente a saída entre os carros
	private void carroSaindo() {
		posSaida++;
		System.out.println("#" + idCarro + " foi o " + posSaida + "º a sair.");
	}


}
