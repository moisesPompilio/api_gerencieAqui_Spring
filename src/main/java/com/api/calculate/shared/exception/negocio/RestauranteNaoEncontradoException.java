package com.api.calculate.shared.exception.negocio;

import com.api.calculate.shared.exception.EntidadeNaoEncontradaException;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public RestauranteNaoEncontradoException(Class classe, String codigo) {
        super(classe, codigo);
    }

}
