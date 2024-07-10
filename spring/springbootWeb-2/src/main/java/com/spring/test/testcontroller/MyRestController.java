package com.spring.test.testcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.testcontroller.vo.MemberVO;

@RestController
@RequestMapping("/restapi/*")
public class MyRestController {
	
	// 1. text/html형식 보내기
	@RequestMapping("/hello")
	public  String hello() {
		return "REST API Test";
	}
	
	// 2. vo->json형식 문자열로 변환 하여 보내기
	@RequestMapping("/member")
	public  MemberVO member() {
		
		MemberVO vo = MemberVO.builder()
				.id("hong500")
				.pwd("1234")
				.name("홍길동500")
				.email("hong500@gmail.com")
				.build();
		// 자바객체 (VO) -> json	
		return  vo;
	}
	
	// 3. List구조형식 객체 -> json->보내기
	@RequestMapping("/memberList")
	public List<MemberVO> memberList(){
		List<MemberVO> list = new ArrayList<>();
		
		for ( int i=0; i<10; i++) {
			MemberVO vo = MemberVO.builder()
					.id("hong60"+i)
					.pwd("1234")
					.name("홍길60"+i)
					.email("hong60"+i+"@gmail.com")
					.build();
			
			list.add(vo);
		}
		return list;
	}
	
	// 4. Map객체 -> json
	
	// request 처리
	// 5. PathVariable
	// 6. 객체구조 매개변수 전달받기
	// 7. ResponseEntity: 응답코드 전달하기
	
	
	

}


/*
REST(Representaional State Transfer) : 하나의 URI가 고유한 리소스를 처리하는 공통방식
RESTfull API
*/