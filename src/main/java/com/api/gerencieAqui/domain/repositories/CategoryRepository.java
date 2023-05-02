package com.api.gerencieAqui.domain.repositories;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.api.gerencieAqui.core.generic.crud.repository.GenericRepository;
import com.api.gerencieAqui.domain.entities.Category;

@Repository
public interface CategoryRepository extends GenericRepository<Category, UUID> {
    Category findByName(String name);
}