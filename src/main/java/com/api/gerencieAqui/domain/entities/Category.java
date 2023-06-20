package com.api.gerencieAqui.domain.entities;



import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.api.gerencieAqui.application.models.input.CategoryInput;
import com.api.gerencieAqui.core.generic.model.GenericEntity;

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
public class Category implements GenericEntity {
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
    public void UpdateCategory(CategoryInput inputCategoryDTO){
        this.name = inputCategoryDTO.getName();
        this.urlPhoto = inputCategoryDTO.getUrlPhoto();
    }

}