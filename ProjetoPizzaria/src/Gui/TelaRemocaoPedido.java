package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemocaoPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCancelarPedido = new JLabel("Cancelar Pedido");
		lblCancelarPedido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCancelarPedido.setBounds(114, 11, 204, 29);
		contentPane.add(lblCancelarPedido);

		JLabel lblInformeOCdigo = new JLabel("Informe o c\u00F3digo:");
		lblInformeOCdigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeOCdigo.setBounds(29, 80, 110, 29);
		contentPane.add(lblInformeOCdigo);

		textField = new JTextField();
		textField.setBounds(179, 85, 188, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(81, 165, 110, 23);
		contentPane.add(btnCancelar);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(244, 165, 97, 23);
		contentPane.add(btnVoltar);

	}

}
