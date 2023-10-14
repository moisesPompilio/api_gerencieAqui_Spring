package com.api.calculate.module.taxRate.domain.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.api.calculate.module.taxRate.domain.entity.TaxRate;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;

@Repository
public interface TaxRateRepository extends GenericRepository<TaxRate, UUID> {
}
