package com.spring.MyProject.service;

import com.spring.MyProject.dto.BoardDTO;
import com.spring.MyProject.dto.PageRequestDTO;
import com.spring.MyProject.dto.PageResponseDTO;
import com.spring.MyProject.entity.Board;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test@DisplayName("게시글 등록 서비스 테스트")
    public void testBoardRegisterTest() {
        log.info("==> board register bno: "+boardService.getClass().getName());

        // 게시글 더미 데이터 생성
        IntStream.rangeClosed(1,10).forEach(i-> {
            BoardDTO boardDTO = BoardDTO.builder()
                    .title("sample title"+i)
                    .content("sample content"+i)
                    .writer("userVoid"+i)
                    .build();

            Long bno = boardService.register(boardDTO);  // 정상 작동시 등록된 bno를 변수에 저장

            log.info("\n==> bno: "+bno);

        });
    }

    @Test@DisplayName("게시글 수정 서비스 테스트")
    public void testBoardModifyTest() {
        this.testBoardRegisterTest();

        log.info("\n==> board modify bno: "+boardService.getClass().getName());

        // 게시글 더미 데이터 생성
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(1L)
                .title("sample title modified")
                .content("sample content modified")
                .build();

        Board modifiedBoard = boardService.modify(boardDTO);  // 정상 작동시 등록된 bno를 변수에 저장

        // Assertions.assertThat(a).isEqualTo(b): 대상 a가 기대값 b와 같은지 확인
        Assertions.assertThat(modifiedBoard.getTitle()).isEqualTo(boardDTO.getTitle());
        Assertions.assertThat(modifiedBoard.getContent()).isEqualTo(boardDTO.getContent());
        
        // test가 일치하지 않을 경우
        Assertions.assertThat("100").isEqualTo(boardDTO.getTitle());

    }

    @Test@DisplayName("게시글 삭제 서비스 테스트")
    public void testBoardRemoveTest() {
        this.testBoardRegisterTest();

        long bno = 5L;
        boardService.remove(bno);
    }

    // 페이징 처리 List

    @Test@DisplayName("게시글 삭제 서비스 테스트")
    public void testBoardBoardListTest() {
        this.testBoardRegisterTest();

        // 더미 페이징 설정
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.list(pageRequestDTO);

        log.info("\n==> pageResponseDTO: "+pageResponseDTO);

    }

}
