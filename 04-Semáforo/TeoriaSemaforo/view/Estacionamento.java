package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Estacionamento {
	
/*
 * Semáforos em Java --
 * Estrutura de semaforo, segundo o número de permissões 
 * (1--mutex-- apenas uma thread por vez) ou (mais-- convencional)
 * 
 * <ctrl + shift + f> faz a indentação do código
 */

	public static void main(String[] args) {
		
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idCarro=0; idCarro<10; idCarro++){
			Thread tCarro = new ThreadCarro(idCarro, semaforo);
			tCarro.start();
		}
		
		
		

	}

}
