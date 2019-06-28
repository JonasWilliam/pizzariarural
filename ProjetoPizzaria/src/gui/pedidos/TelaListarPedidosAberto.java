package gui.pedidos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Pedido;
import negocios.Produto;
import java.awt.Color;

public class TelaListarPedidosAberto extends JFrame {

	private JPanel contentPane;
	private static JFrame TelaListarPedidosAbertoinstance;
	private JTextField txtid;

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
	public TelaListarPedidosAberto() {
		setFont(new Font("Dialog", Font.PLAIN, 99));
		setTitle("Listar Pedidos em Aberto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(250, 235, 215));

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
		btnListarTodos.setBackground(Color.GREEN);
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Pedido[] pedidos = Fachada.getInstance().listarPedidos();
				// ArrayList<Produto> nomeProdutos = new ArrayList<Produto>();
				for (int i = 0; i < pedidos.length; i++) {

					if (pedidos[i] != null && pedidos[i].getStatus() == true) {
						textArea.append(pedidos[i].toString());
					}

				}

			}
		});
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarTodos.setBounds(44, 291, 121, 23);
		contentPane.add(btnListarTodos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.RED);
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
		btnReset.setBackground(Color.GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				txtid.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(182, 292, 89, 23);
		contentPane.add(btnReset);

		JButton btnTeste = new JButton("Procurar");
		btnTeste.setBackground(Color.GREEN);
		btnTeste.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Código do Pedido: ");
				Pedido[] p;
				ArrayList<Produto> produtos;
				p = Fachada.getInstance().listarPedidos();
				if (p != null) {
					for (int i = 0; i < p.length; i++) {
						if (p[i] != null) {
							if (p[i].getId() == Integer.parseInt(txtid.getText())) {
								produtos = p[i].getProdutos();
								textArea.append(String.valueOf(p[i].getId()));
								for (int j = 0; j < produtos.size(); j++) {
									
									textArea.append("\n Código do produto:");
									textArea.append(produtos.get(j).getCodigo());
								}
							}
						}
					}
				}
			}
		});
		btnTeste.setBounds(335, 66, 89, 23);
		contentPane.add(btnTeste);

		txtid = new JTextField();
		txtid.setBounds(242, 67, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblInformarCdigoPara = new JLabel("Informar C\u00F3digo para mais Detalhes:");
		lblInformarCdigoPara.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformarCdigoPara.setBounds(10, 70, 222, 19);
		contentPane.add(lblInformarCdigoPara);
	}
}
