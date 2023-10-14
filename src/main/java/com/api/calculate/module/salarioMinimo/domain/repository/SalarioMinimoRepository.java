package com.api.calculate.module.salarioMinimo.domain.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.api.calculate.module.salarioMinimo.domain.entity.SalarioMinimo;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;

@Repository
public interface SalarioMinimoRepository extends GenericRepository<SalarioMinimo, UUID> {
}
