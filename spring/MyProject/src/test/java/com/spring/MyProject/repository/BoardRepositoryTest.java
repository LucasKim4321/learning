package com.spring.MyProject.repository;

import com.spring.MyProject.dto.BoardListReplyCountDTO;
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
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    @DisplayName("board data 생성")
    public void testCreateBoard() {
        // 1. 더미 생성
//        IntStream.rangeClosed(1,50).forEach(i-> {
//            Board board = Board.builder()
//                    .title("title"+i)
//                    .content("content"+i)
//                    .writer("user"+(i%10))
//                    .build();
//            Board result = boardRepository.save(board);
//            log.info("==> Bno: "+result.getBno());
//        });
        
        // 2. 이미지 포함 더미 생성
        IntStream.rangeClosed(1,20).forEach(i-> {
            Board board = Board.builder()
                    .title("title"+i)
                    .content("content"+i)
                    .writer("user"+(i%10))
                    .email("user"+(i%10)+"@gmail.com")
                    .build();

            // 새로운 첨부파일 추가
            IntStream.rangeClosed(1,3).forEach(j-> {
                // 부모객체 내에서 하위객체 생성
                // board객체에서 BoardImage 객체를 생성
                board.addImage(UUID.randomUUID().toString(), "file"+i+"-"+j+".jpg");
            });

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


    // 조건 검색 결과에 대한 댓글 개수
    @Test@DisplayName("검색 결과에 대한 댓글 개수 테스트")
    public void testSearchReplyCount() {

        // given
        Pageable pageable = PageRequest.of(0,5, Sort.by("bno").descending());

        // 키워드, 타입
        String[] types= {"t","c","w"};
        String keyword = "1";

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);

        log.info("==> total page: "+result.getTotalPages());
        log.info("==> page size: "+result.getSize());
        log.info("==> pageNumber: "+result.getNumber());
        log.info("==> prev: "+result.hasPrevious());
        log.info("==> next: "+result.hasNext());
        log.info("===================");
        result.getContent().forEach(board-> log.info("==> board: "+board));

    }

    // Board와 BoardImage 연관 관계 테스트

    @Test
    @DisplayName("Board save 할 시, BoardImage 자동으로 save : 영속성 전이 테스트")  // cascade 설정에 의한 상태전이 테스트
    public void testInsertWithImage() {

        // Board Entity 생성
        Board board = Board.builder()
                .title("image Test")
                .content("첨부파일테스트")
                .writer("tester")
                .email("test@test.com")
                .build();

        IntStream.rangeClosed(1,3).forEach(i-> {
            
            // 부모객체 내에서 하위객체 생성
            // board객체에서 BoardImage 객체를 생성
            board.addImage(UUID.randomUUID().toString(), "file"+i+".jpg");
        });

        // board entity 저장(영속성 컨텍스트에 반영)
        // board entity를 저장하면 board 속성중에 boardimage 객체를 보관하고 있는
        // set객체 정보를 기반으로 boardimage 객체가 자동으로 save 동장이 발생됨.
        // boardImageRepository.save(board); 묵시적으로 수행됨.
        // BoardImageRepository 미생성 시 자동 구현 및 수행.
        Board savedBoard = boardRepository.save(board);  // cascade 설정에 의해 BoardImage도 자동 저장(상태전이)
        log.info("==> savedBoard: "+savedBoard);

    }

    @Test
    @DisplayName("Boardd, BaordImage(@Transactional) 영속성 전이 테스트2")
    @Transactional
    public void testReadWithImage() {

        // @Transactional 사용시
        // 반드시 존재하는 bno로 확인
        Optional<Board> result = boardRepository.findById(84L);
        Board board = result.orElseThrow();
        log.info("==> board.getImageSet(): "+board.getImageSet());
        board.getImageSet().forEach(imgSet-> log.info("==> imgSet: "+imgSet));

        // @Transactional 미사용시 에러가 발생함.
        // board 연결하여 출력한 후 select를 다시 실행하면 DB가 연결이 끝난 상태이므로
        // 'proxy - no session' 에러 메시지가 발생
        // @Transactional 사용시 작동


    } // end testReadWithImage()

    @Test
    @DisplayName("Boardd, BaordImage(@EntityGraph) 영속성 전이 테스트2")
    public void testReadWithImage2() {

        // @EntityGraph 사용 시 BoardRepository에 추가 설정
        Optional<Board> result2 = boardRepository.findByIdWithImages(84L);
        Board board2 = result2.orElseThrow();
        log.info("==> board.getImageSet(): "+board2.getImageSet());
        board2.getImageSet().forEach(imgSet-> log.info("==> imgSet: "+imgSet));

    } // end testReadWithImage2()

    @Test
    @DisplayName("Board, BaordImage(orphanRemoval) 고아객체 테스트")
    @Transactional@Commit
    public void testImage() {

        // 게시물 가져오기
        Optional<Board> result = boardRepository.findByIdWithImages(83L);
        Board board = result.orElseThrow();
        log.info("==> board.getImageSet(): "+board.getImageSet());

        // 기존 게시물에 첨부파일들 삭제:
        // 1. orphanRemoval = true 설정하지 않을 경우: null 값으로 업데이트 기능 처리됨.
        // 2. orphanRemoval = true 설정 경우: null값이 존재하는 고아객체 제거됨.
        board.clearImage();

        // 새로운 첨부파일 추가
        IntStream.rangeClosed(28,29).forEach(i-> {
            // 부모객체 내에서 하위객체 생성
            // board객체에서 BoardImage 객체를 생성
            board.addImage(UUID.randomUUID().toString(), "file"+i+".jpg");
        });

        Board savedBoard = boardRepository.save(board);  // cascade 설정에 의해 BoardImage도 자동 저장(상태전이)
        log.info("==> savedBoard: "+savedBoard);

        board.getImageSet().forEach(imgSet-> log.info("==> imgSet: "+imgSet));

    }

    // 고아객체 삭제 테스트
//    @Test
//    @DisplayName("Boardd, BaordImage 고아객체삭제")
//    public void removeBoardImagesBoardIsNull() {
//        boardRepository.deleteBoardImageIs(null);
//    }


    @Test
    @DisplayName("특정 게시글에 대한 댓글 삭제 테스트")
    @Transactional@Commit
    public void testBoardReplyRemoveAll(){
        Long bno = 83L;

        // Reply 존재하는 경우 댓글 삭제 -> BoardImage 삭제(imageSet.clear())-> Board 삭제
        // 2. 댓글 삭제
        replyRepository.deleteByBoard_Bno(bno);

        // 3. 게시글 삭제
        boardRepository.deleteById(bno);

    }

    @Test
    @DisplayName("특정 게시글에 대한 댓글 조회 테스트")
    @Transactional@Commit
    public void testSearchImageReplyCount() {

        // 페이징 초기값 설정
        Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());
        boardRepository.searchWithAll(null, null, pageable);

    }



}  // end Test Class

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
