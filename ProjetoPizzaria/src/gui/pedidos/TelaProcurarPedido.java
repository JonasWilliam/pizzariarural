package gui.pedidos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;

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
		setBounds(100, 100, 470, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 400, 173);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblProcurarPedido = new JLabel("Procurar Pedido");
		lblProcurarPedido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProcurarPedido.setBounds(117, 11, 217, 29);
		contentPane.add(lblProcurarPedido);
		
		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCdigo.setBounds(10, 68, 144, 29);
		contentPane.add(lblInformeOCdigo);
		
		textField = new JTextField();
		textField.setBounds(147, 74, 191, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProcurar.setBounds(10, 284, 89, 23);
		contentPane.add(btnProcurar);
		
		JButton btnAddAoPedido = new JButton("Add ao Pedido");
		btnAddAoPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddAoPedido.setBounds(97, 284, 120, 23);
		contentPane.add(btnAddAoPedido);
		
		JButton btnRemoverItem = new JButton("Remover Item");
		btnRemoverItem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoverItem.setBounds(216, 284, 118, 23);
		contentPane.add(btnRemoverItem);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(355, 284, 89, 23);
		contentPane.add(btnVoltar);
	}
}
