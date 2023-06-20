package com.api.gerencieAqui.domain.repositories;
import java.util.UUID;
import com.api.gerencieAqui.core.generic.crud.repository.GenericRepository;
import com.api.gerencieAqui.domain.entities.Product;


public interface ProductRepository extends GenericRepository<Product, UUID> {
    
}