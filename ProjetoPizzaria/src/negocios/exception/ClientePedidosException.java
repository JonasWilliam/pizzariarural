package negocios.exception;

public class ClientePedidosException extends Exception{
	
	private String telefone;
	
	public ClientePedidosException(String telefone) {
		super("Cliente Vazio");
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}

}
