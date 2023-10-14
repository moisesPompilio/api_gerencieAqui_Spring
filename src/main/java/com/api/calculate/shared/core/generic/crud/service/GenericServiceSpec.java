package com.api.calculate.shared.core.generic.crud.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;
import com.api.calculate.shared.core.generic.filter.GenericFilter;
import com.api.calculate.shared.core.generic.filter.GenericSpec;
import com.api.calculate.shared.core.generic.model.GenericEntity;

public abstract class GenericServiceSpec<
        DomainModel extends GenericEntity,
        genericFilter extends GenericFilter<DomainModel>>
        extends GenericService<DomainModel> {

    protected GenericSpec<DomainModel> genericSpec;

    public GenericServiceSpec(GenericRepository<DomainModel, UUID> repositorio, GenericSpec<DomainModel> GenericSpec) {
        super(repositorio);
        this.genericSpec = GenericSpec;
    }

    public Page<DomainModel> buscarPersonalizado(GenericFilter genericFilter, Pageable pageable) {
        return repository.findAll(genericSpec.usandoFiltro(genericFilter), pageable);
    }

}
