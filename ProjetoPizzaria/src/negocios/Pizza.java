package negocios;

import java.io.Serializable;

public class Pizza extends Produto implements Serializable{

	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pizza(String nome, float valor, Tamanho tamanho, int id, String codigo, float custoMaterial) {
		super(nome, valor, tamanho, id, codigo, custoMaterial);
		// TODO Auto-generated constructor stub
	}

	
}
