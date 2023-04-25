package com.api.gerencieAqui.application.DTO.input;

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
public class InputProductDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String urlPhoto;

    private String description;

    @NotNull
    private String categoryId;

    @NotNull
    @Positive
    private double price;

    public Product toEntity(){
        return Conversor.converter(this, Product.class);
    }
}
