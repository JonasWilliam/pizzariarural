package Dados;

import Negocios.Funcionario;

public class RepositorioFuncionarioArray implements RepositorioFuncionario {

	private Funcionario[] funcionarios;
	private int indice;
	private final static int TAMANHO = 100;

	@Override
	public void adicionar(Funcionario funcionario) {
		this.funcionarios[indice] = funcionario;
		this.indice = this.indice + 1;

	}

	public void RepositorioFuncionariosArray() {
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

	@Override
	public void alterarCargo(String cargo, Funcionario a) {
		a.setCargo(cargo);

	}

}
