package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Principal {

	public static void main(String[] args) {
		
		int permiss�o = 1;
		Semaphore semaforo = new Semaphore(permiss�o);
		
		for(int idThread = 0; idThread<300; idThread++){
			Thread pessoa = new ThreadPessoa(idThread, semaforo);
			pessoa.start();
		}

	}

}
