package com.example.demotest.category.service;

import com.example.demotest.category.model.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoryService {

    /**
     * Method to find all categories
     * @return list of all saved categories
     * */

    List<Category> findAll();

    Optional<Category> findCategoryById(final Long id);
    Optional<Category> createOrUpdateCategory(final Category category);
}
