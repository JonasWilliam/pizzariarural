package negocios;

public enum Tamanho {

	P(0.50), M(1), G(2);

	private double valorTamanho;

	Tamanho(double valorTamanho) {
		this.valorTamanho = valorTamanho;
	}

	public double getValorTamanho() {
		return valorTamanho;

	}

}
