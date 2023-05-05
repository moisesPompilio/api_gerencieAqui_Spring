package com.api.gerencieAqui.core.generic.crud.service;

import java.util.UUID;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import com.api.gerencieAqui.core.generic.crud.repository.GenericRepository;
import com.api.gerencieAqui.core.generic.model.GenericEntity;


public abstract class GenericServiceCache<DomainModel extends GenericEntity> extends GenericService<DomainModel> {

    public GenericServiceCache(GenericRepository<DomainModel, UUID> repositorio) {
        super(repositorio);
    }

    @Override
    @Cacheable(value = "genericCacheList", unless = "#result == null")
    public List<DomainModel> listar() {
        return super.listar();
    }
    
    @Override
    @Cacheable(value = "genericCache", key = "#id", unless = "#result == null")
    public DomainModel buscar(String id) {
        return super.buscar(id);
    }

    @CacheEvict("genericCacheList")
    @CachePut(value = "genericCache", key = "#id", unless = "#result == null")
    public DomainModel recarregar(DomainModel domainModel) {
        return super.recarregar(domainModel);
    }

    @CacheEvict(value = "genericCacheList", allEntries = true)
    public DomainModel salvar(DomainModel domainModel) {
        return super.salvar(domainModel);
    }

    
    @Caching(evict = { 
        @CacheEvict(value = "genericCache", key = "#id"), 
        @CacheEvict(value = "genericCacheList", allEntries = true)
    })
    @Override
    public void excluir(String id) {
        super.excluir(id);
    }


}