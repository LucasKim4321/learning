package com.spring.MyProject.service;

import com.spring.MyProject.dto.*;
import com.spring.MyProject.entity.Board;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
        IntStream.rangeClosed(1,3).forEach(i-> {
            BoardDTO boardDTO = BoardDTO.builder()
                    .title("sample title"+i)
                    .content("sample content"+i)
                    .writer("userVoid"+i)
                    .email("test@test.com")
                    .build();

            // 첨부파일 추가
            boardDTO.setFileNames(
                    Arrays.asList(
                            UUID.randomUUID()+"_aaa.jpg",
                            UUID.randomUUID()+"_bbb.jpg",
                            UUID.randomUUID()+"_ccc.jpg"
                    )
            );

//            log.info("==> boardDTO: "+boardDTO);

            Long bno = boardService.register(boardDTO);  // 정상 작동시 등록된 bno를 변수에 저장

//            log.info("==> bno: "+bno);
//            boardDTO.getFileNames().forEach(fileName-> {
//                log.info("==> fileName: "+fileName);
//                String[] arr = fileName.split("_");
//                log.info("==> arr[0]: "+arr[0]+", arr[1]: "+arr[1]);
//            });

        }); // end forEach

    } // end test

    @Test@DisplayName("게시글 조회 서비스 테스트")
//    @Transactional@Commit
    public void testBoardBnoAndBoardImageRead() {
        this.testBoardRegisterTest();  // h2 사용시 필요
        
        Long bno = 1L;
        BoardDTO boardDTO = boardService.readOne(bno);

        log.info("==> boardDTO: "+boardDTO);

        // 이미지 첨부파일 확인
        for (String fileName : boardDTO.getFileNames()) {
            log.info("==> fileName: "+fileName);
        }

    } // end test

    @Test@DisplayName("게시글 수정 서비스 테스트")
    public void testBoardModifyTest() {
        this.testBoardRegisterTest();  // h2 사용시 필요

        log.info("==> board modify bno: "+boardService.getClass().getName());

        // 게시글 더미 데이터 생성
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(1L)
                .title("sample title modified")
                .content("sample content modified")
                .build();

        // 첨부파일 있을 경우
        boardDTO.setFileNames(
                Arrays.asList(
                        UUID.randomUUID()+"_zzz1.jpg",
                        UUID.randomUUID()+"_zzz2.jpg"
                ));  // 수정될 첨부파일을 boardDTO에 set

        Board modifiedBoard = boardService.modify(boardDTO);  // 정상 작동시 등록된 bno를 변수에 저장

        log.info("==> modifiedBoard: "+modifiedBoard);

        // test가 일치할 경우 에러 없음
        // Assertions.assertThat(a).isEqualTo(b): 대상 a가 기대값 b와 같은지 확인
        Assertions.assertThat(modifiedBoard.getTitle()).isEqualTo(boardDTO.getTitle());
        Assertions.assertThat(modifiedBoard.getContent()).isEqualTo(boardDTO.getContent());
        
        // test가 일치하지 않을 경우 에러 발생
//        Assertions.assertThat("100").isEqualTo(boardDTO.getTitle());

    } // end test

    @Test@DisplayName("게시글 삭제 서비스 테스트")
    public void testBoardRemoveTest() {
//        this.testBoardRegisterTest();  // h2 사용시 필요

        // 삭제할 게시글 번호
        long bno = 229L;

        // 댓글이 있는 게시글 삭제시 댓글 삭제도 동시에 일어나야함.
        boardService.remove(bno);

    } // end test

    // 페이징 처리 List
    @Test@DisplayName("게시글 페이징 처리된 List 서비스 테스트")
    public void testBoardBoardListTest() {
//        this.testBoardRegisterTest();  // h2 사용시 필요

        // 더미 페이징 설정
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        // 조건 검색 및 페이징 서비스
        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        log.info("==> responseDTO: "+responseDTO);

    } // end test

    // BoardListAllDTO 조회 테스트
    @Test@DisplayName("게시글, 첨부파일, 댓글, 리스트 조회 테스트")
    public void testBoardListAllDTOTest() {
//        this.testBoardRegisterTest();  // h2 사용시 필요

        // 더미 페이징 설정
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")  // 제목,내용,작성자
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        // 조건 검색 및 페이징 서비스
        PageResponseDTO<BoardListAllDTO> responseDTO = boardService.listWithAll(pageRequestDTO);

        log.info("==> responseDTO: "+responseDTO);

        List<BoardListAllDTO> dtoList = responseDTO.getDtoList();

        dtoList.forEach(boardListAllDTO-> {
            log.info("==> boardListAllDTO.getBno(): "+boardListAllDTO.getBno());
            log.info("==> boardListAllDTO.getTitle(): "+boardListAllDTO.getTitle());

            // 이미지가 있으면 처리
            if (boardListAllDTO.getBoardImages() != null) {

                for (BoardImageDTO boardImageDTO : boardListAllDTO.getBoardImages()) {
                    log.info("==> boardImageDTO: "+boardImageDTO);

                }

            } // end if

        }); // end forEach

    } // end test

} // end class
