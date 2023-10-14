package com.api.calculate.module.tax.application.service;

import java.util.UUID;

import jakarta.annotation.Resource;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.calculate.module.tax.domain.entity.Tax;
import com.api.calculate.module.tax.domain.repository.TaxRepository;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;
import com.api.calculate.shared.core.generic.crud.service.GenericService;

@Service
public class TaxService extends GenericService<Tax> {
    @Resource
    private TaxRepository taxRepository;

    public TaxService(GenericRepository<Tax, UUID> repository) {
        super(repository);
    }

    public List< Tax > getTaxByTaxNameID( UUID taxNameID ) {
        return taxRepository.findByTaxNameIdOrderByDataAsc( taxNameID );
    }

}
