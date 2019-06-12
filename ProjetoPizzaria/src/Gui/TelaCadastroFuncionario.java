package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static JFrame telaCadastroFuncionarioinstance;

	public static JFrame getInstance() {
		if (TelaCadastroFuncionario.telaCadastroFuncionarioinstance == null)
			TelaCadastroFuncionario.telaCadastroFuncionarioinstance = new TelaCadastroFuncionario();

		return TelaCadastroFuncionario.telaCadastroFuncionarioinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroFuncionrios = new JLabel("Cadastro Funcion\u00E1rios");
		lblCadastroFuncionrios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroFuncionrios.setBounds(140, 11, 247, 32);
		contentPane.add(lblCadastroFuncionrios);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 84, 73, 24);
		contentPane.add(lblNome);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalrio.setBounds(10, 119, 73, 14);
		contentPane.add(lblSalrio);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCargo.setBounds(10, 144, 57, 24);
		contentPane.add(lblCargo);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(219, 91, 57, 24);
		contentPane.add(lblCpf);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(219, 121, 65, 19);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(219, 151, 65, 14);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(70, 88, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(70, 118, 139, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(70, 144, 139, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(271, 88, 169, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(271, 118, 169, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(271, 148, 169, 20);
		contentPane.add(textField_5);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(91, 208, 108, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltarParaMenu = new JButton("Voltar para Menu");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltarParaMenu.setBounds(236, 208, 151, 23);
		contentPane.add(btnVoltarParaMenu);
	}
}
