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
import java.awt.Color;
import javax.swing.JTable;

public class TelaProcurarPedido extends JFrame {

	private JPanel contentPane;
	private static JFrame telaProcurarPedidoinstance;
	private JTextField textField;
	private JTable table;
	PedidosTableModel modelo = new PedidosTableModel();

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
		contentPane.setBackground(new Color(250, 235, 215));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 394, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
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
		btnProcurar.setBackground(Color.GREEN);
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o id do Pedido.");
				}
					
				else {

					Pedido achouPedido = Fachada.getInstance().procurarPedido(Integer.parseInt(textField.getText()));
					 if(achouPedido == null){
						 JOptionPane.showMessageDialog(null, "Pedido não existe.");
					 }else{
						 JOptionPane.showMessageDialog(null, "Pedido Encontrado.");
						 modelo.addRow(achouPedido);
					 }
					 
				}
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.setBounds(106, 108, 89, 23);
		contentPane.add(btnProcurar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.getInstance().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(302, 374, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				textField.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(10, 374, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnAlterar = new JButton("Alterar Status");
		btnAlterar.setBackground(Color.GREEN);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaAlterarStatusPedido.getInstance().setVisible(true);
			}
		});
		btnAlterar.setBounds(139, 375, 122, 23);
		contentPane.add(btnAlterar);
		
		JButton btnListarPedidos = new JButton("Listar Pedidos");
		btnListarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarPedidosAberto.getInstance().setVisible(true);
			}
		});
		btnListarPedidos.setBackground(Color.YELLOW);
		btnListarPedidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarPedidos.setBounds(223, 108, 134, 23);
		contentPane.add(btnListarPedidos);
	}
}
