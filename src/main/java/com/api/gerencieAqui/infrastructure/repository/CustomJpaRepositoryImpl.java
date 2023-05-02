package com.api.gerencieAqui.infrastructure.repository;

import com.api.gerencieAqui.core.generic.crud.repository.CustomJpaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;

public class CustomJpaRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID>
        implements CustomJpaRepository<T,ID>, Serializable {

    private final EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.manager = entityManager;
    }

    @Override
    public T refresh(T t) {
        manager.refresh(t);
        return t;
    }

    @Override
    public void detach(T t) {
        manager.refresh(t);
    }

//    @Override
//    public List<T> buscarPersonalizado(ParametrosBusca<T> parametrosBusca) {
//        // Inicialização
//        Class<T> tClass = parametrosBusca.getDomainClass();
//        CriteriaBuilder builder = manager.getCriteriaBuilder();
//        CriteriaQuery<T> query = builder.createQuery(tClass);
//        Root<T> root = query.from(tClass); // From Restaurante
//        var predicates = new ArrayList<Predicate>();
//
//        // Montando a query
//        parametrosBusca.criarFiltro(predicates,builder,root);
//
//        // Converte o ArrayList para Array
//        if (!predicates.isEmpty()){
//            query.where(predicates.toArray(new Predicate[0]));
//        }
//
//        // Realizando a consulta
//        TypedQuery<T> queryTipada = manager.createQuery(query);
//        return queryTipada.getResultList();
//    }

}
