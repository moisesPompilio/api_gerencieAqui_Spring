package com.api.gerencieAqui.application.useCase.CategoryUseCase.Error;

import com.api.gerencieAqui.application.useCase.Error.DuplicateItemException;

public class DuplicateCategoryException extends DuplicateItemException {
    public DuplicateCategoryException(String fieldName, String fieldValue) {
        super(String.format("Category with %s '%s' already exists", fieldName, fieldValue));
    }
}

