package Negocios;

import Dados.RepositorioPedido;
import Dados.RepositorioPedidoArray;
import Exception.ClientePedidosException;

public class ControlePedido {

	RepositorioPedido pedidos = new RepositorioPedidoArray();

	public void criarPedido(Pedido pedido) throws ClientePedidosException {
		if (pedido.getCliente().getTelefone() != null & pedido.getCliente().getTelefone() != "") {
			pedidos.criarPedido(pedido);
		} else {
			ClientePedidosException e;
			e = new ClientePedidosException(pedido.getCliente().getTelefone());
			throw e;
		}
	}

	public void removerPedido(int id) {
		pedidos.removerPedido(id);
	}

	public Pedido[] listarPedidos() {
		return pedidos.listarPedidos();
	}

	public Pedido procurarPedido(int id) {
		return pedidos.procurarPedido(id);
	}

	public void atualizarPedidoAddMais(int id, Produto produto) {
		pedidos.atualizarPedidoAddMais(id, produto);
	}

	public void atualizarPedidoRemoverPedido(int id, Produto produto) {
		pedidos.atualizarPedidoRemoverPedido(id, produto);
	}
}
