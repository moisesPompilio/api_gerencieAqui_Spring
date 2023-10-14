package com.api.calculate.module.reajuste.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.module.reajuste.application.models.ReajusteInput;
import com.api.calculate.module.reajuste.application.models.ReajusteMapper;
import com.api.calculate.module.reajuste.application.models.ReajusteOutput;
import com.api.calculate.module.reajuste.application.service.ReajusteService;
import com.api.calculate.module.reajuste.domain.entity.Reajuste;
import com.api.calculate.shared.core.generic.crud.controller.BasicController;

@RestController
@RequestMapping("/reajuste")
public class ReajusteController extends BasicController<Reajuste, ReajusteInput, ReajusteOutput> {

    @Autowired
    public ReajusteController(ReajusteService service, ReajusteMapper mapper) {
        super(service, mapper);
    }

}