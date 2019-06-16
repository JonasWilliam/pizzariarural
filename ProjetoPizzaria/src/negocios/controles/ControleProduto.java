package negocios.controles;


import dados.RepositorioProduto;
import dados.RepositorioProdutoArray;
import negocios.Produto;
import negocios.exception.IdProdutoException;

public class ControleProduto {

	RepositorioProduto produtos = RepositorioProdutoArray.getInstance();

	public void cadastrarProduto(Produto p) throws IdProdutoException {
		if (p.getId() >= 0) {

			produtos.cadastrarProduto(p);
			RepositorioProdutoArray.getInstance().salvarArquivo();

		} else {
			IdProdutoException e;
			e = new IdProdutoException(p.getId());
			throw e;
		}
	}

	public void removerProduto(String codigo) {
		produtos.removerProduto(codigo);
	}

	public Produto[] listarProdutos() {
		RepositorioProdutoArray.getInstance();
		produtos.listarProdutos();
		return produtos.listarProdutos();
	}

	public Produto procurarProduto(String nome) {
		if (nome != null & nome != "") {
			RepositorioProdutoArray.getInstance();
			produtos.procurarProduto(nome);
		}
		return produtos.procurarProduto(nome);
	}

}
