package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ControllerCarro implements ActionListener{
	
	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private JButton btnCorrer;
	private static JTextField tfVencedor;
	private static JTextField tfPerdedor;
	
	public ControllerCarro(JLabel lblCarro1, JLabel lblCarro2, JButton btnCorrer, JTextField tfVencedor, JTextField tfPerdedor) {
		
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.btnCorrer = btnCorrer;
		ControllerCarro.tfVencedor = tfVencedor;
		ControllerCarro.tfPerdedor = tfPerdedor;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botaoCorrer();
	}

	private void botaoCorrer() {
		Semaphore linhaChegada = new Semaphore(1);
		Thread carro1 = new ThreadCarro(lblCarro1, btnCorrer, linhaChegada, tfVencedor, tfPerdedor);
		Thread carro2 = new ThreadCarro(lblCarro2, btnCorrer, linhaChegada, tfVencedor, tfPerdedor);
		carro1.start();
		carro2.start();
	}

}
