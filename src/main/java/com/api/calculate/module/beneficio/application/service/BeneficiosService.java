package com.api.calculate.module.beneficio.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.calculate.module.beneficio.domain.entity.Beneficios;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;
import com.api.calculate.shared.core.generic.crud.service.GenericService;

@Service
public class BeneficiosService extends GenericService<Beneficios> {

    public BeneficiosService(GenericRepository<Beneficios, UUID> repository) {
        super(repository);
    }

}
