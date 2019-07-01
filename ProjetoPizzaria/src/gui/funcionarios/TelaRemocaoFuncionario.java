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

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;
import java.awt.Color;

public class TelaRemocaoFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textcpf;
	private static JFrame telaRemocaoFuncionarioinstance;

	public static JFrame getInstance() {
		if (TelaRemocaoFuncionario.telaRemocaoFuncionarioinstance == null)
			TelaRemocaoFuncionario.telaRemocaoFuncionarioinstance = new TelaRemocaoFuncionario();

		return TelaRemocaoFuncionario.telaRemocaoFuncionarioinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemocaoFuncionario frame = new TelaRemocaoFuncionario();
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
	public TelaRemocaoFuncionario() {
		setTitle("Remover de Funcion�rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblReoverDeFuncionrio = new JLabel("Remo\u00E7\u00E3o de Funcion\u00E1rio");
		lblReoverDeFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReoverDeFuncionrio.setBounds(61, 11, 363, 29);
		contentPane.add(lblReoverDeFuncionrio);

		JLabel lblInformeOCpf = new JLabel("Informe o CPF:");
		lblInformeOCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCpf.setBounds(26, 85, 125, 29);
		contentPane.add(lblInformeOCpf);

		textcpf = new JTextField();
		textcpf.setBounds(161, 91, 244, 23);
		contentPane.add(textcpf);
		textcpf.setColumns(10);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(Color.RED);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textcpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o cpf do funcion�rio que deseja remover");
				} else {
					Funcionario a = new Funcionario();
					a = Fachada.getInstance().procurarFuncionario(textcpf.getText());
					if (a == null) {
						JOptionPane.showMessageDialog(null, "N�o existe nenhum funcion�rio com esse cpf");
					} else {
						Fachada.getInstance().removerFuncionario(textcpf.getText());
						JOptionPane.showMessageDialog(null, "Funcion�rio removido com sucesso");
						textcpf.setText("");
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemover.setBounds(26, 157, 125, 29);
		contentPane.add(btnRemover);

		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.setBackground(Color.YELLOW);
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarParaMenu.setBounds(300, 158, 105, 29);
		contentPane.add(btnVoltarParaMenu);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.setBackground(Color.GREEN);
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarFuncionarios.getInstance().setVisible(true);
			}
		});
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarTodos.setBounds(161, 157, 116, 28);
		contentPane.add(btnListarTodos);
	}

}
