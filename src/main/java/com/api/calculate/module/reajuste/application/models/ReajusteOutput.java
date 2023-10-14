package com.api.calculate.module.reajuste.application.models;

import java.time.LocalDate;
import java.util.UUID;

import com.api.calculate.shared.core.generic.model.DataTransferObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReajusteOutput implements DataTransferObject {
	private UUID id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	private double reajusteAcumulado;
}
