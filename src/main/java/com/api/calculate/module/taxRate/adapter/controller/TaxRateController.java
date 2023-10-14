package com.api.calculate.module.taxRate.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.module.taxRate.application.models.TaxRateInput;
import com.api.calculate.module.taxRate.application.models.TaxRateMapper;
import com.api.calculate.module.taxRate.application.models.TaxRateOutput;
import com.api.calculate.module.taxRate.application.service.TaxRateService;
import com.api.calculate.module.taxRate.domain.entity.TaxRate;
import com.api.calculate.shared.core.generic.crud.controller.BasicController;

@RestController
@RequestMapping("/taxrate")
public class TaxRateController extends BasicController<TaxRate, TaxRateInput, TaxRateOutput> {

    @Autowired
    public TaxRateController(TaxRateService service, TaxRateMapper mapper) {
        super(service, mapper);
    }
}
