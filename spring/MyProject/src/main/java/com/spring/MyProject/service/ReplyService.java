package com.spring.MyProject.service;

import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.dto.ReplyDTO;
import com.spring.MyProject.entity.Board;
import com.spring.MyProject.entity.Reply;

public interface ReplyService {

    // 1. 댓글 등록
    Long register (ReplyDTO replyDTO);

    // 2. 댓글 조회
    ReplyDTO read (Long rno);

    // 3. 댓글 수정
    void modify (ReplyDTO replyDTO);

    // 4. 댓글 삭제
    void remove (Long rno);

    // 5. 댓글 목록(페이징 기능이 있는 List)
    PageResponseDTO<ReplyDTO> getListBoard (Long bno, PageRequestDTO requestDTO);

    // 원래는 상속자가 본체를 만들어야 하지만 업데이트 되면서 default 사용하면 interface에 본체를 쓰는게 가능
    // ReplyDTO -> Entity : Board entity 객체 처리
    default Reply dtoToEntity(ReplyDTO replyDTO) {
        // DTO에 있는 게시글 bno -> board 객체를 생성
        Board board = Board.builder().bno(replyDTO.getBno()).build();

        Reply reply = Reply.builder()
                .replyText(replyDTO.getReplyText())
                .replyer(replyDTO.getReplyer())
                .board(board)
                .build();

        return reply;
    }

    // Entity -> ReplyDTO : Board  객체 **
    default ReplyDTO entityToDTO (Reply reply) {

        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .replyText(reply.getReplyText())
                .replyer(reply.getReplyer())
                .bno(reply.getBoard().getBno())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return replyDTO;
    }

}
