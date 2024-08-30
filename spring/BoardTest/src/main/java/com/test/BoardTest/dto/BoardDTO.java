package com.test.BoardTest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;

    @NotEmpty
    @Size(min=3, max=100)
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String writer;

    // 현재 로그인 사용자 ID와 게시글 작성자 ID가 동일한지 판별하기위한 항목
    @NotEmpty
    private String writerId;

    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
