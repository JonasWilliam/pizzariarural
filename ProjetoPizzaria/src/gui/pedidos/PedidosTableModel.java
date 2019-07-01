package gui.pedidos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocios.Funcionario;
import negocios.Pedido;

public class PedidosTableModel extends AbstractTableModel {

	private List<Pedido> pedidos = new ArrayList<>();
	private String[] colunas = { "Cliente", "Entregador", "id", "Status","Total" };

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return pedidos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return pedidos.get(linha).getCliente().getNome();
		case 1:
			return pedidos.get(linha).getEntregador().getNome();
		case 2:
			return pedidos.get(linha).getId();
		case 3:
			return pedidos.get(linha).getStatus();
		case 4:
			return pedidos.get(linha).getTotal();
		}
		return null;
	}

	public void addRow(Pedido p) {
		this.pedidos.add(p);
		this.fireTableDataChanged();
	}

	public void limparLista() {
		this.pedidos.clear();
	}
}
