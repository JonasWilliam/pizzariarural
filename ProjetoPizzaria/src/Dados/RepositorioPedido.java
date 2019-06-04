package Dados;


import Negocios.Pedido;
import Negocios.Produto;

public interface RepositorioPedido {

	public void criarPedido(Pedido pedido);
	public void removerPedido(int id);
	public Pedido[] listarPedidos();
	public Pedido procurarPedido(int id);
	public void atualizarPedidoAddMais(int id,Produto produto);
	public void atualizarPedidoRemoverPedido(int id,Produto produto);
}
