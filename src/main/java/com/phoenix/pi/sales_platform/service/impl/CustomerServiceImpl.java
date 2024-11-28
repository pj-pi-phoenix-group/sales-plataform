package com.phoenix.pi.sales_platform.service.impl;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.phoenix.pi.sales_platform.dto.CustomerDto;
import com.phoenix.pi.sales_platform.dto.CustomerDtoRequest;
import com.phoenix.pi.sales_platform.dto.UpdateCustomerDto;
import com.phoenix.pi.sales_platform.exception.CustomerException;
import com.phoenix.pi.sales_platform.mappers.CustomerMapper;
import com.phoenix.pi.sales_platform.model.entity.Customer;
import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;
import com.phoenix.pi.sales_platform.repository.CustomerRepository;
import com.phoenix.pi.sales_platform.service.CustomerService;
;


@Service
public class CustomerServiceImpl implements CustomerService {
  private CustomerRepository customerRepository;
  private CustomerMapper customerMapper;

  public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }


  @Override
  public List<CustomerDto> getAllCustomersByUserId(Long userId) {
    List<Customer> customers = customerRepository.findAllByUserId(userId);
    return customers.stream()
            .map(customerMapper::toDto)
            .collect(Collectors.toList());
  }

  @Override
  public List<CustomerDto> getAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    return customers.stream()
            .map(customerMapper::toDto)
            .collect(Collectors.toList());
  }

  @Override
  public CustomerDto saveCustomer(CustomerDtoRequest customerDto) {
    Customer customer = customerMapper.toEntity(customerDto);

    if (Objects.isNull(customerDto)){
        throw new CustomerException("It cannot be null");
    }
    Customer savedCustomer = customerRepository.save(customer);
    return customerMapper.toDto(savedCustomer);
  }

  @Override
  public CustomerDto updateCustomer(Long id, UpdateCustomerDto updateCustomerDto) {
    // Check if the customer exists
    Customer existingCustomer = customerRepository.findById(id)
        .orElseThrow(() -> new CustomerException("Customer not found with ID: " + id));

    // Update the fields that are provided in UpdateCustomerDto
    if (updateCustomerDto.getName() != null) {
      existingCustomer.setName(updateCustomerDto.getName());
    }
    if (updateCustomerDto.getEmail() != null) {
      existingCustomer.setEmail(updateCustomerDto.getEmail());
    }
    if (updateCustomerDto.getPhone() != null) {
      existingCustomer.setPhone(updateCustomerDto.getPhone());
    }
    if (updateCustomerDto.getAddress() != null) {
      existingCustomer.setAddress(updateCustomerDto.getAddress());
    }
    if (updateCustomerDto.getStatus() != null) {
      existingCustomer.setStatus(updateCustomerDto.getStatus());
    }

    // Save the updated customer
    Customer updatedCustomer = customerRepository.save(existingCustomer);

    // Return the updated customer as a DTO
    return customerMapper.toDto(updatedCustomer);
  }

  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public List<CustomerDto> getAllCustomersByUserIdAndStatus(Long userId, StatusEnum status) {
    List<Customer> customers = customerRepository.findAllByUserIdAndStatus(userId, status);
    return customers.stream()
            .map(customerMapper::toDto)
            .collect(Collectors.toList());
  }
}