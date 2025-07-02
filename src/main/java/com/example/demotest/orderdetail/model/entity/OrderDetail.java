package com.example.demotest.orderdetail.model.entity;

import com.example.demotest.order.model.entity.OrderProduct;
import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int amount;

    private double subtotal;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "id_order")
    private OrderProduct orderpro;
}
