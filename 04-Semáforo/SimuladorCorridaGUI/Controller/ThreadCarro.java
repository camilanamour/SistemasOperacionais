package Controller;

import java.awt.Rectangle;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadCarro extends Thread {

	private JLabel lblCarro;
	private JButton btnCorrer;
	private Semaphore linhaChegada;
	private static JTextField tfVencedor;
	private static JTextField tfPerdedor;


	public ThreadCarro(JLabel lblCarro, JButton btnCorrer, Semaphore linhaChegada, JTextField tfVencedor, JTextField tfPerdedor) {
		this.lblCarro = lblCarro;
		this.btnCorrer = btnCorrer;
		this.linhaChegada = linhaChegada;
		ThreadCarro.tfVencedor = tfVencedor;
		ThreadCarro.tfPerdedor = tfPerdedor;
	}

	@Override
	public void run() {
		preparar();
		Rectangle inicio = corridaIniciada();
		try {
			linhaChegada.acquire();
			classificarCarros();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			linhaChegada.release();
		}
		btnCorrer.setEnabled(true);
		lblCarro.setBounds(inicio);
	}

	private Rectangle corridaIniciada() {
		Rectangle posicao = lblCarro.getBounds();
		Rectangle inicio = lblCarro.getBounds();
		lblCarro.setBounds(posicao);
		
		int distancia = 0;
		while (distancia <= 600) { 
			int movimento = (int) ((Math.random() * 51) + 10);
			posicao.x += movimento;
			distancia += movimento;
			lblCarro.setBounds(posicao);
			try {
				Thread.sleep(200);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		return inicio;
	}


	private void classificarCarros() {
		if(tfVencedor.getText().equals("")){
			tfVencedor.setText(lblCarro.getText());
		}else{
			tfPerdedor.setText(lblCarro.getText());
		}
	}
	
	private void preparar(){
		btnCorrer.setEnabled(false);
		tfVencedor.setText("");
		tfPerdedor.setText("");
	}
	

}
