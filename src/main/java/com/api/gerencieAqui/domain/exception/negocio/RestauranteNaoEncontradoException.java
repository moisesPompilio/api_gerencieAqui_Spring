package com.api.gerencieAqui.domain.exception.negocio;

import com.api.gerencieAqui.domain.exception.EntidadeNaoEncontradaException;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public RestauranteNaoEncontradoException(Class classe, String codigo) {
        super(classe, codigo);
    }

}
