package negocios;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pizza1 extends Produto implements Serializable {

	private float custoMaodeObra;
	private Boolean bordaRecheada;

	public Pizza1() {
		super();

	}

	public Pizza1(String nome, float valor, Tamanho tamanho, int id, String codigo, float custoMaodeObra,
			float custoMaterial) {
		super(nome, valor, tamanho, id, codigo, custoMaterial);
		this.custoMaodeObra = custoMaodeObra;
	}

	public Boolean getBordaRecheada() {
		return bordaRecheada;
	}

	public void setBordaRecheada(Boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}

	public void calcularPreco(Tamanho tamanho, int id, float custoMaterial, float MaodeObra, Boolean bordaRecheada) {
		if (bordaRecheada == true) {
			if (tamanho.getValorTamanho() == TAXA_P) {
				valor = ((custoMaodeObra + (custoMaterial * TAXA_P)) * TAXA_LUCRO) + custoMaodeObra + custoMaterial + 2;
			} else if (tamanho.getValorTamanho() == TAXA_M) {
				valor = ((custoMaodeObra + (custoMaterial * TAXA_M)) * TAXA_LUCRO) + custoMaodeObra + custoMaterial + 2;
			} else {
				valor = ((custoMaodeObra + (custoMaterial * TAXA_G)) * TAXA_LUCRO) + custoMaodeObra + custoMaterial + 2;
			}
		} else {
			if (tamanho.getValorTamanho() == TAXA_P) {
				valor = ((custoMaodeObra + (custoMaterial * TAXA_P)) * TAXA_LUCRO) + custoMaodeObra + custoMaterial;
			} else if (tamanho.getValorTamanho() == TAXA_M) {
				valor = ((custoMaodeObra + (custoMaterial * TAXA_M)) * TAXA_LUCRO) + custoMaodeObra + custoMaterial;
			} else {
				valor = ((custoMaodeObra + (custoMaterial * TAXA_G)) * TAXA_LUCRO) + custoMaodeObra + custoMaterial;
			}

		}
	}

	public void calcularPreco() {
		if (bordaRecheada == true) {
			if (getTamanho().getValorTamanho() == TAXA_P) {
				this.valor = (getCustoMaodeObra() + (getCustoMaterial() * TAXA_P)) * TAXA_LUCRO
						+ (getCustoMaodeObra() + (getCustoMaterial())) + 2;
			} else if (getTamanho().getValorTamanho() == TAXA_M) {
				this.valor = (getCustoMaodeObra() + (getCustoMaterial() * TAXA_M)) * TAXA_LUCRO
						+ (getCustoMaodeObra() + (getCustoMaterial())) + 2;
			} else {
				this.valor = ((getCustoMaodeObra() + (getCustoMaterial() * TAXA_G)) * TAXA_LUCRO)
						+ (getCustoMaodeObra() + (getCustoMaterial())) + 2;
			}

		} else {
			if (getTamanho().getValorTamanho() == TAXA_P) {
				this.valor = (getCustoMaodeObra() + (getCustoMaterial() * TAXA_P)) * TAXA_LUCRO
						+ (getCustoMaodeObra() + (getCustoMaterial()));
			} else if (getTamanho().getValorTamanho() == TAXA_M) {
				this.valor = (getCustoMaodeObra() + (getCustoMaterial() * TAXA_M)) * TAXA_LUCRO
						+ (getCustoMaodeObra() + (getCustoMaterial()));
			} else {
				this.valor = ((getCustoMaodeObra() + (getCustoMaterial() * TAXA_G)) * TAXA_LUCRO)
						+ (getCustoMaodeObra() + (getCustoMaterial()));
			}
		}
	}

}
