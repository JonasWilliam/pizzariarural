package Negocios;

public class Pizza extends Produto{

	private String sabor;
	private Boolean bordaRecheada;
	
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza(String nome, float valor, String tamanho, String sabor, Boolean bordaRecheada) {
		super(nome, valor, tamanho);
		this.sabor = sabor;
		this.bordaRecheada = bordaRecheada;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public Boolean getBordaRecheada() {
		return bordaRecheada;
	}
	public void setBordaRecheada(Boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}
	
	
}
