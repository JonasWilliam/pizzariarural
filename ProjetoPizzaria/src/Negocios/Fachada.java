package Negocios;

public class Fachada {

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
	public void criarPedido(Pedido pedido) {
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

	// Funcionarios

	public void adicionar(Funcionario a) {
		funcionarios.adicionar(a);
	}

	public void remover(String cpf) {
		funcionarios.remover(cpf);
	}

	public Funcionario procurar(String cpf) {
		return funcionarios.procurar(cpf);
	}

	public void alterarSenha(String senha, Funcionario a) {
		funcionarios.alterarSenha(senha, a);
	}

	public void alterarCargo(String cargo, Funcionario a) {
		funcionarios.alterarCargo(cargo, a);
	}

	public Funcionario[] listar() {
		return funcionarios.listar();
	}

}
