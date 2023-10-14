package com.api.calculate.shared.core.generic.crud.service;

import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;
import com.api.calculate.shared.core.generic.model.GenericEntity;
import com.api.calculate.shared.exception.EntidadeEmUsoException;
import com.api.calculate.shared.exception.EntidadeNaoEncontradaException;
import com.api.calculate.shared.exception.IdInvalidoException;
import com.api.calculate.shared.exception.NegocioException;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class GenericService<DomainModel extends GenericEntity> {

    protected final GenericRepository<DomainModel, UUID> repository;

    public List<DomainModel> listar() {
        System.out.println(repository.findAll().get(0).toString());
        return repository.findAll();
    }

    public DomainModel buscar(String domainModelCodigo) {
        return buscarOuFalhar(domainModelCodigo);
    }

    @Transactional
    public DomainModel salvar(DomainModel domainModel) {
        try {
            return salvarERecarregar(domainModel);
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public List<DomainModel> salvarLista(List<DomainModel> listDomainModel) {
        try {
            return repository.saveAll(listDomainModel);
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public void excluir(String id) {
        try {
            repository.deleteById(UUID.fromString(id));
            repository.flush();
        } catch (EmptyResultDataAccessException ex) {
            throw new EntidadeNaoEncontradaException(id);
        } catch (DataIntegrityViolationException ex) {
            throw new EntidadeEmUsoException();
        } catch (IllegalArgumentException ex) {
            throw new IdInvalidoException(id);
        }
    }

    protected DomainModel buscarOuFalhar(String id) {
        try {
            return repository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new EntidadeNaoEncontradaException(id));
        } catch (IllegalArgumentException ex) {
            throw new IdInvalidoException(id);
        }
    }

    @Transactional
    public DomainModel recarregar(DomainModel domainModel) {
        repository.flush();
        return repository.refresh(domainModel);
    }

    @Transactional
    protected DomainModel salvarERecarregar(DomainModel domainModel) {
        return recarregar(repository.save(domainModel));
    }

}