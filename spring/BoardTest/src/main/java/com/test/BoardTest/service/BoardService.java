package com.test.BoardTest.service;

import com.test.BoardTest.dto.BoardDTO;
import com.test.BoardTest.dto.PageRequestDTO;
import com.test.BoardTest.dto.PageResponseDTO;
import com.test.BoardTest.entity.Board;

public interface BoardService {

    // 1. 게시글 등록 서비스 인터페이스
    long register(BoardDTO boardDTO);

    // 2. 게시글 조회
    BoardDTO readOne (Long bno);

    // 3. 게시글 수정
    Board modify(BoardDTO boardDTO);

    // 4. 게시글 삭제
    void remove(Long bno);

    // 5. 게시글 목록 : 페이징 처리를 한 게시글 목록
    PageResponseDTO<BoardDTO> list (PageRequestDTO pageRequestDTO);  // 반환값에 따라 실제 PageResponseDTO의 dtoList 타입이 달라짐

}
