package com.api.calculate.module.tax_name.application.models;

import org.springframework.stereotype.Component;

import com.api.calculate.module.tax_name.domain.entity.TaxName;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;

@Component
public class TaxNameMapper extends GenericMapper<TaxName, TaxNameInput, TaxNameOutput> {

    public TaxNameMapper() {
        super(TaxName.class, TaxNameInput.class, TaxNameOutput.class);
    }

}
