package com.api.calculate.module.taxRate.application.models;

import org.springframework.stereotype.Component;

import com.api.calculate.module.taxRate.domain.entity.TaxRate;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;

@Component
public class TaxRateMapper extends GenericMapper<TaxRate, TaxRateInput, TaxRateOutput> {

    public TaxRateMapper() {
        super(TaxRate.class, TaxRateInput.class, TaxRateOutput.class);
    }

    // @Override
    // public TaxRateOutput toOutput(TaxRate domainModel) {
    //     TaxRateOutput output = modelMapper.map(domainModel, TaxRateOutput.class);
    //     output.setRateTimeline(domainModel.getRateTimeline());
    //     return output;
    // }

}
