package com.api.calculate.module.tax_name.application.models;

import jakarta.validation.constraints.NotEmpty;

import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxNameInput implements DataTransferObject {
    @NotEmpty
    private String name;

    @NotEmpty
    private String description;
}