package gui.funcionarios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import negocios.Funcionario;

public class FuncionarioTableModel extends AbstractTableModel {

	private List<Funcionario> funcionarios = new ArrayList<>();
	private String[] colunas = { "Nome", "Cpf", "Salário", "Cargo" };

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return funcionarios.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return funcionarios.get(linha).getNome();
		case 1:
			return funcionarios.get(linha).getCpf();
		case 2:
			return funcionarios.get(linha).getSalario();
		case 3:
			return funcionarios.get(linha).getCargo();
		}
		return null;
	}

	public void addRow(Funcionario f) {
		this.funcionarios.add(f);
		this.fireTableDataChanged();
	}

	public void limparLista() {
		this.funcionarios.clear();
	}
}
