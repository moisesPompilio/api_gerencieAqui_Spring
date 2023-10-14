package com.api.calculate.module.salarioMinimo.application.models;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalarioMinimoInput implements DataTransferObject {
    @NotNull
	private LocalDate data;
    @NotNull
	private float valor;
}
