package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProcurarController implements ActionListener{
	
	private JTextField tfCaminho;
	
	public ProcurarController(JTextField caminho){
		this.tfCaminho = caminho;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		procurarArquivo();
		
	}

	private void procurarArquivo() {
		
		JFileChooser choose = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos executáveis (.exe)", "exe");
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File (diretorioBase);
		
//		Construindo a tela de busca de arquivo
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		int retorno = choose.showOpenDialog(null);  // "ABRIR"
		
		if(retorno == choose.APPROVE_OPTION){
			String caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			tfCaminho.setText(caminhoArquivo);
		}
	}
	

}
