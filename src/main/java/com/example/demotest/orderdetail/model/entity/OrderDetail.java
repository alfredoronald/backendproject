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

    public OrderDetail() {
    }

    public OrderDetail(Long id, int amount, double subtotal, OrderProduct orderpro) {
        this.id = id;
        this.amount = amount;
        this.subtotal = subtotal;
        this.orderpro = orderpro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public OrderProduct getOrderpro() {
        return orderpro;
    }

    public void setOrderpro(OrderProduct orderpro) {
        this.orderpro = orderpro;
    }
}
