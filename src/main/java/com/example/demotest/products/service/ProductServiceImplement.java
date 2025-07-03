package com.example.demotest.products.service;

import com.example.demotest.products.model.entity.Products;
import com.example.demotest.products.model.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements IProductService{

    final IProductRepository iProductRepository;

    public ProductServiceImplement(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public List<Products> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Products> findCategoryById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Optional<Products> createOrUpdateProduct(Products products) {
        Products newProducts = iProductRepository.save(products);
        return Optional.of(newProducts);
    }
}
