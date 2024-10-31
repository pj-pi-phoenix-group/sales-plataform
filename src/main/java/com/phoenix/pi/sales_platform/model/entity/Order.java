package com.phoenix.pi.sales_platform.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id_user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "product_id_product_id")
    private Product productId;
    private int quantity;
    private Date orderDate;
}
