package gui.pedidos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import gui.funcionarios.FuncionarioTableModel;
import gui.produtos.ProdutoTableModel;
import negocios.Fachada;
import negocios.Pedido;
import negocios.Produto;

public class TelaListarPedidosAberto extends JFrame {

	private JPanel contentPane;
	private static JFrame TelaListarPedidosAbertoinstance;
	private JTextField txtid;
	private JTable table;
	PedidosTableModel modelo = new PedidosTableModel();
	ProdutoTableModel modelo2 = new ProdutoTableModel();
	private JTable table_1;

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
		setBounds(100, 100, 451, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(250, 235, 215));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 62, 414, 173);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);

		JLabel label = new JLabel("");
		label.setBounds(346, 378, 79, 14);
		contentPane.add(label);
		label.setText("");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(162, 370, 134, 26);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("");

		JLabel lblListarPedidos = new JLabel("Listar Pedidos Em Aberto");
		lblListarPedidos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblListarPedidos.setBounds(65, 11, 345, 24);
		contentPane.add(lblListarPedidos);

		JButton btnListarTodos = new JButton("Listar");
		btnListarTodos.setBackground(Color.GREEN);
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				TelaListarPedidosAbertoinstance = null;
			//	TelaListarPedidosAberto.getInstance();
				Pedido[] pedidos = Fachada.getInstance().listarPedidos();
				for (int i = 0; i < pedidos.length; i++) {
					if (pedidos[i] != null && pedidos[i].getStatus() == true) {
						modelo.addRow(pedidos[i]);
					}
				}
			}
		});
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarTodos.setBounds(97, 262, 121, 23);
		contentPane.add(btnListarTodos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListarPedidosAbertoinstance = null;
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(239, 262, 89, 23);
		contentPane.add(btnVoltar);

		txtid = new JTextField();
		txtid.setBounds(206, 339, 108, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);

		JLabel lblInformarCdigoPara = new JLabel("Id para mais Detalhes:");
		lblInformarCdigoPara.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformarCdigoPara.setBounds(23, 338, 235, 19);
		contentPane.add(lblInformarCdigoPara);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(Color.GREEN);
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TelaListarDetalhesPedido.getInstance().setVisible(true);
				modelo2.limparLista();
				
				Pedido[] p;
				ArrayList<Produto> produtos;
				p = Fachada.getInstance().listarPedidos();

				if (txtid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite um Id para Procurar.");
				} else {

					Pedido pedido = Fachada.getInstance().procurarPedido(Integer.parseInt(txtid.getText()));
					if(pedido == null) {
						JOptionPane.showMessageDialog(null, "Não existe pedido com esse id.");
					}
					
					if (p != null) {

						for (int i = 0; i < p.length; i++) {
							if (p[i] != null) {
								if (p[i].getId() == Integer.parseInt(txtid.getText())) {
									lblNewLabel.setText(String.valueOf(p[i].getId()));
									label.setText(String.valueOf(p[i].getStatus()));
									
									produtos = p[i].getProdutos();
									modelo.limparLista();
									for (int j = 0; j < produtos.size(); j++) {
										System.out.print("teste1");
										modelo2.addRow(produtos.get(j));

									}
								}
							}
						}
					}
				}

			}
		});
		btnProcurar.setBounds(336, 337, 89, 23);
		contentPane.add(btnProcurar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 407, 405, 145);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(modelo2);

		JLabel lblDetalhesDoPedido = new JLabel("Detalhes do Pedido");
		lblDetalhesDoPedido.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDetalhesDoPedido.setBounds(102, 296, 270, 32);
		contentPane.add(lblDetalhesDoPedido);

		JLabel lblIdDoPedido = new JLabel("Id do Pedido:");
		lblIdDoPedido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIdDoPedido.setBounds(25, 370, 121, 26);
		contentPane.add(lblIdDoPedido);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(291, 377, 46, 14);
		contentPane.add(lblStatus);
		
		

	}
}
