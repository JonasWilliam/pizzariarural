package gui.produtos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Produto;
import negocios.Refrigerante;
import negocios.Tamanho;
import negocios.exception.IdProdutoException;

public class TelaCadastroRefrigerante extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private static JFrame telaCadastroRefrigeranteinstance;
	Refrigerante refrigerante = new Refrigerante();
	private JTextField textValorTotal;
	private JTextField textCodigo;
	private JTextField textCustoMaterial;

	public static JFrame getInstance() {
		if (TelaCadastroRefrigerante.telaCadastroRefrigeranteinstance == null)
			TelaCadastroRefrigerante.telaCadastroRefrigeranteinstance = new TelaCadastroRefrigerante();

		return TelaCadastroRefrigerante.telaCadastroRefrigeranteinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroRefrigerante frame = new TelaCadastroRefrigerante();
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
	public TelaCadastroRefrigerante() {
		setTitle("Cadastro de Refrigerante");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDePizza = new JLabel("Cadastro de Refrigerante\r\n");
		lblCadastroDePizza.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDePizza.setBounds(48, 11, 257, 22);
		contentPane.add(lblCadastroDePizza);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(27, 95, 58, 15);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(120, 94, 162, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnVoltarParaMenu = new JButton("Voltar");
		btnVoltarParaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltarParaMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarParaMenu.setBounds(170, 266, 112, 23);
		contentPane.add(btnVoltarParaMenu);

		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorTotal.setBounds(27, 213, 112, 22);
		contentPane.add(lblValorTotal);

		textValorTotal = new JTextField();
		textValorTotal.setEditable(false);
		textValorTotal.setBounds(137, 216, 102, 20);
		contentPane.add(textValorTotal);
		textValorTotal.setColumns(10);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigo.setBounds(27, 62, 72, 22);
		contentPane.add(lblCdigo);

		textCodigo = new JTextField();
		textCodigo.setBounds(120, 63, 162, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);

		JComboBox refrigeranteComboBox = new JComboBox(Tamanho.values());
		refrigeranteComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refrigeranteComboBox.getSelectedItem();
				System.out.println(refrigeranteComboBox.getSelectedItem());
			}
		});
		refrigeranteComboBox.setBounds(120, 121, 46, 22);
		contentPane.add(refrigeranteComboBox);

		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTamanho.setBounds(27, 121, 88, 19);
		contentPane.add(lblTamanho);

		JButton btnCadastrarRefrigerante = new JButton("Cadastrar");
		btnCadastrarRefrigerante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refrigerante.setCodigo(textCodigo.getText());
				refrigerante.setNome(textNome.getText());
				refrigerante.setTamanho(Tamanho.valueOf(refrigeranteComboBox.getSelectedItem().toString()));
				refrigerante.setCustoMaterial(Float.parseFloat(textCustoMaterial.getText()));
				refrigerante.calcularPreco();
				textValorTotal.setText(new String(refrigerante.getValor() + ""));
				try {
					Produto p;
					p = Fachada.getInstance().procurarProduto(textCodigo.getText());
					if (p == null) {
					Fachada.getInstance().cadastrarProduto(refrigerante);
					JOptionPane.showMessageDialog(null, "Refrigerante adicionado ao repositorio com sucesso");
					textNome.setText("");
					textCodigo.setText("");
					textCustoMaterial.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Já existe um Refrigerante adicionado ao repositorio com esse Código.");
					}
				} catch (IdProdutoException eId) {
					eId.printStackTrace();
				}

			}

		});
		btnCadastrarRefrigerante.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarRefrigerante.setBounds(27, 266, 112, 23);
		contentPane.add(btnCadastrarRefrigerante);

		JLabel lblCustomaterial = new JLabel("CustoMaterial:");
		lblCustomaterial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCustomaterial.setBounds(27, 151, 102, 15);
		contentPane.add(lblCustomaterial);

		textCustoMaterial = new JTextField();
		textCustoMaterial.setBounds(126, 149, 124, 19);
		contentPane.add(textCustoMaterial);
		textCustoMaterial.setColumns(10);
	}
}
