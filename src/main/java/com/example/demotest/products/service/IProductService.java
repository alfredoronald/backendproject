package com.example.demotest.products.service;


import com.example.demotest.products.model.entity.Products;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductService {
    /**
     * Method to find all categories
     * @return list of all saved categories
     * */

    List<Products> findAll();
    Optional<Products> findProductById(final Long id);
    Optional<Products> createOrUpdateProduct(final Products products);
    Boolean deleteProductById(final Long id);
}
