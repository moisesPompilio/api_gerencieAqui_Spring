package com.api.gerencieAqui.application.DTO.mapper;

import org.springframework.stereotype.Component;

import com.api.gerencieAqui.application.DTO.input.InputCategoryDTO;
import com.api.gerencieAqui.application.DTO.output.OutputCategory;
import com.api.gerencieAqui.core.generic.mapper.GenericMapper;
import com.api.gerencieAqui.domain.entities.Category;

@Component
public class CategoryMapper extends GenericMapper<Category, InputCategoryDTO, OutputCategory> {
    public CategoryMapper() {
        super(Category.class, InputCategoryDTO.class, OutputCategory.class);
    }
}
