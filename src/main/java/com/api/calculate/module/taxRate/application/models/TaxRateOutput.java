package com.api.calculate.module.taxRate.application.models;

import java.util.List;
import java.util.UUID;

import com.api.calculate.module.taxRate.domain.entity.RateTimeline;
import com.api.calculate.module.taxRate.domain.entity.TaxType;
import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxRateOutput implements DataTransferObject {
    private UUID id;

    private String name;

    private TaxType type;

    private List< RateTimeline > rateTimeline;
}
