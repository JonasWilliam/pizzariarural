package negocios.controles;

import dados.RepositorioFuncionario;
import dados.RepositorioFuncionarioArray;
import negocios.Funcionario;
import negocios.exception.CpfInvalidoException;

public class ControleFuncionario {

	RepositorioFuncionario funcionarios = RepositorioFuncionarioArray.getInstance();

	public void adicionarFuncionario(Funcionario a) throws CpfInvalidoException {
		if (a.getCpf() != null & a.getCpf() != "") {
			RepositorioFuncionarioArray.getInstance();
			funcionarios.adicionarFuncionario(a);
			RepositorioFuncionarioArray.getInstance().salvarArquivo();
			System.out.println("Funcionario Cadastrado com Sucesso");
		} else {
			CpfInvalidoException e;
			e = new CpfInvalidoException(a.getCpf());
			throw e;
		}
	}

	public void removerFuncionario(String cpf) {
		RepositorioFuncionarioArray.getInstance();
		funcionarios.removerFuncionario(cpf);
		RepositorioFuncionarioArray.getInstance().salvarArquivo();
	}

	public Funcionario procurarFuncionario(String cpf) {
		
		if (cpf != null & cpf != "") {
			
			RepositorioFuncionarioArray.getInstance();
			funcionarios.procurarFuncionario(cpf);
	
			
		}

		return funcionarios.procurarFuncionario(cpf);
	}

	public void alterarSenhaFuncionario(String senha, String a) {
		RepositorioFuncionarioArray.getInstance();
		funcionarios.alterarSenhaFuncionario(senha, a);
		RepositorioFuncionarioArray.getInstance().salvarArquivo();
	}

	public Funcionario[] listarFuncionario() {
		RepositorioFuncionarioArray.getInstance();
		funcionarios.listarFuncionario();
		return funcionarios.listarFuncionario();
	}
	
	
	

}
