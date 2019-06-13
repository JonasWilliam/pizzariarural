package Negocios;

public class Funcionario {

	private String nome;
	private float salario;
	private String login;
	private String senha;
	private String cpf;
	//private String cargo;

	public Funcionario(String nome, float salario, String login, String senha, String cpf) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	/*@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", salario=" + salario + ", login=" + login + ", senha=" + senha + ", cpf="
				+ cpf + "]";
	}*/
	public String toString() {
		return new StringBuffer(" Nome : ")
				.append(this.nome).append(" cpf : ")
				.append(this.cpf).toString();
	}

}
