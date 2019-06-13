package exception;

public class CpfInvalidoException extends Exception {

	private String cpf;

	public CpfInvalidoException(String cpf) {
		super("CPF Invalido");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

}
