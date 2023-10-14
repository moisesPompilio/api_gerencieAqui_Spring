package com.api.calculate.module.tax.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "tax")
public class Tax implements GenericEntity {
    @Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column
	@NotNull
	private LocalDate data;

    @NotNull
    @Column( name = "tax_name_id" )
    private UUID taxNameId;

	@Column
	@NotNull
	private double percentual;
}
