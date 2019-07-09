package gui.produtos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocios.Produto;

public class ProdutoTableModel1 extends AbstractTableModel {

	private List<Produto> produtos = new ArrayList<>();
	private String[] colunas = { "Código", "Nome", "Valor", "Tamanho", "Qtd" };
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return produtos.get(linha).getCodigo();
			
		case 1:
			return produtos.get(linha).getNome();
		case 2:
			return produtos.get(linha).getValor();
		case 3:
			return produtos.get(linha).getTamanho();
		case 4:
			return produtos.get(linha).getQuantidade();
		}
		return null;
	}
	public void addRow(Produto p) {
		this.produtos.add(p);
		this.fireTableDataChanged();
	}

	public void limparLista() {
		this.produtos.clear();
		
	}
	public void att() {
		this.fireTableDataChanged();
	}

}
