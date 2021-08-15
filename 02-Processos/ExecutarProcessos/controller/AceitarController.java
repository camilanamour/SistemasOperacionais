package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.TelaPrincipal;

public class AceitarController implements ActionListener{
	
	private JTextField tfCaminho;
	private TelaPrincipal tela;
	
	public AceitarController(JTextField caminho, TelaPrincipal tela){
		this.tfCaminho = caminho;	
		this.tela = tela;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Executar();
	}
	

	private void Executar(){
		String processo = tfCaminho.getText();
		try {
			Runtime.getRuntime().exec(processo);
			tela.dispose();
		} catch (IOException e) {
			String msgErro = e.getMessage();
					
			if(msgErro.contains("740")){ 
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c"); 
				buffer.append(" ");
				buffer.append(tfCaminho.getText());
				try {
					Runtime.getRuntime().exec(buffer.toString());
					tela.dispose();
				} catch (IOException e1) {
					msgErro = e1.getMessage();
					JOptionPane.showMessageDialog(null, msgErro, "Erro", JOptionPane.ERROR_MESSAGE);
				} 
			} else{
				JOptionPane.showMessageDialog(null, "Caminho inválido", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
