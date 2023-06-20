package com.api.gerencieAqui.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerencieAqui.application.models.input.ProductInput;
import com.api.gerencieAqui.application.models.mapper.ProductMapper;
import com.api.gerencieAqui.application.models.output.ProductOutput;
import com.api.gerencieAqui.application.service.ProductService;
import com.api.gerencieAqui.core.generic.crud.controller.BasicController;
import com.api.gerencieAqui.domain.entities.Product;

@RestController
@RequestMapping("/product")
public class ProductController extends BasicController<Product, ProductInput, ProductOutput> {
    
    @Autowired
    public ProductController(ProductService servico, ProductMapper mapper) {
        super(servico, mapper);
    }
  
}
