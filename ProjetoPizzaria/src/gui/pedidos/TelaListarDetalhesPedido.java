package gui.pedidos;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.produtos.ProdutoTableModel;
import negocios.Fachada;
import negocios.Pedido;
import negocios.Produto;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaListarDetalhesPedido extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtid;
	ProdutoTableModel modelo = new ProdutoTableModel();
	private JLabel lblProdutosDoPedido;
	private static JFrame instance;
	
	public static JFrame getInstance() {
		if (TelaListarDetalhesPedido.instance == null)
			TelaListarDetalhesPedido.instance = new TelaListarDetalhesPedido();

		return TelaListarDetalhesPedido.instance;

	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarDetalhesPedido frame = new TelaListarDetalhesPedido();
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
	public TelaListarDetalhesPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 414, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		JButton btnNewButton = new JButton("Procurar\r\n");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pedido[] p;
				ArrayList<Produto> produtos;
				p = Fachada.getInstance().listarPedidos();
				if (p != null) {
					
					for (int i = 0; i < p.length; i++) {
						if (p[i] != null) {
							if (p[i].getId() == Integer.parseInt(txtid.getText())) {
								
								produtos = p[i].getProdutos();
								modelo.limparLista();
								for (int j = 0; j < produtos.size(); j++) {
									System.out.print("teste1");
									modelo.addRow(produtos.get(j));
								}
							}
						}
					}
				}
			}
		});
		btnNewButton.setBounds(293, 222, 89, 23);
		contentPane.add(btnNewButton);
		
		txtid = new JTextField();
		txtid.setBounds(104, 223, 152, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		lblProdutosDoPedido = new JLabel("Produtos do Pedido: ");
		lblProdutosDoPedido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProdutosDoPedido.setBounds(36, 11, 341, 23);
		contentPane.add(lblProdutosDoPedido);
		
	}
}
