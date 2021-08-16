package view;

import java.io.IOException;

import controller.ArquivoController;

public class Principal {

	public static void main(String[] args) {
		
		ArquivoController arquivos = new ArquivoController();
		String path = "C:\\TEMP";
		String name = "generic_food.csv";
		
		try {
			System.out.println(arquivos.readFile(path, name));
		} catch (IOException e) {
			System.err.println("Erro na leitura");
		}
	}

}
