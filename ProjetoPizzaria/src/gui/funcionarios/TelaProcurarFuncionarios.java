package gui.funcionarios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dados.RepositorioFuncionarioArray;
import gui.TelaPrincipal;
import negocios.Fachada;
import negocios.Funcionario;

import javax.swing.JLabel;
import java.awt.Font;

public class TelaProcurarFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textcpf;
	private static JFrame telaListarFuncionarioinstance;

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
		setBounds(100, 100, 300, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 223, 150);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Dados: \n");
				if(textcpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o cpf do funcionario.");
				}
					
				else {

					Funcionario achouFuncionario = Fachada.getInstance().procurarFuncionario(textcpf.getText());
					 if(achouFuncionario == null){
						 JOptionPane.showMessageDialog(null, "Funcion�rio n�o existe.");
					 }else{
						 textArea.append(achouFuncionario.toString());
					 }
					 
				}
			}
		});
		btnProcurar.setBounds(10, 65, 123, 23);
		contentPane.add(btnProcurar);
		
		textcpf = new JTextField();
		textcpf.setBounds(135, 37, 153, 20);
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
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltar.setBounds(155, 262, 133, 41);
		contentPane.add(btnVoltar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textcpf.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(163, 65, 125, 23);
		contentPane.add(btnReset);
		
	}
}
