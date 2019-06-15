package negocios;

import java.io.Serializable;

public class Gerente extends Funcionario  implements Serializable{

	public Gerente(String nome, float salario, String login, String senha, String cpf,Cargos cargo) {
		super(nome, salario, login, senha, cpf, cargo);
		// TODO Auto-generated constructor stub
	}

}
