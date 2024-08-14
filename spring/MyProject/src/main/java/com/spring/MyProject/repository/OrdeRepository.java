package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdeRepository extends JpaRepository<Order, Long> {
}
