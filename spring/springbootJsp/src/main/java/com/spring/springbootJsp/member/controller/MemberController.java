package com.spring.springbootJsp.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.springbootJsp.member.dao.E02MemberDAOMybatis;
import com.spring.springbootJsp.member.dto.PageRequestDTO;
import com.spring.springbootJsp.member.dto.PageResponseDTO;
import com.spring.springbootJsp.member.service.MemberService;
import com.spring.springbootJsp.member.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/member")
public class MemberController {
	static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private E02MemberDAOMybatis memberDAO;
	// 서비스 객체 선언
	
	// sysdate
	// http://localhost:8099/member/now
	@GetMapping("/now")
	public String getDBGetTime(Model model ) {
		
		String getTime = memberDAO.getTime();
		logger.info("==> xml로 작성한 sql getTime(); "+getTime);
		
		model.addAttribute("now", getTime) ;
		
		
		return "member/mybatisViewTest";
	}
	
	// 회원 목록
	// http://localhost:8099/member/list
	@GetMapping("/list")
	public String getList(Model model) {
		List<MemberVO> list = memberDAO.getMemberList();
		logger.info("=> member list: "+list);
		
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
	
	// 회원 조회
	// http://localhost:8099/member/view?id=hong2
	@GetMapping("/view")
	public String getView(Model model, HttpServletRequest req) {
		String id = req.getParameter("id");
//		System.out.println(); 애플리케이션에 해당 기능이 포함됨. 프로그램 덩치가 커짐.
		logger.info("=> member/view id: "+id);  // 포함되지 않음.
		
		model.addAttribute("member",memberDAO.getMemberView(id));
		
		return "member/memberView";
	}
	
	// 회원 등록
	// http://localhost:8099/member/insert?id=hong99&pwd=2222&name=홍홍홍&email=honghong@gmail.com
	// 회원 등록 입력 폼 요청
	@GetMapping("/registerMember")
	public String registerMember() {
		
		return "member/registerMember";
	}
	// 회원 정보 데이터 처리 요청
	@GetMapping("/insert")
	public String memberRegister(HttpServletRequest req) {
		MemberVO vo = MemberVO.builder()
				.id(req.getParameter("id"))
				.pwd(req.getParameter("pwd"))
				.name(req.getParameter("name"))
				.email(req.getParameter("email"))
				.build();
		
		logger.info("=> member/insert: "+vo);
		
		memberDAO.insertMember(vo);
		
		return "member/memberRegister";
	}
	
	// 회원 삭제
	@GetMapping("/remove")
	public String removeMember(HttpServletRequest req) {
		String id = req.getParameter("id");
		logger.info("=> member/remove id: "+id);
		
		memberDAO.deleteMember(id);
		return "member/memberDelete";
	}
	
	// 회원 수정
	@GetMapping("/modify")
	public String modifyMember(HttpServletRequest req) {
		MemberVO vo = MemberVO.builder()
				.id(req.getParameter("id"))
				.pwd(req.getParameter("pwd"))
				.name(req.getParameter("name"))
				.email(req.getParameter("email"))
				.build();
		logger.info("=> member/modify: "+vo);
		
		memberDAO.updateMember(vo);
		
		return "redirect:/member/list";
		
	}
	


	// 중복 아이디 체크
	@GetMapping("/idcheck")
	public String idCheck(HttpServletRequest req) {
		String id = req.getParameter("id");
		logger.info("=> member/idcheck id: "+id);
		
		String isOK = memberDAO.idCheck(id);
		logger.info("=> idCheck result: "+isOK);logger.info("=> "+(isOK.equals("true")?"이미 사용중인 아이디입니다.":"사용가능한 아이디입니다!"));
		
		return "redirect:/member/list";
	}
	
	
	// ------------------------------------- //
	// 동적 SQL 활용
	// ------------------------------------- //
	
	// 조건 검색하는 DAO기능 요청
	@GetMapping("/searchMember")
	public String searchMember(Model model, HttpServletRequest req) {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		model.addAttribute("members", memberDAO.getMemberListIf(id, name, email)) ;
		return "member/memberList";  //포워딩 방식으로 리턴. 서버에서 요청에서 요청받은 주소로 바꿔줌
	}
	
	@GetMapping("/forEachMemberSelect")
	public String forEachMember(Model model) {
		List<String> nameList = new ArrayList<>();
		nameList.add("홍길동");
		nameList.add("이순신");
		nameList.add("강감찬");
		
		model.addAttribute("members", memberDAO.getForEachSelect(nameList));
		
		return "member/memberList";
	}
	
	@GetMapping("/forEachMemberInsert")
	public String forEachInsert(Model model) {
		List<MemberVO> memberList = new ArrayList<>();
		for (int i=100; i<105; i++) {
			MemberVO vo = MemberVO.builder()
					.id("m"+i).pwd("1"+i).name("길순"+i).email("m"+i+"@test.com")
					.build();
			memberList.add(vo);
		}
		
//		model.addAttribute("members", memberDAO.setForEachInsert(memberList));
		
		memberDAO.setForEachInsert(memberList);
		model.addAttribute("members", memberList);
		
		return "member/memberList";
	}
	
	
	// 웹페이지 연동
	// registerMember.jsp
	
	// 중복아이디 체크
	@PostMapping("/idcheck2")
	public ResponseEntity<String> idCheck2(HttpServletRequest req) {
		String id = req.getParameter("id");
		
		String isOK = memberDAO.idCheck(id);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		
		return new ResponseEntity<String>(isOK, responseHeaders, HttpStatus.CREATED);
	}
	
	// 회원 등록
	@PostMapping("/insert2")
	public String memberRegister2(HttpServletRequest req) {
		MemberVO vo = MemberVO.builder()
				.id(req.getParameter("id"))
				.pwd(req.getParameter("pwd"))
				.name(req.getParameter("name"))
				.email(req.getParameter("email"))
				.build();
		
		logger.info("=> member/insert: "+vo);
		
		memberDAO.insertMember(vo);
		
		return "member/memberRegister";
	}

	// 회원 삭제
	@GetMapping("/remove2")
	public String removeMember2(HttpServletRequest req) {
		String id = req.getParameter("id");
		logger.info("=> member/remove id: "+id);
		
		memberDAO.deleteMember(id);
		return "redirect:/member/list";
	}
	
	// 회원 수정
		@PostMapping("/modify2")
		public String modifyMember2(HttpServletRequest req, MemberVO vo) {
			
			// MemberVO 속성이름과 입력폼에서 전달해준 매개 변수가 같으면 자동으로 만들어줌
			
//			MemberVO vo = MemberVO.builder()
//					.id(req.getParameter("id"))
//					.pwd(req.getParameter("pwd"))
//					.name(req.getParameter("name"))
//					.email(req.getParameter("email"))
//					.build();
			logger.info("=> member/modify: "+vo);
			
			memberDAO.updateMember(vo);
			
			return "redirect:/member/list";
			
		}

		
	// ---------------------------------------------------------- //
		
	// 회원 목록2
	// http://localhost:8099/member/list2
	@GetMapping("/list2")
	public String getList2(Model model, PageRequestDTO pageRequestDTO) {
		
		log.info("=> list pageRequestDTO: "+pageRequestDTO);
		
		if (pageRequestDTO.getTypes() != null) {
			log.info("=> list pageRequestDTO.getTypes not null: "+pageRequestDTO.getTypes().length);
			
		} else {
			log.info("=> list pageRequestDTO.getTypes is null: "+pageRequestDTO.getTypes());
		}
		
		// 페이지 기능 설정
		PageResponseDTO<MemberVO> pageResponseDTO = memberService.getMemberList(pageRequestDTO);
		model.addAttribute("pageResponseDTO", pageResponseDTO);
		
		
		
//		List<MemberVO> list = memberDAO.getMemberList();
//		logger.info("=> member list: "+list);
//		
//		model.addAttribute("members", list);
		
		return "member/memberList2";
	}

	// 회원 조회
	// http://localhost:8099/member/view?id=hong2
	@GetMapping("/view2")
	public String getView2(Model model, PageRequestDTO pageRequestDTO, String id) {
//		System.out.println(); 애플리케이션에 해당 기능이 포함됨. 프로그램 덩치가 커짐.
//		logger.info("=> member/view id: "+id);  // 포함되지 않음.
		
		model.addAttribute("member",memberDAO.getMemberView(id));
		
//		return "member/memberView";
		return "member/memberView2";
	}
	
	// 회원 등록
	// http://localhost:8099/member/insert?id=hong99&pwd=2222&name=홍홍홍&email=honghong@gmail.com
	// 회원 등록 입력 폼 요청
	@GetMapping("/registerMember2")
	public String registerMember2() {
		
		return "member/registerMember2";
	}
	

	// 회원 수정
	@PostMapping("/modify3")
	public String modifyMember3(
			RedirectAttributes redirectModel,  // 2. RedirectAttributes추가 redirect방식에서 데이터 전달 객체
			PageRequestDTO pageRequestDTO,  // 1. RedirectAttributes 없이 쓸때 이것만
			MemberVO vo) {  // MemberVO 필수
		
		// MemberVO 속성이름과 입력폼에서 전달해준 매개 변수가 같으면 자동으로 만들어줌
		
//				MemberVO vo = MemberVO.builder()
//						.id(req.getParameter("id"))
//						.pwd(req.getParameter("pwd"))
//						.name(req.getParameter("name"))
//						.email(req.getParameter("email"))
//						.build();
		logger.info("=> member/modify: "+vo);
		
		memberDAO.updateMember(vo);
		
		// 1.
//		return "redirect:/member/list2?"+pageRequestDTO.getLink();  // 현재 페이지 정보
		
		// 2. 방법
		// redirect: 정보 전달 객체 : GET방식 전달
		redirectModel.addAttribute("page", pageRequestDTO.getPage());
		redirectModel.addAttribute("size", pageRequestDTO.getSize());
		redirectModel.addAttribute("name", "ffffffffffffffffff");
		return "redirect:/member/list2";
		
		// 3. 방법 여기선 적용 힘듬
		// redirect: 정보 전달 객체 : POST방식 전달  한번 전달 되면 값 사라짐
//		redirectModel.addFlashAttribute("page", pageRequestDTO.getPage());
//		redirectModel.addFlashAttribute("size", pageRequestDTO.getSize());
//		return "redirect:/member/list2";
			
	}
	
//	// 회원 삭제
//	@GetMapping("/remove3")
//	public String removeMember3(
//			//@ModelAttribute("pageReqeustDTO") PageRequestDTO pageRequestDTO,
//			PageRequestDTO pageRequestDTO,  // @ModelAttribute("pageReqeustDTO") 생략
//			String id) {
//		id = req.getParameter("id");
//		logger.info("=> member/remove id: "+id);
//		
//		memberDAO.deleteMember(id);
//		return "redirect:/member/list";
//	}
	
	
	
}
