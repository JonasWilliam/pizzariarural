package gui.produtos;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPizza extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private static JFrame telaCadastroPizzainstance;

	public static JFrame getInstance() {
		if (TelaCadastroPizza.telaCadastroPizzainstance == null)
			TelaCadastroPizza.telaCadastroPizzainstance = new TelaCadastroPizza();

		return TelaCadastroPizza.telaCadastroPizzainstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPizza frame = new TelaCadastroPizza();
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
	public TelaCadastroPizza() {
		setTitle("Cadastro de Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDePizza = new JLabel("Cadastro de Pizza\r\n");
		lblCadastroDePizza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDePizza.setBounds(150, 11, 257, 22);
		contentPane.add(lblCadastroDePizza);

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSabor.setBounds(27, 110, 58, 18);
		contentPane.add(lblSabor);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 111, 139, 20);
		contentPane.add(textField_1);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(128, 207, 112, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarParaMenu.setBounds(266, 207, 141, 23);
		contentPane.add(btnVoltarParaMenu);
	}
}
