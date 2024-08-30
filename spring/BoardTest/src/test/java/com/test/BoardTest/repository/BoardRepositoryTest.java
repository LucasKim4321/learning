package com.test.BoardTest.repository;

import com.test.BoardTest.entity.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;


    @Test
    @DisplayName("보드 생성 테스트")
    void createBoardTest() {

        IntStream.rangeClosed(1,30).forEach(i-> {
            Board board = Board.builder()
                    .title("title"+i)
                    .content("content"+i)
                    .writer("tester")
                    .writerId("test")
                    .build();

            Board result = boardRepository.save(board);
//            log.info("==> result: "+result);
//            log.info("==> result.getWriter: "+result.getWriter());

        });

    } // end test

    @Test
    @DisplayName("보드 목록 테스트")
    void listBoardTest() {
//        this.createBoardTest(); // h2로 테스트 할 때 필요

        List<Board> list = boardRepository.findAll();

        list.stream().forEach(board-> {
            log.info("==> board: "+board);
        });

    } // end test

    @Test
    @DisplayName("보드 수정 테스트")
    void modifyBoardTest() {
        this.createBoardTest(); // h2로 테스트 할 때 필요

        Long bno = 3L;

        Board board = boardRepository.findById(bno).orElseThrow();

        board.change("updatedTitle","updatedContent");

        Board savedBoard = boardRepository.save(board);

//        log.info("==> update: "+savedBoard);
        this.listBoardTest();


    } // end test

    @Test
    @DisplayName("보드 삭제 테스트")
    void deleteBoardTest() {
        this.createBoardTest(); // h2로 테스트 할 때 필요

        Long bno = 1L;

        Board board = boardRepository.findById(bno).orElseThrow();

        boardRepository.delete(board);

        this.listBoardTest();

    } // end test

    @Test
    @DisplayName("보드 검색 테스트")
    void searchBoardTest() {
        this.createBoardTest(); // h2로 테스트 할 때 필요

        // data 생성 후 삭제 할 글번호 읽어와서 삭제 작업

        // paging 정보  pageNumber: 현재 페이지를 설정(실제 만들어진 페이지를 초과하면 각종 오류발생)
        Pageable pageable = PageRequest.of(0,5, Sort.by("bno"));
        log.info("==> pageable: "+pageable);

        // 키워드, 타입
        String[] types= {"t","c","w"};
        String keyword = "1";

        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);
        log.info("==> result: "+result);
        log.info("==> result.getContent(): "+result.getContent());  // 현재 페이지의 내용물(content)가 나옴
        result.getContent().forEach(board->log.info("==> result list: "+board));

        log.info("==> paging info");
        log.info("==> 총페이지: "+result.getTotalPages());
        log.info("==> 페이지 사이즈: "+result.getSize());
        log.info("==> 현재페이지: "+result.getNumber());
        log.info("==> 이전페이지: "+result.hasPrevious());
        log.info("==> 다음페이지: "+result.hasNext());

        // 비교판단 Assert  junit라이브러리
        // AssertThat(result3.hasPrevious()).isEqualTo(0);

    } // end test

} // end class