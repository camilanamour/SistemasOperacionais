package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSapo;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("======================= CORRIDA DE SAPOS =======================");	
		System.out.println("== COMEÇOU =====================================================\n");
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int numero=0; numero<5; numero++){
			Thread sapo = new ThreadSapo(numero, semaforo);
			sapo.start();
		}

	}

}
