package Negocios;

import Dados.RepositorioProduto;
import Dados.RepositorioProdutoArray;

public class ControleProduto {

	RepositorioProduto produtos = new RepositorioProdutoArray();

	public void cadastrarProduto(Produto p) {
		produtos.cadastrarProduto(p);
	}

	public void removerProduto(int id) {
		produtos.removerProduto(id);
	}

	public Produto[] listarProdutos() {
		return produtos.listarProdutos();
	}

	public Produto procurarProduto(int id) {
		return produtos.procurarProduto(id);
	}

}
