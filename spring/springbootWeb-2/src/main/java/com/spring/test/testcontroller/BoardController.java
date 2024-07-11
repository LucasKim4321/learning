package com.spring.test.testcontroller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.testcontroller.vo.ArticleVO;

@RestController
@RequestMapping("/boards")
public class BoardController {
	static Logger logger = LoggerFactory.getLogger(BoardController.class);
		
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<ArticleVO>> listArticles() {  // 요청 받으면 데이터를 가져와서 보내주는 역할

		logger.info("listArticles() 호출...");
		List<ArticleVO> list = new ArrayList<>();
		for (int i=0; i<10; i++) {
			ArticleVO vo = ArticleVO.builder()
					.articleNO(i)
					.title("제목"+i)
					.content("내용"+i)
					.writer("홍길동"+i)
					.build();
			
			list.add(vo);
		}
		
		return new ResponseEntity<List<ArticleVO>>(list, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> addArticle(@RequestBody ArticleVO articleVO) {
		ResponseEntity<String> resEntity = null;
		
		try {
			logger.info("=> addArticle() 메서드 호출...");
			logger.info("=> ArticleVO: "+articleVO);
			resEntity = new ResponseEntity("add_SUCCEEDED", HttpStatus.OK);
			
		} catch (Exception e) {
			resEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return resEntity;
	}
	
}

/* 

 REST방식 URI표현
 
 POST		추가(Create)
 GET		조회(Select)
 PUT		수정(Update)
 DELETE		삭제(Delete)
 
 /작업명/기본키+ 메서드 + 데이터
 
 작업명: 요청하는 작업의 종류
 기본키: 요청하는 작업에 해당하는 대상의 기본키
 메서드: 요청하는 기능
 데이터: 기능 수행에 필요한 JSON데이터
 
 REST로 게시판 기능
 POST	/boards+데이터		=> 글 등록
 GET	/boards/133			=> 133 글 조회
 PUT	/boards/133+데이터	=> 133 글 수정
 DELETE	/boards/133			=> 133 글 삭제
 

 */