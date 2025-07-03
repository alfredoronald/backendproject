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

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, int cantidad, Users user) {
        this.id = id;
        this.cantidad = cantidad;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
