package com.example.demotest.users.model.entity;


import com.example.demotest.order.model.entity.OrderProduct;
import com.example.demotest.shoppingCart.model.entity.ShoppingCart;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private enum rol{
      CLIENTE,
      ADMIN,
    };

    @OneToMany(mappedBy = "user")
    List<OrderProduct> orderProducts;
    @OneToMany(mappedBy = "user")
    List<ShoppingCart> shoppingCarts;

    public Users() {
    }

    public Users(String password, String userName, Long id, List<ShoppingCart> shoppingCarts, List<OrderProduct> orderProducts) {
        this.password = password;
        this.userName = userName;
        this.id = id;
        this.shoppingCarts = shoppingCarts;
        this.orderProducts = orderProducts;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
