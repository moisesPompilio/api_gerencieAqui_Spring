package com.api.calculate.shared.exception.negocio;

import com.api.calculate.shared.exception.EntidadeNaoEncontradaException;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public EstadoNaoEncontradoException(Class classe, String codigo) {
        super(classe, codigo);
    }

}
