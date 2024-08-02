package com.spring.MyProject.service;

import com.spring.MyProject.dto.ReplyDTO;
import com.spring.MyProject.entity.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ReplyServiceImplTest {

    @Autowired
    private ReplyService replyService;

    @Test@DisplayName("댓글 등록")
    public void testRegisterReply() {

        Board board = Board.builder().bno(1L).build();

        // 클라이언트에 넘겨받은 값을 ReplyDTO 객체에 저장
        ReplyDTO replyDTO = ReplyDTO.builder()
                .replyText("ReplyDTO Text")
                .replyer("replyer")
                .board(board)
                .build();

        // 댓글 등록 서비스 호출하여 실행
        log.info("==> 댓글 등록: "+replyService.register(replyDTO));
    }


    @Test@DisplayName("댓글 조회")
    public void testReadReply() {

        Long rno = 1L;

        // 댓글 조회 서비스 호출하여 실행
        log.info("==> 댓글 조회: "+replyService.read(rno));
    }

}