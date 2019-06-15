package negocios;

import java.io.Serializable;

public class Produto implements Serializable{

	private String nome;
	private float valor;
	private Peso peso;
	private int id;
	
	public Produto(String nome, float valor, Peso peso,int id) {
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

	public Peso getPeso() {
		return peso;
	}

	public void setTamanho(Peso peso) {
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
