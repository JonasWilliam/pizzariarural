package Dados;

import Negocios.Pedido;
import Negocios.Produto;

public class RepositorioPedidoArray implements RepositorioPedido {

	private Pedido[] pedidos;
	private int indice;
	private final static int TAMANHO = 100;

	public RepositorioPedidoArray() {
		this.pedidos = new Pedido[TAMANHO];
		this.indice = 0;
	}

	@Override
	public void criarPedido(Pedido pedido) {
		this.pedidos[indice] = pedido;
		this.indice = this.indice + 1;

	}

	@Override
	public void removerPedido(int id) {
		for (int i = 0; i <= pedidos.length; i++) {
			if (pedidos[i].getId() == id) {
				pedidos[i] = null;

				for (int j = 0; j <= pedidos.length; j++) {

					if (pedidos[j] == null && pedidos[j + 1] != null) {
						pedidos[i] = pedidos[j];
					}
				}
			}
		}
	}

	@Override
	public Pedido[] listarPedidos() {

		return pedidos;
	}

	@Override
	public Pedido procurarPedido(int id) {
		Pedido p = new Pedido();
		for (int i = 0; i <= pedidos.length; i++) {
			if (pedidos[i].getId() == id) {
				p = pedidos[i];
			}else
				p = null;
		}
		return p;
	}

	@Override
	public void atualizarPedidoAddMais(int id, Produto produto) {
		procurarPedido(id);
		
	}

	@Override
	public void atualizarPedidoRemoverPedido(int id, Produto produto) {
		// TODO Auto-generated method stub
		
	}

	

	

}
