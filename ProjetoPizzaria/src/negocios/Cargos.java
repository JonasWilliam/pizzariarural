package negocios;

public enum Cargos {
	
	Gerente("Gerente"), Entregador("Entregador"), Vendedor("Vendedor");

	private String funcao;

	Cargos(String funcao) {
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;

	}

}
