package Dados;

import Negocios.Produto;

public interface RepositorioProduto {

	public void cadastrarProduto(Produto p);
	public void removerProduto(int id);
	public Produto[] listarProdutos();
	public Produto procurarProduto(int id);
	
	
}
