package controller;

public class ThreadVetor extends Thread{
	
	private int numero;
	private int vetor[] = new int [1000];
	
	//método construtor
	public ThreadVetor(int num, int vetor[]){
		this.numero = num;
		this.vetor = vetor;
	}
	
	@Override
	public void run() {
				
		if(numero%2 == 0){
			ThreadPar();		
		} else {
			ThreadImpar();
		}
		
	}

	private void ThreadImpar() {
		double tempoInicial = System.nanoTime();
		for(int i: vetor){
		}
		double tempoFinal = System.nanoTime();
		double tempo = (tempoFinal - tempoInicial);
		tempo /= (Math.pow(10, 9));
		System.out.println("FOREACH: " + tempo);
		
	}

	private void ThreadPar() {
		double tempoInicial = System.nanoTime();
		int tamanho = vetor.length;
		for(int i=0; i<tamanho;i++){
		}
		double tempoFinal = System.nanoTime();
		double tempo = (tempoFinal - tempoInicial);
		tempo /= (Math.pow(10, 9));
		System.out.println("FOR: " + tempo);	
	}

}
