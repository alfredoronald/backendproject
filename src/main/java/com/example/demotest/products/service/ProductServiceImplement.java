package com.example.demotest.products.service;

import com.example.demotest.category.model.entity.Category;
import com.example.demotest.category.model.repository.ICategoryRepo;
import com.example.demotest.products.model.entity.Products;
import com.example.demotest.products.model.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements IProductService{

    final IProductRepository iProductRepository;
    final ICategoryRepo iCategoryRepository;

    public ProductServiceImplement(IProductRepository iProductRepository, ICategoryRepo iCategoryRepository) {
        this.iProductRepository = iProductRepository;
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    public List<Products> findAll() {
        return iProductRepository.findAll();
    }


    @Override
    public Optional<Products> findProductById(Long id) {
        return iProductRepository.findById(id);
    }
    @Override
    public Optional<Products> createOrUpdateProduct(Products products) {
        if(products.getCategory()!=null){
            iCategoryRepository.save(products.getCategory());
        }
        Products newProducts = iProductRepository.save(products);
        return Optional.of(newProducts);
    }



    @Override
    public Boolean deleteProductById(Long id) {
        Optional<Products> productsOptional = findProductById(id);
        if(productsOptional.isEmpty()){
            return false;
        }else{
            iProductRepository.delete(productsOptional.get());
            return true;
        }
    }
}
