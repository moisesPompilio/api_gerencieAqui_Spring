package com.api.calculate.module.salarioMinimo.application.models;

import org.springframework.stereotype.Component;

import com.api.calculate.module.salarioMinimo.domain.entity.SalarioMinimo;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;

@Component
public class SalarioMinimoMapper extends GenericMapper<SalarioMinimo, SalarioMinimoInput, SalarioMinimoOutput> {

    public SalarioMinimoMapper() {
        super(SalarioMinimo.class, SalarioMinimoInput.class, SalarioMinimoOutput.class);
    }

}