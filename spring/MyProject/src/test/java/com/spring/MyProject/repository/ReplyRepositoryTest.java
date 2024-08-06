package com.spring.MyProject.repository;

import com.spring.MyProject.entity.Board;
import com.spring.MyProject.entity.Reply;
import jakarta.transaction.Transactional;
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

import java.util.Optional;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class ReplyRepositoryTest {

	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private BoardRepository boardRepository;

	@Test
	@DisplayName("board data 생성")
	public void testCreateBoard() {
		IntStream.rangeClosed(1,10).forEach(i-> {
			Board board = Board.builder()
					.title("title"+i)
					.content("content"+i)
					.writer("user"+(i%10))
					.build();
			Board result = boardRepository.save(board);
			log.info("==> Bno: "+result.getBno());
		});
	}

	@Test@DisplayName("Reply객체(댓글) 생성하기")
	public void testInsertReply() {
//		this.testCreateBoard();  // h2에서 테스트시 필요 // 전체 실행하면 필요 없음

		//  댓글 300개 생성하기
		IntStream.rangeClosed(1,300).forEach(i-> {
			// 게시글 번호 무작위 선정
			long bno = (long)(Math.random()*15)+86;

			Optional<Board> result = boardRepository.findById(bno);
			Board board = result.orElseThrow();

			// 특정 게시글에 대한 댓글 생성(특정 게시글과 댓글과 연관관계 설정 후 생성)
			Reply reply = Reply.builder()
					// board_bno 필드만 생성하여 board의 pk필드 bno값을 설정하고 join상태 설정
					// 보드의 bno값을 참조해서 만듬 bno값이 들어감  // 값을 읽어 올 수 없는 경우 생성 시 에러
					.board(board)  // .board_bno(board.getBno())
					.replyText("댓글"+i)
					.replyer("replyer"+i)
					.build();

			// DB처리
			replyRepository.save(reply);

		});

	}

	@Test@DisplayName("특정 게시글 댓글 조회 테스트")
//	@Transactional  // 하나의 작업이 두개 이상 작업해야 하는 경우 // board를 읽어올 때 한번 더 작업해야함
	public void testBoardReplies() {
		this.testCreateBoard();  // h2에서 테스트시 필요 // 전체 실행하면 필요 없음
		this.testInsertReply();  // h2에서 테스트시 필요 // 전체 실행하면 필요 없음

		Long bno = 1L;

		Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());
		Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

		log.info("==> result: "+result);
		result.getContent().forEach(reply -> {
			log.info("==> reply: "+reply);
		});
	}

}
