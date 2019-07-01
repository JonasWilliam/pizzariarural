package gui.pedidos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import gui.produtos.ProdutoTableModel;
import gui.produtos.TelaListarProdutos;
import negocios.Cliente;
import negocios.Entregador;
import negocios.Fachada;
import negocios.Funcionario;
import negocios.Pedido;
import negocios.Produto;
import negocios.exception.ClientePedidosException;
import java.awt.Color;
import javax.swing.JTable;

public class TelaCadastrarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private static JFrame telaPedidosinstance;
	private JTextField txtEnd;
	private JTextField txtTel;
	private JTextField TOTAL;
	private JTextField txtId;
	Entregador entregador = new Entregador();
	Cliente cliente = new Cliente();
	Pedido pedido = new Pedido();
	private JTextField textAdd;
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	private JTextField textRemove;
	private JTextField txtEntregador;
	private JTable table;
	ProdutoTableModel modelo = new ProdutoTableModel();

	public static JFrame getInstance() {
		if (TelaCadastrarPedido.telaPedidosinstance == null)
			TelaCadastrarPedido.telaPedidosinstance = new TelaCadastrarPedido();

		return TelaCadastrarPedido.telaPedidosinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarPedido frame = new TelaCadastrarPedido();
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
	public TelaCadastrarPedido() {
		setTitle("Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 40, 314, 150);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);

		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(12, 45, 66, 15);
		contentPane.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setBounds(87, 43, 183, 19);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		JLabel lblDadosDoCliente = new JLabel("Dados do Cliente");
		lblDadosDoCliente.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDadosDoCliente.setBounds(43, -2, 227, 34);
		contentPane.add(lblDadosDoCliente);

		JLabel lblEntregador = new JLabel("Entregador :");
		lblEntregador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEntregador.setBounds(7, 167, 80, 23);
		contentPane.add(lblEntregador);

		JLabel lblNomeCliente = new JLabel("Telefone :");
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeCliente.setBounds(12, 97, 66, 15);
		contentPane.add(lblNomeCliente);

		JLabel lblEnderecoCliente = new JLabel("Endere\u00E7o :");
		lblEnderecoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnderecoCliente.setBounds(12, 71, 64, 15);
		contentPane.add(lblEnderecoCliente);

		JLabel lblValorTotal = new JLabel("Valor Total :");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorTotal.setBounds(12, 364, 103, 18);
		contentPane.add(lblValorTotal);

		txtEnd = new JTextField();
		txtEnd.setBounds(86, 69, 186, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);

		txtTel = new JTextField();
		txtTel.setBounds(88, 95, 182, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		TOTAL = new JTextField();
		TOTAL.setFont(new Font("Tahoma", Font.BOLD, 14));
		TOTAL.setEditable(false);
		TOTAL.setBounds(103, 365, 86, 20);
		contentPane.add(TOTAL);
		TOTAL.setColumns(10);
		

		JComboBox comboBoxentregadores = new JComboBox();
		comboBoxentregadores.setBounds(96, 168, 114, 22);
		contentPane.add(comboBoxentregadores);

		JButton btnCarregar = new JButton("\r\nListar");
		btnCarregar.setBackground(Color.YELLOW);
		btnCarregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario[] entregadores;
				entregadores = Fachada.getInstance().listarFuncionario();
				for (int i = 0; i < entregadores.length; i++) {
					if (entregadores[i] != null && entregadores[i].getCargo().toString().equals("Entregador")) {
						comboBoxentregadores.addItem(entregadores[i].getNome());
					}

				}
			}
		});
		
		txtEntregador = new JTextField();
		txtEntregador.setBounds(103, 200, 86, 20);
		contentPane.add(txtEntregador);
		txtEntregador.setColumns(10);
		txtEntregador.setText((String) comboBoxentregadores.getSelectedItem());
		txtEntregador.setEditable(false);
		txtEntregador.setVisible(false);
		
		btnCarregar.setBounds(220, 167, 80, 23);
		contentPane.add(btnCarregar);

		JButton btnCalcularTotal = new JButton("Calcular Total");
		btnCalcularTotal.setBackground(Color.YELLOW);
		btnCalcularTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText(txtTel.getText());
				txtEntregador.setText((String) comboBoxentregadores.getSelectedItem());
				float total = 0;
				for (int i = 0; i < produtos.size(); i++) {
					total += produtos.get(i).getValor();
					TOTAL.setText(String.valueOf(total));
				}
			}
		});
		btnCalcularTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalcularTotal.setBounds(252, 363, 129, 23);
		contentPane.add(btnCalcularTotal);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(Color.GREEN);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entregador.setNome(txtEntregador.getText());
				cliente.setNome(txtCliente.getText());
				cliente.setEndereco(txtEnd.getText());
				cliente.setTelefone(txtTel.getText());
				txtId.setText(txtTel.getText());
				int id = (Integer.parseInt(txtId.getText()));
				float soma = (Float.parseFloat(TOTAL.getText()));
				pedido = new Pedido(cliente, produtos, entregador, soma, id, true);
				try {
					Fachada.getInstance().criarPedido(pedido);
					JOptionPane.showMessageDialog(null, "Pedido adicionado ao repositorio com sucesso");
					txtEntregador.setText("");
					txtCliente.setText("");
					txtEnd.setText("");
					txtTel.setText("");
					txtId.setText("");
					TOTAL.setText("");
					

				} catch (ClientePedidosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(391, 364, 120, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.getInstance().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(521, 364, 103, 23);
		contentPane.add(btnVoltar);

		JLabel lblIdPedido = new JLabel("ID Pedido:");
		lblIdPedido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdPedido.setBounds(12, 245, 81, 14);
		contentPane.add(lblIdPedido);

		txtId = new JTextField();
		txtId.setBounds(87, 243, 144, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		txtId.setEditable(false);

		JLabel lblInformeOCdigo = new JLabel("Informe o C\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformeOCdigo.setBounds(310, 201, 120, 17);
		contentPane.add(lblInformeOCdigo);

		textAdd = new JTextField();
		textAdd.setBounds(438, 201, 87, 20);
		contentPane.add(textAdd);
		textAdd.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p;
				p = Fachada.getInstance().procurarProduto(textAdd.getText());
				if (textAdd.getText().equals("") || textAdd.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "informe um codigo");
				} else if (p == null) {
					JOptionPane.showMessageDialog(null, "Produto não existe");
				} else {
					modelo.addRow(p);
					produtos.add(p);
					textAdd.setText("");
				}

			}

		});
		btnAdd.setBounds(546, 199, 66, 23);
		contentPane.add(btnAdd);

		JButton btnDelet = new JButton("Apagar");
		btnDelet.setBackground(Color.RED);
		btnDelet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto j;
				j = Fachada.getInstance().procurarProduto(textRemove.getText());
				produtos.remove(j);
				textRemove.setText("");
				modelo.limparLista();
				for(int i = 0; i < produtos.size(); i++) {
					modelo.addRow(produtos.get(i));
				}

			}
		});

		btnDelet.setBounds(535, 241, 89, 23);
		contentPane.add(btnDelet);

		JLabel lblCdigoPApagar = new JLabel("C\u00F3digo p/ Apagar");
		lblCdigoPApagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoPApagar.setBounds(310, 237, 120, 23);
		contentPane.add(lblCdigoPApagar);

		textRemove = new JTextField();
		textRemove.setBounds(439, 243, 86, 20);
		contentPane.add(textRemove);
		textRemove.setColumns(10);

		JLabel lblProdutos = new JLabel("PRODUTOS");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProdutos.setBounds(353, 2, 194, 27);
		contentPane.add(lblProdutos);

		JButton btnNewButton = new JButton("Listar Todos Produtos");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarProdutos.getInstance().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(310, 273, 215, 23);
		contentPane.add(btnNewButton);
		
		


		/*
		 * private void carregarComboBox(){ ArrayList<String> contas = new
		 * ArrayList<String>(); contas =
		 * RepositorioContasArray.getInstance().getContas(); for(int i = 0;
		 * i<=contas.size()-1;i++){ comboBoxContas.addItem(contas.get(i)); }
		 */
	}
}
