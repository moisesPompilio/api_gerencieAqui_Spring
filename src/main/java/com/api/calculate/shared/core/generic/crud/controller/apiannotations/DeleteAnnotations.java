package com.api.calculate.shared.core.generic.crud.controller.apiannotations;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeleteAnnotations {

    @DeleteMapping("/{id}")
    void excluir(@PathVariable String id);

}
