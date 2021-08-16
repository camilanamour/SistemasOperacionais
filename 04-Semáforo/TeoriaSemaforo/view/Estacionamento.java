package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Estacionamento {
	
/*
 * Sem�foros em Java --
 * Estrutura de semaforo, segundo o n�mero de permiss�es 
 * (1--mutex-- apenas uma thread por vez) ou (mais-- convencional)
 * 
 * <ctrl + shift + f> faz a indenta��o do c�digo
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
