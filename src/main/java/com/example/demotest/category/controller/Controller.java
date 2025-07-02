package com.example.demotest.category.controller;

import com.example.demotest.category.model.entity.Category;

import com.example.demotest.category.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/category")
public class Controller {

    final ICategoryService categoryService;

    public Controller(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
       return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());

    }

    @PostMapping
    public ResponseEntity<?> createOtUpdate(@RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.createOrUpdateCategory(category);
        if(categoryOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se creo el empleado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryOptional.get());
    }

}
