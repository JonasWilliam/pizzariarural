package gui.funcionarios;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaAlterarSenhaFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textsenha;
	private static JFrame telaTelaAlterarSenhaFuncionarioinstance;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textcpf;

	public static JFrame getInstance() {
		if (TelaAlterarSenhaFuncionario.telaTelaAlterarSenhaFuncionarioinstance == null)
			TelaAlterarSenhaFuncionario.telaTelaAlterarSenhaFuncionarioinstance = new TelaAlterarSenhaFuncionario();

		return TelaAlterarSenhaFuncionario.telaTelaAlterarSenhaFuncionarioinstance;

	}
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarSenhaFuncionario frame = new TelaAlterarSenhaFuncionario();
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
	public TelaAlterarSenhaFuncionario() {
		getContentPane().setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(155, 90, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnTeste = new JButton("teste");
		btnTeste.setBounds(123, 183, 89, 23);
		getContentPane().add(btnTeste);
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 52, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAtt = new JButton("ATT");
		btnAtt.setBounds(114, 147, 89, 23);
		getContentPane().add(btnAtt);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarSenha = new JLabel("Alterar Senha");
		lblAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlterarSenha.setBounds(150, 11, 202, 41);
		contentPane.add(lblAlterarSenha);
		
		JLabel lblInformeANova = new JLabel("nova senha:");
		lblInformeANova.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeANova.setBounds(46, 118, 86, 28);
		contentPane.add(lblInformeANova);
		
		textsenha = new JTextField();
		textsenha.setBounds(142, 123, 105, 20);
		contentPane.add(textsenha);
		textsenha.setColumns(10);
		
		JButton btnTeste_1 = new JButton("ALTERAR");
		btnTeste_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTeste_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().alterarSenha(textsenha.getText(),textcpf.getText());
			}
		});
		btnTeste_1.setBounds(105, 186, 93, 23);
		contentPane.add(btnTeste_1);
		
		textcpf = new JTextField();
		textcpf.setBounds(88, 87, 142, 20);
		contentPane.add(textcpf);
		textcpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:\r\n");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(46, 93, 46, 14);
		contentPane.add(lblCpf);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(218, 187, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
