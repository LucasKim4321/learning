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

    private Long rno;
    @NotNull
    private Long bno;  // 댓글의 부모
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replyer;
    private LocalDateTime regDate, modDate;

}
