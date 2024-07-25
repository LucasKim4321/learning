package com.spring.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{ // 테이블 이름, 기본키
	
	List<Item> findByItemNm(String itemNm);
	
}

/* 
 * JpaRepository 지원하는 메서드 (기본적으로 들어있는 기능)
 * <S extends T> save(S entity) : 저장 및 수정
 * void delete(t entity) : 삭제
 * count() : 총 개수 반환
 * Iterable<T> findAll() : 모든 엔티티 조회
 * 
 * find+(엔티티이름) +By + 변수(필드)명
 * 
 */
 