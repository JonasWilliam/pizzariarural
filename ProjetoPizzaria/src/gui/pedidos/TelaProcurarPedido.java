package gui.pedidos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Pedido;

public class TelaProcurarPedido extends JFrame {

	private JPanel contentPane;
	private static JFrame telaProcurarPedidoinstance;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setTitle("Procurar Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 142, 358, 166);
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
		textField.setBounds(172, 73, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Dados: \n");
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o id do Pedido.");
				}
					
				else {

					Pedido achouPedido = Fachada.getInstance().procurarPedido(Integer.parseInt(textField.getText()));
					 if(achouPedido == null){
						 JOptionPane.showMessageDialog(null, "Pedido não existe.");
					 }else{
						 JOptionPane.showMessageDialog(null, "Pedido Encontrado.");
						 textArea.append(achouPedido.toString());
					 }
					 
				}
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.setBounds(172, 108, 89, 23);
		contentPane.add(btnProcurar);
		
		JButton btnAddAoPedido = new JButton("Adicionar ao Pedido");
		btnAddAoPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddAoPedido.setBounds(219, 319, 185, 23);
		contentPane.add(btnAddAoPedido);
		
		JButton btnRemoverItem = new JButton("Remover Item do Pedido");
		btnRemoverItem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoverItem.setBounds(219, 341, 185, 23);
		contentPane.add(btnRemoverItem);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.getInstance().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(172, 368, 89, 32);
		contentPane.add(btnVoltar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(271, 108, 89, 23);
		contentPane.add(btnReset);
		
		textField_1 = new JTextField();
		textField_1.setBounds(22, 319, 187, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(22, 342, 187, 20);
		contentPane.add(textField_2);
	}
}
