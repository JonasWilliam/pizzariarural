package gui.produtos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;
import negocios.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 364, 150);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblProcurarUmProduto = new JLabel("Procurar um Produto");
		lblProcurarUmProduto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProcurarUmProduto.setBounds(10, 11, 303, 31);
		contentPane.add(lblProcurarUmProduto);
		
		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCdigo.setBounds(10, 58, 164, 31);
		contentPane.add(lblInformeOCdigo);
		
		textField = new JTextField();
		textField.setBounds(144, 65, 186, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("Dados: \n");
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o Nome do Produto.");
				}
					
				else {

					Produto achouProduto = Fachada.getInstance().procurarProduto(textField.getText());
					 if(achouProduto == null){
						 JOptionPane.showMessageDialog(null, "Produto n�o existe.");
					 }else{
						 JOptionPane.showMessageDialog(null, "Produto existe.");
						 textArea.append(achouProduto.toString());
					 }
					 
				}
				
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.setBounds(20, 261, 109, 23);
		contentPane.add(btnProcurar);
		
		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarParaMenu.setBounds(254, 261, 120, 24);
		contentPane.add(btnVoltarParaMenu);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textArea.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(144, 261, 89, 23);
		contentPane.add(btnReset);
	}
}
