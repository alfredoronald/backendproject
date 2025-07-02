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


}
