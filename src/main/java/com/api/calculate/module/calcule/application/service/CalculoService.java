package com.api.calculate.module.calcule.application.service;

import java.util.List;

import com.api.calculate.module.calcule.application.models.TaxThoughtLine;

public interface CalculoService {
    List< TaxThoughtLine > getTaxThoughtLineOutput( String taxRateID );
}
