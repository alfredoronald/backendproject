package com.example.demotest.category.model.entity;

import com.example.demotest.products.model.entity.Products;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    List<Products>  products;
}
