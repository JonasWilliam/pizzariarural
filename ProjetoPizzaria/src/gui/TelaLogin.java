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

import negocios.Fachada;
import negocios.Funcionario;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtSenha;

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
		setBounds(100, 100, 430, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPizzariaRural = new JLabel("\t\t            Pizzaria Rural");
		lblPizzariaRural.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblPizzariaRural.setBounds(10, 11, 414, 60);
		contentPane.add(lblPizzariaRural);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCpf.setBounds(50, 129, 81, 36);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(136, 139, 139, 26);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setBounds(50, 190, 81, 26);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(136, 192, 139, 26);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if(txtCpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o cpf do funcionario.");
				}else if(txtCpf.getText().equals("admin") && txtSenha.getText().equals("admin")) {
					setVisible(false);
					TelaPrincipal.getInstance().setVisible(true);
				}else {

					Funcionario achouFuncionario = Fachada.getInstance().procurarFuncionario(txtCpf.getText());
					 if(achouFuncionario == null){
						 JOptionPane.showMessageDialog(null, "Funcionário não existe.");
					 }else{
						 if(achouFuncionario.getCpf().equals(txtCpf.getText()) && achouFuncionario.getSenha().equals(txtSenha.getText())) {
							 TelaPrincipal.getInstance().setVisible(true);
							 setVisible(false);
						 }
						 
					 }
					 
				}
				
				
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(164, 253, 111, 23);
		contentPane.add(btnEntrar);
	}
}
