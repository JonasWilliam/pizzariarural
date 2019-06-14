package dados;

import negocios.Funcionario;

public interface RepositorioFuncionario {

	public void adicionarFuncionario(Funcionario a);
	public void removerFuncionario(String cpf);
	public Funcionario procurarFuncionario(String cpf);
	public void alterarSenhaFuncionario(String senha,String cpf);
	public Funcionario[] listarFuncionario();
}