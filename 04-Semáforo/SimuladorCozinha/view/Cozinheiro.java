package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPrato;

public class Cozinheiro {

	public static void main(String[] args) {
		
		
		int permissaoEntregaPrato = 1;
		Semaphore semaforoEntrega = new Semaphore(permissaoEntregaPrato);
		
		for(int idPrato=0; idPrato<5; idPrato++){
			Thread prato = new ThreadPrato(idPrato, semaforoEntrega);
			prato.start();
		}

	}

}
