package negocios;

import java.io.Serializable;

public class Produto implements Serializable {

<<<<<<< HEAD
	private String nome;
	protected float valor;
	protected Tamanho tamanho;
	protected int id;

	public Produto(String nome, float valor, Tamanho tamanho, int id) {
||||||| merged common ancestors
	private String nome;
	private float valor;
	private Peso peso;
	private int id;
	
	public Produto(String nome, float valor, Peso peso,int id) {
=======
	
	private float valor;
	private Peso peso;
	private int id;
	
	public Produto(String nome, float valor, Peso peso,int id) {
>>>>>>> e67b827465ba9ce044cbaa3bc24aee7482d9009c
		super();
		
		this.valor = valor;
		this.tamanho = tamanho;
		this.id = id;
	}

	public Produto() {

	}



	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float calcularPreco(Tamanho tamanho, int id) {
		if (id == 1) {
			if (tamanho.getValorTamanho() == 0.5) {
				return valor = 10;
			} else if (tamanho.getValorTamanho() == 1) {
				return valor = 20;
			} else {
				return valor = 30;
			}
		} else{
			if (tamanho.getValorTamanho() == 0.5) {
				return valor = 2;
			} else if (tamanho.getValorTamanho() == 1) {
				return valor = 4;
			} else {
				return valor = 6;
			}
		}

	}
}
