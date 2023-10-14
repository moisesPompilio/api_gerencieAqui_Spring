package com.api.calculate.shared.exception;

public class IdInvalidoException extends NegocioException{
    private static final long serialVersionUID = 1L;

    public static final String idInvalido = "Esse id é invalido: ";

    public IdInvalidoException(String id) {
		super(idInvalido + id);
	}
}
