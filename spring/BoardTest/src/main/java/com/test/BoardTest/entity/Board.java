package com.test.BoardTest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="board")
@Getter@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board extends BaseEntity{

    @Id // 기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)  // length = (max = 16383)
    private String content;
    @Column(length = 50, nullable = false)
    private String writer;

    // 현재 로그인 사용자와 게시글 작성자가 동일한지 판별하기 위한 항목
    // 이메일은 변동 가능성이 있음
    @Column(length = 50, nullable = false)
    private String writerId;

    // 데이터 수정하는 메서드
    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }

} // end class

