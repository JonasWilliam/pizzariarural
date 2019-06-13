package exception;

public class IdProdutoException extends Exception{
	
	private int id;

	public IdProdutoException(int id) {
		super("Produto Inexistente");
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
