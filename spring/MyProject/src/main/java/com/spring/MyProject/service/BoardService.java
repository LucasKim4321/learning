package com.spring.MyProject.service;

import com.spring.MyProject.dto.*;
import com.spring.MyProject.entity.Board;

import java.util.List;
import java.util.stream.Collectors;

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

    // 6. 댓글의 숫자를 처리하는 인터페이스 : 조회 결과를 List구조에 저장 및 페이징 처리
    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);

    // 7. 게시글의 이미지와 댓글의 숫자 처리
    PageResponseDTO<BoardListAllDTO> listWithAll(PageRequestDTO pageRequestDTO);

    // 8. DTO -> Entity : List<String> fileName -> Board에서 Set<boardImage> 타입으로 변환
    default Board dtoToEntity(BoardDTO boardDTO) {
        
        // getter DTO -> setter Entity -> DB table 저장
        Board board = Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .email(boardDTO.getEmail())
                .build();

        // 첨부파일이 있을 경우  // imageSet에 추가
        if (boardDTO.getFileNames() != null) {
            boardDTO.getFileNames().forEach(fileName -> {
                String[] arr = fileName.split("_");  // 첨부파일 이름 구성 : "UUID값" + "_" + "파일이름.확장자"
                board.addImage(arr[0], arr[1]);  // [0]UUID [1]파일이름
            });
        }

        return board;

    } // end dtoToEntity

    // 9. Entity -> DTO : 조회 기능
    default BoardDTO entityToDTO (Board board) {

        // getter Entity -> setter DTO
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .email(board.getEmail())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .build();

        List<String> fileNames = board.getImageSet()
                .stream()
                .sorted()
                .map(boardImage -> boardImage.getUuid()+"_"+boardImage.getFileName())
                .collect(Collectors.toList());

        boardDTO.setFileNames(fileNames);

        return boardDTO;

    } // end entityToDTO

} // end class
