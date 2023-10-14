package com.api.calculate.module.tax.domain.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.calculate.module.tax.domain.entity.Tax;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;

@Repository
public interface TaxRepository extends GenericRepository<Tax, UUID> {
    List< Tax > findByTaxNameIdOrderByDataAsc( UUID id );
}
