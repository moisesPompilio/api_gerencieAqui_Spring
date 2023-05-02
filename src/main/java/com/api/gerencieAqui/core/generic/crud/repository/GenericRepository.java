package com.api.gerencieAqui.core.generic.crud.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository <T, ID> extends CustomJpaRepository<T, ID>,
        JpaSpecificationExecutor<T> {

    Optional<T> findById(ID id);
    
    // Optional<T> findByCodigo(String codigo);

    // void deleteByCodigo(String codigo);

}
