package com.api.calculate.module.calcule.adapter.controller;

import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.calculate.module.calcule.application.models.TaxThoughtLine;
import com.api.calculate.module.calcule.application.service.CalculoService;

@RestController
@RequestMapping("/calculo")
public class CalculoController {
    @Resource
    private CalculoService calculoService;

    @GetMapping("/tax/{taxRateID}")
    public List< TaxThoughtLine > getTax (@PathVariable String taxRateID) {
        return calculoService.getTaxThoughtLineOutput(taxRateID);
    }

}
