package com.spring.MyProject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    // spring-boot-starter-validation: 서버 유효성 검사 라이브러리

    private Long rno;
    @NotNull
    private Long bno;  // 댓글의 부모
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replyer;
    private LocalDateTime regDate, modDate;

}
