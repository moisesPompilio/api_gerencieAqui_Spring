package com.api.gerencieAqui.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerencieAqui.application.DTO.input.InputCategoryDTO;
import com.api.gerencieAqui.application.DTO.mapper.CategoryMapper;
import com.api.gerencieAqui.application.DTO.output.OutputCategory;
import com.api.gerencieAqui.application.service.CategoryService;
import com.api.gerencieAqui.core.generic.crud.controller.BasicController;
import com.api.gerencieAqui.domain.entities.Category;


@RestController
@RequestMapping("/CategoryGeneric")
public class CategoryControllerGeneric extends BasicController<Category, InputCategoryDTO, OutputCategory> {
    
    @Autowired
    public CategoryControllerGeneric(CategoryService servico, CategoryMapper mapper) {
        super(servico, mapper);
    }
  
}
