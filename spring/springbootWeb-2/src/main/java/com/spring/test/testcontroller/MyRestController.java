package com.spring.test.testcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.testcontroller.vo.MemberVO;

@RestController
@RequestMapping("/restapi/*")
public class MyRestController {
	
	// ----------------------------- //
	// 다양한 형태로 데이터 전달 : JSON형식
	// ----------------------------- //
	
	// 1. text/html형식 보내기
	@RequestMapping("/hello")
	public  String hello() {
		return "REST API Test";
	}
	
	// 2. vo객체 전달 vo->json형식 문자열로 변환 하여 보내기
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
	@GetMapping("/memberMap")
	public Map<Integer, MemberVO> memberMap() {
		Map<Integer, MemberVO> map = new HashMap<>();

		for ( int i=0; i<10; i++) {
			MemberVO vo = MemberVO.builder()
					.id("hong60"+i)
					.pwd("1234")
					.name("홍길60"+i)
					.email("hong60"+i+"@gmail.com")
					.build();
			
			map.put(i, vo);  // key, value 저장
		}
		return map;
	}
	
	
	// request 처리
	
	// 5. PathVariable
//	@RequestMapping("/notice") @RequestMapping(value="/notice") // 같음
//	@RequestMapping(value="/notice/{num}/boardlist", method=RequestMethod.GET) 게시글 링크 구조 이런거 쓰기도 함
//	참고 네이버 카페 게시글 링크 https://cafe.naver.com/sssw/17046611
	@RequestMapping(value="/notice/{num}", method=RequestMethod.GET)
	public int notice(@PathVariable("num") int num) {
		
		return num;
	}
	
	
	// 6. 객체구조 매개변수 전달받기
	// 클라이언트에서 JSON에 전송한 객체 -> 컨트롤러에서 JSON->VO객체로 전환
	@PostMapping("/info")  // @RequestMapping(value="info", method= RequestMethod.POST) 같음
//	public String info(HttpServletRequest req) {
//	String id = req.getParameter("id");
//	String name = req.getParameter("name");
//	return "("+id+","+name+")데이터를 정상적으로 전송 받았습니다.";turn vo;
//}
	public MemberVO info(@RequestBody MemberVO vo) {  // @@RequestBody하면 데이터를 받을때 그대로 받아옴
		
		System.out.println("=> 전송받은 객체값: "+vo);
		
		return vo;
	}
	
	
	// 7. ResponseEntity: 응답코드 전달하기
	@GetMapping("/memberList2")
	public ResponseEntity<List<MemberVO>> memberList2() {
		
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
		
		// 인위적으로 상태값 출력 INTERNAL_SERVER_ERROR 500번 에러 코드 HttpStatus.OK 200번 정상 코드
		return new ResponseEntity<List<MemberVO>>(list, HttpStatus.OK);
		
	}
	
	// HttpHeaders클래스를 통해 전송할 데이터 종류, 한글 인코딩 설정
	@RequestMapping(value="/resp_entity")
	public ResponseEntity responseEntity() {
		
		
		HttpHeaders respHeader = new HttpHeaders();
		respHeader.add("Content-type", "text/html; charset=utf-8");
		
		String 
		mess = "<script>";
		mess += "	alert('등록되었습니다!');";
		mess += "	location.href='/restapi/memberList';";
		mess += "</script>";
		
		return new ResponseEntity(mess,respHeader, HttpStatus.CREATED);  // HttpStatus.CREATED  코드번호 201
	}
	
}


/*
REST(Representaional State Transfer) : 하나의 URI가 고유한 리소스를 처리하는 공통방식
RESTfull API
*/