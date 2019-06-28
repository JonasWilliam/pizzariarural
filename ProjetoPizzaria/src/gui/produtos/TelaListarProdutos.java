package gui.produtos;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Produto;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Color;

public class TelaListarProdutos extends JFrame {

	private JPanel contentPane;
	private static JFrame telaListarProdutosinstance;

	public static JFrame getInstance() {
		if (TelaListarProdutos.telaListarProdutosinstance == null)
			TelaListarProdutos.telaListarProdutosinstance = new TelaListarProdutos();

		return TelaListarProdutos.telaListarProdutosinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarProdutos frame = new TelaListarProdutos();
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
	public TelaListarProdutos() {
		setTitle("Listar Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(250, 235, 215));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 434, 181);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		

		JLabel lblListarProdutos = new JLabel("Listar Produtos");
		lblListarProdutos.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListarProdutos.setBounds(108, 11, 205, 32);
		contentPane.add(lblListarProdutos);

		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.setBackground(Color.GREEN);
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Produto[] produto = Fachada.getInstance().listarProdutos();
				//ArrayList<Produto> nomeProdutos = new ArrayList<Produto>();
				for (int i = 0; i < produto.length; i++) {
					if(produto[i] != null) {
						textArea.append(produto[i].toString());	
					}
					

				}
				
			}
		});
		btnListarTodos.setBounds(24, 260, 136, 25);
		contentPane.add(btnListarTodos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.YELLOW);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);

			}
		});
		btnVoltar.setBounds(269, 260, 76, 25);
		contentPane.add(btnVoltar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(170, 261, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(Color.RED);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFechar.setBounds(355, 262, 89, 23);
		contentPane.add(btnFechar);
	}
}
