package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 340, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenuProdutos = new JMenu("Produtos");
		mnNewMenuProdutos.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(mnNewMenuProdutos);
		
		JMenuItem mntmInserirPizza = new JMenuItem("Inserir Pizza");
		mntmInserirPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPizza.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmInserirPizza);
		
		JMenuItem mntmInserirRefrigerante = new JMenuItem("Inserir Refrigerante");
		mntmInserirRefrigerante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroRefrigerante.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmInserirRefrigerante);
		
		JMenuItem mntmProcurar = new JMenuItem("Procurar");
		mnNewMenuProdutos.add(mntmProcurar);
		
		JMenuItem mntmListarTodos = new JMenuItem("Listar Todos");
		mnNewMenuProdutos.add(mntmListarTodos);
		
		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemocaoProduto.getInstance().setVisible(true);
			}
		});
		mnNewMenuProdutos.add(mntmRemover);
		
		JMenu mnNewMenuPedidos = new JMenu("Pedidos");
		mnNewMenuPedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(mnNewMenuPedidos);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnNewMenuPedidos.add(mntmCadastrar);
		
		JMenuItem mntmProcurar_1 = new JMenuItem("Procurar");
		mnNewMenuPedidos.add(mntmProcurar_1);
		
		JMenuItem mntmAlterarPedido = new JMenuItem("Add ao Pedido\r\n");
		mnNewMenuPedidos.add(mntmAlterarPedido);
		
		JMenuItem mntmRemoverItemDo = new JMenuItem("Remover item do Pedido");
		mnNewMenuPedidos.add(mntmRemoverItemDo);
		
		JMenuItem mntmListarPedidos = new JMenuItem("Listar Pedidos");
		mnNewMenuPedidos.add(mntmListarPedidos);
		
		JMenuItem mntmCancelar = new JMenuItem("Cancelar");
		mnNewMenuPedidos.add(mntmCancelar);
		
		JMenu mnNewFuncionarios = new JMenu("Funcion\u00E1rios\r\n");
		mnNewFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(mnNewFuncionarios);
		
		JMenuItem mntmAdicionar = new JMenuItem("Adicionar");
		mntmAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario.getInstance().setVisible(true);
			}
		});
		mnNewFuncionarios.add(mntmAdicionar);
		
		JMenuItem mntmProcurar_2 = new JMenuItem("Procurar");
		mnNewFuncionarios.add(mntmProcurar_2);
		
		JMenuItem mntmListarFuncionrios = new JMenuItem("Listar Funcion\u00E1rios");
		mnNewFuncionarios.add(mntmListarFuncionrios);
		
		JMenuItem mntmAlterarSenha = new JMenuItem("Alterar Senha");
		mnNewFuncionarios.add(mntmAlterarSenha);
		
		JMenuItem mntmRemover_1 = new JMenuItem("Remover");
		mnNewFuncionarios.add(mntmRemover_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
