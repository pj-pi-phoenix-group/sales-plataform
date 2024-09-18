package com.phoenix.pi.sales_platform.controller;

import com.phoenix.pi.sales_platform.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/v1/users")
public class UserController {

    @GetMapping
    public void test (User user){}
}
