package com.api.calculate.module.tax.application.models;

import org.springframework.stereotype.Component;

import com.api.calculate.module.tax.domain.entity.Tax;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;

@Component
public class TaxMapper extends GenericMapper<Tax, TaxInput, TaxOutput> {

    public TaxMapper() {
        super(Tax.class, TaxInput.class, TaxOutput.class);
    }

}
