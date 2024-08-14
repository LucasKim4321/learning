package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

// Cart에 대한 JpaRepository
public interface CartRepository extends JpaRepository<Cart, Long> {  // JpaRepository<엔티티명, 엔티티의 기본키명>
}
