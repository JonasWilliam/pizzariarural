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

public class TelaRemocaoProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JFrame telaRemocaoProdutoinstance;

	public static JFrame getInstance() {
		if (TelaRemocaoProduto.telaRemocaoProdutoinstance == null)
			TelaRemocaoProduto.telaRemocaoProdutoinstance = new TelaRemocaoProduto();

		return TelaRemocaoProduto.telaRemocaoProdutoinstance;

	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemocaoProduto frame = new TelaRemocaoProduto();
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
	public TelaRemocaoProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemooProduto = new JLabel("Remo\u00E7\u00E3o Produto");
		lblRemooProduto.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRemooProduto.setBounds(104, 11, 243, 34);
		contentPane.add(lblRemooProduto);

		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCdigo.setBounds(27, 86, 147, 34);
		contentPane.add(lblInformeOCdigo);

		textField = new JTextField();
		textField.setBounds(166, 93, 163, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemover.setBounds(161, 156, 125, 29);
		contentPane.add(btnRemover);
	}

}
