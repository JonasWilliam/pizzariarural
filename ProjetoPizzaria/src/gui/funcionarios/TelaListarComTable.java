package gui.funcionarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocios.Fachada;
import negocios.Funcionario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarComTable extends javax.swing.JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTable table;
	FuncionarioTableModel modelo = new FuncionarioTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarComTable frame = new TelaListarComTable();
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
	public TelaListarComTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("nome:");
		lblNome.setBounds(27, 23, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("cpf:");
		lblCpf.setBounds(27, 57, 46, 14);
		contentPane.add(lblCpf);
		
		nome = new JTextField();
		nome.setBounds(76, 20, 86, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(76, 54, 86, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario();
				f.setNome(nome.getText());
				f.setCpf(cpf.getText());
				modelo.addRow(f);
			}
		});
		btnAdd.setBounds(46, 101, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnRemover = new JButton("remover");
		btnRemover.setBounds(155, 101, 89, 23);
		contentPane.add(btnRemover);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(46, 198, 351, 75);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table);
		
		table.setModel(modelo);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario[] teste = Fachada.getInstance().listarFuncionario();
				for(int i = 0; i < teste.length; i++) {
					if(teste[i] != null) {
						modelo.addRow(teste[i]);
					}
				}
			}
		});
		btnListar.setBounds(271, 101, 89, 23);
		contentPane.add(btnListar);
		
	
	}
}
