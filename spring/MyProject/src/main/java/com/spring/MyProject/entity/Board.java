package com.spring.MyProject.entity;

import jakarta.persistence.*;
import lombok.*;

// Entity 정의 : 테이블에 적용될 구조설계 정의하여 테이블과 entity 1:1 맵핑
@Table(name="Board")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board extends BaseEntity{  //extends BaseEntity 하면 BaseEntity에 있는 변수 여기에 추가

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)  // length = (max = 16383)
    private String content;
    @Column(length = 50, nullable = false)
    private String writer;

    // 데이터 수정하는 메서드
    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 첨부파일

}


/*
 * 스프링 계층 구조
 *
 * 1. 프레젠테이션 계층 (컨트롤러)
 *  - HTTP요청을 받고 이 요청을 비즈니스 계층으로 전송하는 역할
 *
 * 2. 비즈니스 계층 (서비스)
 *  - 모든 비즈니스 로직 처리 (서비스를 만들기 위한 로직)
 *
 * 3. 퍼시스턴스 계층 (리포지토리):Entity가 작업대상
 *  - 모든 데이터베이스 관련 로직을 처리
 * 
 * 4. 데이터베이스 (database)
 *  - 엔티티와 1:1 맵핑된 테이블은 실제 DB작업을 반영
 *
 */