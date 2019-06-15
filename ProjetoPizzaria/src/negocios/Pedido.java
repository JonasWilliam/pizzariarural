package negocios;

import java.io.Serializable;

public class Pedido implements Serializable{

	private Cliente cliente;
	private Produto[] produtos;
	private Entregador entregador;
	
	private float total;
	private int id;
	
	public Pedido(Cliente cliente, Produto[] produtos, Entregador entregador, float total,int id) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.entregador = entregador;
		this.total = total;
		this.id = id;
	}
	public Pedido() {
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto[] getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}
	public Entregador getEntregador() {
		return entregador;
	}
	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
