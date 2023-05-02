package com.api.gerencieAqui.core.generic.crud.controller;

import com.api.gerencieAqui.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.api.gerencieAqui.core.generic.crud.controller.apiannotations.GetAnnotations;
import com.api.gerencieAqui.core.generic.crud.service.GenericService;
import com.api.gerencieAqui.core.generic.mapper.GenericMapper;
import com.api.gerencieAqui.core.generic.model.DataTransferObject;
import com.api.gerencieAqui.core.generic.model.GenericEntity;

import java.util.List;

public abstract class ExceptPostPutController<
            DomainModel extends GenericEntity,
            InputModel extends DataTransferObject,
            OutputModel extends DataTransferObject>
        extends GenericController<DomainModel, InputModel, OutputModel>
        implements GetAnnotations<OutputModel>, DeleteAnnotations {

    public ExceptPostPutController(GenericService<DomainModel> service, GenericMapper<DomainModel, InputModel, OutputModel> mapper) {            
        super(service, mapper);
    }
    @Override
    public List<OutputModel> listar() {
        return super.listar();
    }

    @Override
    public OutputModel buscar(String codigo) {
        return super.buscar(codigo);
    }

    @Override
    public void excluir(String codigo) {
        super.excluir(codigo);
    }
}
