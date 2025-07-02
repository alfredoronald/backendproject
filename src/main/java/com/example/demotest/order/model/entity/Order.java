package com.example.demotest.order.model.entity;

import com.example.demotest.products.model.entity.Products;
import com.example.demotest.users.model.entity.Users;
import jakarta.persistence.*;



import java.util.Date;

@Entity
@Table(name="order")
public class Order {
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


}
