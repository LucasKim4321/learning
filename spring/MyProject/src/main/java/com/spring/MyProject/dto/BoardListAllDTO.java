package com.spring.MyProject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardListAllDTO {

    private Long bno;
    private String title;
    private String writer;
    private String email;
    private LocalDateTime regDate;

    //SELECT COUNT(*) FROM reply WHERE board_bno = 1 (게시글번호)
    private Long replyCount;

    private List<BoardImageDTO> boardImages;

}
