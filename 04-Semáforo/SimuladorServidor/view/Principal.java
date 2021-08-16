package view;

import java.util.concurrent.Semaphore;

import controller.ThreadController;

public class Principal {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int i=0; i<21; i++){
			Thread thread = new ThreadController(i, semaforo);
			thread.start();
		}

	}

}
