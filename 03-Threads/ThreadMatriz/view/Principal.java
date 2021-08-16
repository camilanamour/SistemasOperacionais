package view;

import controller.ThreadController;

public class Principal {

	public static void main(String[] args) {
		int matriz[][] = new int [3][5];
		
		for(int i=0; i<matriz.length; i++){
			for(int j=0; j<matriz[i].length; j++){
				matriz[i][j] = (int) (Math.random() * 11);
			}
		}
		for(int i=0; i<3; i++){
			Thread t = new ThreadController(i, matriz[i]);
			t.start();
			
		}		

	}

}
