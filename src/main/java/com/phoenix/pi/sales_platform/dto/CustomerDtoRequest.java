package com.phoenix.pi.sales_platform.dto;

import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Valid
public class CustomerDtoRequest {
  @NotNull
  private String name;

  @NotNull
  private String email;

  @NotNull
  private String address;

  @NotNull
  private String phone;

  @NotNull
  private Long userId;

  @NotNull
  private StatusEnum status;

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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

}