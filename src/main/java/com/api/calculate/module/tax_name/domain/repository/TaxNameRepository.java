package com.api.calculate.module.tax_name.domain.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.api.calculate.module.tax_name.domain.entity.TaxName;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;

@Repository
public interface TaxNameRepository extends GenericRepository<TaxName, UUID> {
   TaxName findByName(String name);
}
