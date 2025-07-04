package com.example.demotest.products.model.repository;

import com.example.demotest.products.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Products,Long> {
    List<Products> findByCategory_Id(Long categoryId);
}
