package gui;

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

import gui.funcionarios.TelaCadastroFuncionario;
import negocios.Fachada;
import negocios.Funcionario;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private static JFrame telaLogininstance;
	private JPasswordField txtSenha;

	public static JFrame getInstance() {
		if (TelaLogin.telaLogininstance == null)
			TelaLogin.telaLogininstance = new TelaLogin();

		return TelaLogin.telaLogininstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("Pizzaria Rural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPizzariaRural = new JLabel("Pizzaria Rural");
		lblPizzariaRural.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblPizzariaRural.setBounds(61, 11, 214, 36);
		contentPane.add(lblPizzariaRural);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCpf.setBounds(50, 105, 81, 36);
		contentPane.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setBounds(110, 112, 176, 26);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(50, 152, 51, 26);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtCpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o cpf do funcionario.");
				} else {

					Funcionario achouFuncionario = Fachada.getInstance().procurarFuncionario(txtCpf.getText());
					Funcionario[] listaFuncionario = Fachada.getInstance().listarFuncionario();
					if (achouFuncionario == null) {

					
							JOptionPane.showMessageDialog(null, "Funcionário não existe.");
						
					} else {
						if (achouFuncionario.getCpf().equals(txtCpf.getText())
								&& achouFuncionario.getSenha().equals(txtSenha.getText())
								&& achouFuncionario.getCargo().toString().equals(("Gerente"))) {

							TelaPrincipal.getInstance().setVisible(true);
							setVisible(false);

						} else if (achouFuncionario.getCargo().toString().equals("Vendedor")) {
							TelaPrincipalVendedor.getInstance().setVisible(true);
							setVisible(false);
						}
					}

				}

			}

		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(10, 210, 100, 23);
		contentPane.add(btnEntrar);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSenha.setText("");
				txtCpf.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(248, 209, 94, 25);
		contentPane.add(btnReset);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(110, 152, 176, 26);
		contentPane.add(txtSenha);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario.getInstance().setVisible(true);
				dispose();
			}
		});
		btnCadastro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastro.setBounds(120, 212, 118, 23);
		contentPane.add(btnCadastro);
	}
}
