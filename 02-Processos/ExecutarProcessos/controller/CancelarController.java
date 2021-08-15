package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TelaPrincipal;

public class CancelarController implements ActionListener{
	
	private TelaPrincipal tela;
	
	public CancelarController(TelaPrincipal tela){
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
	}

}
