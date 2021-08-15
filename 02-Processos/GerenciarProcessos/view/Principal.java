package view;

import javax.swing.JOptionPane;
import controller.OperacoesProcessos;

public class Principal {

	public static void main(String[] args) {
		
		OperacoesProcessos controller = new OperacoesProcessos();
		
		String os = controller.sistemaOperacional();
		int opcao = 0;
		
		do{
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Gerenciamento de Processos\n\n"
					+ "1- Listar os processos\n"
					+ "2- Matar processo pelo PID\n"
					+ "3- Matar processo pelo nome\n"
					+ "0- Finalizar\n\nEscolha:"));
			switch(opcao){
				case 1: controller.listarProcessos(os); break;
				case 2: int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo:"));
						controller.mataPID(os, pid); break;
				case 3: String nome = JOptionPane.showInputDialog("Digite o nome do processo:");
						controller.mataNome(os, nome); break;
				case 0: System.exit(0); break;
				default: JOptionPane.showMessageDialog(null, "Opção Inválida");break;
			}
		}while(opcao!=0);

	}

}
