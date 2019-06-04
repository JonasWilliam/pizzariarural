package Negocios;

import Dados.RepositorioFuncionario;
import Dados.RepositorioFuncionarioArray;

public class ControleFuncionario {

	RepositorioFuncionario funcionarios = new RepositorioFuncionarioArray();

	public void adicionar(Funcionario a) {
		funcionarios.adicionar(a);
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

	public void alterarCargo(String cargo, Funcionario a) {
		funcionarios.alterarCargo(cargo, a);
	}

	public Funcionario[] listar() {
		return funcionarios.listar();
	}

}
