package com.api.gerencieAqui.application.models.output;

import java.util.UUID;

import com.api.gerencieAqui.core.generic.model.DataTransferObject;

import lombok.Data;

@Data
public class CategoryOutput implements DataTransferObject {
    private UUID id;

    private String name;

    private String urlPhoto;
}
