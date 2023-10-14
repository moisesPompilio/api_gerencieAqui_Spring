package com.api.calculate.module.tax.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.module.tax.application.models.TaxInput;
import com.api.calculate.module.tax.application.models.TaxMapper;
import com.api.calculate.module.tax.application.models.TaxOutput;
import com.api.calculate.module.tax.application.service.TaxService;
import com.api.calculate.module.tax.domain.entity.Tax;
import com.api.calculate.shared.core.generic.crud.controller.BasicController;

@RestController
@RequestMapping("/tax")
public class TaxController extends BasicController<Tax, TaxInput, TaxOutput> {

    @Autowired
    public TaxController(TaxService service, TaxMapper mapper) {
        super(service, mapper);
    }

}