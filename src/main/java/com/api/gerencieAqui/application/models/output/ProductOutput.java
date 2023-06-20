package com.api.gerencieAqui.application.models.output;

import java.util.UUID;

import com.api.gerencieAqui.core.generic.model.DataTransferObject;

import lombok.Data;

@Data
public class ProductOutput implements DataTransferObject {
    private UUID id;

    private String name;

    private String description;

    private String urlPhoto;

    private UUID categoryId;

    private double sale;

    private double cost;
}
