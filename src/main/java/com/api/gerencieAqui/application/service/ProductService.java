package com.api.gerencieAqui.application.service;

import org.springframework.stereotype.Service;

import com.api.gerencieAqui.core.generic.crud.service.GenericServiceCache;
import com.api.gerencieAqui.domain.entities.Product;
import com.api.gerencieAqui.domain.repositories.ProductRepository;

@Service
public class ProductService extends GenericServiceCache<Product> {

    public ProductService(ProductRepository repositorio) {
		super(repositorio);
	}    
}
