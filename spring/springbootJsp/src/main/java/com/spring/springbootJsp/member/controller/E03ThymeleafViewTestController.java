package com.spring.springbootJsp.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.springbootJsp.member.dao.E02MemberDAOMybatis;
import com.spring.springbootJsp.member.dto.MemberDTO;
import com.spring.springbootJsp.member.dto.PageRequestDTO;
import com.spring.springbootJsp.member.dto.PageResponseDTO;
import com.spring.springbootJsp.member.service.MemberService;
import com.spring.springbootJsp.member.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/thymeleaf")
public class E03ThymeleafViewTestController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private E02MemberDAOMybatis memberDAO;
	
	
	@GetMapping("/ex01")
	public String ThymeleafRoot(Model model) {
		model.addAttribute("msg", "Hellog Thymeleaf !!");
		return "thymeleaf/root";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		MemberVO vo = MemberVO.builder()
				.id("id100").pwd("1234")
				.name("hong456").email("hong456@gmail.com")
				.build();
		
		model.addAttribute("member", vo);
		
		return "thymeleaf/memberView";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		List<MemberVO> list = new ArrayList<>();
		
		for (int i=0; i<3; i++) {
			MemberVO vo = MemberVO.builder()
					.id("id100").pwd("1234")
					.name("hong456").email("hong456@gmail.com")
					.build();
			
			list.add(vo);
		}
		
		model.addAttribute("members", list);
		
		return "thymeleaf/memberList";
	}
	
	@GetMapping("/ex04")
	public String ThymeleafLink(Model model) {
		return "thymeleaf/href";
	}
	
	@GetMapping("/ex05")
	public String thymeleafParam(Model model, String id, String name) {
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		return "thymeleaf/href_param";
	}
	
	@GetMapping("/ex06")
	public String templateLayout(Model model) {
		
		
		return "thymeleaf/layoutViewTest";
	}
	
	@GetMapping("/ex07")
	public String templateLayout2() {
		
		
		return "thymeleaf/thymeleafViewTest";
	}
	
	@GetMapping("/ex08")
	public String getList2(Model model, PageRequestDTO pageRequestDTO) {
		
		// 페이지 기능 설정
		PageResponseDTO<MemberDTO> pageResponseDTO = memberService.getMemberList(pageRequestDTO);
		model.addAttribute("pageResponseDTO", pageResponseDTO);
		
		return "thymeleaf/member/memberList";
	}
	
	@GetMapping("/memberList")
	public String getMemberList(Model model, PageRequestDTO pageRequestDTO) {
		
		// 페이지 기능 설정
		PageResponseDTO<MemberDTO> pageResponseDTO = memberService.getMemberList(pageRequestDTO);
		model.addAttribute("pageResponseDTO", pageResponseDTO);
		
		return "thymeleaf/member/memberList2";
	}
	
	@GetMapping("/registerMember")
	public String registerMember() {
		
		return "thymeleaf/member/registerMember";
	}
	
	@GetMapping("/memberList2")
	public String getMemberList2(Model model, PageRequestDTO pageRequestDTO) {
		
		// 페이지 기능 설정
		PageResponseDTO<MemberDTO> pageResponseDTO = memberService.getMemberList(pageRequestDTO);
		model.addAttribute("pageResponseDTO", pageResponseDTO);
		
		return "thymeleaf/member/memberList3";
	}
	
	@GetMapping("/viewMember")
	public String getView2(Model model, PageRequestDTO pageRequestDTO, String id) {
//		System.out.println(); 애플리케이션에 해당 기능이 포함됨. 프로그램 덩치가 커짐.
//		logger.info("=> member/view id: "+id);  // 포함되지 않음.
		
		model.addAttribute("member",memberDAO.getMemberView(id));
		return "thymeleaf/member/viewMember";
		
	}
	
	// 회원 수정
	@PostMapping("/modifyMember")
	public String modifyMember(
			RedirectAttributes redirectModel,  // 2. RedirectAttributes추가 redirect방식에서 데이터 전달 객체
			PageRequestDTO pageRequestDTO,  // 1. RedirectAttributes 없이 쓸때 이것만
			MemberVO vo) {  // MemberVO 필수
		
		// MemberVO 속성이름과 입력폼에서 전달해준 매개 변수가 같으면 자동으로 만들어줌
		
//					MemberVO vo = MemberVO.builder()
//							.id(req.getParameter("id"))
//							.pwd(req.getParameter("pwd"))
//							.name(req.getParameter("name"))
//							.email(req.getParameter("email"))
//							.build();
		
		memberDAO.updateMember(vo);
		
		// 1.
//			return "redirect:/member/list2?"+pageRequestDTO.getLink();  // 현재 페이지 정보
		
		// 2. 방법
		// redirect: 정보 전달 객체 : GET방식 전달
		redirectModel.addAttribute("page", pageRequestDTO.getPage());
		redirectModel.addAttribute("size", pageRequestDTO.getSize());
		return "redirect:/thymeleaf/memberList";
		
		// 3. 방법 여기선 적용 힘듬
		// redirect: 정보 전달 객체 : POST방식 전달  한번 전달 되면 값 사라짐
//			redirectModel.addFlashAttribute("page", pageRequestDTO.getPage());
//			redirectModel.addFlashAttribute("size", pageRequestDTO.getSize());
//			return "redirect:/member/list2";
			
	}
	
	// 회원 삭제
	@GetMapping("/deleteMember")
	public String deleteMember(
			//@ModelAttribute("pageReqeustDTO") PageRequestDTO pageRequestDTO,
			PageRequestDTO pageRequestDTO,  // @ModelAttribute("pageReqeustDTO") 생략
			String id) {
		
		
		memberDAO.deleteMember(id);
		return "redirect:/thymeleaf/memberList";
	}
	
	// 중복아이디 체크
	@PostMapping("/checkID")
	public ResponseEntity<String> checkID(HttpServletRequest req) {
		String id = req.getParameter("id");
		
		String isOK = memberDAO.idCheck(id);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		
		return new ResponseEntity<String>(isOK, responseHeaders, HttpStatus.CREATED);
	}
	
	// 회원 등록
	@PostMapping("/insertMember")
	public String insertMember(HttpServletRequest req) {
		MemberVO vo = MemberVO.builder()
				.id(req.getParameter("id"))
				.pwd(req.getParameter("pwd"))
				.name(req.getParameter("name"))
				.email(req.getParameter("email"))
				.build();
		
		
		memberDAO.insertMember(vo);
		
		return "redirect:/thymeleaf/memberList";
	}
}
