package com.api.calculate.module.reajuste.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.calculate.module.reajuste.domain.entity.Reajuste;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;
import com.api.calculate.shared.core.generic.crud.service.GenericService;

@Service
public class ReajusteService extends GenericService<Reajuste> {

    public ReajusteService(GenericRepository<Reajuste, UUID> repository) {
        super(repository);
    }

}
