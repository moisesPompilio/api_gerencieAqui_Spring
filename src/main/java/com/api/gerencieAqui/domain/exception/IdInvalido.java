package com.api.gerencieAqui.domain.exception;

public class IdInvalido extends NegocioException{
    private static final long serialVersionUID = 1L;

    public static final String idInvalido = "Esse id é invalido: ";

    public IdInvalido(String id) {
		super(idInvalido + id);
	}
}
