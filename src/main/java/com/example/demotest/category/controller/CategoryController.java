package com.example.demotest.category.controller;

import com.example.demotest.category.model.entity.Category;

import com.example.demotest.category.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    final ICategoryService categoryService;


    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
       return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<?> createOtUpdate(@RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.createOrUpdateCategory(category);
        if(categoryOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se agrego una nueva categoria");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryOptional.get());
    }

}
