package com.api.gerencieAqui.application.service;

import org.springframework.stereotype.Service;

import com.api.gerencieAqui.core.generic.crud.service.GenericService;
import com.api.gerencieAqui.domain.entities.Category;
import com.api.gerencieAqui.domain.repositories.CategoryRepository;

@Service
public class CategoryService extends GenericService<Category> {

    public CategoryService(CategoryRepository repositorio) {
		super(repositorio);
	}    
}
