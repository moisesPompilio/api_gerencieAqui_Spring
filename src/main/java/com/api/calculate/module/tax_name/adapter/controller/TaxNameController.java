package com.api.calculate.module.tax_name.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.module.tax_name.application.models.TaxNameInput;
import com.api.calculate.module.tax_name.application.models.TaxNameMapper;
import com.api.calculate.module.tax_name.application.models.TaxNameOutput;
import com.api.calculate.module.tax_name.application.service.TaxNameService;
import com.api.calculate.module.tax_name.domain.entity.TaxName;
import com.api.calculate.shared.core.generic.crud.controller.BasicController;

@RestController
@RequestMapping("/taxname")
public class TaxNameController extends BasicController<TaxName, TaxNameInput, TaxNameOutput> {

    @Autowired
    public TaxNameController(TaxNameService service, TaxNameMapper mapper) {
        super(service, mapper);
    }
}
