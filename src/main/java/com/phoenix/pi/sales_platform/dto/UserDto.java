package com.phoenix.pi.sales_platform.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {

    private UUID userId;
    private String name;
    private String number;
    private String email;
    private String password;
}
