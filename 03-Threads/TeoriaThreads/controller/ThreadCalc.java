package controller;

// opera��es soma, subtra��o, multiplica��o, divis�o -- cada uma � uma thread
public class ThreadCalc extends Thread{
	
	private int a, b, op;
	
	public ThreadCalc(int a, int b, int op){
		this.a = a;
		this.b = b;
		this.op = op;
	}
	
	@Override
	public void run() { //main--chama--Thread--chama--Calc --> n�o roubar
		Calc();
	}

	private void Calc() {
		int tempo = 1000; //1000 milissegundos bloqueada - 1 segundo - bloqueio m�nimo impacta
		try {
			sleep(op * tempo); //vai deixar na ordem
			
			/* vai ficar bloqueada todoas as op��es por tempo diferentes
			 * bloqueia a thread -- pede um par�metro long (n�mero)
			 * pode ser um inteiro, um long 
			 * */
			
		} catch (InterruptedException e) { //Erro n�o muito comum
			e.printStackTrace();
		} 
		
		int res = 0;
		String operacao = "";
		
		switch (op) {
		case 0: 
			res = a + b;
			operacao = "+"; 
			break;
		case 1: 
			res = a - b;
			operacao = "-"; 
			break;
		case 2: 
			res = a * b;
			operacao = "*"; 
			break;
		case 3: 
			res = a / b;
			operacao = "/"; 
			break;
		}
//		Identificar qual thread fez cada calculo
		System.out.println("TID #" + getId() + " --> " 
							+ a + " " + operacao + " " + b + " = " + res);
	}
	
	
}
