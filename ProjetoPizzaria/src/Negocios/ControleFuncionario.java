package Negocios;

import Dados.RepositorioFuncionario;
import Dados.RepositorioFuncionarioArray;
import Exception.CpfInvalidoException;

public class ControleFuncionario {

	RepositorioFuncionario funcionarios = new RepositorioFuncionarioArray();

	public void adicionar(Funcionario a) throws CpfInvalidoException {
		if (a.getCpf() != null & a.getCpf() != "") {
			funcionarios.adicionar(a);
		} else {
			CpfInvalidoException e;
			e = new CpfInvalidoException(a.getCpf());
			throw e;
		}
	}

	public void remover(String cpf) {
		funcionarios.remover(cpf);
	}

	public Funcionario procurar(String cpf) {
		return funcionarios.procurar(cpf);
	}

	public void alterarSenha(String senha, Funcionario a) {
		funcionarios.alterarSenha(senha, a);
	}


	public Funcionario[] listar() {
		return funcionarios.listar();
	}

}
