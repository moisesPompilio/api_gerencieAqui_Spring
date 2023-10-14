package com.api.calculate.module.beneficio.application.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiosInput implements DataTransferObject {
    @NotEmpty
    private String name;

    @NotNull
	private boolean salario13;

    @NotNull
	private String[] inacumulavel;

	private boolean dif;
}
