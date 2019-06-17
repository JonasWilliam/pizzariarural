package gui.pedidos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Pedido;

public class TelaListarPedido extends JFrame {

	private JPanel contentPane;
	private static JFrame telaListarPedidoinstance;

	public static JFrame getInstance() {
		if (TelaListarPedido.telaListarPedidoinstance == null)
			TelaListarPedido.telaListarPedidoinstance = new TelaListarPedido();

		return TelaListarPedido.telaListarPedidoinstance;

	}
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarPedido frame = new TelaListarPedido();
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
	public TelaListarPedido() {
		setFont(new Font("Dialog", Font.PLAIN, 99));
		setTitle("Listar Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 400, 173);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblListarPedidos = new JLabel("Listar Pedidos");
		lblListarPedidos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblListarPedidos.setBounds(128, 11, 242, 24);
		contentPane.add(lblListarPedidos);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Pedido[] pedidos = Fachada.getInstance().listarPedidos();
				//ArrayList<Produto> nomeProdutos = new ArrayList<Produto>();
				for (int i = 0; i < pedidos.length; i++) {
					if(pedidos[i] != null) {
						textArea.append(pedidos[i].toString());	
					}
					

				}
				
			
			}
		});
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarTodos.setBounds(44, 291, 121, 23);
		contentPane.add(btnListarTodos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(201, 291, 89, 23);
		contentPane.add(btnVoltar);
	}
}
