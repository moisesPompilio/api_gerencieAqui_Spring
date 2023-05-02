package com.api.gerencieAqui.application.useCase.CategoryUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.api.gerencieAqui.application.DTO.input.InputCategoryDTO;
import com.api.gerencieAqui.application.useCase.CategoryUseCase.Error.DuplicateCategoryException;
import com.api.gerencieAqui.domain.entities.Category;
import com.api.gerencieAqui.domain.repositories.CategoryRepository;

@Service
public class CreateCategoryUseCase {
    @Autowired
    private CategoryRepository categoryRepository;

    public void handle(InputCategoryDTO inputCategoryDTO) throws Exception{
        Category category = inputCategoryDTO.toEntity();
        try {
            categoryRepository.save(category);
        } catch (DataAccessException e) {
            if (categoryRepository.findByName(inputCategoryDTO.getName()) != null) {
                throw new DuplicateCategoryException("name", inputCategoryDTO.getName());
            }
            throw new Exception("Error while saving category to database", e);
        }
    }
}
