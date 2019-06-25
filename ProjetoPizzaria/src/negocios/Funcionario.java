package negocios;

import java.io.Serializable;

public class Funcionario  implements Serializable{

	private String nome;
	private float salario;
	private Cargos cargo;
	private String senha;
	private String cpf;
	
	public Funcionario(String nome) {
		this.nome = nome;
	}

	public Funcionario(String nome, float salario, String senha, String cpf,Cargos cargo) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.senha = senha;
		this.cpf = cpf;
		this.cargo = cargo;

	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cargos getCargo() {
		return cargo;
	}

	public void setCargo(Cargos cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "\n"+" nome: " + nome + "\n salario:" + salario + "\n cpf:"
				+ cpf + "\n Cargo:"+ cargo + "\n **********************";
	}

	

}
