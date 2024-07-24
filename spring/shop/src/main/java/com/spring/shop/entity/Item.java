package com.spring.shop.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.spring.shop.constant.ItemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// 엔티티: 데이터베이스의 테이블에 대응하는 클래스, JPA에서 관리
@Entity
@Table(name="item")  // name을 지정하지 않으면 class 이름과 자동으로 동일하게 설정
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {  
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // autoincrement 사용시 spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
//	@GeneratedValue(strategy=GenerationType.AUTO)  // autoincrement
	
	private Long id;						// 상품 코드
	
	@Column(nullable = false, length = 50)
	private String itemNm;					// 상품 이름
	
	@Column(name="price", nullable = false)
	private int price;						// 가격
	
	// db컬럼 정보 직접 기술
//	@Column(columnDefinition = "int not null default 0")
	@Column(nullable = false)
	private int stockNumber;				// 재고 수량
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;				// 상품상세 설명
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;	// 상품 판매 상태
	
	private LocalDate regTime;				// 등록 시간
	private LocalDateTime updateTime;		// 수정 시간
}


/* 
 * GenerationType.IDENTITY : 기본키 생성
 * GenerationType.AUTO : JPA 구현체가 자동으로 생성 전략 결정
 * GenerationType.SEQUENCE : DB 시퀸스 오브젝트를 이용한 기본키 생성 @SequenceGenerator를 사용하여 시퀸스 **
 * GenerationType.TABLE : 키 생성용 테이블에 사용, @TableGenerator필요
 */
