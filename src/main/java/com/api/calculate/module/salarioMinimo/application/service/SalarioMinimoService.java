package com.api.calculate.module.salarioMinimo.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.calculate.module.salarioMinimo.domain.entity.SalarioMinimo;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;
import com.api.calculate.shared.core.generic.crud.service.GenericService;

@Service
public class SalarioMinimoService extends GenericService<SalarioMinimo> {

    public SalarioMinimoService(GenericRepository<SalarioMinimo, UUID> repository) {
        super(repository);
    }

}
