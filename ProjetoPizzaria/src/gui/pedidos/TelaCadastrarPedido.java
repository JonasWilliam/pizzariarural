package gui.pedidos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

<<<<<<< HEAD
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
||||||| merged common ancestors
=======
import javax.swing.JButton;
import javax.swing.JCheckBox;
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
<<<<<<< HEAD
import negocios.Tamanho;
||||||| merged common ancestors

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
=======
import negocios.Cliente;
import negocios.Entregador;
import negocios.Fachada;
import negocios.Pedido;
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c

public class TelaCadastrarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtQuantidadeDePizzas;
	private JTextField txtQuantidadeDeRegrigerantes;
	private JTextField txtNomeDoEntregador;
	private static JFrame telaPedidosinstance;
	private JTextField txtend;
	private JTextField txttel;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textid;
	Entregador entregador = new Entregador();
	Cliente cliente = new Cliente();
	Pedido pedido;

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

		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(12, 45, 66, 15);
		contentPane.add(lblCliente);
<<<<<<< HEAD

		txtNDoTelefone = new JTextField();
		txtNDoTelefone.setBounds(87, 43, 183, 19);
		contentPane.add(txtNDoTelefone);
		txtNDoTelefone.setColumns(10);

||||||| merged common ancestors
		
		txtNDoTelefone = new JTextField();
		txtNDoTelefone.setBounds(87, 43, 183, 19);
		contentPane.add(txtNDoTelefone);
		txtNDoTelefone.setColumns(10);
		
=======
		
		txtCliente = new JTextField();
		txtCliente.setBounds(87, 43, 183, 19);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
		JLabel lblDadosDoCliente = new JLabel("Dados do Cliente");
		lblDadosDoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDadosDoCliente.setBounds(87, 0, 146, 15);
		contentPane.add(lblDadosDoCliente);

		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPizza.setBounds(431, 0, 66, 15);
		contentPane.add(lblPizza);

		JLabel lblRefrigerantes = new JLabel("Refrigerantes");
		lblRefrigerantes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRefrigerantes.setBounds(115, 136, 107, 28);
		contentPane.add(lblRefrigerantes);

		txtQuantidadeDePizzas = new JTextField();
		txtQuantidadeDePizzas.setBounds(389, 43, 36, 19);
		contentPane.add(txtQuantidadeDePizzas);
		txtQuantidadeDePizzas.setColumns(10);

		txtQuantidadeDeRegrigerantes = new JTextField();
		txtQuantidadeDeRegrigerantes.setText("Quantidade de Regrigerantes");
		txtQuantidadeDeRegrigerantes.setBounds(69, 173, 36, 19);
		contentPane.add(txtQuantidadeDeRegrigerantes);
		txtQuantidadeDeRegrigerantes.setColumns(10);

		JLabel lblEntregador = new JLabel("Entregador :");
		lblEntregador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEntregador.setBounds(33, 245, 93, 15);
		contentPane.add(lblEntregador);

		txtNomeDoEntregador = new JTextField();
		txtNomeDoEntregador.setText("Nome do Entregador");
		txtNomeDoEntregador.setBounds(129, 243, 141, 19);
		contentPane.add(txtNomeDoEntregador);
		txtNomeDoEntregador.setColumns(10);

		JLabel lblNomeCliente = new JLabel("Telefone :");
		lblNomeCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeCliente.setBounds(12, 97, 66, 15);
		contentPane.add(lblNomeCliente);

		JLabel lblEnderecoCliente = new JLabel("Endere\u00E7o :");
		lblEnderecoCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnderecoCliente.setBounds(12, 71, 64, 15);
		contentPane.add(lblEnderecoCliente);

		JLabel lblSabor = new JLabel("Sabor 1 :");
		lblSabor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSabor.setBounds(350, 97, 60, 15);
		contentPane.add(lblSabor);

		JLabel lblSabor_1 = new JLabel("Sabor 2 :");
		lblSabor_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSabor_1.setBounds(350, 123, 66, 15);
		contentPane.add(lblSabor_1);

		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTamanho.setBounds(442, 45, 83, 15);
		contentPane.add(lblTamanho);

		JLabel lblQuantidade = new JLabel("Qtd :");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBounds(33, 175, 93, 15);
		contentPane.add(lblQuantidade);

		JLabel lblQtd = new JLabel("Qtd :");
		lblQtd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQtd.setBounds(350, 46, 43, 15);
		contentPane.add(lblQtd);

		JLabel lblSabor_2 = new JLabel("Sabor 3 :");
		lblSabor_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSabor_2.setBounds(350, 149, 66, 15);
		contentPane.add(lblSabor_2);

		JLabel lblSabor_3 = new JLabel("Sabor 4 :");
		lblSabor_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSabor_3.setBounds(350, 175, 66, 15);
		contentPane.add(lblSabor_3);

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
		lblValorTotal.setBounds(33, 303, 103, 18);
		contentPane.add(lblValorTotal);

		JCheckBox checkBox = new JCheckBox("Borda Recheada");
		checkBox.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBox.setBounds(350, 211, 175, 23);
		contentPane.add(checkBox);
<<<<<<< HEAD

		textField = new JTextField();
		textField.setBounds(86, 69, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(88, 95, 182, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

||||||| merged common ancestors
		
		textField = new JTextField();
		textField.setBounds(86, 69, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 95, 182, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
=======
		
		txtend = new JTextField();
		txtend.setBounds(86, 69, 186, 20);
		contentPane.add(txtend);
		txtend.setColumns(10);
		
		txttel = new JTextField();
		txttel.setBounds(88, 95, 182, 20);
		contentPane.add(txttel);
		txttel.setColumns(10);
		
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
		textField_2 = new JTextField();
		textField_2.setBounds(420, 120, 94, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(420, 95, 94, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBounds(420, 146, 94, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(420, 172, 94, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBounds(184, 173, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(162, 301, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
<<<<<<< HEAD

		JButton btnConfirmar = new JButton("Confirmar");
||||||| merged common ancestors
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
=======
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setNome(txtCliente.getText());
				cliente.setTelefone(txttel.getText());
				cliente.setEndereco(txtend.getText());
				entregador.setNome(txtNomeDoEntregador.getText());
			int id = Integer.parseInt(textid.getText());
				//pedido = new Pedido(cliente,lista,entregador,total,id);
				//Fachada.getInstance().criarPedido(pedido);
			}
		});
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(318, 301, 120, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(463, 301, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblIdPedido = new JLabel("ID Pedido:");
		lblIdPedido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdPedido.setBounds(32, 271, 73, 14);
		contentPane.add(lblIdPedido);
<<<<<<< HEAD

		textField_9 = new JTextField();
		textField_9.setBounds(126, 273, 144, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

		JComboBox pizzaComboBox = new JComboBox(Tamanho.values());
		pizzaComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pizzaComboBox.getItemAt(pizzaComboBox.getSelectedIndex());
			}
		});
		pizzaComboBox.setBounds(521, 40, 49, 24);
		contentPane.add(pizzaComboBox);

		JComboBox refrigeranteComboBox = new JComboBox(Tamanho.values());
		refrigeranteComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refrigeranteComboBox.getItemAt(refrigeranteComboBox.getSelectedIndex());
			}
		});
		refrigeranteComboBox.setBounds(87, 198, 49, 24);
		contentPane.add(refrigeranteComboBox);

||||||| merged common ancestors
		
		textField_9 = new JTextField();
		textField_9.setBounds(126, 273, 144, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
=======
		
		textid = new JTextField();
		textid.setBounds(126, 273, 144, 20);
		contentPane.add(textid);
		textid.setColumns(10);
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
	}
}