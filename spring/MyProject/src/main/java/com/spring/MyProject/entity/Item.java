package com.spring.MyProject.entity;

import com.spring.MyProject.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Entity 정의 : 테이블에 적용될 구조설계 정의하여 테이블과 entity 1:1 맵핑
@Table(name="Item")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
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
