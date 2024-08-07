package com.spring.MyProject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
// 쿼리 조건으로 자주 사용되는 칼럼에는 인덱스 생성하여 사용
@Table(name = "Reply",
        indexes =
                {@Index(name="idx_reply_board_bno", columnList = "board_bno")})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//exclude를 하지 않으면 board가 ToString가지고 있을 시 board도 ToString해서 읽어옴
@ToString(exclude = "board")  // Board Entity에 존재하는 toString()은 작동 중지
//@ToString
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long rno;

    // 현재 댓글의 필드명은 엔티티_필드명(PK)으로 자동으로 생성 => board_bno
    // @ManyToOne 이랑 board는 필수
    // 아래의 경우 board entity  연결은 즉시 연결이 아닌 필요시에만 연결
    @ManyToOne(fetch = FetchType.LAZY)  // fetch = FetchType.LAZY 지연 시키는 역할. 즉시 연결이 아닌 필요할 때 board를 로딩
    private Board board;  // bno가 찍힘  자동으로 FK와 PK관계를 만들어줌 // 멤버변수 이름 => board_bno
    // 컴파일 후
    // private Long board_bno; 형식으로 인식
    
    private String replyText;
    private String replyer;

    // 수정 작업을 위한 메서드 정의
    public void changeText(String text) {
        this.replyText = text;
    }

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