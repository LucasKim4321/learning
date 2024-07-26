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

}
