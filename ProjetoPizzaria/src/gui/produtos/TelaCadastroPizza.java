package gui.produtos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Pizza1;
import negocios.Tamanho;
import negocios.exception.IdProdutoException;

public class TelaCadastroPizza extends JFrame {

	private JPanel contentPane;
	private JTextField txtSabor;
	private static JFrame telaCadastroPizzainstance;
	Pizza1 pizza = new Pizza1();
	private JTextField txtCustoMaterial;
	private JTextField txtCodigo;
	private JTextField txtCustoMaodeObra;
	private JTextField txtTaxa;
	private JTextField txtValorTotal;

	public static JFrame getInstance() {
		if (TelaCadastroPizza.telaCadastroPizzainstance == null)
			TelaCadastroPizza.telaCadastroPizzainstance = new TelaCadastroPizza();

		return TelaCadastroPizza.telaCadastroPizzainstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPizza frame = new TelaCadastroPizza();
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
	public TelaCadastroPizza() {
		setTitle("Cadastro de Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDePizza = new JLabel("Cadastro de Pizza\r\n");
		lblCadastroDePizza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDePizza.setBounds(49, 11, 192, 22);
		contentPane.add(lblCadastroDePizza);

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSabor.setBounds(25, 78, 58, 18);
		contentPane.add(lblSabor);

		txtSabor = new JTextField();
		txtSabor.setColumns(10);
		txtSabor.setBounds(87, 78, 139, 20);
		contentPane.add(txtSabor);

		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarParaMenu.setBounds(156, 267, 112, 23);
		contentPane.add(btnVoltarParaMenu);

		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTamanho.setBounds(25, 108, 81, 28);
		contentPane.add(lblTamanho);

		JComboBox pizzaComboBox = new JComboBox(Tamanho.values());
		pizzaComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pizzaComboBox.getSelectedItem();
				txtTaxa.setText(pizzaComboBox.getSelectedItem().toString());
			}
		});
		pizzaComboBox.setBounds(113, 110, 45, 22);
		contentPane.add(pizzaComboBox);

		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorTotal.setBounds(25, 210, 112, 22);
		contentPane.add(lblValorTotal);

		txtCustoMaterial = new JTextField();
		txtCustoMaterial.setBounds(145, 145, 58, 20);
		contentPane.add(txtCustoMaterial);
		txtCustoMaterial.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(102, 45, 139, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(25, 45, 76, 19);
		contentPane.add(lblCodigo);

		JLabel lblCustoMaterial = new JLabel("Custo Mateiral:");
		lblCustoMaterial.setBounds(30, 148, 112, 15);
		contentPane.add(lblCustoMaterial);

		JLabel lblTaxa = new JLabel("Taxa:");
		lblTaxa.setBounds(176, 104, 64, 26);
		contentPane.add(lblTaxa);

		JLabel lblCustoMoDe = new JLabel("Custo Mão de Obra:");
		lblCustoMoDe.setBounds(27, 180, 149, 18);
		contentPane.add(lblCustoMoDe);

		txtCustoMaodeObra = new JTextField();
		txtCustoMaodeObra.setBounds(177, 177, 96, 19);
		contentPane.add(txtCustoMaodeObra);
		txtCustoMaodeObra.setColumns(10);

		txtTaxa = new JTextField();
		txtTaxa.setEditable(false);
		txtTaxa.setBounds(240, 113, 50, 19);
		contentPane.add(txtTaxa);
		txtTaxa.setColumns(10);

		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(144, 212, 124, 19);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);

		JButton btnCadastrarPizza = new JButton("Cadastrar");
		btnCadastrarPizza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pizza.setCodigo(txtCodigo.getText());
				pizza.setNome(txtSabor.getText());
				pizza.setTamanho(Tamanho.valueOf(pizzaComboBox.getSelectedItem().toString()));
				pizza.setCustoMaterial(Float.parseFloat(txtCustoMaterial.getText()));
				pizza.setCustoMaodeObra(Float.parseFloat(txtCustoMaodeObra.getText()));
				pizza.calcularPreco();
				txtValorTotal.setText(new String(pizza.getValor() + ""));
				pizza.setId(1);
				

				try {
					Fachada.getInstance().cadastrarProduto(pizza);
					JOptionPane.showMessageDialog(null, "Sabor de Pizza adicionado ao repositorio com sucesso");
					txtSabor.setText("");
					txtCodigo.setText("");
					txtCustoMaterial.setText("");
					txtCustoMaodeObra.setText("");
				} catch (IdProdutoException eId) {
					eId.printStackTrace();
				}

			}

		});
		btnCadastrarPizza.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarPizza.setBounds(25, 267, 112, 23);
		contentPane.add(btnCadastrarPizza);
	}
}
