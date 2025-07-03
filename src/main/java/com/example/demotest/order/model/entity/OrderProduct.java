package com.example.demotest.order.model.entity;

import com.example.demotest.orderdetail.model.entity.OrderDetail;
import com.example.demotest.pay.model.entity.Pay;
import com.example.demotest.products.model.entity.Products;
import com.example.demotest.users.model.entity.Users;
import jakarta.persistence.*;



import java.util.Date;
import java.util.List;

@Entity
@Table(name="order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String orderName;

    @Column(name="data_date")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    private double total;

    private enum estado{
        PENDIENTE,
        EN_PROCESO,
        ENVIADO,
        ENTREGADO,
        CANCELADO
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_user")
    private Users user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_products")
    private Products products;

    @OneToMany(mappedBy = "orderpro")
    List<OrderDetail> orderDetails;

    @OneToOne
    @JoinColumn(name = "id_pay")
    private Pay pay;

    public OrderProduct() {
    }

    public OrderProduct(Long id, String orderName, Date fecha, double total, Products products, Users user, List<OrderDetail> orderDetails, Pay pay) {
        this.id = id;
        this.orderName = orderName;
        this.fecha = fecha;
        this.total = total;
        this.products = products;
        this.user = user;
        this.orderDetails = orderDetails;
        this.pay = pay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }
}
