package com.api.calculate.module.beneficio.application.models;

import java.util.UUID;

import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiosOutput implements DataTransferObject {
    private UUID id;

    private String name;

	private boolean salario13;

	private String[] inacumulavel;

	private boolean dif;
}
