package com.api.calculate.shared.core.generic.crud.controller.apiannotations;

public interface AllApiAnnotations<InputModel, OutputModel>
        extends GetAnnotations<OutputModel>,
        PostPutAnnotations<InputModel,OutputModel>,
        DeleteAnnotations {
}
