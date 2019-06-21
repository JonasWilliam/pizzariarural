package gui.funcionarios;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;
import negocios.Produto;

public class TelaListarFuncionarios extends JFrame {

	private JPanel contentPane;
	private static JFrame telaListarFuncionarioinstance;

	public static JFrame getInstance() {
		if (TelaListarFuncionarios.telaListarFuncionarioinstance == null)
			TelaListarFuncionarios.telaListarFuncionarioinstance = new TelaListarFuncionarios();

		return TelaListarFuncionarios.telaListarFuncionarioinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarFuncionarios frame = new TelaListarFuncionarios();
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
	public TelaListarFuncionarios() {
		setTitle("Listar Funcionários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 414, 150);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		JLabel lblListarFuncionrios = new JLabel("Listar Funcion\u00E1rios");
		lblListarFuncionrios.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListarFuncionrios.setBounds(84, 11, 295, 28);
		contentPane.add(lblListarFuncionrios);

		JButton btnListarTodos = new JButton("Listar");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Funcionario[] funcionarios = Fachada.getInstance().listarFuncionario();

				for (int i = 0; i < funcionarios.length; i++) {
					if (funcionarios[i] != null) {
						// cpfFuncionarios.add(funcionarios[i]);
						textArea.append(funcionarios[i].toString());
					}

				}

			}
		});
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarTodos.setBounds(10, 296, 102, 23);
		contentPane.add(btnListarTodos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(231, 297, 79, 23);
		contentPane.add(btnVoltar);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(154, 297, 79, 23);
		contentPane.add(btnReset);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFechar.setBounds(335, 297, 89, 23);
		contentPane.add(btnFechar);

	}
}
