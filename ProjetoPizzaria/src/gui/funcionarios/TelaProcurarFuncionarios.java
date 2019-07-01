package gui.funcionarios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dados.RepositorioFuncionarioArray;
import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaProcurarFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textcpf;
	private static JFrame telaListarFuncionarioinstance;
	FuncionarioTableModel modelo = new FuncionarioTableModel();
	private JTable table;
	
	public static JFrame getInstance() {
		if (TelaProcurarFuncionarios.telaListarFuncionarioinstance == null)
			TelaProcurarFuncionarios.telaListarFuncionarioinstance = new TelaProcurarFuncionarios();

		return TelaProcurarFuncionarios.telaListarFuncionarioinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcurarFuncionarios frame = new TelaProcurarFuncionarios();
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
	public TelaProcurarFuncionarios() {
		setTitle("Procurar Funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 346, 151);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		
		
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(Color.GREEN);
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				if(textcpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o cpf do funcionario.");
				}
					
				else {

					Funcionario achouFuncionario = Fachada.getInstance().procurarFuncionario(textcpf.getText());
					 if(achouFuncionario == null){
						 JOptionPane.showMessageDialog(null, "Funcionário não existe.");
					 }else{
						 JOptionPane.showMessageDialog(null, "Funcionário existe.");
						 modelo.addRow(achouFuncionario);
						
					 }
					 
				}
			}
		});
		btnProcurar.setBounds(10, 65, 123, 23);
		contentPane.add(btnProcurar);
		
		textcpf = new JTextField();
		textcpf.setBounds(121, 37, 153, 20);
		contentPane.add(textcpf);
		textcpf.setColumns(10);
		
		JLabel lblProcurarFuncionrio = new JLabel("Procurar Funcion\u00E1rio");
		lblProcurarFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProcurarFuncionrio.setBounds(10, 11, 223, 23);
		contentPane.add(lblProcurarFuncionrio);
		
		JLabel lblInformeOCpf = new JLabel("Informe o CPF :");
		lblInformeOCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformeOCpf.setBounds(13, 39, 120, 14);
		contentPane.add(lblInformeOCpf);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.RED);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPrincipal.getInstance().setVisible(true);
			}
			
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(195, 260, 110, 30);
		contentPane.add(btnVoltar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.limparLista();
				textcpf.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(20, 261, 110, 30);
		contentPane.add(btnReset);
		
	}
}
