package com.phoenix.pi.sales_platform.dto;

import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Valid
public class ProductDtoRequest {
    @NotNull
    private String description;
    @NotNull
    private String brand;
    @NotNull
    private String category;
    @NotNull
    @PositiveOrZero
    private int quantity;
    @PositiveOrZero
    private double price;



    @NotNull
    private StatusEnum status;

    @NotNull
    private Long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
