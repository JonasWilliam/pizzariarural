package negocios;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable{

	private Cliente cliente;
	private ArrayList<Produto> produtos;
	private Entregador entregador;
	private boolean status;
	private float total;
	private int id;
	
	public Pedido(Cliente cliente, ArrayList<Produto> produtos, Entregador entregador, float total,int id,boolean status) {
		super();
		this.cliente = cliente;
		this.produtos = produtos;
		this.entregador = entregador;
		this.total = total;
		this.id = id;
		this.status = status;
	}
	public Pedido() {
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "\n *****************************"+ "\n cliente: " + cliente.getNome() + "\n entregador:" + entregador.getNome() + "\n total="
				+ total + "\n id=" + id + "\n Status: "+ status +"\n *****************************";
	}
	
	
}
