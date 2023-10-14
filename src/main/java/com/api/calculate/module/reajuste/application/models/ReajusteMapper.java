package com.api.calculate.module.reajuste.application.models;

import org.springframework.stereotype.Component;

import com.api.calculate.module.reajuste.domain.entity.Reajuste;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;

@Component
public class ReajusteMapper extends GenericMapper<Reajuste, ReajusteInput, ReajusteOutput> {

    public ReajusteMapper() {
        super(Reajuste.class, ReajusteInput.class, ReajusteOutput.class);
    }

}
