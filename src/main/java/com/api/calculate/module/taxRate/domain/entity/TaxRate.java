package com.api.calculate.module.taxRate.domain.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import com.api.calculate.shared.core.generic.model.GenericEntity;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tax_rate")
public class TaxRate implements GenericEntity {
    @Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

    @NotEmpty
    @Column( unique = true )
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "tax_type")
    @Type(PostgreSQLEnumType.class)
    private TaxType type;

    @NotNull
    @Column(columnDefinition = "jsonb", name = "rate_timeline" )
    @JdbcTypeCode(SqlTypes.JSON)
    private List< RateTimeline > rateTimeline;

}
