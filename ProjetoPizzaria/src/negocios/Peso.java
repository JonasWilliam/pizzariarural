package negocios;

public enum Peso {

	MeioQuilo(0.50), UmQuilo(1), DoisQuilo(2);

	private double valorPeso;

	Peso(double valorPeso) {
		this.valorPeso = valorPeso;
	}

	public double getValorPeso() {
		return valorPeso;

	}

}
