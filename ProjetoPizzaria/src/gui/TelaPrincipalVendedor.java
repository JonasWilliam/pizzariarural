package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.funcionarios.TelaAlterarSenhaFuncionario;
import gui.funcionarios.TelaCadastroFuncionario;
import gui.funcionarios.TelaListarFuncionarios;
import gui.funcionarios.TelaProcurarFuncionarios;
import gui.funcionarios.TelaRemocaoFuncionario;
import gui.pedidos.TelaCadastrarPedido;
import gui.pedidos.TelaListarPedidosAberto;
import gui.pedidos.TelaListarTodosPedido;
import gui.pedidos.TelaProcurarPedido;
import gui.pedidos.TelaRemocaoPedido;
import gui.produtos.TelaCadastroPizza;
import gui.produtos.TelaCadastroRefrigerante;
import gui.produtos.TelaListarProdutos;
import gui.produtos.TelaProcurarProduto;
import gui.produtos.TelaRemocaoProduto;
import java.awt.Color;

public class TelaPrincipalVendedor extends JFrame {

	private JPanel contentPane;
	private static JFrame telaPrincipalVendedorinstance;

	public static JFrame getInstance() {
		if (TelaPrincipalVendedor.telaPrincipalVendedorinstance == null)
			TelaPrincipalVendedor.telaPrincipalVendedorinstance = new TelaPrincipalVendedor();

		return TelaPrincipalVendedor.telaPrincipalVendedorinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalVendedor frame = new TelaPrincipalVendedor();
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
	public TelaPrincipalVendedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenuProdutos = new JMenu("Produtos");
		mnNewMenuProdutos.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(mnNewMenuProdutos);

		JMenuItem mntmInserirPizza = new JMenuItem("Inserir Pizza");
		mntmInserirPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroPizza.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmInserirPizza);

		JMenuItem mntmInserirRefrigerante = new JMenuItem("Inserir Refrigerante");
		mntmInserirRefrigerante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroRefrigerante.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmInserirRefrigerante);

		JMenuItem mntmProcurar = new JMenuItem("Procurar");
		mntmProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaProcurarProduto.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmProcurar);

		JMenuItem mntmListarTodos = new JMenuItem("Listar Todos");
		mntmListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListarProdutos.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmListarTodos);

		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaRemocaoProduto.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmRemover);

		JMenu mnNewMenuPedidos = new JMenu("Pedidos");
		mnNewMenuPedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(mnNewMenuPedidos);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastrarPedido.getInstance().setVisible(true);
			}
		});
		mnNewMenuPedidos.add(mntmCadastrar);

		JMenuItem mntmProcurar_1 = new JMenuItem("Procurar");
		mntmProcurar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaProcurarPedido.getInstance().setVisible(true);
			}
		});
		
		JMenuItem mntmListarPedidosEm = new JMenuItem("Listar Pedidos em Aberto");
		mntmListarPedidosEm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListarPedidosAberto.getInstance().setVisible(true);
			}
		});
		mnNewMenuPedidos.add(mntmListarPedidosEm);
		mnNewMenuPedidos.add(mntmProcurar_1);

		JMenuItem mntmListarPedidos = new JMenuItem("Listar Todos Pedidos");
		mntmListarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListarTodosPedido.getInstance().setVisible(true);
			}
		});
		mnNewMenuPedidos.add(mntmListarPedidos);

		JMenuItem mntmCancelar = new JMenuItem("Cancelar");
		mntmCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaRemocaoPedido.getInstance().setVisible(true);
			}
		});
		mnNewMenuPedidos.add(mntmCancelar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaLogin.getInstance().setVisible(true);
			}
		});
		mntmSair.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
