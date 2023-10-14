package com.api.calculate.module.calcule.application.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//essa classe não é uma entidade no banco
//Só tem o @Entity e @Id para o entityManagerFactory fazer o mapeamento dela de forma automático
public class TaxThoughtLine {

    @Id
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Id
    private String name;


    @Id
    private double percentual;
}
