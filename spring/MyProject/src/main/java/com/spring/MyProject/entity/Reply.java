package com.spring.MyProject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")  // Board Entity에 존재하는 toString()은 작동 중지
public class Reply {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long rno;
    // board entity  연결은 즉시 연결이 아닌 필요시에만 연결
    @ManyToOne(fetch = FetchType.LAZY)  // fetch = FetchType.LAZY 지연 시키는 역할. 필요할 때 board를 로딩
    private Board board;  // bno가 찍힘  자동으로 FK와 PK관계를 만들어줌
    
    private String replyText;
    private String replyer;

}


/*
 * 연관관계 : JPA 연관 관계 판단 기준
 * - 연관 관계의 기준은 항상 변화가 많은 쪽을 기준으로 결정
 * - ERD의 FK를 기준으로 결정
 *
 * Board Entity  <->  Reply Entity        => 1:n
 * 게시글                  댓글
 *
 * 글번호 PK               글번호 PK
 * 작성자                  부모글 번호 FK
 * 글제목                  댓글 내용
 * 글내용                  댓글 작성자
 * 작성일자                댓글 작성일자
 * 수정일자                댓글 수정일자
 *
 */