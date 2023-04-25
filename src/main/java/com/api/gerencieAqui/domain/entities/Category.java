package com.api.gerencieAqui.domain.entities;



import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.api.gerencieAqui.application.DTO.input.InputCategoryDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String urlPhoto;

    public Category(String name, String urlPhoto) {
        this.name = name;
        this.urlPhoto = urlPhoto;
    }
    public void UpdateCategory(InputCategoryDTO inputCategoryDTO){
        this.name = inputCategoryDTO.getName();
        this.urlPhoto = inputCategoryDTO.getUrlPhoto();
    }

}