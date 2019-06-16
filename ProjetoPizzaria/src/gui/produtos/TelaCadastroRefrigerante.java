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
import negocios.Refrigerante;
import negocios.Tamanho;
import negocios.exception.IdProdutoException;
import javax.swing.JComboBox;

public class TelaCadastroRefrigerante extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private static JFrame telaCadastroRefrigeranteinstance;
	Refrigerante refrigerante = new Refrigerante();
	private JTextField textField;
	private JTextField textField_1;

	public static JFrame getInstance() {
		if (TelaCadastroRefrigerante.telaCadastroRefrigeranteinstance == null)
			TelaCadastroRefrigerante.telaCadastroRefrigeranteinstance = new TelaCadastroRefrigerante();

		return TelaCadastroRefrigerante.telaCadastroRefrigeranteinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroRefrigerante frame = new TelaCadastroRefrigerante();
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
	public TelaCadastroRefrigerante() {
		setTitle("Cadastro de Refrigerante");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDePizza = new JLabel("Cadastro de Refrigerante\r\n");
		lblCadastroDePizza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDePizza.setBounds(48, 11, 257, 22);
		contentPane.add(lblCadastroDePizza);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(27, 74, 58, 15);
		contentPane.add(lblNome);

		JButton btnCadastrarRefrigerante = new JButton("Cadastrar");
		btnCadastrarRefrigerante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refrigerante.setNome(textNome.getText());
				try {
					Fachada.getInstance().cadastrarProduto(refrigerante);
					JOptionPane.showMessageDialog(null, "Refrigerante adicionado ao repositorio com sucesso");
					textNome.setText("");
				} catch (IdProdutoException eId) {
					eId.printStackTrace();
				}

			}

		});
		btnCadastrarRefrigerante.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarRefrigerante.setBounds(48, 289, 112, 23);
		contentPane.add(btnCadastrarRefrigerante);

		textNome = new JTextField();
		textNome.setBounds(100, 72, 176, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarParaMenu.setBounds(170, 289, 134, 23);
		contentPane.add(btnVoltarParaMenu);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(27, 119, 72, 22);
		contentPane.add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(100, 122, 176, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigo.setBounds(27, 170, 58, 22);
		contentPane.add(lblCdigo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 173, 176, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox(Tamanho.values());
		comboBox.setBounds(100, 220, 46, 22);
		contentPane.add(comboBox);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTamanho.setBounds(27, 221, 72, 19);
		contentPane.add(lblTamanho);
	}
}
