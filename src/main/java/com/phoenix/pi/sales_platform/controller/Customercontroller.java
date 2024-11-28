package com.phoenix.pi.sales_platform.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.pi.sales_platform.dto.CustomerDto;
import com.phoenix.pi.sales_platform.dto.CustomerDtoRequest;
import com.phoenix.pi.sales_platform.dto.UpdateCustomerDto;
import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;
import com.phoenix.pi.sales_platform.service.CustomerService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer API", description = "Endpoints for managing customer")
public class Customercontroller {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDtoRequest customerDtoRequest) {
        CustomerDto createdCustomer = customerService.saveCustomer(customerDtoRequest);
         if (!Objects.nonNull(customerDtoRequest)) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerDto updateCustomerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(id, updateCustomerDto);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}/status")
    public ResponseEntity<List<CustomerDto>> findAllByUserIdAndStatus(@PathVariable Long userId, @RequestParam StatusEnum status) {
      List<CustomerDto> customers = customerService.getAllCustomersByUserIdAndStatus(userId, status);
      return ResponseEntity.ok(customers);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CustomerDto>> findAllByUserId(@PathVariable Long userId) {
        List<CustomerDto> customers = customerService.getAllCustomersByUserId(userId);
        return ResponseEntity.ok(customers);
    }
}
