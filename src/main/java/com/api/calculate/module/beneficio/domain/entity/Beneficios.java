package com.api.calculate.module.beneficio.domain.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.api.calculate.shared.core.generic.model.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "beneficios")
public class Beneficios implements GenericEntity {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

    @NotEmpty
    private String name;

    @NotNull
	private boolean salario13;

    @NotNull
	private String[] inacumulavel;

	private boolean dif;
}
