package com.api.calculate.module.beneficio.domain.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.api.calculate.module.beneficio.domain.entity.Beneficios;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;

@Repository
public interface BeneficiosRepository extends GenericRepository<Beneficios, UUID> {
}