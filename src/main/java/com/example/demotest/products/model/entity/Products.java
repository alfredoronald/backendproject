package com.example.demotest.products.model.entity;


import com.example.demotest.category.model.entity.Category;
import com.example.demotest.order.model.entity.OrderProduct;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String productDescription;

    @Column(name="product_price")
    private BigDecimal productPrice;

    private int stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_category")
    private Category category;

    @OneToMany(mappedBy = "products")
    List<OrderProduct> orderProducts;

}
