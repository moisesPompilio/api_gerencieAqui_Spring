package com.api.calculate.module.beneficio.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.module.beneficio.application.models.BeneficiosInput;
import com.api.calculate.module.beneficio.application.models.BeneficiosMapper;
import com.api.calculate.module.beneficio.application.models.BeneficiosOutput;
import com.api.calculate.module.beneficio.application.service.BeneficiosService;
import com.api.calculate.module.beneficio.domain.entity.Beneficios;
import com.api.calculate.shared.core.generic.crud.controller.BasicController;



@RestController
@RequestMapping("/beneficios")
public class BeneficiosController extends BasicController<Beneficios, BeneficiosInput, BeneficiosOutput> {

    @Autowired
    public BeneficiosController(BeneficiosService service, BeneficiosMapper mapper) {
        super(service, mapper);
    }

}
