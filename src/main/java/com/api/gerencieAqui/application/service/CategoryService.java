package com.api.gerencieAqui.application.service;

import org.springframework.stereotype.Service;

import com.api.gerencieAqui.core.generic.crud.service.GenericServiceCache;
import com.api.gerencieAqui.domain.entities.Category;
import com.api.gerencieAqui.domain.repositories.CategoryRepository;

@Service
public class CategoryService extends GenericServiceCache<Category> {

    public CategoryService(CategoryRepository repositorio) {
		super(repositorio);
	}    
}
