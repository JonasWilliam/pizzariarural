package negocios;

import java.io.Serializable;

public class Vendedor extends Funcionario implements Serializable{

	public Vendedor(String nome, float salario, String login, String senha, String cpf, Cargos cargo) {
		super(nome, salario, login, senha, cpf, cargo);
		// TODO Auto-generated constructor stub
	}

}
