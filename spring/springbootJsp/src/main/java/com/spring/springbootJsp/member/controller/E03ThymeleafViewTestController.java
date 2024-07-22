package com.spring.springbootJsp.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springbootJsp.member.dto.MemberDTO;
import com.spring.springbootJsp.member.dto.PageRequestDTO;
import com.spring.springbootJsp.member.dto.PageResponseDTO;
import com.spring.springbootJsp.member.service.MemberService;
import com.spring.springbootJsp.member.vo.MemberVO;

@Controller
@RequestMapping("/thymeleaf")
public class E03ThymeleafViewTestController {
	
	@Autowired
	private MemberService memberService;
	
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
}
