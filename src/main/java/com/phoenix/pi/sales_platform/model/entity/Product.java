package com.phoenix.pi.sales_platform.model.entity;


import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private String brand;
    private String category;
    private int quantity;
    private double price;
    private StatusEnum status;
}
