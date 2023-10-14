package com.api.calculate.module.taxRate.application.models;

import java.util.List;

import com.api.calculate.module.taxRate.domain.entity.RateTimeline;
import com.api.calculate.module.taxRate.domain.entity.TaxType;
import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxRateInput implements DataTransferObject {

    private String name;

    private TaxType type;

    private List< RateTimeline > rateTimeline;
}
