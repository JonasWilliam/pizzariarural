package Gui;

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

import Negocios.Fachada;
import Negocios.Funcionario;

public class TelaListarFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTextField textteste;
	private static JFrame telaListarFuncionarioinstance;

	public static JFrame getInstance() {
		if (TelaListarFuncionarios.telaListarFuncionarioinstance == null)
			TelaListarFuncionarios.telaListarFuncionarioinstance = new TelaListarFuncionarios();

		return TelaListarFuncionarios.telaListarFuncionarioinstance;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarFuncionarios frame = new TelaListarFuncionarios();
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
	public TelaListarFuncionarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 414, 135);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Dados: \n");
				if(textteste.equals(""))
					JOptionPane.showMessageDialog(null, "Digite o cpf do funcionario.");
				else{ 
					 Funcionario achouFuncionario = Fachada.getInstance().procurar(textteste.getText());
					 if(achouFuncionario == null){
						 JOptionPane.showMessageDialog(null, "Funcionário não existe.");
					 }else{
						 textArea.append(achouFuncionario.toString());
					 }
					 
				}
			}
		});
		btnProcurar.setBounds(42, 41, 89, 23);
		contentPane.add(btnProcurar);
		
		textteste = new JTextField();
		textteste.setBounds(154, 42, 86, 20);
		contentPane.add(textteste);
		textteste.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnListar.setBounds(42, 63, 89, 23);
		contentPane.add(btnListar);
		
	}
}
