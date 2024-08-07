package com.spring.MyProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.MyProject.entity.Board;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//exclude를 하지 않으면 board가 ToString가지고 있을 시 board도 ToString해서 읽어옴
@ToString(exclude = "bno")  // Board Entity에 존재하는 toString()은 작동 중지
//@ToString
public class ReplyDTO {
    // spring-boot-starter-validation: 서버 유효성 검사 라이브러리

    private Long rno;
    @NotNull
    private Long bno;  // 댓글의 부모
//    private Board board;  // 댓글의 부모글 번호와 연동
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replyer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    @JsonFormat
    private LocalDateTime modDate;

}


/*
@JsonIgnore, @JsonIgnoreProperties, @JsonIgnoreType 이러한 주석은 JSON 직렬화, 역직렬화에서
속성을 무시하는데 사용됩니다.

@JsonIgnore 어노테이션은 클래스의 속성(필드, 멤버변수) 수준에서 사용되고
@JsonIgnoreProperties 어노테이션은 클래스 수준(클래스 선언 바로 위에)에 사용됩니다.
@JsonIgnoreType 어노테이션은 클래스 수준에서 사용되며 전체 클래스를 무시합니다.

 */