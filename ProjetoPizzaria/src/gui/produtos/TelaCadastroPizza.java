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
import negocios.Pizza;
import negocios.Tamanho;
import negocios.exception.IdProdutoException;

public class TelaCadastroPizza extends JFrame {

	private JPanel contentPane;
	private JTextField txtSabor;
	private static JFrame telaCadastroPizzainstance;
	Pizza pizza = new Pizza();
	private JTextField txtValor;
	private JTextField txtCodigo;

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
		lblSabor.setBounds(25, 68, 58, 18);
		contentPane.add(lblSabor);

		txtSabor = new JTextField();
		txtSabor.setColumns(10);
		txtSabor.setBounds(83, 69, 139, 20);
		contentPane.add(txtSabor);

		JButton btnCadastrarPizza = new JButton("Cadastrar");
		btnCadastrarPizza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pizza.setNome(txtSabor.getText());
				pizza.setId(Integer.parseInt(txtCodigo.getText()));
				pizza.setValor(Float.parseFloat(txtValor.getText()));
				
				try {
					Fachada.getInstance().cadastrarProduto(pizza);
					JOptionPane.showMessageDialog(null, "Sabor de Pizza adicionado ao repositorio com sucesso");
					txtSabor.setText("");
				} catch (IdProdutoException eId) {
					eId.printStackTrace();
				}

			}

		});
		btnCadastrarPizza.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarPizza.setBounds(25, 267, 112, 23);
		contentPane.add(btnCadastrarPizza);

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
		lblTamanho.setBounds(20, 108, 81, 28);
		contentPane.add(lblTamanho);
		
		JComboBox comboBox = new JComboBox(Tamanho.values());
		comboBox.setBounds(99, 113, 45, 22);
		contentPane.add(comboBox);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(25, 157, 58, 22);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(84, 160, 111, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(83, 207, 139, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(25, 206, 76, 19);
		contentPane.add(lblCodigo);
	}
}
