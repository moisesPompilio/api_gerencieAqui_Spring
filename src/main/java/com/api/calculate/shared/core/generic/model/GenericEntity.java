package com.api.calculate.shared.core.generic.model;

import java.util.UUID;

public interface GenericEntity {

    UUID getId();

    // String getCodigo();

    // void setCodigo(String codigo);

    // String getName();

    // Comentários: Para funcionar, é necessário sobrescrever e
    // anotar com @Prepersist
    // default void gerarCodigo() {
    //     setCodigo(UUID.randomUUID().toString());
    // }

}
