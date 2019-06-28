package gui;

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
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private static JFrame telaPrincipalinstance;

	public static JFrame getInstance() {
		if (TelaPrincipal.telaPrincipalinstance == null)
			TelaPrincipal.telaPrincipalinstance = new TelaPrincipal();

		return TelaPrincipal.telaPrincipalinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenuProdutos = new JMenu("Produtos");
		mnNewMenuProdutos.setBackground(Color.LIGHT_GRAY);
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
		mnNewMenuPedidos.setBackground(Color.LIGHT_GRAY);
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

		JMenu mnNewFuncionarios = new JMenu("Funcion\u00E1rios\r\n");
		mnNewFuncionarios.setBackground(Color.LIGHT_GRAY);
		mnNewFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(mnNewFuncionarios);

		JMenuItem mntmAdicionar = new JMenuItem("Adicionar");
		mntmAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroFuncionario.getInstance().setVisible(true);
			}
		});
		mnNewFuncionarios.add(mntmAdicionar);

		JMenuItem mntmProcurar_2 = new JMenuItem("Procurar");
		mntmProcurar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaProcurarFuncionarios.getInstance().setVisible(true);
			}
		});
		mnNewFuncionarios.add(mntmProcurar_2);

		JMenuItem mntmListarFuncionrios = new JMenuItem("Listar Funcion\u00E1rios");
		mntmListarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListarFuncionarios.getInstance().setVisible(true);
			}
		});
		mnNewFuncionarios.add(mntmListarFuncionrios);

		JMenuItem mntmAlterarSenha = new JMenuItem("Alterar Senha");
		mntmAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAlterarSenhaFuncionario.getInstance().setVisible(true);
			}
		});
		mnNewFuncionarios.add(mntmAlterarSenha);

		JMenuItem mntmRemover_1 = new JMenuItem("Remover");
		mntmRemover_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaRemocaoFuncionario.getInstance().setVisible(true);
			}
		});
		mnNewFuncionarios.add(mntmRemover_1);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setBackground(Color.RED);
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
