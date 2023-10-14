package com.api.calculate.shared.exception.negocio;

import com.api.calculate.shared.exception.EntidadeNaoEncontradaException;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public CozinhaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public CozinhaNaoEncontradaException(Class classe) {
        super(classe);
    }

    public CozinhaNaoEncontradaException(Class classe, String codigo) {
        super(classe, codigo);
    }

}
