package negocios.controles;


import dados.RepositorioFuncionarioArray;
import dados.RepositorioPedido;
import dados.RepositorioPedidoArray;
import negocios.Pedido;
import negocios.Produto;
import negocios.exception.ClientePedidosException;

public class ControlePedido {

	RepositorioPedido pedidos =  RepositorioPedidoArray.getInstance();

	public void criarPedido(Pedido pedido) throws ClientePedidosException {
		if (pedido.getCliente().getTelefone() != null & pedido.getCliente().getTelefone() != "") {
			pedidos.criarPedido(pedido);
			RepositorioPedidoArray.getInstance().salvarArquivo();
		} else {
			ClientePedidosException e;
			e = new ClientePedidosException(pedido.getCliente().getTelefone());
			throw e;
		}
	}

	public void removerPedido(int id) {
		pedidos.removerPedido(id);
		RepositorioPedidoArray.getInstance().salvarArquivo();
	}

	public Pedido[] listarPedidos() {
		RepositorioPedidoArray.getInstance();
		return pedidos.listarPedidos();
	}

	public Pedido procurarPedido(int id) {
		
			
			RepositorioPedidoArray.getInstance();
			pedidos.procurarPedido(id);

		return pedidos.procurarPedido(id);
	}

	public void atualizarPedidoAddMais(int id, Produto produto) {
		pedidos.atualizarPedidoAddMais(id, produto);
	}

	public void atualizarPedidoRemoverPedido(int id, Produto produto) {
		pedidos.atualizarPedidoRemoverPedido(id, produto);
	}
}
