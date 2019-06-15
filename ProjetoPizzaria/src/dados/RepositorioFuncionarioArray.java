package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import negocios.Funcionario;

public class RepositorioFuncionarioArray implements RepositorioFuncionario,Serializable{

	private Funcionario[] funcionarios;
	private int indice;
	private final static int TAMANHO = 100;
	private static RepositorioFuncionarioArray instance;

	
	public static RepositorioFuncionarioArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	public RepositorioFuncionarioArray() {
		this.funcionarios = new Funcionario[TAMANHO];
		this.indice = 0;

		
	}

	@Override
	public void adicionarFuncionario(Funcionario funcionario) {
		this.funcionarios[indice] = funcionario;
		this.indice = this.indice + 1;
		

	}

	@Override
	public void removerFuncionario(String cpf) {
		for (int i = 0; i < indice; i++) {
			if (funcionarios[i].getCpf().equals(cpf)) {
				funcionarios[i] = null;

				for (int j = 0; j < indice; j++) {

					if (funcionarios[j] == null && funcionarios[j + 1] != null) {
						funcionarios[i] = funcionarios[j];
					}
				}

			}

		}
	}

	@Override
	public Funcionario[] listarFuncionario() {
		return funcionarios;
	}

	public void printa() {
		Funcionario[] teste = funcionarios;
		for (int i = 0; i < indice; i++) {
			System.out.println("Nº: " + (indice + 1) + " Nome: " + funcionarios[i].getNome());
		}
	}

	@Override
	public Funcionario procurarFuncionario(String cpf) {
		Funcionario a = null;
		for (int i = 0; i < indice; i++) {
			if (funcionarios[i].getCpf().equals(cpf)) {
				System.out.println("Nome: " + funcionarios[i].getNome() + " Cpf: " + funcionarios[i].getCpf());
				a = funcionarios[i];
			}else
				a = null;

		}
		
		return a;
	}

	@Override
	public void alterarSenhaFuncionario(String senha, String cpf) {
		Funcionario a = new Funcionario();
		a = procurarFuncionario(cpf);
		a.setSenha(senha);

	}



	private static RepositorioFuncionarioArray lerDoArquivo() {
		RepositorioFuncionarioArray instanciaLocal = null;

		File in = new File("funcionarios.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioFuncionarioArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioFuncionarioArray();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("funcionarios.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					/* Silent */}
			}
		}
	}

}
