package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController controller = new RedesController();
				
		String os = controller.sistemaOperacional();
		int opcao = 0;
		do{
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Processos - Redes\n\n"
					+ "1- Configuração de IP\n"
					+ "2- Tempo médio do PING\n"
					+ "0- Finalizar\n\nEscolha:"));
			switch(opcao){
				case 1: System.out.println(controller.configuraIP(os)); break;
				case 2: System.out.println(controller.mediaPing(os)); break;
				case 0: System.exit(0);
				default: JOptionPane.showMessageDialog(null, "Opção Inválida");break;
			}
		}while(opcao!=0);
	}

}