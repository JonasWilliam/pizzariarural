package Negocios;

public class Refrigerante extends Produto{
	
	private String marca;
	private String sabor;
	
	public Refrigerante(String nome, float valor, Peso peso, String marca, String sabor,int id) {
		super(nome, valor, peso,id);
		this.marca = marca;
		this.sabor = sabor;
	}

	public Refrigerante() {
		super();
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
