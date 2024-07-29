package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("board data 생성")
    public void testCreateBoard() {
        IntStream.rangeClosed(1,50).forEach(i-> {
            Board board = Board.builder()
                    .title("title"+i)
                    .content("content"+i)
                    .writer("user"+(i%10))
                    .build();
            Board result = boardRepository.save(board);
            log.info("==> Bno: "+result.getBno());
        });
    }

    @Test
    @DisplayName("board data 조회")
    public void testSelectBoard() {
        // data 생성 후 조회 할 글번호 읽어와서 조회 작업
        this.testCreateBoard();  // H2DB로 테스트 후 자동 삭제되서 매번 생성 해줘야함

        Long bno = 50L;

        // Optional : null을 허용하는 wrapper형식의 클래스
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();  // orElseThrow() : Optional 객체의 유무를 판단하고 예외를 처리하기 위해 사용

        log.info("==> findBy(): 50 : "+ board);
    }


    @Test
    @DisplayName("board data 조회")
    public void testModifyBoard() {
        // data 생성 후 수정 할 글번호 읽어와서 수정 작업
        this.testCreateBoard();  // H2DB로 테스트 후 자동 삭제되서 매번 생성 해줘야함

        Long bno = 49L;

        // 1. 수정할 내용 조회
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();  // orElseThrow() : Optional 객체의 유무를 판단하고 예외를 처리하기 위해 사용

        // 2. 정할 내용 엔티티에 반영
        board.change("updated"+board.getTitle(), "updated"+board.getContent());

        // 3. 저장
        Board savedBaord = boardRepository.save(board);
        log.info("==> update: "+savedBaord);
    }


    @Test
    @DisplayName("board data 삭제")
    public void testDeleteBoard() {
        // data 생성 후 삭제 할 글번호 읽어와서 삭제 작업
        this.testCreateBoard();  // H2DB로 테스트 후 자동 삭제되서 매번 생성 해줘야함

        Long bno = 45L;

        boardRepository.deleteById(bno);
        Optional<Board> result = boardRepository.findById(bno);
//        Board board = result.orElseThrow();  // orElseThrow() : Optional 객체의 유무를 판단하고 예외를 처리하기 위해 사용
//        orElse(존재하지 않을 경우(null)이면 처리할 내용 기술)

//        orElseThrow(존재하지 않을 경우(null)이면 처리할 예외처리 기술)
//        Board board = result.orElseThrow(IllegalAccessException::new);
//        optional 타입객체
//        if(result.isEmpty())  // 경과 값이 존재하지 않으면(null)이면 처리
//            log.info("=> 없는 글번호");
//        else log.info(result);


    }

    //---------------//
    //   페이징 처리
    //---------------//

    @Test
    @DisplayName("ssearch and paging 테스트")
    public void testSearch() {
        // data 생성 후 삭제 할 글번호 읽어와서 삭제 작업
        this.testCreateBoard();  // H2DB로 테스트 후 자동 삭제되서 매번 생성 해줘야함

        // pageNumber 0이 1페이지
        Pageable pageable = PageRequest.of(1,5, Sort.by("bno"));
        log.info("==> pageable: "+pageable);

        Page<Board> result = boardRepository.search(pageable);
        log.info("==> result: "+result);
        result.getContent().forEach(board->log.info("==> result list: "+board));

        List<Board> result2 = boardRepository.search(pageable).getContent();
        result2.forEach(board->log.info("==> result2 list: "+board));
    }

    @Test
    @DisplayName("search keyword and paging 테스트")
    public void testSearchAll() {
        // data 생성 후 삭제 할 글번호 읽어와서 삭제 작업
        this.testCreateBoard();  // H2DB로 테스트 후 자동 삭제되서 매번 생성 해줘야함

        // paging 정보  pageNumber: 현재 페이지를 설정(실제 만들어진 페이지를 초과하면 각종 오류발생)
        Pageable pageable = PageRequest.of(2,5, Sort.by("bno"));
        log.info("==> pageable: "+pageable);

        // 키워드, 타입
        String[] types= {"t","c","w"};
        String keyword = "1";

        Page<Board> result3 = boardRepository.searchAll(types, keyword, pageable);
        log.info("==> result3: "+result3);
        log.info("==> result3.getContent(): "+result3.getContent());  // 현재 페이지의 내용물(content)가 나옴
        result3.getContent().forEach(board->log.info("==> result3 list: "+board));

        log.info("==> paging info");
        log.info("==> 총페이지: "+result3.getTotalPages());
        log.info("==> 페이지 사이즈: "+result3.getSize());
        log.info("==> 현재페이지: "+result3.getNumber());
        log.info("==> 이전페이지: "+result3.hasPrevious());
        log.info("==> 다음페이지: "+result3.hasNext());

        // 비교판단 Assert  junit라이브러리
        // AssertThat(result3.hasPrevious()).isEqualTo(0);
    }
}

 /** Pageable설정 PageRequest
 Creates a new PageRequest with sort parameters applied.
 Params: pageNumber – zero-based page number, must not be negative.
         pageSize – the size of the page to be returned, must be greater than 0.
         sort – must not be null, use Sort. unsorted() instead.

protected PageRequest(int pageNumber, int pageSize, Sort sort) {

    super(pageNumber, pageSize);

    Assert.notNull(sort, "Sort must not be null");

    this.sort = sort;
}

public static PageRequest of(int pageNumber, int pageSize) {
    return of(pageNumber, pageSize, Sort.unsorted());
}
  */
