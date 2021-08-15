package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AceitarController;
import controller.CancelarController;
import controller.ProcurarController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tfCaminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
				
		setTitle("Executar - " + System.getProperty("os.name"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensagem = new JLabel("Digite o caminho do execut\u00E1vel ou clique em procurar");
		lblMensagem.setBounds(62, 22, 322, 21);
		contentPane.add(lblMensagem);
		
		tfCaminho = new JTextField();
		tfCaminho.setBounds(62, 54, 320, 20);
		contentPane.add(tfCaminho);
		tfCaminho.setColumns(10);
		
		JLabel lblAbrir = new JLabel("Abrir:");
		lblAbrir.setBounds(15, 57, 46, 14);
		contentPane.add(lblAbrir);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(62, 99, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(161, 99, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(260, 99, 89, 23);
		contentPane.add(btnProcurar);
						
		ProcurarController procura = new ProcurarController(tfCaminho);
		btnProcurar.addActionListener(procura);
		
		AceitarController aceita = new AceitarController(tfCaminho, this);
		btnOk.addActionListener(aceita);
		
		CancelarController cancela = new CancelarController(this);
		btnCancelar.addActionListener(cancela);
	}
}
