package Negocios;

public class Produto {

	private String nome;
	private float valor;
	private String tamanho;
	
	public Produto(String nome, float valor, String tamanho) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.tamanho = tamanho;
	}
	
	public Produto() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
