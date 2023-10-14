package com.api.calculate.module.tax_name.application.models;

import java.util.UUID;

import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxNameOutput implements DataTransferObject {
    private UUID id;

    private String name;

    private String description;
}
