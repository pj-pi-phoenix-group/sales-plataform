package com.phoenix.pi.sales_platform.model.entity;


import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Product")
public class Product {
    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Product(Long productId, String description, String brand, String category, int quantity, double price, StatusEnum status) {
        this.productId = productId;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private String brand;
    private String category;
    private int quantity;
    private double price;
    private StatusEnum status;
}
