package com.api.gerencieAqui.application.models.input;

import java.util.UUID;

import com.api.gerencieAqui.core.generic.model.DataTransferObject;
import com.api.gerencieAqui.domain.entities.Product;
import com.api.gerencieAqui.infrastructure.util.Conversor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInput implements DataTransferObject {

    @NotEmpty
    private String name;

    @NotEmpty
    private String urlPhoto;

    private String description;

    private UUID categoryId;

    @NotNull
    @Positive
    private double sale;

    @NotNull
    @Positive
    private double cost;

    public Product toEntity() {
        return Conversor.converter(this, Product.class);
    }
}
