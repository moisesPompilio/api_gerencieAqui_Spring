package com.api.calculate.shared.core.generic.crud.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.api.calculate.module.tax_name.domain.entity.TaxName;

import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository <T, ID> extends CustomJpaRepository<T, ID>,
        JpaSpecificationExecutor<T> {

    Optional<T> findById(ID id);

    // Optional<T> findByCodigo(String codigo);

    // void deleteByCodigo(String codigo);

}
