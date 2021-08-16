package view;

import controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {
		int vetor[] = new int[1000];
		for(int i=0; i<1000; i++){
			int random = (int) ((Math.random() * 100) + 1);
			vetor[i] = random;
		}
		
		for(int t=0; t<2; t++){
			Thread threadVetor = new ThreadVetor(t+1, vetor);
			threadVetor.start();
		}
	}

}
