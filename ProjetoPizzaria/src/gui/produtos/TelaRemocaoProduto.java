package gui.produtos;

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
import negocios.Produto;
import java.awt.Color;

public class TelaRemocaoProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
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
		setTitle("Remover Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setToolTipText("");
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

		textCodigo = new JTextField();
		textCodigo.setToolTipText("");
		textCodigo.setBounds(184, 91, 163, 25);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(Color.RED);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o Codigo do Produto que deseja remover");
					textCodigo.setText("");
				} else {
					Produto p = new Produto();
					p = Fachada.getInstance().procurarProduto(textCodigo.getText());
					if (p == null) {
						JOptionPane.showMessageDialog(null, "Nao existe nenhum Produto com esse codigo");
						textCodigo.setText("");
					} else {
						Fachada.getInstance().removerProduto(textCodigo.getText());
						JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
						textCodigo.setText("");
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemover.setBounds(27, 156, 125, 29);
		contentPane.add(btnRemover);
		
		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.setBackground(Color.YELLOW);
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltarParaMenu.setBounds(316, 157, 108, 29);
		contentPane.add(btnVoltarParaMenu);
		
		JButton btnListarProdutos = new JButton("Listar Produtos");
		btnListarProdutos.setBackground(Color.GREEN);
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarProdutos.getInstance().setVisible(true);
			}
		});
		btnListarProdutos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListarProdutos.setBounds(162, 161, 144, 23);
		contentPane.add(btnListarProdutos);
	}

}
