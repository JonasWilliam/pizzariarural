package gui;

import negocios.Fachada;
import negocios.Funcionario;
import negocios.exception.CpfInvalidoException;

public class Teste {

	public static void main(String[] args) throws CpfInvalidoException {
		// TODO Auto-generated method stub
		Funcionario a = new Funcionario();
		a.setNome("HAHA");
		a.setLogin("HAHA");
		a.setSenha("HAHA");
		a.setCpf("987");
		a.setSalario(987);
		Fachada.getInstance().adicionar(a);
		Fachada.getInstance().printa();//teste
		Fachada.getInstance().procurarFuncionario("987");
		Fachada.getInstance().procurarFuncionario("000");
		

	}

}
