package com.api.gerencieAqui.domain.entities;



import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.api.gerencieAqui.application.models.input.ProductInput;
import com.api.gerencieAqui.core.generic.model.GenericEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements GenericEntity {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    @NotEmpty
    private String name;

    private String description;

    @NotNull
    @NotEmpty
    private String urlPhoto;

    @Column(name = "categories_id")
    private UUID categoryId;

    @NotNull
    @Positive
    private double sale;

    @NotNull
    @Positive
    private double cost;

    public void UpdateProduct(ProductInput inputProductDTO){
        this.name = inputProductDTO.getName();
        this.description = inputProductDTO.getDescription();
        this.urlPhoto = inputProductDTO.getUrlPhoto();
        this.categoryId = inputProductDTO.getCategoryId();
        this.sale = inputProductDTO.getSale();
        this.cost = inputProductDTO.getCost();
    }

}
