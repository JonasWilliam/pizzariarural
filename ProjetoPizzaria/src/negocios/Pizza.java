package negocios;

import java.io.Serializable;

public class Pizza extends Produto implements Serializable {

	private Boolean bordaRecheada;

	public Pizza() {
		super();
		this.id = 1;
		// TODO Auto-generated constructor stub
	}

	public Pizza(String nome, float valor, Tamanho tamanho, Boolean bordaRecheada, int id) {
		super(nome, valor, tamanho, id);
		this.bordaRecheada = bordaRecheada;
	}

	public Boolean getBordaRecheada() {
		return bordaRecheada;
	}

	public void setBordaRecheada(Boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}
	
	@Override
	public float getValor() {
		return this.valor = calcularPreco(this.tamanho, this.id);
	}

}
