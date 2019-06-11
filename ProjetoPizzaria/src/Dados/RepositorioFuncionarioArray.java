package Dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Negocios.Funcionario;

public class RepositorioFuncionarioArray implements RepositorioFuncionario {

	private Funcionario[] funcionarios;
	private int indice;
	private final static int TAMANHO = 100;
	private static RepositorioFuncionarioArray instance;

	@Override
	public void adicionar(Funcionario funcionario) {
		this.funcionarios[indice] = funcionario;
		this.indice = this.indice + 1;

	}

	public RepositorioFuncionarioArray() {
		this.funcionarios = new Funcionario[TAMANHO];
		this.indice = 0;
	}

	@Override
	public void remover(String cpf) {
		for (int i = 0; i <= funcionarios.length; i++) {
			if (funcionarios[i].getCpf().equals(cpf)) {
				funcionarios[i] = null;

				for (int j = 0; j <= funcionarios.length; j++) {

					if (funcionarios[j] == null && funcionarios[j + 1] != null) {
						funcionarios[i] = funcionarios[j];
					}
				}
			}
		}
	}

	@Override
	public Funcionario[] listar() {

		return funcionarios;
	}

	@Override
	public Funcionario procurar(String cpf) {
		Funcionario funcionario = new Funcionario();
		for (int i = 0; i <= funcionarios.length; i++) {
			if (funcionarios[i].getCpf().equals(cpf)) {
				funcionario = funcionarios[i];
			} else
				funcionario = null;

		}
		return funcionario;

	}

	@Override
	public void alterarSenha(String senha, Funcionario a) {
		a.setSenha(senha);

	}

	public static RepositorioFuncionarioArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
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
