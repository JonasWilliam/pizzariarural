package negocios;

import java.io.Serializable;

public class Refrigerante extends Produto implements Serializable {

	private String marca;

	public Refrigerante(String nome, float valor, Tamanho tamanho, int id) {
		super(nome, valor, tamanho, id);
		this.id = id;
	}

	public Refrigerante() {
		super();
		this.id = 2;
	}

	@Override
	public float getValor() {
		return this.valor = calcularPreco(this.tamanho, this.id);
	}

}
