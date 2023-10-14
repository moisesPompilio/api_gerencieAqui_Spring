package com.api.calculate.shared.core.generic.filter;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import com.api.calculate.shared.core.generic.model.GenericEntity;

import java.util.ArrayList;

public abstract class GenericSpec<DomainModel extends GenericEntity> {

    public Specification<DomainModel> usandoFiltro(GenericFilter<DomainModel> genericFilter){
        return Specification.where((root, query, builder) -> {
            // Get nos subrecursos
            var predicates = new ArrayList<Predicate>();

            genericFilter.criarFiltro(predicates, builder, root);

            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
