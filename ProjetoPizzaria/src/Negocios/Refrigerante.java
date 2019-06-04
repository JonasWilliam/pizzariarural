package Negocios;

public class Refrigerante extends Produto{
	
	private String marca;
	private String sabor;
	
	public Refrigerante(String nome, float valor, String tamanho, String marca, String sabor) {
		super(nome, valor, tamanho);
		this.marca = marca;
		this.sabor = sabor;
	}

	public Refrigerante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	
	
}
