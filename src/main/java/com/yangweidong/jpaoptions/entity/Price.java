package com.yangweidong.jpaoptions.entity;


import javax.persistence.*;

@Entity
@Table(name = "t_price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_price_id")
    private int priceId;

    @Column(name = "c_price_number")
    private int priceNumber;


}
