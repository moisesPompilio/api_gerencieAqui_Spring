package com.api.calculate.module.beneficio.application.models;

import org.springframework.stereotype.Component;

import com.api.calculate.module.beneficio.domain.entity.Beneficios;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;


@Component
public class BeneficiosMapper extends GenericMapper<Beneficios, BeneficiosInput, BeneficiosOutput> {

    public BeneficiosMapper() {
        super(Beneficios.class, BeneficiosInput.class, BeneficiosOutput.class);
    }

}
