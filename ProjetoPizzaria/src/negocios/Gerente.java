package negocios;

import java.io.Serializable;

public class Gerente extends Funcionario  implements Serializable{

	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerente(String nome, float salario, String senha, String cpf, Cargos cargo) {
		super(nome, salario, senha, cpf, cargo);
		// TODO Auto-generated constructor stub
	}



}
