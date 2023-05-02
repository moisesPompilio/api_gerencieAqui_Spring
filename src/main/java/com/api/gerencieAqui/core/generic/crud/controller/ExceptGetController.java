package com.api.gerencieAqui.core.generic.crud.controller;

import com.api.gerencieAqui.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.api.gerencieAqui.core.generic.crud.controller.apiannotations.PostPutAnnotations;
import com.api.gerencieAqui.core.generic.crud.service.GenericService;
import com.api.gerencieAqui.core.generic.mapper.GenericMapper;
import com.api.gerencieAqui.core.generic.model.DataTransferObject;
import com.api.gerencieAqui.core.generic.model.GenericEntity;

import java.util.HashMap;

public abstract class ExceptGetController<
            DomainModel extends GenericEntity,
            InputModel extends DataTransferObject,
            OutputModel extends DataTransferObject>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements PostPutAnnotations<InputModel,OutputModel>, DeleteAnnotations {

    public ExceptGetController(GenericService<DomainModel> service, GenericMapper<DomainModel, InputModel, OutputModel> mapper) {            
        super(service, mapper);
    }
    @Override
    public OutputModel salvar(InputModel inputModel) {
        return super.salvar(inputModel);
    }

    @Override
    public OutputModel atualizar(String codigo, InputModel inputModel) {
        return super.atualizar(codigo, inputModel);
    }

    @Override
    public OutputModel atualizarParcial(String codigo, HashMap<String, Object> fields) {
        return super.atualizarParcial(codigo, fields);
    }

    @Override
    public void excluir(String codigo) {
        super.excluir(codigo);
    }
}
