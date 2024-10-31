package com.phoenix.pi.sales_platform.repository;

import com.phoenix.pi.sales_platform.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
