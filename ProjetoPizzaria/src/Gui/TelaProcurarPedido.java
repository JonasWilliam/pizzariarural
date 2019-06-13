package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProcurarPedido extends JFrame {

	private JPanel contentPane;
	private static JFrame telaProcurarPedidoinstance;
	private JTextField textField;

	public static JFrame getInstance() {
		if (TelaProcurarPedido.telaProcurarPedidoinstance == null)
			TelaProcurarPedido.telaProcurarPedidoinstance = new TelaProcurarPedido();

		return TelaProcurarPedido.telaProcurarPedidoinstance;

	}
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcurarPedido frame = new TelaProcurarPedido();
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
	public TelaProcurarPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProcurarPedido = new JLabel("Procurar Pedido");
		lblProcurarPedido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProcurarPedido.setBounds(117, 11, 217, 29);
		contentPane.add(lblProcurarPedido);
		
		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCdigo.setBounds(10, 102, 144, 29);
		contentPane.add(lblInformeOCdigo);
		
		textField = new JTextField();
		textField.setBounds(150, 108, 217, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnProcurar = new JButton("PROCURAR");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.setBounds(81, 191, 110, 23);
		contentPane.add(btnProcurar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(223, 191, 89, 23);
		contentPane.add(btnVoltar);
	}
}
