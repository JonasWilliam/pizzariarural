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
import java.awt.Color;

public class TelaRemocaoPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textcdg;
	private static JFrame telaRemocaoFuncionarioinstance;

	public static JFrame getInstance() {
		if (TelaRemocaoPedido.telaRemocaoFuncionarioinstance == null)
			TelaRemocaoPedido.telaRemocaoFuncionarioinstance = new TelaRemocaoPedido();

		return TelaRemocaoPedido.telaRemocaoFuncionarioinstance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemocaoPedido frame = new TelaRemocaoPedido();
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
	public TelaRemocaoPedido() {
		setTitle("Cancelar Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(250, 235, 215));

		JLabel lblCancelarPedido = new JLabel("Cancelar Pedido");
		lblCancelarPedido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCancelarPedido.setBounds(114, 11, 204, 29);
		contentPane.add(lblCancelarPedido);

		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeOCdigo.setBounds(29, 80, 132, 29);
		contentPane.add(lblInformeOCdigo);

		textcdg = new JTextField();
		textcdg.setBounds(179, 85, 188, 24);
		contentPane.add(textcdg);
		textcdg.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textcdg.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o Id do Pedido que deseja remover");
				} else {
					Pedido a = new Pedido();
					a = Fachada.getInstance().procurarPedido(Integer.parseInt(textcdg.getText()));
					if (a == null) {
						JOptionPane.showMessageDialog(null, "Não existe nenhum Pedido com esse Id");
					} else {
						Fachada.getInstance().removerPedido(Integer.parseInt(textcdg.getText()));
						JOptionPane.showMessageDialog(null, "Pedido removido com sucesso");
						telaRemocaoFuncionarioinstance = null;
						dispose();
						TelaPrincipal.getInstance().setVisible(true);
					}
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(76, 141, 118, 23);
		contentPane.add(btnCancelar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.YELLOW);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(239, 141, 97, 23);
		contentPane.add(btnVoltar);

	}

}
