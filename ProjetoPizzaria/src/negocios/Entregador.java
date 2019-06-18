package negocios;

import java.io.Serializable;

public class Entregador implements Serializable {

	private String nome;

	public Entregador(String nome) {
		this.nome = nome;
	}

	public Entregador() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
