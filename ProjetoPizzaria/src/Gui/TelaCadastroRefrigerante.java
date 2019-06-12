package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCadastroRefrigerante extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textSabor;
	private JTextField textValor;
	private JTextField textTamanho;
	private JTextField textCodigo;
	private JTextField textField;
	private static JFrame telaCadastroRefrigeranteinstance;

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
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 500, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblCadastroDePizza = new JLabel("Cadastro de Refrigerante\r\n");
			lblCadastroDePizza.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblCadastroDePizza.setBounds(125, 11, 257, 22);
			contentPane.add(lblCadastroDePizza);
			
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNome.setBounds(27, 74, 58, 15);
			contentPane.add(lblNome);
			
			JLabel lblSabor = new JLabel("Sabor:");
			lblSabor.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblSabor.setBounds(27, 110, 58, 18);
			contentPane.add(lblSabor);
			
			JLabel lblValor = new JLabel("Valor:");
			lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblValor.setBounds(27, 146, 69, 22);
			contentPane.add(lblValor);
			
			JLabel lblTamanho = new JLabel("Tamanho:");
			lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTamanho.setBounds(248, 74, 76, 22);
			contentPane.add(lblTamanho);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCdigo.setBounds(248, 110, 58, 23);
			contentPane.add(lblCdigo);
			
			
			
			JButton btnCadastrar = new JButton("CADASTRAR");
			btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCadastrar.setBounds(194, 206, 112, 23);
			contentPane.add(btnCadastrar);
			
			textNome = new JTextField();
			textNome.setBounds(80, 73, 139, 20);
			contentPane.add(textNome);
			textNome.setColumns(10);
			
			textSabor = new JTextField();
			textSabor.setColumns(10);
			textSabor.setBounds(80, 111, 139, 20);
			contentPane.add(textSabor);
			
			textValor = new JTextField();
			textValor.setColumns(10);
			textValor.setBounds(80, 149, 139, 20);
			contentPane.add(textValor);
			
			textTamanho = new JTextField();
			textTamanho.setColumns(10);
			textTamanho.setBounds(335, 73, 139, 20);
			contentPane.add(textTamanho);
			
			textCodigo = new JTextField();
			textCodigo.setColumns(10);
			textCodigo.setBounds(335, 111, 139, 20);
			contentPane.add(textCodigo);
			
			JLabel lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMarca.setBounds(248, 152, 76, 14);
			contentPane.add(lblMarca);
			
			textField = new JTextField();
			textField.setBounds(335, 149, 139, 20);
			contentPane.add(textField);
			textField.setColumns(10);
		}

}
