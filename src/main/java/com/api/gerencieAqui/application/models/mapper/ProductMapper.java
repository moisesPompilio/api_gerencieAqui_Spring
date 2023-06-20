package com.api.gerencieAqui.application.models.mapper;

import org.springframework.stereotype.Component;

import com.api.gerencieAqui.application.models.input.ProductInput;
import com.api.gerencieAqui.application.models.output.ProductOutput;
import com.api.gerencieAqui.core.generic.mapper.GenericMapper;
import com.api.gerencieAqui.domain.entities.Product;

@Component
public class ProductMapper extends GenericMapper<Product, ProductInput, ProductOutput> {
    public ProductMapper() {
        super(Product.class, ProductInput.class, ProductOutput.class);
    }
}
