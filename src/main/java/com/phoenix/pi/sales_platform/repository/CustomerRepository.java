package com.phoenix.pi.sales_platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoenix.pi.sales_platform.model.entity.Customer;
import com.phoenix.pi.sales_platform.model.entity.enums.StatusEnum;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<Customer> findAllByUserId(Long userId);
  List<Customer> findAllByUserIdAndStatus(Long userId, StatusEnum status);
}
