package com.phoenix.pi.sales_platform.repository;


import com.phoenix.pi.sales_platform.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
