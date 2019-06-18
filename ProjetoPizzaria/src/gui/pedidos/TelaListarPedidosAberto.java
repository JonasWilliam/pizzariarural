package gui.pedidos;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import gui.funcionarios.TelaRemocaoFuncionario;
import negocios.Fachada;
import negocios.Pedido;

public class TelaListarPedidosAberto extends JFrame {

	private JPanel contentPane;
	private static JFrame TelaListarPedidosAbertoinstance;

	public static JFrame getInstance() {
		if (TelaListarPedidosAberto.TelaListarPedidosAbertoinstance == null)
			TelaListarPedidosAberto.TelaListarPedidosAbertoinstance = new TelaListarPedidosAberto();

		return TelaListarPedidosAberto.TelaListarPedidosAbertoinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarPedidosAberto frame = new TelaListarPedidosAberto();
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
	public TelaListarPedidosAberto()  {
		setFont(new Font("Dialog", Font.PLAIN, 99));
		setTitle("Listar Pedidos em Aberto");
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
		textArea.setEditable(false);
		
		JLabel lblListarPedidos = new JLabel("Listar Pedidos Em Aberto");
		lblListarPedidos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblListarPedidos.setBounds(65, 11, 345, 24);
		contentPane.add(lblListarPedidos);
		
		JButton btnListarTodos = new JButton("Listar");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Pedido[] pedidos = Fachada.getInstance().listarPedidos();
				//ArrayList<Produto> nomeProdutos = new ArrayList<Produto>();
				for (int i = 0; i < pedidos.length; i++) {
				
					if(pedidos[i] != null && pedidos[i].getStatus() == true) {
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
		btnVoltar.setBounds(281, 291, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(182, 292, 89, 23);
		contentPane.add(btnReset);
	}

}
