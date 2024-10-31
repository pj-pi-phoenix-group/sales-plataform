package com.phoenix.pi.sales_platform.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Product productId;
    private int quantity;
    private Date orderDate;
}
