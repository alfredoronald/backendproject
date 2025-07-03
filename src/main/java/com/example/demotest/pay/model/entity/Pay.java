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

    public Pay() {
    }

    public Pay(Date payDate, OrderProduct orderProduct, Long id) {
        this.payDate = payDate;
        this.orderProduct = orderProduct;
        this.id = id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }
}
