package com.phoenix.pi.sales_platform.dto;

public class UserLoginDtoRequest {
    private String email;
    private String password;

    public UserLoginDtoRequest() {
    }

    public UserLoginDtoRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}