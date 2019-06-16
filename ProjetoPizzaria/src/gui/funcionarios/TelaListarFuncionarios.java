package gui.funcionarios;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;

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
		setTitle("Listar Funcion√°rio");
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

		JLabel lblListarFuncionrios = new JLabel("Listar Funcion\u00E1rios");
		lblListarFuncionrios.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListarFuncionrios.setBounds(84, 11, 295, 28);
		contentPane.add(lblListarFuncionrios);

		JButton btnListarTodos = new JButton("Listar");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Funcionario[] funcionarios = Fachada.getInstance().listarFuncionario();
				ArrayList<Funcionario> cpfFuncionarios = new ArrayList<Funcionario>();
				for (int i = 0; i < funcionarios.length; i++) {
					if (funcionarios[i] != null) {
						cpfFuncionarios.add(funcionarios[i]);
						// textArea.append(funcionarios[i].toString());
						// textArea.setText(funcionarios[i].toString());
						// textArea.setText(funcionarios[i].getCpf());
					}

				}
				for (int i = 0; i < cpfFuncionarios.size(); i++) {
					// textArea.setText("Lista de funcion·rios:");

					textArea.append(cpfFuncionarios.get(i).toString());
				}
			}
		});
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarTodos.setBounds(78, 296, 122, 23);
		contentPane.add(btnListarTodos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(228, 297, 89, 23);
		contentPane.add(btnVoltar);

	}
}
