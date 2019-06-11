package Dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Negocios.Produto;


public class RepositorioProdutoArray implements RepositorioProduto {

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
		this.indice = this.indice + 1;

	}

	@Override
	public void removerProduto(int id) {
		for (int i = 0; i <= produtos.length; i++) {
			if (produtos[i].getId() == id) {
				produtos[i] = null;

				for (int j = 0; j <= produtos.length; j++) {

					if (produtos[j] == null && produtos[j + 1] != null) {
						produtos[i] = produtos[j];
					}
				}
			}
		}
	}

	@Override
	public Produto[] listarProdutos() {
		// TODO Auto-generated method stub
		return produtos;
	}

	@Override
	public Produto procurarProduto(int id) {
		Produto p = new Produto();
		for (int i = 0; i <= produtos.length; i++) {
			if (produtos[i].getId() == id) {
				p = produtos[i];
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
