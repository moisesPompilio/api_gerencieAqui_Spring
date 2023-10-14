package com.api.calculate.module.tax.application.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

import com.api.calculate.shared.core.generic.model.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxInput implements DataTransferObject {
    @NotNull
	private LocalDate data;

    @NotNull
    private UUID taxNameId;

    @NotNull
	private double percentual;
}
