package com.api.gerencieAqui.domain.exception.negocio;

import com.api.gerencieAqui.domain.exception.EntidadeNaoEncontradaException;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;
    
    public CidadeNaoEncontradaException(Class classe, String codigo) {
        super(classe, codigo);
    }

}
