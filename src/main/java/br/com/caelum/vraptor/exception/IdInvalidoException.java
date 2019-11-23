package br.com.caelum.vraptor.exception;

public class IdInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdInvalidoException(String message) {
		super(message);
	}
}
