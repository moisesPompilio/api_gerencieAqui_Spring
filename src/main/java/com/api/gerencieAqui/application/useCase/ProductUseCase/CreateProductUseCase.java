package com.api.gerencieAqui.application.useCase.ProductUseCase;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.gerencieAqui.application.DTO.input.InputProductDTO;
import com.api.gerencieAqui.infrastructure.repositories.ProductRepository;

public class CreateProductUseCase {
    @Autowired
    private ProductRepository productRepository;

    public void handle(InputProductDTO inputProductDTO) throws Exception{
        productRepository.save(inputProductDTO.toEntity());
    }
}
