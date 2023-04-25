package com.api.gerencieAqui.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gerencieAqui.application.DTO.input.InputCategoryDTO;
import com.api.gerencieAqui.application.useCase.CategoryUseCase.CreateCategoryUseCase;
import com.api.gerencieAqui.application.useCase.Error.DuplicateItemException;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CreateCategoryUseCase createCategoryUseCase;

    @PostMapping
    public ResponseEntity<Object> createCategoryController(@RequestBody InputCategoryDTO inputCategoryDTO) {
        try {
            createCategoryUseCase.handle(inputCategoryDTO);
            return ResponseEntity.ok().build();
        } catch (DuplicateItemException e) {
            return e.returnResponseEntity();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.internalServerError().body("Failed to create category. Server Error");
        }
    }
}
