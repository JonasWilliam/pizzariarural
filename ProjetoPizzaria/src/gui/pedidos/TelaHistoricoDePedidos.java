package gui.pedidos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Pedido;
import java.awt.Color;
import javax.swing.JTable;

public class TelaHistoricoDePedidos extends JFrame {

	private JPanel contentPane;
	private static JFrame telaListarPedidoinstance;
	private JTable table;
	PedidosTableModel modelo = new PedidosTableModel();

	public static JFrame getInstance() {
		if (TelaHistoricoDePedidos.telaListarPedidoinstance == null)
			TelaHistoricoDePedidos.telaListarPedidoinstance = new TelaHistoricoDePedidos();

		return TelaHistoricoDePedidos.telaListarPedidoinstance;

	}
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistoricoDePedidos frame = new TelaHistoricoDePedidos();
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
	public TelaHistoricoDePedidos() {
		setFont(new Font("Dialog", Font.PLAIN, 99));
		setTitle("Listar Pedidos Fechados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(250, 235, 215));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 414, 173);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(235, 291, 135, 23);
		contentPane.add(btnVoltar);
		
		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.setBackground(Color.GREEN);
		btnListarTodos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				Pedido[] pedidos = Fachada.getInstance().listarPedidos();
				for (int i = 0; i < pedidos.length; i++) {
					if (pedidos[i] != null && pedidos[i].getStatus() == false) {
						modelo.addRow(pedidos[i]);
					}
				}
			}
		});
		btnListarTodos.setBounds(62, 292, 135, 23);
		contentPane.add(btnListarTodos);
		
		JLabel lblHistricoDePedidos = new JLabel("Hist\u00F3rico de Pedidos");
		lblHistricoDePedidos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHistricoDePedidos.setBounds(75, 11, 295, 36);
		contentPane.add(lblHistricoDePedidos);
	}
}
