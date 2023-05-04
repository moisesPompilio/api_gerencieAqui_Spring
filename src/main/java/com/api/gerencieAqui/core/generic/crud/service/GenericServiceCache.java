package com.api.gerencieAqui.core.generic.crud.service;

import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.api.gerencieAqui.core.generic.crud.repository.GenericRepository;
import com.api.gerencieAqui.core.generic.model.GenericEntity;
import com.api.gerencieAqui.domain.exception.EntidadeEmUsoException;
import com.api.gerencieAqui.domain.exception.EntidadeNaoEncontradaException;
import com.api.gerencieAqui.domain.exception.NegocioException;
import java.util.List;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


public abstract class GenericServiceCache<DomainModel extends GenericEntity> extends GenericService<DomainModel> {

    public GenericServiceCache(GenericRepository<DomainModel, UUID> repositorio) {
        super(repositorio);
    }

    
    @CacheEvict(value = "genericCache", key = "#id")
    @Transactional
    @Override
    public void excluir(String id) {
        try {
            repositorio.deleteById(UUID.fromString(id));
            repositorio.flush();
        } catch (EmptyResultDataAccessException ex) {
            throw new EntidadeNaoEncontradaException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new EntidadeEmUsoException();
        }
    }


}