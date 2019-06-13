package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.Font;

public class TelaPedidos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNDoTelefone;
	private JTextField txtQuantidadeDePizzas;
	private JTextField txtQuantidadeDeRegrigerantes;
	private JTextField txtNomeDoEntregador;
	private JTextField txtPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedidos frame = new TelaPedidos();
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
	public TelaPedidos() {
		setTitle("Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setBounds(12, 26, 66, 15);
		contentPane.add(lblCliente);
		
		txtNDoTelefone = new JTextField();
		txtNDoTelefone.setText("Nº do Telefone");
		txtNDoTelefone.setBounds(75, 24, 124, 19);
		contentPane.add(txtNDoTelefone);
		txtNDoTelefone.setColumns(10);
		
		JLabel lblDadosDoCliente = new JLabel("Dados do Cliente");
		lblDadosDoCliente.setBounds(172, 0, 124, 15);
		contentPane.add(lblDadosDoCliente);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(165, 65, 72, 15);
		contentPane.add(lblProdutos);
		
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setBounds(175, 86, 66, 15);
		contentPane.add(lblPizza);
		
		JLabel lblRefrigerantes = new JLabel("Refrigerantes");
		lblRefrigerantes.setBounds(163, 184, 107, 15);
		contentPane.add(lblRefrigerantes);
		
		txtQuantidadeDePizzas = new JTextField();
		txtQuantidadeDePizzas.setText("Quantidade de Pizzas");
		txtQuantidadeDePizzas.setBounds(75, 111, 36, 19);
		contentPane.add(txtQuantidadeDePizzas);
		txtQuantidadeDePizzas.setColumns(10);
		
		txtQuantidadeDeRegrigerantes = new JTextField();
		txtQuantidadeDeRegrigerantes.setText("Quantidade de Regrigerantes");
		txtQuantidadeDeRegrigerantes.setBounds(75, 201, 36, 19);
		contentPane.add(txtQuantidadeDeRegrigerantes);
		txtQuantidadeDeRegrigerantes.setColumns(10);
		
		JLabel lblEntregador = new JLabel("Entregador :");
		lblEntregador.setBounds(33, 249, 93, 15);
		contentPane.add(lblEntregador);
		
		txtNomeDoEntregador = new JTextField();
		txtNomeDoEntregador.setText("Nome do Entregador");
		txtNomeDoEntregador.setBounds(129, 247, 141, 19);
		contentPane.add(txtNomeDoEntregador);
		txtNomeDoEntregador.setColumns(10);
		
		JLabel lblNomeCliente = new JLabel("Nome :");
		lblNomeCliente.setBounds(230, 26, 66, 15);
		contentPane.add(lblNomeCliente);
		
		JLabel lblEnderecoCliente = new JLabel("Endereço :");
		lblEnderecoCliente.setBounds(12, 42, 86, 15);
		contentPane.add(lblEnderecoCliente);
		
		JLabel lblSabor = new JLabel("Sabor 1 :");
		lblSabor.setBounds(33, 137, 66, 15);
		contentPane.add(lblSabor);
		
		JLabel lblSabor_1 = new JLabel("Sabor 2 :");
		lblSabor_1.setBounds(33, 157, 66, 15);
		contentPane.add(lblSabor_1);
		
		JLabel lblPeso = new JLabel("Peso :");
		lblPeso.setBounds(133, 113, 66, 15);
		contentPane.add(lblPeso);
		
		JLabel lblQuantidade = new JLabel("Qtd :");
		lblQuantidade.setBounds(33, 203, 93, 15);
		contentPane.add(lblQuantidade);
		
		JLabel lblQtd = new JLabel("Qtd :");
		lblQtd.setBounds(32, 113, 66, 15);
		contentPane.add(lblQtd);
		
		txtPeso = new JTextField();
		txtPeso.setText("Peso");
		txtPeso.setBounds(185, 111, 51, 19);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblSabor_2 = new JLabel("Sabor 3 :");
		lblSabor_2.setBounds(204, 137, 66, 15);
		contentPane.add(lblSabor_2);
		
		JLabel lblSabor_3 = new JLabel("Sabor 4 :");
		lblSabor_3.setBounds(204, 157, 66, 15);
		contentPane.add(lblSabor_3);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(129, 203, 66, 15);
		contentPane.add(lblNome);
		
		JLabel lblLitros = new JLabel("Litros :");
		lblLitros.setBounds(292, 203, 66, 15);
		contentPane.add(lblLitros);
		
		JLabel lblValorTotal = new JLabel("Valor Total :");
		lblValorTotal.setBounds(33, 279, 93, 15);
		contentPane.add(lblValorTotal);
		
		JCheckBox checkBox = new JCheckBox("Borda Recheada");
		checkBox.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBox.setBounds(266, 109, 175, 23);
		contentPane.add(checkBox);
	}
}
