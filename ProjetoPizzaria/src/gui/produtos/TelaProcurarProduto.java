package gui.produtos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProcurarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JFrame telaProcurarProdutoinstance;

	public static JFrame getInstance() {
		if (TelaProcurarProduto.telaProcurarProdutoinstance == null)
			TelaProcurarProduto.telaProcurarProdutoinstance = new TelaProcurarProduto();

		return TelaProcurarProduto.telaProcurarProdutoinstance;

	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcurarProduto frame = new TelaProcurarProduto();
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
	public TelaProcurarProduto() {
		setTitle("Procurar um Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 424, 0);
		contentPane.add(label);
		
		JLabel lblProcurarUmProduto = new JLabel("Procurar um Produto");
		lblProcurarUmProduto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProcurarUmProduto.setBounds(75, 11, 303, 31);
		contentPane.add(lblProcurarUmProduto);
		
		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCdigo.setBounds(37, 102, 164, 31);
		contentPane.add(lblInformeOCdigo);
		
		textField = new JTextField();
		textField.setBounds(219, 106, 186, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.setBounds(66, 186, 130, 23);
		contentPane.add(btnProcurar);
		
		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarParaMenu.setBounds(254, 185, 120, 24);
		contentPane.add(btnVoltarParaMenu);
	}
}
