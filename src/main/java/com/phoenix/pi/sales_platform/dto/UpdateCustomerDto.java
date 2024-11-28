package com.phoenix.pi.sales_platform.dto;

import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;

import jakarta.validation.Valid;

@Valid
public class UpdateCustomerDto {
  private String name;
  private String email;
  private String address;
  private String phone;
  private StatusEnum status;

  // Getters and Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  

}
