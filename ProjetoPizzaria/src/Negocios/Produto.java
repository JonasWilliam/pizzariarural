package Negocios;

public class Produto {

	private String nome;
	private float valor;
	private float peso;
	private int id;
	
	public Produto(String nome, float valor, float peso,int id) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.peso = peso;
		this.id = id;
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

	public float getPeso() {
		return peso;
	}

	public void setTamanho(float peso) {
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
