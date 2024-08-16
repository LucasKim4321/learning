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
    private Long replyCount;

    private List<BoardImageDTO> boarImages;

}
