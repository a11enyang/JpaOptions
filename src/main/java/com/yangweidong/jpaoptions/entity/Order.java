package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @Column(name = "c_order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
