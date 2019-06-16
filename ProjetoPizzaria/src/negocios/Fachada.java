package negocios;



import negocios.controles.ControleFuncionario;
import negocios.controles.ControlePedido;
import negocios.controles.ControleProduto;
import negocios.exception.ClientePedidosException;
import negocios.exception.CpfInvalidoException;
import negocios.exception.IdProdutoException;

public class Fachada{

	private ControlePedido pedidos;
	private static Fachada instance;
	private ControleProduto produtos;
	private ControleFuncionario funcionarios;

	public Fachada() {
		pedidos = new ControlePedido();
		produtos = new ControleProduto();
		funcionarios = new ControleFuncionario();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	
	//Pedido
	public void criarPedido(Pedido pedido) throws ClientePedidosException {
		pedidos.criarPedido(pedido);
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

	// Produto

	public void cadastrarProduto(Produto p) throws IdProdutoException {
		produtos.cadastrarProduto(p);
	}

	public void removerProduto(int id) {
		produtos.removerProduto(id);
	}

	public Produto[] listarProdutos() {
		return produtos.listarProdutos();
	}

	public Produto procurarProduto(String nome) {
		return produtos.procurarProduto(nome);
	}

	// Funcionarios

	public void adicionar(Funcionario a) throws CpfInvalidoException {
		funcionarios.adicionarFuncionario(a);
	}

	public void removerFuncionario(String cpf) {
		funcionarios.removerFuncionario(cpf);
	}

	public Funcionario procurarFuncionario(String cpf) {
		return funcionarios.procurarFuncionario(cpf);
	}

	public void alterarSenha(String senha, String a) {
		funcionarios.alterarSenhaFuncionario(senha, a);
	}


	public Funcionario[] listarFuncionario() {
		return funcionarios.listarFuncionario();
	}
	
	

}
