package gui.produtos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Pizza;
import negocios.Tamanho;
import negocios.exception.IdProdutoException;

public class TelaCadastroPizza extends JFrame {

	private JPanel contentPane;
	private JTextField txtSabor;
	private static JFrame telaCadastroPizzainstance;
	Pizza pizza = new Pizza();
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
		setBounds(100, 100, 330, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDePizza = new JLabel("Cadastro de Pizza\r\n");
		lblCadastroDePizza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDePizza.setBounds(49, 11, 192, 22);
		contentPane.add(lblCadastroDePizza);

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSabor.setBounds(25, 101, 58, 18);
		contentPane.add(lblSabor);

		txtSabor = new JTextField();
		txtSabor.setColumns(10);
		txtSabor.setBounds(87, 102, 154, 20);
		contentPane.add(txtSabor);

		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarParaMenu.setBounds(205, 334, 99, 23);
		contentPane.add(btnVoltarParaMenu);

		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTamanho.setBounds(25, 130, 81, 28);
		contentPane.add(lblTamanho);

		JComboBox pizzaComboBox = new JComboBox(Tamanho.values());
		pizzaComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pizzaComboBox.getSelectedItem();
				txtTaxa.setText(pizzaComboBox.getSelectedItem().toString());
			}
		});
		pizzaComboBox.setBounds(116, 135, 45, 22);
		contentPane.add(pizzaComboBox);

		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorTotal.setBounds(25, 292, 112, 22);
		contentPane.add(lblValorTotal);

		txtCustoMaterial = new JTextField();
		txtCustoMaterial.setBounds(171, 168, 109, 20);
		contentPane.add(txtCustoMaterial);
		txtCustoMaterial.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(87, 71, 154, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JCheckBox checkBoxBorda = new JCheckBox("Borda Recheada");
		checkBoxBorda.setFont(new Font("Dialog", Font.BOLD, 14));
		checkBoxBorda.setBounds(25, 234, 175, 23);
		contentPane.add(checkBoxBorda);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(25, 71, 76, 19);
		contentPane.add(lblCodigo);

		JLabel lblCustoMaterial = new JLabel("Custo Mateiral:");
		lblCustoMaterial.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCustoMaterial.setBounds(25, 169, 136, 15);
		contentPane.add(lblCustoMaterial);

		JLabel lblTaxa = new JLabel("Taxa:");
		lblTaxa.setBounds(171, 133, 64, 26);
		contentPane.add(lblTaxa);

		JLabel lblCustoMoDe = new JLabel("Custo M\u00E3o de Obra:");
		lblCustoMoDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustoMoDe.setBounds(25, 195, 149, 18);
		contentPane.add(lblCustoMoDe);

		txtCustoMaodeObra = new JTextField();
		txtCustoMaodeObra.setBounds(168, 196, 112, 19);
		contentPane.add(txtCustoMaodeObra);
		txtCustoMaodeObra.setColumns(10);

		txtTaxa = new JTextField();
		txtTaxa.setEditable(false);
		txtTaxa.setBounds(208, 136, 50, 19);
		contentPane.add(txtTaxa);
		txtTaxa.setColumns(10);

		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(113, 295, 124, 19);
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
				pizza.setBordaRecheada(checkBoxBorda.isSelected());
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
					dispose();
					TelaPrincipal.getInstance().setVisible(true);
				} catch (IdProdutoException eId) {
					eId.printStackTrace();
				}

			}

		});
		btnCadastrarPizza.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarPizza.setBounds(10, 334, 99, 23);
		contentPane.add(btnCadastrarPizza);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSabor.setText("");
				txtCodigo.setText("");
				txtCustoMaterial.setText("");
				txtCustoMaodeObra.setText("");
				checkBoxBorda.setSelected(false);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(116, 334, 79, 23);
		contentPane.add(btnReset);
	}
}
