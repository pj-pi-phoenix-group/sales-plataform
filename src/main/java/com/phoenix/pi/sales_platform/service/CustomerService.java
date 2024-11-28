package com.phoenix.pi.sales_platform.service;

import java.util.List;

import com.phoenix.pi.sales_platform.dto.CustomerDto;
import com.phoenix.pi.sales_platform.dto.CustomerDtoRequest;
import com.phoenix.pi.sales_platform.dto.UpdateCustomerDto;
import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;

public interface CustomerService {

  List<CustomerDto> getAllCustomers();
  List<CustomerDto> getAllCustomersByUserId(Long userId);
  CustomerDto saveCustomer(CustomerDtoRequest customerDto);
  CustomerDto updateCustomer(Long id, UpdateCustomerDto updateCustomerDto);
  void deleteCustomer(Long id);
  List<CustomerDto> getAllCustomersByUserIdAndStatus(Long userId, StatusEnum status);
  
} 