package com.example.demotest.orderdetail.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int amount;

    private double subtotal;

}
