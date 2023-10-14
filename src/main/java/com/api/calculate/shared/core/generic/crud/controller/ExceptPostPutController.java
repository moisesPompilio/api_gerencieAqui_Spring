package com.api.calculate.shared.core.generic.crud.controller;

import java.util.List;

import com.api.calculate.shared.core.generic.crud.controller.apiannotations.DeleteAnnotations;
import com.api.calculate.shared.core.generic.crud.controller.apiannotations.GetAnnotations;
import com.api.calculate.shared.core.generic.crud.service.GenericService;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;
import com.api.calculate.shared.core.generic.model.DataTransferObject;
import com.api.calculate.shared.core.generic.model.GenericEntity;

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
    public OutputModel buscar(String id) {
        return super.buscar(id);
    }

    @Override
    public void excluir(String id) {
        super.excluir(id);
    }
}
