package com.example.demotest.shoppingCart.model.entity;

import com.example.demotest.users.model.entity.Users;
import jakarta.persistence.*;

@Entity
@Table(name ="shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_user")
    private Users user;

}
