package com.api.gerencieAqui.core.generic.crud.service;

import com.api.gerencieAqui.core.generic.crud.repository.GenericRepository;
import com.api.gerencieAqui.core.generic.filter.GenericSpec;
import com.api.gerencieAqui.core.generic.filter.GenericFilter;
import com.api.gerencieAqui.core.generic.model.GenericEntity;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Classe que representa um serviço REST com filtros dinâmicos.
 *
 * @author Moises Alexandre Pompilio da osta
 */
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
        return repositorio.findAll(genericSpec.usandoFiltro(genericFilter), pageable);
    }

}
