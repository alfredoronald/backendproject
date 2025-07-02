package com.example.demotest.pay.model.entity;

import com.example.demotest.order.model.entity.OrderProduct;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private enum metodPay{
        TARJETA,
        PAYPAL,
        VISA,
        MASTERCARD
    };


    private enum statusPay{
        COMPLETADO,
        EN_PROCESO,
        FALLIDO
    };

    @Column(name="date_pay")
    @Temporal(TemporalType.DATE)
    private Date payDate;

    @OneToOne(mappedBy = "pay")
    private OrderProduct orderProduct;

}
