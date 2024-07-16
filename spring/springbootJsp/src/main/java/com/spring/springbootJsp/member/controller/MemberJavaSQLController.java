package com.spring.springbootJsp.member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springbootJsp.member.dao.E03MemberDAOJavaSQL;
import com.spring.springbootJsp.member.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member/sqlclass")
public class MemberJavaSQLController {
	// MemberJavaSQLController.class에 대한 로그를 띄우겠다고 설정 미설정시 추후 로그 띄울때 에러
	static Logger logger = LoggerFactory.getLogger(MemberJavaSQLController.class);
	
//	@Autowired
//	private E03MemberDAOJavaSQL memberDAOJavaSQL;
	
	// @Autowired 미사용 시
	private final E03MemberDAOJavaSQL memberDAOJavaSQL;
	
	// 생성자를 통해 의존성 주입
	public MemberJavaSQLController(E03MemberDAOJavaSQL memberDAOJavaSQL) {
		this.memberDAOJavaSQL = memberDAOJavaSQL;
		logger.info("<===============생성자===============>");
	}
	
	// 회원 목록
	// http://localhost:8099/member/list
	@GetMapping("/list")
	public String getList(Model model) {
		List<MemberVO> list = memberDAOJavaSQL.getMemberList();
		logger.info("=> member/sqlclass/list: "+list);
		
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
	
	// 회원 조회
	// http://localhost:8099/member/view?id=hong2
	@GetMapping("/view")
	public String getView(Model model, HttpServletRequest req) {
		String id = req.getParameter("id");
//		System.out.println(); 애플리케이션에 해당 기능이 포함됨. 프로그램 덩치가 커짐.
		logger.info("=> member/sqlclass/view id: "+id);  // 포함되지 않음.
		
		model.addAttribute("member",memberDAOJavaSQL.getMemberView(id));
		
		return "member/memberView";
	}
	

	// -------------------------------------------------------- //
	// SQL Class 밉핑 : SQL어노테이션에 사용되는 SQL물 모듈화
	// -------------------------------------------------------- //
	@GetMapping("/final_list")
	public String getFinalList(Model model) {
		List<MemberVO> list = memberDAOJavaSQL.getFinalMemberList();
		logger.info("=> member/sqlclass/final_list: "+list);
		
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
	@GetMapping("/list2")
	public String getMemberList2(Model model) {
		List<MemberVO> list = memberDAOJavaSQL.getMemberList2();
		logger.info("=> member/sqlclass/list2: "+list);
		
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
	@GetMapping("/list3")
	public String getMemberList3(Model model) {
		List<MemberVO> list = memberDAOJavaSQL.getMemberList3();
		logger.info("=> member/sqlclass/list3: "+list);
		
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
	// -------------------------------------------------------- //
	
	// http://localhost:8099/member/sqlclass/insert?id=hong500&pwd=6879&name=%ED%99%8D500&email=hong500@gmail.com
	@GetMapping("/insert")
	public String insertMember(HttpServletRequest req) {
		MemberVO vo = MemberVO.builder()
				.id(req.getParameter("id"))
				.pwd(req.getParameter("pwd"))
				.name(req.getParameter("name"))
				.email(req.getParameter("email"))
				.build();
		
		logger.info("=> member/insert: "+vo);
		
		int isOK = memberDAOJavaSQL.insertMember(vo);
		
		return "redirect:/member/sqlclass/list";
	}
	
	@GetMapping("/modify")
	public String modifyMember(HttpServletRequest req) {
		MemberVO vo = MemberVO.builder()
				.id(req.getParameter("id"))
				.pwd(req.getParameter("pwd"))
				.name(req.getParameter("name"))
				.email(req.getParameter("email"))
				.build();
		
		logger.info("=> member/insert: "+vo);
		
		int isOK = memberDAOJavaSQL.updateMember(vo);
		
		return "member/memberModify";
	}
	
	@GetMapping("/delete")
	public String deleteMember(HttpServletRequest req) {
		String id = req.getParameter("id");
		
		int isOK = memberDAOJavaSQL.deleteMember(id);
		logger.info("=> member/delete: "+isOK);
		
		return "member/memberDelete";
	}
	
	// 회원 조회
	// http://localhost:8099/member/view2?id=hong2
	@GetMapping("/view2")
	public String view2Member(Model model, HttpServletRequest req) {
		String id = req.getParameter("id");
		
		model.addAttribute("member",memberDAOJavaSQL.viewMember(id));
		
		return "member/memberView";
	}

	// 아이디 체크
	@GetMapping("/idcheck")
	public String idCheck(HttpServletRequest req) {
		String id = req.getParameter("id");
		
		String isOK = memberDAOJavaSQL.idCheck(id);
		logger.info("=> idcheck result: "+isOK);
		
		return "member/memberList";
	}
	
	// 동적 SQL
	// 조건 검색 // 이름, 이메일 체크
	@GetMapping("/getMemberListIf")
	public String getMemberListIf(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
//		List<MemberVO> members = memberDAOJavaSQL.getMemberListIf(name, email);
//		logger.info("=> getMemberListIf: "+members);
		model.addAttribute("members", memberDAOJavaSQL.getMemberListIf(name, email));
		
		return "member/memberList";
	}
	
}
