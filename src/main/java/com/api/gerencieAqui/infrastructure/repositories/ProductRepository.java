package com.api.gerencieAqui.infrastructure.repositories;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gerencieAqui.domain.entities.Product;


public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}