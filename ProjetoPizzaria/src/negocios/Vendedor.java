package negocios;

import java.io.Serializable;

public class Vendedor extends Funcionario implements Serializable{

	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendedor(String nome, float salario, String senha, String cpf) {
		super(nome, salario, senha, cpf);
		// TODO Auto-generated constructor stub
	}


}
