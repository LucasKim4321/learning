package com.spring.MyProject.repository;

import com.spring.MyProject.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

// CartItem에 대한 JpaRepository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {  // JpaRepository<엔티티명, 엔티티의 기본키명>
}
