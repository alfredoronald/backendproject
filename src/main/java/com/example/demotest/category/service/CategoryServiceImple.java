package com.example.demotest.category.service;

import com.example.demotest.category.model.entity.Category;
import com.example.demotest.category.model.repository.ICategoryRepo;
import com.example.demotest.products.model.entity.Products;
import com.example.demotest.products.model.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImple implements ICategoryService {

    final ICategoryRepo  categoryRepo;
    final IProductRepository productRepository;

    public CategoryServiceImple(ICategoryRepo categoryRepo, IProductRepository productRepository) {
        this.categoryRepo = categoryRepo;
        this.productRepository = productRepository;

    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Optional<Category> createOrUpdateCategory(Category category) {
        if(category.getProducts()!=null){
            productRepository.saveAll(category.getProducts());
        }
        Category newCategory = categoryRepo.save(category);
        return Optional.of(newCategory);
    }
}
