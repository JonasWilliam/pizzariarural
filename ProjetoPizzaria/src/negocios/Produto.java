package negocios;

import java.io.Serializable;

public class Produto implements Serializable {

	private String nome;
	protected float valor;
	protected Tamanho tamanho;
	protected int id;
	private String codigo;
	protected float custoMaterial;
	protected float custoMaodeObra;

	protected static final Float TAXA_P = new Float(0.5);
	protected static final Float TAXA_M = new Float(1);
	protected static final Float TAXA_G = new Float(2);
	protected static final Float TAXA_LUCRO = new Float(0.15);

	public Produto(String nome, float valor, Tamanho tamanho, int id, String codigo, float custoMaterial) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.tamanho = tamanho;
		this.id = id;
		this.custoMaterial = custoMaterial;
	}

	public float getCustoMaterial() {
		return custoMaterial;
	}

	public void setCustoMaterial(float custoMaterial) {
		this.custoMaterial = custoMaterial;
	}

	public float getCustoMaodeObra() {
		return custoMaodeObra;
	}

	public void setCustoMaodeObra(float custoMaodeObra) {
		this.custoMaodeObra = custoMaodeObra;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Produto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
