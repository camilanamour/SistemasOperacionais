package controller;

public class ThreadController extends Thread{
	
	private int vetor [] = new int [5];
	private int numero;
	
	public ThreadController(int numero, int vetor[]){
		this.numero = numero;
		this.vetor = vetor;
	}
	
	@Override
	public void run() {
		CalculaSoma();
	}

	private void CalculaSoma() {
		int soma = 0;
		for(int x=0; x<5; x++){
			soma+=vetor[x];
		}
		System.out.println("linha " + this.numero + ": " + soma);
	
	}

}
