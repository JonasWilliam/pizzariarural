package Dados;

import Negocios.Funcionario;

public interface RepositorioFuncionario {

	public void adicionar(Funcionario a);
	public void remover(String cpf);
	public Funcionario procurar(String cpf);
	public void alterarSenha(String senha,String cpf);
	public Funcionario[] listar();
}