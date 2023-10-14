package com.api.calculate.shared.core.generic.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

// Comentários: Anotação que informa ao Spring para não instanciar uma implementação
// Para este repositório
@NoRepositoryBean
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID> {

//    List<T> buscarPersonalizado(ParametrosBusca<T> parametrosBusca);

    T refresh(T t);

    void detach(T entity);

}
