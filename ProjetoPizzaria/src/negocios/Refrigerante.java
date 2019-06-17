package negocios;

import java.io.Serializable;

public class Refrigerante extends Produto implements Serializable {

	public Refrigerante(String nome, float valor, Tamanho tamanho, int id, String codigo, float custoMaterial) {
		super(nome, valor, tamanho, id, codigo, custoMaterial);
	}

	public Refrigerante() {
		super();
		
	}

	public void calcularPreco(Tamanho tamanho, int id, float custoMaterial) {
		if (tamanho.getValorTamanho() == TAXA_P) {
			valor = (custoMaterial * TAXA_LUCRO) + custoMaterial;
		} else if (tamanho.getValorTamanho() == TAXA_M) {
			valor = (custoMaterial * TAXA_LUCRO) + custoMaterial;
		} else {
			valor = (custoMaterial * TAXA_LUCRO) + custoMaterial;
		}
	}

	public void calcularPreco() {
		if (getTamanho().getValorTamanho() == TAXA_P) {
			valor = (getCustoMaterial() * TAXA_LUCRO) + getCustoMaterial();
		} else if (getTamanho().getValorTamanho() == TAXA_M) {
			valor = (getCustoMaterial() * TAXA_LUCRO) + getCustoMaterial();
		} else {
			valor = (getCustoMaterial() * TAXA_LUCRO) + getCustoMaterial();
		}
	}

}
