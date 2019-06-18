package negocios;

public enum Cargos {
	
	Gerente("Gerente"), Vendedor("Vendedor"),Entregador("Entregador");

	private String funcao;

	Cargos(String funcao) {
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;

	}

}
