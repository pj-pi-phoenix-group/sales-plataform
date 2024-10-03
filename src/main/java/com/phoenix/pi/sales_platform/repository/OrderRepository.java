package com.phoenix.pi.sales_platform.repository;

import com.phoenix.pi.sales_platform.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
