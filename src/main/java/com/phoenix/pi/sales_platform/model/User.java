package com.phoenix.pi.sales_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String number;
    private String email;
    private String password;
}
