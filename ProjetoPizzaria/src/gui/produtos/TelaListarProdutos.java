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

public class TelaListarProdutos extends JFrame {

	private JPanel contentPane;
	private static JFrame telaListarProdutosinstance;
	private JTable table;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 414, 150);
		contentPane.add(scrollPane);

		TextArea textArea = new TextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblListarProdutos = new JLabel("Listar Produtos");
		lblListarProdutos.setBounds(165, 28, 66, 15);
		contentPane.add(lblListarProdutos);

		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Produto[] produto = Fachada.getInstance().listarProdutos();
				ArrayList<Produto> nomeProdutos = new ArrayList<Produto>();
				for (int i = 0; i < produto.length; i++) {
					if (produto[i] != null) {
						nomeProdutos.add(produto[i]);
					}

				}
				for (int i = 0; i < nomeProdutos.size(); i++) {
					textArea.append(nomeProdutos.get(i).toString());
				}
			}
		});
		btnListarTodos.setBounds(22, 247, 146, 25);
		contentPane.add(btnListarTodos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);

			}
		});
		btnVoltar.setBounds(221, 247, 114, 25);
		contentPane.add(btnVoltar);
		
		table = new JTable();
		table.setBounds(63, 52, 291, 15);
		contentPane.add(table);
	}
}
