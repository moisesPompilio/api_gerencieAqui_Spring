package com.api.gerencieAqui.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gerencieAqui.domain.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByName(String name);
}