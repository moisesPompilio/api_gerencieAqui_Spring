package com.api.calculate.shared.core.generic.crud.controller;

import lombok.RequiredArgsConstructor;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.api.calculate.shared.core.generic.crud.service.GenericService;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;
import com.api.calculate.shared.core.generic.model.DataTransferObject;
import com.api.calculate.shared.core.generic.model.GenericEntity;
import com.api.calculate.shared.exception.NegocioException;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public abstract class GenericController<
        DomainModel extends GenericEntity,
        InputModel extends DataTransferObject,
        OutputModel extends DataTransferObject> {

    // @Autowired
    protected final GenericService<DomainModel> service;

    // @Autowired
    protected final GenericMapper<DomainModel, InputModel, OutputModel> mapper;

    public List<OutputModel> listar() {
        return mapper.toOutputCollection(service.listar());
    }

    public OutputModel buscar(String id) {
        DomainModel domainModel = service.buscar(id);
        return mapper.toOutput(domainModel);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public OutputModel salvar(InputModel inputModel) {
        DomainModel domainModel = mapper.toDomain(inputModel);
        domainModel = service.salvar(domainModel);
        return mapper.toOutput(domainModel);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public List<OutputModel> salvarLista(List<InputModel> inputModelList){
        List<DomainModel> domainModelList = mapper.toDomainCollection(inputModelList);
        service.salvarLista(domainModelList);
        return mapper.toOutputCollection(domainModelList);
    }

    @Transactional
    public OutputModel atualizar(String id,
                                 InputModel inputModel) {
        try {
            DomainModel domainModel = service.buscar(id);
            mapper.updateEntity(inputModel, domainModel);
            return mapper.toOutput(service.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @Transactional
    public OutputModel atualizarParcial(String id,
                                        HashMap<String,Object> fields) {
        try {
            DomainModel domainModel = service.buscar(id);
            mapper.patchEntity(fields, domainModel);
            return mapper.toOutput(service.recarregar(domainModel));
        } catch (DataIntegrityViolationException ex) {
            throw new NegocioException(ex);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(String id) {
        service.excluir(id);
    }
}
