package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import negocios.Pedido;
import negocios.Produto;

public class RepositorioPedidoArray implements RepositorioPedido,Serializable {

	private Pedido[] pedidos;
	private int indice;
	private final static int TAMANHO = 100;
	private static RepositorioPedidoArray instance;
	
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
	
	public static RepositorioPedidoArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioPedidoArray lerDoArquivo() {
		RepositorioPedidoArray instanciaLocal = null;

		File in = new File("pedidos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioPedidoArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioPedidoArray();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;
	}

	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("pedidos.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					/* Silent */}
			}
		}
	}

	

	

}
