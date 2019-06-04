package Dados;

import Negocios.Produto;


public class RepositorioProdutoArray implements RepositorioProduto {

	private Produto[] produtos;
	private int indice;
	private final static int TAMANHO = 100;

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

}
