package gui.funcionarios;

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

import dados.RepositorioFuncionarioArray;
import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;
import negocios.exception.CpfInvalidoException;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textnome;
	private JTextField textsalario;
	private JTextField textcpf;
	private JTextField textsenha;
	private static JFrame telaCadastroFuncionarioinstance;
	Funcionario funcionario = new Funcionario();
	
	

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
		setTitle("Cadastro Funcionários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 300);
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
		lblSalrio.setBounds(10, 120, 73, 14);
		contentPane.add(lblSalrio);
		

		
		
		JLabel lblCpf = new JLabel("CPF :");

		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(212, 115, 57, 24);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(10, 145, 65, 14);
		contentPane.add(lblSenha);
		
		textnome = new JTextField();
		textnome.setBounds(70, 88, 356, 20);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		textsalario = new JTextField();
		textsalario.setColumns(10);
		textsalario.setBounds(70, 117, 124, 20);
		contentPane.add(textsalario);
		
		textcpf = new JTextField();
		textcpf.setColumns(10);
		textcpf.setBounds(264, 118, 164, 20);
		contentPane.add(textcpf);
		
		textsenha = new JTextField();
		textsenha.setColumns(10);
		textsenha.setBounds(70, 145, 163, 20);
		contentPane.add(textsenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*funcionario.setNome(textnome.getText());
				funcionario.setSalario(Float.parseFloat(textsalario.getText()));
				funcionario.setCpf(textcpf.getText());
				funcionario.setSenha(textsenha.getText());*/
				funcionario = new Funcionario(textnome.getText(),Float.parseFloat(textsalario.getText()),textsenha.getText(),textcpf.getText());
				try {
					Fachada.getInstance().adicionar(funcionario);
					//RepositorioFuncionarioArray.getInstance().salvarArquivo();
					JOptionPane.showMessageDialog(null, "Funcion�rio adicionado ao repositorio com sucesso");
					textnome.setText("");
					textsalario.setText("");
					textsenha.setText("");
					textcpf.setText("");
					dispose();
					TelaPrincipal.getInstance().setVisible(true);
				} catch (CpfInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*
				try {
					//Fachada.getInstance().adicionar(funcionario);
					RepositorioFuncionarioArray.getInstance().adicionar(funcionario);
					JOptionPane.showMessageDialog(null, "Funcion�rio adicionado ao repositorio com sucesso");
				} catch (CpfInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
//				Fachada.getInstance().cadastrar(conta);
				RepositorioContasArray.getInstance().inserir(conta);
				JOptionPane.showMessageDialog(null, "Conta adicionada ao repositório com sucesso");*/
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(21, 209, 108, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltarParaMenu.setBounds(299, 208, 108, 24);
		contentPane.add(btnVoltarParaMenu);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textnome.setText("");
				textsalario.setText("");
				textsenha.setText("");
				textcpf.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(161, 209, 108, 23);
		contentPane.add(btnReset);
	}
}
