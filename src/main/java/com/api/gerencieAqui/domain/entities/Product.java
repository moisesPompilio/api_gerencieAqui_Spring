package com.api.gerencieAqui.domain.entities;



import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.api.gerencieAqui.application.DTO.input.InputProductDTO;

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
public class Product {
    
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

    @NotNull
    @Column(name = "category_id")
    private String categoryId;

    @NotNull
    @Positive
    private double price;

    public void UpdateProduct(InputProductDTO inputProductDTO){
        this.name = inputProductDTO.getName();
        this.description = inputProductDTO.getDescription();
        this.urlPhoto = inputProductDTO.getUrlPhoto();
        this.categoryId = inputProductDTO.getCategoryId();
        this.price = inputProductDTO.getPrice();
    }

}
