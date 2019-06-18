package gui.pedidos;

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
import negocios.Pedido;

public class TelaAlterarStatusPedido extends JFrame {

	private JPanel contentPane;
	private static JFrame TelaAlterarStatusPedidoinstance;
	private JTextField textid;
	Pedido pedido;

	public static JFrame getInstance() {
		if (TelaAlterarStatusPedido.TelaAlterarStatusPedidoinstance == null)
			TelaAlterarStatusPedido.TelaAlterarStatusPedidoinstance = new TelaAlterarStatusPedido();

		return TelaAlterarStatusPedido.TelaAlterarStatusPedidoinstance;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarStatusPedido frame = new TelaAlterarStatusPedido();
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
	public TelaAlterarStatusPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarStatus = new JLabel("Alterar Status Pedido");
		lblAlterarStatus.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAlterarStatus.setBounds(64, 11, 328, 26);
		contentPane.add(lblAlterarStatus);
		
		JLabel lblInformeOId = new JLabel("Informe o Id do pedido:");
		lblInformeOId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOId.setBounds(34, 104, 213, 26);
		contentPane.add(lblInformeOId);
		
		textid = new JTextField();
		textid.setBounds(257, 109, 135, 20);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.getInstance().alterarStatus(Integer.parseInt(textid.getText()));
				JOptionPane.showMessageDialog(null, "Status alterado com sucesso");
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(91, 161, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaProcurarPedido.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(203, 162, 89, 23);
		contentPane.add(btnVoltar);
	}
}
