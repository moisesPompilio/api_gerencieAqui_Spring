package com.api.calculate.module.salarioMinimo.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.module.salarioMinimo.application.models.SalarioMinimoInput;
import com.api.calculate.module.salarioMinimo.application.models.SalarioMinimoMapper;
import com.api.calculate.module.salarioMinimo.application.models.SalarioMinimoOutput;
import com.api.calculate.module.salarioMinimo.application.service.SalarioMinimoService;
import com.api.calculate.module.salarioMinimo.domain.entity.SalarioMinimo;
import com.api.calculate.shared.core.generic.crud.controller.BasicController;

@RestController
@RequestMapping("/salariominimo")
public class SalarioMinimoController extends BasicController<SalarioMinimo, SalarioMinimoInput, SalarioMinimoOutput> {

    @Autowired
    public SalarioMinimoController(SalarioMinimoService service, SalarioMinimoMapper mapper) {
        super(service, mapper);
    }

}
