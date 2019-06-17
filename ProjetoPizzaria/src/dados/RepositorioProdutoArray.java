package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import negocios.Produto;

public class RepositorioProdutoArray implements RepositorioProduto, Serializable {

	private Produto[] produtos;
	private int indice;
	private final static int TAMANHO = 100;
	private static RepositorioProdutoArray instance;

	public RepositorioProdutoArray() {
		this.produtos = new Produto[TAMANHO];
		this.indice = 0;
	}

	@Override
	public void cadastrarProduto(Produto produto) {
		this.produtos[indice] = produto;
		//produtos[indice].setId(indice);
		this.indice = this.indice + 1;
		
	}

	@Override
	public void removerProduto(String codigo) {
		for (int i = 0; i < indice; i++) {
			if (produtos[i].getCodigo().equals(codigo)) {
				produtos[i] = null;
				indice--;
				System.out.println("removeu na posição" + i);

				for (int j = 0; j < indice; j++) {
					System.out.println("chegou no segundo FOR");
					if (produtos[j] == null) {
						if (produtos[j + 1] != null) {
							produtos[j] = produtos[j + 1];
							break;
						}
						System.out.println("chegou no ao fim do for");
					}
				}
			}
		}
	}

	@Override
	public Produto[] listarProdutos() {
		for (int i = 0; i < indice; i++) {
			System.out.println(indice + " " + produtos[i].getNome());
		}
		return produtos;
	}

	@Override
	public Produto procurarProduto(String codigo) {
		Produto p = null;
		for (int i = 0; i < indice; i++) {
			if (produtos[i].getCodigo().equals(codigo)) {
				System.out.println("Nome: " + produtos[i].getNome());
				return produtos[i];
			} else
				p = null;
		}
		return p;
	}

	public static RepositorioProdutoArray getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	private static RepositorioProdutoArray lerDoArquivo() {
		RepositorioProdutoArray instanciaLocal = null;

		File in = new File("produtos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioProdutoArray) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioProdutoArray();
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
		File out = new File("produtos.dat");
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
