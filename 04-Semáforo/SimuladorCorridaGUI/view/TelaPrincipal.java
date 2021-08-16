package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerCarro;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfVencedor;
	private JTextField tfPerdedor;

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
		setTitle("Corrida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarro1 = new JLabel("CARRO 1");
		lblCarro1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCarro1.setForeground(new Color(153, 0, 51));
		lblCarro1.setBounds(10, 61, 79, 32);
		contentPane.add(lblCarro1);
		
		JLabel lblCarro2 = new JLabel("CARRO 2");
		lblCarro2.setForeground(new Color(0, 0, 51));
		lblCarro2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCarro2.setBounds(10, 117, 79, 32);
		contentPane.add(lblCarro2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 104, 664, 2);
		contentPane.add(separator);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBackground(new Color(204, 204, 204));
		btnCorrer.setBounds(569, 170, 89, 23);
		contentPane.add(btnCorrer);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setBounds(239, 12, 66, 23);
		contentPane.add(lblVencedor);
		
		tfVencedor = new JTextField();
		tfVencedor.setEditable(false);
		tfVencedor.setBounds(300, 12, 136, 23);
		contentPane.add(tfVencedor);
		tfVencedor.setColumns(10);
		
		tfPerdedor = new JTextField();
		tfPerdedor.setEditable(false);
		tfPerdedor.setColumns(10);
		tfPerdedor.setBounds(522, 12, 136, 23);
		contentPane.add(tfPerdedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setBounds(463, 12, 66, 23);
		contentPane.add(lblPerdedor);
		
		ControllerCarro largada = new ControllerCarro(lblCarro1, lblCarro2, btnCorrer, tfVencedor, tfPerdedor);
		btnCorrer.addActionListener(largada);
	}
}
