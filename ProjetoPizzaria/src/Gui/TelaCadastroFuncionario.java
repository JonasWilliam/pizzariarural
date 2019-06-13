package Gui;

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

import Dados.RepositorioFuncionarioArray;
import Exception.CpfInvalidoException;
import Negocios.Fachada;
import Negocios.Funcionario;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textnome;
	private JTextField textsalario;
	private JTextField textcpf;
	private JTextField textlogin;
	private JTextField textsenha;
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
		setTitle("Cadastro Funcion√°rios");
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
		

		
		
		JLabel lblCpf = new JLabel("CPF :");

		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(10, 146, 57, 24);
		contentPane.add(lblCpf);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(219, 87, 65, 19);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(219, 119, 65, 14);
		contentPane.add(lblSenha);
		
		textnome = new JTextField();
		textnome.setBounds(70, 88, 139, 20);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		textsalario = new JTextField();
		textsalario.setColumns(10);
		textsalario.setBounds(70, 118, 139, 20);
		contentPane.add(textsalario);
		
		textcpf = new JTextField();
		textcpf.setColumns(10);
		textcpf.setBounds(70, 144, 169, 20);
		contentPane.add(textcpf);
		
		textlogin = new JTextField();
		textlogin.setColumns(10);
		textlogin.setBounds(271, 88, 169, 20);
		contentPane.add(textlogin);
		
		textsenha = new JTextField();
		textsenha.setColumns(10);
		textsenha.setBounds(271, 118, 169, 20);
		contentPane.add(textsenha);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(textnome.getText());
				funcionario.setSalario(Float.parseFloat(textsalario.getText()));
				funcionario.setLogin(textlogin.getText());
				funcionario.setCpf(textcpf.getText());
				funcionario.setSenha(textsenha.getText());
				RepositorioFuncionarioArray.getInstance().adicionar(funcionario);
				JOptionPane.showMessageDialog(null, "Funcion·rio adicionado ao repositorio com sucesso");
				/*
				try {
					//Fachada.getInstance().adicionar(funcionario);
					RepositorioFuncionarioArray.getInstance().adicionar(funcionario);
					JOptionPane.showMessageDialog(null, "Funcion·rio adicionado ao repositorio com sucesso");
				} catch (CpfInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
//				Fachada.getInstance().cadastrar(conta);
				RepositorioContasArray.getInstance().inserir(conta);
				JOptionPane.showMessageDialog(null, "Conta adicionada ao reposit√≥rio com sucesso");*/
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(91, 208, 108, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltarParaMenu = new JButton("Voltar para Menu");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltarParaMenu.setBounds(236, 208, 151, 23);
		contentPane.add(btnVoltarParaMenu);
	}
}
