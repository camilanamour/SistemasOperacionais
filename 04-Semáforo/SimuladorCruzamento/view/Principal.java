package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		
		String[] posInicial = {"sul", "norte", "leste", "oeste"};
		String[] posFinal = {"norte", "sul", "oeste", "leste"};
		Semaphore semaforo = new Semaphore(1);
		
		for(int id=0; id<4; id++){
			Thread carro = new ThreadCarro(id, semaforo, posInicial[id], posFinal[id]);
			carro.start();
		}
	}

}
