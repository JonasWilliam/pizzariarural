package gui.produtos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Pizza;
import negocios.exception.IdProdutoException;

public class TelaCadastroPizza extends JFrame {

	private JPanel contentPane;
<<<<<<< HEAD
	private JTextField textField_1;
||||||| merged common ancestors
	private JTextField textField_1;
	private JTextField textField_2;
=======
	private JTextField textSabor;
	private JTextField textValor;
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
	private static JFrame telaCadastroPizzainstance;
	Pizza pizza = new Pizza();

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
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDePizza = new JLabel("Cadastro de Pizza\r\n");
		lblCadastroDePizza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDePizza.setBounds(150, 11, 257, 22);
		contentPane.add(lblCadastroDePizza);

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSabor.setBounds(27, 110, 58, 18);
		contentPane.add(lblSabor);

<<<<<<< HEAD
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 111, 139, 20);
		contentPane.add(textField_1);
||||||| merged common ancestors
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(27, 146, 69, 22);
		contentPane.add(lblValor);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 111, 139, 20);
		contentPane.add(textField_1);
=======
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(27, 146, 69, 22);
		contentPane.add(lblValor);

		textSabor = new JTextField();
		textSabor.setColumns(10);
		textSabor.setBounds(84, 111, 139, 20);
		contentPane.add(textSabor);
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c

<<<<<<< HEAD
		JButton btnCadastrar = new JButton("Cadastrar");
||||||| merged common ancestors
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(84, 149, 139, 20);
		contentPane.add(textField_2);

		JButton btnCadastrar = new JButton("CADASTRAR");
=======
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(84, 149, 139, 20);
		contentPane.add(textValor);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pizza.setSabor(textSabor.getText());
				pizza.setValor(Float.parseFloat(textValor.getText()));
				try {
					Fachada.getInstance().cadastrarProduto(pizza);
					JOptionPane.showMessageDialog(null, "Pizza adicionada ao repositorio com sucesso");
					textSabor.setText("");
					textValor.setText("");
				} catch (IdProdutoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(128, 207, 112, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarParaMenu.setBounds(266, 207, 141, 23);
		contentPane.add(btnVoltarParaMenu);
	}
}
