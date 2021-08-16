package view;

import controller.ThreadCalc;
import controller.ThreadID;

public class Principal {

	public static void main(String[] args) {
		
//		Fazer 5 threads - que execurão em ordem aleatória - quem termina primeiro
		for(int idThread = 0; idThread<5; idThread++){
			Thread t = new ThreadID(idThread);
//			Superclasse    classe específica (polimorfismo) -- comportamento da sua classe mãe
//			ThreadID t = new ThreadID(idThread) -- instancia
			t.start(); //Inicializa o que está em run
		}
		
		
		int a = 10;
		int b = 2;
//		System.out.println("\nCalculadora - Ordem");
		for(int op = 0; op<4; op++){
			Thread threadCalc = new ThreadCalc(a, b, op);
			threadCalc.start();
		}
	}

}
