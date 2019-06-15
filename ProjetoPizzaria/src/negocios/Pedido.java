package negocios;

import java.io.Serializable;

public class Pedido implements Serializable{

	private Cliente cliente;
	private Produto[] produtos;
	private Entregador entregador;
	private Vendedor vendedor;
	private float total;
	private int id;
	
	public Pedido(Cliente cliente, Produto[] produtos, Entregador entregador, Vendedor vendedor, float total,int id) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.entregador = entregador;
		this.vendedor = vendedor;
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
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
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
