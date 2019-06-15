package gui.funcionarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemocaoFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textcpf;
	private static JFrame telaRemocaoFuncionarioinstance;

	public static JFrame getInstance() {
		if (TelaRemocaoFuncionario.telaRemocaoFuncionarioinstance == null)
			TelaRemocaoFuncionario.telaRemocaoFuncionarioinstance = new TelaRemocaoFuncionario();

		return TelaRemocaoFuncionario.telaRemocaoFuncionarioinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemocaoFuncionario frame = new TelaRemocaoFuncionario();
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
	public TelaRemocaoFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblReoverDeFuncionrio = new JLabel("Remo\u00E7\u00E3o de Funcion\u00E1rio");
		lblReoverDeFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblReoverDeFuncionrio.setBounds(61, 11, 363, 29);
		contentPane.add(lblReoverDeFuncionrio);

		JLabel lblInformeOCpf = new JLabel("Informe o Cpf:");
		lblInformeOCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOCpf.setBounds(26, 85, 125, 29);
		contentPane.add(lblInformeOCpf);

		textcpf = new JTextField();
		textcpf.setBounds(161, 91, 244, 23);
		contentPane.add(textcpf);
		textcpf.setColumns(10);

		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textcpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o cpf do funcionário que deseja remover");
				} else {
					Fachada.getInstance().removerFuncionario(textcpf.getText());
					JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso");
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemover.setBounds(61, 157, 125, 29);
		contentPane.add(btnRemover);

		JButton btnVoltarParaMenu = new JButton("Voltar para Menu");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarParaMenu.setBounds(216, 157, 141, 29);
		contentPane.add(btnVoltarParaMenu);
	}

}
