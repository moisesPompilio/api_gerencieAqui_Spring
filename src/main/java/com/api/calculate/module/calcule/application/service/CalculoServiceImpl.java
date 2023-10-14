package com.api.calculate.module.calcule.application.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.api.calculate.module.calcule.application.models.TaxThoughtLine;
import com.api.calculate.module.calcule.domain.repository.TaxThoughtLineDAO;
import com.api.calculate.module.taxRate.application.service.TaxRateService;
import com.api.calculate.module.taxRate.domain.entity.TaxRate;
import com.api.calculate.module.taxRate.domain.entity.TaxType;

@Service
public class CalculoServiceImpl implements CalculoService {
    @Resource
    private TaxRateService taxRateService;

    @Resource
    private TaxThoughtLineDAO taxThoughtLineDAO;

    public List< TaxThoughtLine > getTaxThoughtLineOutput( String taxRateID ) {
        TaxRate taxRate =  taxRateService.buscar(taxRateID);
        List< TaxThoughtLine > list = taxThoughtLineDAO.findByTaxRate(taxRate);
        calculateListTax(list, taxRate.getType(), null);
        return list;
    }

    public List< TaxThoughtLine > calculateListTax( List< TaxThoughtLine > list, TaxType type, LocalDate updateDate ) {
        Double tax = 0.0;
        List< TaxThoughtLine > listTax = new ArrayList<>();
        if ( updateDate == null ) {
            updateDate = LocalDate.now();
        }
        if ( type.equals(TaxType.CORRECTION) ) {
            tax = 1.0;
        }
        for ( TaxThoughtLine taxThoughtLine: list ) {
            if ( updateDate.isAfter(taxThoughtLine.getData() ) || updateDate.equals( taxThoughtLine.getData() ) ) {
                tax = type.equals(TaxType.CORRECTION) ?
                    tax * ( 1 + ( taxThoughtLine.getPercentual() / 100 ) ) :
                    tax + taxThoughtLine.getPercentual() ;
                taxThoughtLine.setPercentual(tax);
                listTax.add( taxThoughtLine);
            }
        }
        return listTax;
    }
}
