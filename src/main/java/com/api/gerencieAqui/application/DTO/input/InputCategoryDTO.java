package com.api.gerencieAqui.application.DTO.input;


import com.api.gerencieAqui.domain.entities.Category;
import com.api.gerencieAqui.infrastructure.util.Conversor;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputCategoryDTO {
    @NotEmpty
    private String name;

    @NotEmpty
    private String urlPhoto;

    public Category toEntity(){
        Category category = Conversor.converter(this, Category.class);
        return category;
    }
}
