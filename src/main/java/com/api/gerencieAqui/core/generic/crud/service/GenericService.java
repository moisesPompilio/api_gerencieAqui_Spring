package com.api.gerencieAqui.core.generic.crud.service;

import com.api.gerencieAqui.core.generic.crud.repository.GenericRepository;
import com.api.gerencieAqui.core.generic.model.GenericEntity;
import com.api.gerencieAqui.domain.exception.EntidadeEmUsoException;
import com.api.gerencieAqui.domain.exception.EntidadeNaoEncontradaException;
import com.api.gerencieAqui.domain.exception.NegocioException;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Classe que representa um serviço REST genérico.
 *
 * @author Moises Alexandre Pompilio da osta
 */
@RequiredArgsConstructor
public abstract class GenericService<DomainModel extends GenericEntity> {

    protected final GenericRepository<DomainModel, UUID> repositorio;

    
    public List<DomainModel> listar() {
        return repositorio.findAll();
    }
    @Cacheable(value = "genericCache", key = "#domainModelCodigo", unless = "#result == null")
    public DomainModel buscar(String domainModelCodigo) {
        return buscarOuFalhar(domainModelCodigo);
    }

    @Transactional
    public DomainModel salvar(DomainModel domainModel) {
        try {
            return salvarERecarregar(domainModel);
        } catch (DataIntegrityViolationException ex){
            throw new NegocioException(ex);
        }
    }

    @CacheEvict(value = "genericCache", key = "#id")
    @Transactional
    public void excluir(String id) {
        try{
            repositorio.deleteById(UUID.fromString(id));
            repositorio.flush();
        } catch (EmptyResultDataAccessException ex){
            throw new EntidadeNaoEncontradaException(id);
        } catch (DataIntegrityViolationException ex){
            throw new EntidadeEmUsoException();
        }
    }
    @Cacheable(value = "genericCache", key = "#id", unless = "#result == null")
    private DomainModel buscarOuFalhar(String id) {
        return repositorio.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntidadeNaoEncontradaException(id));
    }

    @Transactional
    public DomainModel recarregar(DomainModel domainModel) {
        repositorio.flush();
        return repositorio.refresh(domainModel);
    }

    @Transactional
    //@CachePut(value = "genericCache", key = "#domainModel.id", unless = "#result == null")
    private DomainModel salvarERecarregar(DomainModel domainModel) {
        return recarregar(repositorio.save(domainModel));
    }   

}