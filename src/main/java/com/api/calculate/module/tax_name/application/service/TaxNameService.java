package com.api.calculate.module.tax_name.application.service;

import org.springframework.stereotype.Service;

import com.api.calculate.module.tax_name.domain.entity.TaxName;
import com.api.calculate.module.tax_name.domain.repository.TaxNameRepository;
import com.api.calculate.shared.core.generic.crud.service.GenericService;

@Service
public class TaxNameService extends GenericService<TaxName> {

    private final TaxNameRepository customTaxNameRepository;

    public TaxNameService(TaxNameRepository repository) {
        super(repository);
        this.customTaxNameRepository = repository;
    }

    public TaxName getName (String name) {
        return customTaxNameRepository.findByName(name);
    }

}
