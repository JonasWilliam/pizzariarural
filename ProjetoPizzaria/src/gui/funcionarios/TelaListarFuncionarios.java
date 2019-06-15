package gui.funcionarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TelaListarFuncionarios extends JFrame {

	private JPanel contentPane;
	private static JFrame telaListarFuncionarioinstance;
	private JTable textArea;

	
	
	
	
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
		setTitle("Listar Funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTable();
		textArea.setBounds(12, 63, 426, 213);
		contentPane.add(textArea);
		
		JLabel lblListarFuncionrios = new JLabel("Listar Funcion\u00E1rios");
		lblListarFuncionrios.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListarFuncionrios.setBounds(84, 11, 295, 28);
		contentPane.add(lblListarFuncionrios);
		
<<<<<<< HEAD
		JButton btnListarTodos = new JButton("Listar");
||||||| merged common ancestors
		JButton btnListarTodos = new JButton("Listar TODOS");
=======
		JButton btnListarTodos = new JButton("Listar TODOS");
	
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
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