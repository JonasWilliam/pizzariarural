package gui;

import negocios.Fachada;
import negocios.Funcionario;
import negocios.Pizza;
import negocios.Refrigerante;
import negocios.Tamanho;
import negocios.exception.CpfInvalidoException;
import negocios.exception.IdProdutoException;

public class Teste {

	public static void main(String[] args) throws CpfInvalidoException, IdProdutoException {
		// TODO Auto-generated method stub
		Funcionario a = new Funcionario();
		a.setNome("HAHA");
		a.setLogin("HAHA");
		a.setSenha("HAHA");
		a.setCpf("987");
		a.setSalario(987);
		//Fachada.getInstance().adicionar(a);
		//Fachada.getInstance().printa();//teste
		//Fachada.getInstance().listarFuncionario();
		//Fachada.getInstance().procurarFuncionario("987");
		//Fachada.getInstance().procurarFuncionario("000");
		Refrigerante r = new Refrigerante();
		r.setNome("Guaraná Antartica");
		Fachada.getInstance().cadastrarProduto(r);
		//System.out.println(r.getValor());
		System.out.println(r.getNome());
		System.out.println(r.getId());
		Pizza p = new Pizza();
		p.setNome("Calabresa");
		Fachada.getInstance().cadastrarProduto(p);
		System.out.println(p.getNome());
		System.out.println(p.getId());
	}

	
}
