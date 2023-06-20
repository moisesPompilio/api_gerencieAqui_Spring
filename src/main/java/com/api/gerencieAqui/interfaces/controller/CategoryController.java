package com.api.gerencieAqui.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerencieAqui.application.models.input.CategoryInput;
import com.api.gerencieAqui.application.models.mapper.CategoryMapper;
import com.api.gerencieAqui.application.models.output.CategoryOutput;
import com.api.gerencieAqui.application.service.CategoryService;
import com.api.gerencieAqui.core.generic.crud.controller.BasicController;
import com.api.gerencieAqui.domain.entities.Category;


@RestController
@RequestMapping("/category")
public class CategoryController extends BasicController<Category, CategoryInput, CategoryOutput> {
    
    @Autowired
    public CategoryController(CategoryService servico, CategoryMapper mapper) {
        super(servico, mapper);
    }
  
}
