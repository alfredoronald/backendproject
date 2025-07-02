package com.example.demotest.category.service;

import com.example.demotest.category.model.entity.Category;
import com.example.demotest.category.model.repository.ICategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImple implements ICategoryService {

    final ICategoryRepo  categoryRepo;

    public CategoryServiceImple(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
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
        Category newCategory = categoryRepo.save(category);
        return Optional.of(newCategory);
    }
}
