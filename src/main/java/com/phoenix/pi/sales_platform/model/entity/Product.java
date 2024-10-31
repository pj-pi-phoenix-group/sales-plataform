package com.phoenix.pi.sales_platform.model.entity;


import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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
