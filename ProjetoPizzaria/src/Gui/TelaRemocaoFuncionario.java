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

public class TelaRemocaoFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReoverDeFuncionrio = new JLabel("Remo\u00E7\u00E3o de Funcion\u00E1rio");
		lblReoverDeFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReoverDeFuncionrio.setBounds(61, 11, 363, 29);
		contentPane.add(lblReoverDeFuncionrio);
		
		JLabel lblInformeOCpf = new JLabel("Informe o Cpf:");
		lblInformeOCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCpf.setBounds(26, 85, 125, 29);
		contentPane.add(lblInformeOCpf);
		
		textField = new JTextField();
		textField.setBounds(161, 91, 244, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemover.setBounds(161, 156, 125, 29);
		contentPane.add(btnRemover);
	}

}
