package com.api.gerencieAqui.application.models.mapper;

import org.springframework.stereotype.Component;

import com.api.gerencieAqui.application.models.input.CategoryInput;
import com.api.gerencieAqui.application.models.output.CategoryOutput;
import com.api.gerencieAqui.core.generic.mapper.GenericMapper;
import com.api.gerencieAqui.domain.entities.Category;

@Component
public class CategoryMapper extends GenericMapper<Category, CategoryInput, CategoryOutput> {
    public CategoryMapper() {
        super(Category.class, CategoryInput.class, CategoryOutput.class);
    }
}
