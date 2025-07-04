package com.example.demotest.products.controller;


import com.example.demotest.products.model.entity.Products;
import com.example.demotest.products.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category/products")
public class ProductController {

    final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }


    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iProductService.findAll());

    }

    @PostMapping
    public ResponseEntity<?> createOtUpdate(@RequestBody Products products) {
        Optional<Products> productsOptional = iProductService.createOrUpdateProduct(products);
        if(productsOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body("Se añadio correctamente");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productsOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return  ResponseEntity
                    .status(HttpStatus.OK)
                .body(iProductService.deleteProductById(id));
    }
}
