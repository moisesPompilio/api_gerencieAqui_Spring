package com.api.calculate.module.calcule.domain.repository;

import java.util.List;

import com.api.calculate.module.calcule.application.models.TaxThoughtLine;
import com.api.calculate.module.taxRate.domain.entity.TaxRate;

public interface TaxThoughtLineDAO {
    public List< TaxThoughtLine > findByTaxRate ( TaxRate taxRate );
}
