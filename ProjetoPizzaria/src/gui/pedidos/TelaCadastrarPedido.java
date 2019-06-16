package gui.pedidos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Cliente;
import negocios.Entregador;
import negocios.Fachada;
import negocios.Pedido;
import negocios.Produto;
import negocios.Tamanho;

public class TelaCadastrarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtQuantidadeDeRegrigerantes;
	private static JFrame telaPedidosinstance;
	private JTextField txtEnd;
	private JTextField txtTel;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField txtId;
	Entregador entregador = new Entregador();
	Cliente cliente = new Cliente();
	Pedido pedido = new Pedido();
	private JTextField txtNomeDoEntregador;
	private JTextField textAdd;
	ArrayList<Produto> produtos = new ArrayList<Produto>();

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
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 40, 264, 150);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(12, 45, 66, 15);
		contentPane.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setBounds(87, 43, 183, 19);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);

		JLabel lblDadosDoCliente = new JLabel("Dados do Cliente");
		lblDadosDoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDadosDoCliente.setBounds(87, 0, 146, 15);
		contentPane.add(lblDadosDoCliente);

		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPizza.setBounds(408, 0, 66, 15);
		contentPane.add(lblPizza);

		JLabel lblRefrigerantes = new JLabel("Refrigerantes");
		lblRefrigerantes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRefrigerantes.setBounds(126, 136, 107, 15);
		contentPane.add(lblRefrigerantes);

		txtQuantidadeDeRegrigerantes = new JTextField();
		txtQuantidadeDeRegrigerantes.setText("Quantidade de Regrigerantes");
		txtQuantidadeDeRegrigerantes.setBounds(69, 173, 36, 19);
		contentPane.add(txtQuantidadeDeRegrigerantes);
		txtQuantidadeDeRegrigerantes.setColumns(10);

		JLabel lblEntregador = new JLabel("Entregador :");
		lblEntregador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEntregador.setBounds(33, 245, 93, 15);
		contentPane.add(lblEntregador);

		JLabel lblNomeCliente = new JLabel("Telefone :");
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeCliente.setBounds(12, 97, 66, 15);
		contentPane.add(lblNomeCliente);

		JLabel lblEnderecoCliente = new JLabel("Endere\u00E7o :");
		lblEnderecoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnderecoCliente.setBounds(12, 71, 64, 15);
		contentPane.add(lblEnderecoCliente);

		JLabel lblQuantidade = new JLabel("Qtd :");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBounds(33, 175, 93, 15);
		contentPane.add(lblQuantidade);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(126, 176, 49, 15);
		contentPane.add(lblNome);

		JLabel lblLitros = new JLabel("Litros :");
		lblLitros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLitros.setBounds(33, 203, 66, 15);
		contentPane.add(lblLitros);

		JLabel lblValorTotal = new JLabel("Valor Total :");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorTotal.setBounds(12, 364, 103, 18);
		contentPane.add(lblValorTotal);

		JCheckBox checkBox = new JCheckBox("Borda Recheada");
		checkBox.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBox.setBounds(350, 282, 175, 23);
		contentPane.add(checkBox);

		txtEnd = new JTextField();
		txtEnd.setBounds(86, 69, 186, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);

		txtTel = new JTextField();
		txtTel.setBounds(88, 95, 182, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(184, 173, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(103, 365, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entregador.setNome(txtNomeDoEntregador.getText());
				cliente.setNome(txtCliente.getText());
				cliente.setEndereco(txtEnd.getText());
				cliente.setTelefone(txtTel.getText());
				int id = (Integer.parseInt(txtId.getText()));
				//pedido = new Pedido(cliente,produtos,entregador,null,id);
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(372, 364, 120, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.getInstance().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(501, 364, 73, 23);
		contentPane.add(btnVoltar);

		JLabel lblIdPedido = new JLabel("ID Pedido:");
		lblIdPedido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdPedido.setBounds(32, 271, 73, 14);
		contentPane.add(lblIdPedido);

		txtId = new JTextField();
		txtId.setBounds(126, 273, 144, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JComboBox refrigeranteComboBox = new JComboBox(Tamanho.values());
		refrigeranteComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refrigeranteComboBox.getItemAt(refrigeranteComboBox.getSelectedIndex());
			}
		});
		refrigeranteComboBox.setBounds(87, 198, 49, 24);
		contentPane.add(refrigeranteComboBox);
		
		txtNomeDoEntregador = new JTextField();
		txtNomeDoEntregador.setBounds(126, 243, 144, 20);
		contentPane.add(txtNomeDoEntregador);
		txtNomeDoEntregador.setColumns(10);
		
		JLabel lblInformeOCdigo = new JLabel("Informe o C\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformeOCdigo.setBounds(310, 201, 149, 17);
		contentPane.add(lblInformeOCdigo);
		
		textAdd = new JTextField();
		textAdd.setBounds(438, 201, 93, 20);
		contentPane.add(textAdd);
		textAdd.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto p;
				p = Fachada.getInstance().procurarProduto(textAdd.getText());
				textArea.append(p.toString());
				produtos.add(p);
				
				
			}
		});
		btnAdd.setBounds(335, 241, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelet = new JButton("Apagar");
		btnDelet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto j;
				j = Fachada.getInstance().procurarProduto(textAdd.getText());
				produtos.remove(j);
			}
		});
		btnDelet.setBounds(436, 241, 89, 23);
		contentPane.add(btnDelet);
		
		JButton btnCalcularTotal = new JButton("Calcular Total");
		btnCalcularTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalcularTotal.setBounds(233, 364, 129, 23);
		contentPane.add(btnCalcularTotal);

	}
}
