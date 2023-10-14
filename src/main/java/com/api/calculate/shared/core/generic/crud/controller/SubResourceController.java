package com.api.calculate.shared.core.generic.crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.api.calculate.shared.core.generic.crud.service.GenericService;
import com.api.calculate.shared.core.generic.mapper.GenericMapper;
import com.api.calculate.shared.core.generic.model.DataTransferObject;
import com.api.calculate.shared.core.generic.model.FatherEntity;
import com.api.calculate.shared.core.generic.model.GenericEntity;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public abstract class SubResourceController<
        FatherModel extends FatherEntity,
        ChildModel extends GenericEntity,
        ChildInputModel extends DataTransferObject,
        ChildOutputModel extends DataTransferObject> {

    final String nomeSubRecurso;

    @Autowired
    protected GenericService<FatherModel> fatherService;

    @Autowired
    protected GenericService<ChildModel> childService;

    @Autowired
    protected GenericMapper<ChildModel, ChildInputModel, ChildOutputModel> childMapper;

    @GetMapping
    public List<ChildOutputModel> listarDomainModel(@PathVariable String id) {
        FatherModel fatherModel = fatherService.buscar(id);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.listarSubRecurso(nomeSubRecurso));
    }

    @GetMapping("/{childId}")
    public List<ChildOutputModel> buscarDomainModel(@PathVariable String id, @PathVariable String childId) {
        FatherModel fatherModel = fatherService.buscar(id);
        ChildModel childModel = childService.buscar(childId);
        return childMapper.toOutputCollection((Collection<ChildModel>) fatherModel.buscarSubRecurso(nomeSubRecurso, childModel));
    }

    @PostMapping("/{childId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void associarDomainModel(@PathVariable String id, @PathVariable String childId) {
        FatherModel fatherModel = fatherService.buscar(id);
        ChildModel childModel = childService.buscar(childId);
        fatherModel.associarSubRecurso(nomeSubRecurso, childModel);
    }

    @DeleteMapping("/{childId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void DesassociarDomainModel(@PathVariable String id, @PathVariable String childId) {
        FatherModel fatherModel = fatherService.buscar(id);
        ChildModel childModel = childService.buscar(childId);
        fatherModel.desassociarSubRecurso(nomeSubRecurso, childModel);
    }

}
