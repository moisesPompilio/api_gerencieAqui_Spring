package com.api.gerencieAqui.core.generic.model;

public interface ActivatableEntity extends GenericEntity {

    boolean isAtivo();

    void setAtivo(boolean ativo) ;

    default void ativar(){
        setAtivo(true);
    }

    default void inativar(){
        setAtivo(false);
    }
}
