package negocios;

public enum Cargos {
	
	Gerente("Gerente"), Vendedor("Vendedor");

	private String funcao;

	Cargos(String funcao) {
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;

	}

}
