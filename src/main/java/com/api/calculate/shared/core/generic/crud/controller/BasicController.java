package com.api.calculate.shared.core.generic.crud.controller;

import java.util.HashMap;
import java.util.List;

import com.api.calculate.shared.core.generic.crud.controller.apiannotations.AllApiAnnotations;
import com.api.calculate.shared.core.generic.crud.service.GenericService;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;
import com.api.calculate.shared.core.generic.model.DataTransferObject;
import com.api.calculate.shared.core.generic.model.GenericEntity;

public abstract class BasicController<DomainModel extends GenericEntity, InputModel extends DataTransferObject, OutputModel extends DataTransferObject>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements AllApiAnnotations<InputModel, OutputModel> {

    public BasicController(GenericService<DomainModel> service, GenericMapper<DomainModel, InputModel, OutputModel> mapper) {
        super(service, mapper);
    }

    @Override
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    public OutputModel buscar(String id) {
        return super.buscar(id);
    }

    @Override
    public OutputModel salvar(InputModel inputModel) {
        return super.salvar(inputModel);
    }

    @Override
    public List<OutputModel> salvarLista(List<InputModel> inputModelList){
    return super.salvarLista(inputModelList);
    }

    @Override
    public OutputModel atualizar(String id, InputModel inputModel) {
        return super.atualizar(id, inputModel);
    }

    @Override
    public OutputModel atualizarParcial(String id, HashMap<String, Object> fields) {
        return super.atualizarParcial(id, fields);
    }

    @Override
    public void excluir(String id) {
        super.excluir(id);
    }
}
